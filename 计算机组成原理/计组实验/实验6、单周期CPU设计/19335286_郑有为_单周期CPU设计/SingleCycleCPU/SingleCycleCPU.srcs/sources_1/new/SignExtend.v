`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/23 23:07:51
// Module Name: SignExtend
//////////////////////////////////////////////////////////////////////////////////
module SignExtend(
    inout clk,
    input [31:0] Instruction,
    output reg [31:0] ExtendedData
    );
    always @ (Instruction or clk)
    begin
        ExtendedData = {{16{Instruction[15]}},Instruction[15:0]};
    end
endmodule
