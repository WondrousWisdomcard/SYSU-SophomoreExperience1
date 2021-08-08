`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/12/13 16:53:27
// Design Name: 
// Module Name: CPU_sim
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


module CPU_sim;
    reg clk;
    reg reset;
    wire [15:0] result;
    initial 
           begin
               clk = 0;
               reset = 0;
               # 15;
               reset = 1;
           end
           
    always # 5
               begin
                   clk =~ clk;
               end
          
     CPU cpu(clk,reset,result);
     
endmodule
