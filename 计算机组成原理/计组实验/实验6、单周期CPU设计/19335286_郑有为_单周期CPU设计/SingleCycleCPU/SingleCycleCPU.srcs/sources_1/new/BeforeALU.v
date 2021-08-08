`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/23 22:15:28
// Design Name: 
// Module Name: BeforeALU
//////////////////////////////////////////////////////////////////////////////////
module BeforeALU(
    input ALUSrc1,
    input ALUSrc2,
    input [31:0] ReadData1,
    input [31:0] Instruction,
    input [31:0] ReadData2,
    input [31:0] SignExtend,
    output reg [31:0] ALUInput1,
    output reg [31:0] ALUInput2
    );
    wire [31:0] Shamt = {{16{Instruction[15]}},Instruction[15:0]};
    
    always @ (ALUSrc1 or ReadData1 or Shamt)
    ALUInput1 = (ALUSrc1 == 1) ? Shamt : ReadData1;
    
    always @ (ALUSrc2 or ReadData2 or SignExtend)
    ALUInput2 = (ALUSrc2 == 1) ? SignExtend : ReadData2;
    
endmodule
