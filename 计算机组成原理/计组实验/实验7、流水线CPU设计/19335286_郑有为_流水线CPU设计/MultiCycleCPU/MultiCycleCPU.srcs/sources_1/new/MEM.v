`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/14 20:04:39
// Module Name: MEM
//////////////////////////////////////////////////////////////////////////////////

module MEM(
    input clk,
    input JumpFromEXMEM,
    input BranchFromEXMEM,
    input MemReadFromEXMEM,
    input MemToRegFromEXMEM,
    input MemWriteFromEXMEM,
    input RegWriteFromEXMEM,
    
    input [31:0] ResultFromAdd2FromEXMEM,
    input ZeroFromEXMEM,
    input [31:0] ALUResultFromEXMEM,
    input [31:0] ReadData2FromEXMEM,
    input [4:0] ResultFromMux1FromEXMEM,
    
    output [31:0] ReadData,
    output PCSrcFromBranch
    );
    
     DataMemory datamemory(clk,MemWriteFromEXMEM,MemReadFromEXMEM,ALUResultFromEXMEM,ReadData2FromEXMEM,ReadData);
     
     SetPCSrc setpcsrc(ZeroFromEXMEM,BranchFromEXMEM,PCSrcFromBranch);
endmodule
