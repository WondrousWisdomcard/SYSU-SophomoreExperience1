`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 11:03:04
// Module Name: Mux5
//////////////////////////////////////////////////////////////////////////////////


module Mux5(
    input ALUSrc1FromIDEX,
    input [31:0] ReadData1FromIDEX,
    input [31:0] InstructionFromIDEX,
    output [31:0] ResultFromMux5
    );
    assign  ResultFromMux5 = (ALUSrc1FromIDEX == 1) ? {{27{InstructionFromIDEX[10]}},InstructionFromIDEX[10:6]} : ReadData1FromIDEX;
endmodule
