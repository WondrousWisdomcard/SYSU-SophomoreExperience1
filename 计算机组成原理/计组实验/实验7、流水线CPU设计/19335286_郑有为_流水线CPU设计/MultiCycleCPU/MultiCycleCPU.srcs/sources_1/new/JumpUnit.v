`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/15 07:58:24
// Module Name: JumpUnit
//////////////////////////////////////////////////////////////////////////////////


module JumpUnit(
    input [31:0] AddressFromIFID,
    input [31:0] InstructionFromIFID,
    output [31:0] JumpAddress
    );
    assign JumpAddress = {AddressFromIFID[31:28],InstructionFromIFID[25:0],2'b00};
    
endmodule
