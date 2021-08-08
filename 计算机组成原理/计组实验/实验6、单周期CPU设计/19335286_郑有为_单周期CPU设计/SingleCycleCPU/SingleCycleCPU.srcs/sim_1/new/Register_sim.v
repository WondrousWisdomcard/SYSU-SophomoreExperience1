`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/23 21:11:15
// Module Name: Register_sim
//////////////////////////////////////////////////////////////////////////////////


module Register_sim;

    reg clk;
    reg [31:0] Instruction;
    reg [31:0] WriteData = 32'b00000000000000000000000000001111;
    wire [31:0] ReadData1, ReadData2;
    initial 
       begin
           clk = 0;
           
           Instruction = 32'b11111111111111111111111111111111;
           # 200;
           
           # 200;
           Instruction = 32'b11111111111111111111111111111111;
           
       end
       
    wire RegDst = 1,RegWrite = 1;
    
    Registers Reg_test(clk,Instruction,RegDst,RegWrite,WriteData,ReadData1,ReadData2);
        
    always # 200 
    begin
        clk =~ clk;
    end
    
endmodule
