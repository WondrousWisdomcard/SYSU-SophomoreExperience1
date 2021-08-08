`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/26 00:33:58

//////////////////////////////////////////////////////////////////////////////////


module FinalCPUTest;
    reg reset;
    reg clk; 
    wire [15:0] PCandWriteData;
    wire [31:0] Instruction;
    initial 
           begin
               clk = 0;
               reset = 0;
               # 3;
               reset = 1;
           end
           
    always # 1
               begin
                   clk =~ clk;
               end
               
    CPU_top CPU_test(clk,reset,PCandWriteData,Instruction);
    
endmodule
