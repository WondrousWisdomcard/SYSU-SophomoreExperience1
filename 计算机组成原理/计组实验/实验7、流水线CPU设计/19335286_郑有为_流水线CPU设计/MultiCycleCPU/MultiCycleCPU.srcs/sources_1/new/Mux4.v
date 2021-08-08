`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 11:01:56
// Module Name: Mux4
//////////////////////////////////////////////////////////////////////////////////


module Mux4(
    input PCSrcFromBranch, 
    input [31:0] ResultFromAdd1,
    input [31:0] Add2ResultFromEXMEM,
    output reg [31:0] ResultFromMux4
    );
    always @ (PCSrcFromBranch or ResultFromAdd1 or Add2ResultFromEXMEM)
    begin
    ResultFromMux4 = (PCSrcFromBranch == 1) ? Add2ResultFromEXMEM : ResultFromAdd1;
    end
endmodule
