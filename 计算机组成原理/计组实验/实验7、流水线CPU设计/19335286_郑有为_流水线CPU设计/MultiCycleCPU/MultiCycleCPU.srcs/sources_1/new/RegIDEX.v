`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 19:16:50
// Module Name: RegIDEX
//////////////////////////////////////////////////////////////////////////////////


module RegIDEX(
    input clk,
    input RegDst,
    input Jump,
    input Branch,
    input MemRead,
    input MemToReg,
    input MemWrite,
    input ALUSrc1,
    input ALUSrc2,
    input RegWrite,
    
    input [31:0] AddressFromIFID,
    input [31:0] ReadData1,
    input [31:0] ReadData2,
    input [31:0] ExtendedData, 
    input [31:0] InstructionFromIFID,
    
    output reg RegDstFromIDEX,
    output reg JumpFromIDEX,
    output reg BranchFromIDEX,
    output reg MemReadFromIDEX,
    output reg MemToRegFromIDEX,
    output reg MemWriteFromIDEX,
    output reg ALUSrc1FromIDEX,
    output reg ALUSrc2FromIDEX,
    output reg RegWriteFromIDEX,
    
    output reg [31:0] AddressFromIDEX,
    output reg [31:0] ReadData1FromIDEX,
    output reg [31:0] ReadData2FromIDEX,
    output reg [31:0] ExtendedDataFromIDEX, 
    output reg [31:0] InstructionFromIDEX
    );
    
    reg StoreRegDst;
    reg StoreJump;
    reg StoreBranch;
    reg StoreMemRead;
    reg StoreMemToReg;
    reg StoreMemWrite;
    reg StoreALUSrc1;
    reg StoreALUSrc2;
    reg StoreRegWrite;
    reg [31:0] StoreAddress;
    reg [31:0] StoreReadData1;
    reg [31:0] StoreReadData2;
    reg [31:0] StoreExtendedData; 
    reg [31:0] StoreInstruction;
    
    always @ (negedge clk) // WRITE
        begin
            StoreRegDst <= RegDst;
            StoreJump <= Jump;
            StoreBranch <= Branch;
            StoreMemRead <= MemRead;
            StoreMemToReg <= MemToReg;
            StoreMemWrite <= MemWrite;
            StoreALUSrc1 <= ALUSrc1;
            StoreALUSrc2 <= ALUSrc2;
            StoreRegWrite <= RegWrite;
            StoreAddress <= AddressFromIFID;
            StoreReadData1 <= ReadData1;
            StoreReadData2 <= ReadData2;
            StoreExtendedData <= ExtendedData;
            StoreInstruction <= InstructionFromIFID;
        end
        
    always @ (posedge clk) // READ
        begin
            RegDstFromIDEX <= StoreRegDst;
            JumpFromIDEX <= StoreJump;
            BranchFromIDEX <= StoreBranch;
            MemReadFromIDEX <= StoreMemRead;
            MemToRegFromIDEX <= StoreMemToReg;
            MemWriteFromIDEX <= StoreMemWrite;
            ALUSrc1FromIDEX <= StoreALUSrc1;
            ALUSrc2FromIDEX <= StoreALUSrc2;
            RegWriteFromIDEX <= StoreRegWrite;
            AddressFromIDEX <= StoreAddress;
            ReadData1FromIDEX <= StoreReadData1;
            ReadData2FromIDEX <= StoreReadData2;
            ExtendedDataFromIDEX <= StoreExtendedData;
            InstructionFromIDEX <= StoreInstruction;
        end
endmodule
