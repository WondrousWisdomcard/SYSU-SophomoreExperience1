`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/06 09:40:40
// Design Name: 
// Module Name: tbjsq_sim
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


module tbjsq_sim;
    reg clk = 0;
    reg clr_l = 1;
    reg ld_l = 1;
    reg enp = 1;
    reg ent = 1;
    reg [3:0] d = 0;
    wire [3:0] q;
    wire rco;
tbjsq uut(clk,clr_l,ld_l,enp,ent,d,q,rco);
always #10 clk =~ clk;
endmodule
