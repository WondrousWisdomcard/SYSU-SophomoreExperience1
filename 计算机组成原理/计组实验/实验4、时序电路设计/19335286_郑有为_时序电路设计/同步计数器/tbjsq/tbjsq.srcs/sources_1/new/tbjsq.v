`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/06 09:22:34
// Design Name: 
// Module Name: tbjsq
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


module tbjsq(clk, clr_l, ld_l, enp, ent, d, q, rco);
input clk,clr_l,ld_l,enp,ent;
input [3:0] d;
output [3:0] q;
output rco;
reg [3:0] q = 0;
reg rco = 0;

reg [31:0] divclk_cnt = 0;
reg divclk = 0;
always@(posedge clk)
    begin
        if(divclk_cnt == 25000000)
        begin
            divclk =~ divclk;
            divclk_cnt = 0;
        end
        else
        begin
            divclk_cnt = divclk_cnt + 1'b1;
        end
    end;
    
always @ (posedge divclk)
    begin
        if(clr_l == 0)
            q<=0;
        else if(ld_l == 0)
            q<=d;
        else if((ent==1)&&(enp==1))
            q<=q+1;
        else q<=q;
    end
    
always @ (q or ent) 
    begin
    if((ent == 1) && (q == 15))
        rco = 1;
    else
        rco = 0;
    end
endmodule
