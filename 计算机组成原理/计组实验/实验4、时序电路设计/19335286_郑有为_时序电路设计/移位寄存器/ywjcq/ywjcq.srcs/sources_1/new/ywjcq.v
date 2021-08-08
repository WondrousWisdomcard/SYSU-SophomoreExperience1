`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/06 10:37:26
// Design Name: 
// Module Name: ywjcq
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

module ywjcq(clk,clr_l,rin,lin,s,d,q );
input clk,clr_l,rin,lin;
input [1:0] s;
input [3:0] d;
output [3:0] q;
reg [3:0] q;
always @ (posedge clk or negedge clr_l)
    if (clr_l==0) q<=0;
    else case (s)
        0:q<=q; //±£³Ö
        1:q<={rin,q[3:1]}; //ÓÒÒÆ
        2:q<={q[2:0],lin}; //×óÒÆ
        3:q<=d; //×°ÔØ
    default q<=4'bx ;
    endcase
endmodule