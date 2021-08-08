`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 10:41:09
// Module Name: PC
//////////////////////////////////////////////////////////////////////////////////

module PC(
    input clk,
    input reset,
    input [31:0] ResultFromMux4,
    output reg [31:0] Address
    );

    //always @ (posedge clk or negedge reset)
    always @ (posedge clk or negedge reset)
    begin
        if(reset == 0) Address = -4;
        else Address = ResultFromMux4;
    end  
endmodule
