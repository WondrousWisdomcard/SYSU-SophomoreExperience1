`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/06 15:24:56
// Design Name: 
// Module Name: pmd2
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


module pmd2(clk,led);
input clk;
output [7:0] led;

    reg [31:0] divclk_cnt = 0;
    reg divclk = 0;
    reg [2:0] p = 0;

    
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
    end
    
always @ (posedge divclk)
    begin
    p = p + 1'b1;
    end

p138_2_0 p0(1,0,0,p,led);

endmodule
