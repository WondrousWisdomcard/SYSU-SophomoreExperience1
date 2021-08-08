`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 09:21:09
// Design Name: 
// Module Name: p138sim
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


module p138sim();
reg g1;
reg g2a_l;
reg g2b_l;
reg[2:0] a;
wire[7:0] y_l;
p138 v74x138(g1,g2a_l,g2b_l,a,y_l);
initial begin
    g1=0;
    g2a_l=0;
    g2b_l=0;
    a=0;
    #100;
    g1=1;
    g2a_l=0;
    g2b_l=0;
end;
always #100 a=a+1;
endmodule
