`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 10:50:54
// Module Name: Mux1
//////////////////////////////////////////////////////////////////////////////////


module Mux1(
    input RegDstFromIDEX,
    input [31:0] InstructionFromIDEX,
    output [4:0] ResultFromMux1
    );
    assign ResultFromMux1 = (RegDstFromIDEX == 1) ? {InstructionFromIDEX[15:11]} : {InstructionFromIDEX[20:16]};
endmodule
