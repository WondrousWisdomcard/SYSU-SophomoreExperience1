`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/31 11:16:46
// Design Name: 
// Module Name: xlfsq_sim
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module xlfsq_sim();
    reg clk;
    wire led;
    xlfsq uut(clk,led);
    initial begin
        clk = 0;
    end
    always #5 clk =~clk;
endmodule
