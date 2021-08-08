`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 10:55:04
// Module Name: Mux2
//////////////////////////////////////////////////////////////////////////////////

module Mux2(
    input ALUSrc2FromIDEX,
    input [31:0] ReadData2FromIDEX,
    input [31:0] ExtendedDataFromIDEX,
    output [31:0] ResultFromMux2
    );
    assign  ResultFromMux2 = (ALUSrc2FromIDEX == 1) ? ExtendedDataFromIDEX : ReadData2FromIDEX;
endmodule
