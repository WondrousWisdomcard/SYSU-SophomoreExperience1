`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/19 21:20:43
//////////////////////////////////////////////////////////////////////////////////

module PC(
    input clk,
    input reset,
    input [31:0] next,
    output reg [31:0] now
    );
    
    initial begin
        now = 0;
    end
   
    always @ (posedge clk or negedge reset)
    begin
        if(reset == 0) now = 0;
        else now = next;
    end
        
endmodule
