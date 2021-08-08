`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/20 09:54:36
// Design Name: 
// Module Name: CPU_top
//////////////////////////////////////////////////////////////////////////////////

module CPU_top(
    input clk,
    input reset,
    output reg [15:0] PCandWriteData,
    output [31:0] Instruction
    );
    
    wire [31:0] CurAddress; // 当前指令地址
    wire [31:0] TempAddress; // 下一个指令地址    
    wire Jump,Branch;
    wire RegDst,RegWrite;
    wire [31:0] SignExtend; 
    wire [31:0] WriteDataMem;
    wire [31:0] WriteDataReg; 
    wire [31:0] ReadData1, ReadData2;
    wire [31:0] ALUInput1;
    wire [31:0] ALUInput2;
    wire ALUSrc1,ALUSrc2;
    wire [3:0] ALUControl;
    wire [31:0] Result;
    wire Zero;
    wire [31:0] ReadData;
    wire MemRead,MemWrite;
    wire MemToReg;        
    wire [31:0] fromReg31;
    wire JR;
    wire JAL;
    wire BranchNot;
    
    CPUControl CPUControl_test(Instruction,RegDst,Jump,Branch,MemRead,MemToReg,MemWrite,ALUSrc1,ALUSrc2,RegWrite,JR,JAL,BranchNot);
      
    NextAddress NextAddress_test(Jump,Branch,Zero,JR,BranchNot,CurAddress,Instruction,SignExtend,fromReg31,TempAddress);
    
    PC PC_test(clk,reset,TempAddress,CurAddress);
    
    InstructionMemory InstructionMemory_test(CurAddress,Instruction);
    
    Registers Registers_test(clk,Instruction,RegDst,RegWrite,WriteDataReg,JAL,CurAddress,ReadData1,ReadData2,fromReg31);

    SignExtend SignExtend_test(clk,Instruction,SignExtend);
    
    BeforeALU BeforeALU_test(ALUSrc1,ALUSrc2,ReadData1,Instruction,ReadData2,SignExtend,ALUInput1,ALUInput2);
    
    ALUControlUnit ALUControlUnit_test(Instruction,ALUControl);
    
    ALU ALU_test(ALUControl,ALUInput1,ALUInput2,Result,Zero);
    
    assign WriteDataMem = ReadData2;
    
    DataMemory DataMamory_test(clk,MemWrite,MemRead,Result,WriteDataMem,ReadData);
    
    SelectRegWriteData SelectRegWriteData_test(MemToReg,ReadData,Result,WriteDataReg);
    
    always @(negedge clk)
    PCandWriteData = {WriteDataReg[7:0],CurAddress[7:0]};
    
endmodule
