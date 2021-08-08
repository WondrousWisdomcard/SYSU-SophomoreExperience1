`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 16:48:31
// Module Name: CPU
//////////////////////////////////////////////////////////////////////////////////
 

module CPU(
    input clk,
    input reset,
    output [15:0] result
    );
    
    wire [31:0] WriteDataFromMux3;
    wire [31:0] AddressFromIFID;
    wire [31:0] Address;
    assign result = {WriteDataFromMux3[7:0],Address[7:0]};
    
    //IF
    wire PCSrcFromBranch;
    wire Jump;
    wire [31:0] Add2ResultFromEXMEM; //BEQ
    wire [31:0] ResultFromAdd1;
    wire [31:0] Instruction;
    wire [31:0] JumpAddress;
    
    IF IF_(clk,reset,PCSrcFromBranch,Jump,Add2ResultFromEXMEM,
        JumpAddress,ResultFromAdd1,Instruction,Address);
        
    //wire [31:0] AddressFromIFID;
    wire [31:0] InstructionFromIFID;
    RegIFID Reg1(clk,ResultFromAdd1,Instruction,AddressFromIFID,InstructionFromIFID);
    
    //ID  
    wire RegWriteFromMEMWB;
    wire [4:0] WriteRegisterFromMEMWB;
    //wire [31:0] WriteDataFromMux3;
    wire RegDst,Branch,MemRead,MemToReg, MemWrite,ALUSrc1,ALUSrc2,RegWrite;
    wire [31:0] ReadData1,ReadData2,ExtendedData;
        
    ID ID_(clk,AddressFromIFID,InstructionFromIFID,RegWriteFromMEMWB,
        WriteRegisterFromMEMWB,WriteDataFromMux3, RegDst,Jump,
        Branch,MemRead,MemToReg, MemWrite,ALUSrc1,ALUSrc2,
        RegWrite,ReadData1,ReadData2,ExtendedData,JumpAddress);
            
    wire RegDstFromIDEX,JumpFromIDEX,BranchFromIDEX,
          MemReadFromIDEX,MemToRegFromIDEX,
          MemWriteFromIDEX,ALUSrc1FromIDEX,ALUSrc2FromIDEX,RegWriteFromIDEX;
    wire [31:0] AddressFromIDEX,ReadData1FromIDEX,
          ReadData2FromIDEX,ExtendedDataFromIDEX,InstructionFromIDEX;
          
    RegIDEX Reg2(clk,RegDst,Jump,Branch,MemRead,MemToReg,MemWrite,ALUSrc1,ALUSrc2,RegWrite,
        AddressFromIFID,ReadData1,ReadData2,ExtendedData,InstructionFromIFID,
        RegDstFromIDEX, JumpFromIDEX,BranchFromIDEX,
        MemReadFromIDEX,MemToRegFromIDEX, MemWriteFromIDEX,ALUSrc1FromIDEX,ALUSrc2FromIDEX,RegWriteFromIDEX,
        AddressFromIDEX,ReadData1FromIDEX,ReadData2FromIDEX,ExtendedDataFromIDEX, InstructionFromIDEX); 
             
     //EX        
     wire [31:0] ResultFromAdd2,ALUResult;
     wire Zero;
     wire [4:0] ResultFromMux1;
     
     EX EX_(clk,RegDstFromIDEX,ALUSrc1FromIDEX,ALUSrc2FromIDEX,AddressFromIDEX,
        ReadData1FromIDEX,ReadData2FromIDEX,ExtendedDataFromIDEX,InstructionFromIDEX,
        ResultFromAdd2,Zero,ALUResult,ResultFromMux1);
     
     wire JumpFromEXMEM,BranchFromEXMEM,MemReadFromEXMEM,MemToRegFromEXMEM,MemWriteFromEXMEM,RegWriteFromEXMEM,ZeroFromEXMEM;
     wire [31:0] ALUResultFromEXMEM,ReadData2FromEXMEM;
     wire [4:0] ResultFromMux1FromEXMEM;
            
     RegEXMEM Reg3(clk,JumpFromIDEX,BranchFromIDEX,MemReadFromIDEX,MemToRegFromIDEX,MemWriteFromIDEX,RegWriteFromIDEX,
        ResultFromAdd2,Zero,ALUResult,ReadData2FromIDEX,ResultFromMux1,
        JumpFromEXMEM,BranchFromEXMEM,MemReadFromEXMEM,MemToRegFromEXMEM,MemWriteFromEXMEM,RegWriteFromEXMEM,
        Add2ResultFromEXMEM,ZeroFromEXMEM,ALUResultFromEXMEM,ReadData2FromEXMEM,ResultFromMux1FromEXMEM);
          
     //MEM
     wire [31:0] ReadData;
     
     MEM MEM_(clk,JumpFromEXMEM,BranchFromEXMEM,MemReadFromEXMEM,MemToRegFromEXMEM,MemWriteFromEXMEM,RegWriteFromEXMEM,
         Add2ResultFromEXMEM,ZeroFromEXMEM,ALUResultFromEXMEM,ReadData2FromEXMEM,ResultFromMux1FromEXMEM,
         ReadData,PCSrcFromBranch);
     
     wire MemToRegFromMEMWB;
     wire [31:0] ALUResultFromMEMWB,ReadDataFromMEMWB;
     
     RegMEMWB Reg4(clk,MemToRegFromEXMEM,RegWriteFromEXMEM,ReadData,ALUResultFromEXMEM,ResultFromMux1FromEXMEM,
         MemToRegFromMEMWB,RegWriteFromMEMWB,ReadDataFromMEMWB,ALUResultFromMEMWB,WriteRegisterFromMEMWB);
        
     //WB
     WB WB_(MemToRegFromMEMWB,ReadDataFromMEMWB,ALUResultFromMEMWB,WriteDataFromMux3);
     
         
endmodule
