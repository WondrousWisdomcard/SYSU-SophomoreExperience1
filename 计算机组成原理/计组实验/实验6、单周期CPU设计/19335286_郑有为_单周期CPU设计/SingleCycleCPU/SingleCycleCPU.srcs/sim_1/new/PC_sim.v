`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/19 23:18:16
// Module Name: PC_sim
//////////////////////////////////////////////////////////////////////////////////

    
module PC_sim;

    reg clk;
    reg reset;
    
    wire [31:0] CurAddress;
    
    reg Jump = 0,Branch = 0;
    
    wire [31:0] Instruction;
    reg [31:0] SignExtend = 0;
    
    wire [31:0] WriteData = 0; 
    wire [31:0] ExtendedData;
    
    wire [31:0] ReadData1, ReadData2;
    initial 
       begin
           clk = 0;
           reset = 0;
           # 10;
           reset = 1;
       end

    wire [31:0] Result;
    wire Zero;
    CPU_top myCPU(clk, reset, CurAddress, Instruction, ReadData1, ReadData2, ExtendedData, Result, Zero);
        
    always # 2 
    begin
        clk =~ clk;
    end
    
    
endmodule
