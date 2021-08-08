`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/15 08:06:33
// Module Name: Mux6
//////////////////////////////////////////////////////////////////////////////////


module Mux6(
    input Jump,
    input [31:0] ResultFromMux4,
    input [31:0] JumpAddress,
    output [31:0] ResultFromMux6
    );
    assign ResultFromMux6 = (Jump == 1) ? JumpAddress : ResultFromMux4;
endmodule
