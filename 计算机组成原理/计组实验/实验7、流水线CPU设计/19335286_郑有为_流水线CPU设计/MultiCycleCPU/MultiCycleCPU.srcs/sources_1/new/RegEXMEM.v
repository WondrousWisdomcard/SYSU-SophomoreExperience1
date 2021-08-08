`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 11:33:03
// Module Name: RegEXMEM
//////////////////////////////////////////////////////////////////////////////////


module RegEXMEM(
    input clk,
    input JumpFromIDEX,
    input BranchFromIDEX,
    input MemReadFromIDEX,
    input MemToRegFromIDEX,
    input MemWriteFromIDEX,
    input RegWriteFromIDEX,
    
    input [31:0] ResultFromAdd2,
    input Zero,
    input [31:0] ALUResult,
    input [31:0] ReadData2FromIDEX,
    input [4:0] ResultFromMux1,
    
    output reg JumpFromEXMEM,
    output reg BranchFromEXMEM,
    output reg MemReadFromEXMEM,
    output reg MemToRegFromEXMEM,
    output reg MemWriteFromEXMEM,
    output reg RegWriteFromEXMEM,
    
    output reg [31:0] ResultFromAdd2FromEXMEM,
    output reg ZeroFromEXMEM,
    output reg [31:0] ALUResultFromEXMEM,
    output reg [31:0] ReadData2FromEXMEM,
    output reg [4:0] ResultFromMux1FromEXMEM
    );

    reg StoreJump;
    reg StoreBranch;
    reg StoreMemRead;
    reg StoreMemToReg;
    reg StoreMemWrite;
    reg StoreRegWrite;
    
    reg [31:0] StoreResultFromAdd2;
    reg StoreZero;
    reg [31:0] StoreALUResult;
    reg [31:0] StoreReadData2;
    reg [4:0] StoreResultFromMux1;

    always @ (negedge clk) // WRITE
    begin
        StoreJump = JumpFromIDEX;
        StoreBranch = BranchFromIDEX;
        StoreMemRead = MemReadFromIDEX;
        StoreMemToReg = MemToRegFromIDEX;
        StoreMemWrite = MemWriteFromIDEX;
        StoreRegWrite = RegWriteFromIDEX;
        
        StoreResultFromAdd2 = ResultFromAdd2;
        StoreZero = Zero;
        StoreALUResult = ALUResult;
        StoreReadData2 = ReadData2FromIDEX;
        StoreResultFromMux1 = ResultFromMux1;
    end
    
    always @ (posedge clk) // READ
    begin
        JumpFromEXMEM = StoreJump;
        BranchFromEXMEM = StoreBranch;
        MemReadFromEXMEM = StoreMemRead;
        MemToRegFromEXMEM = StoreMemToReg;
        MemWriteFromEXMEM = StoreMemWrite;
        RegWriteFromEXMEM = StoreRegWrite;
        
        ResultFromAdd2FromEXMEM = StoreResultFromAdd2;
        ZeroFromEXMEM = StoreZero;
        ALUResultFromEXMEM = StoreALUResult;
        ReadData2FromEXMEM = StoreReadData2;
        ResultFromMux1FromEXMEM = StoreResultFromMux1;
        //$display("ALUResultFromEXMEM: ",ALUResultFromEXMEM);
    end
endmodule


