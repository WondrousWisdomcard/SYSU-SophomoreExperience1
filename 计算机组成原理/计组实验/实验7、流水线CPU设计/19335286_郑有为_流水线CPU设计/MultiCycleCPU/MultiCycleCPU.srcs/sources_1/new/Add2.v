`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 10:46:38 
// Module Name: Add2
//////////////////////////////////////////////////////////////////////////////////


module Add2(
    input [31:0] AddressFromIDEX,
    input [31:0] ExtendedDataFromIDEX,
    output [31:0] ResultFromAdd2
    );
    assign ResultFromAdd2 = AddressFromIDEX + (ExtendedDataFromIDEX * 4);
endmodule
