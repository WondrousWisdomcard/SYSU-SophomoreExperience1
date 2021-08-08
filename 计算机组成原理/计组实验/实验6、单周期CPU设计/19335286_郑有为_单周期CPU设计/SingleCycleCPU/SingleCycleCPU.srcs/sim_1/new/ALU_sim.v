`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/24 09:30:12
// Design Name: 
// Module Name: ALU_sim
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


module ALU_sim;
    reg ALUSrc1;
    reg ALUSrc2;
    reg [31:0] ReadData1;
    reg [31:0] Instruction;
    reg [31:0] ReadData2;
    reg [31:0] SignExtend;
    reg clk;
    
    wire [31:0] ALUInput1;
    wire [31:0] ALUInput2;
    wire [3:0] ALUControl;
    wire [31:0] Result;
    wire Zero;
    
    initial begin
    clk = 0;
    ALUSrc1 = 0;
    ALUSrc2 = 0;
    ReadData1 = 32'b00000000000000000000000000000001;
    Instruction = 32'b00100000000010000000000000000100;
    ReadData2 = 32'b00000000000000000000000000000101;
    SignExtend = 32'b00000000000000000000000000000111;
    //ALUControl = 4'b0000;
    end
    
    
    always #10 begin
    ALUSrc1 = ALUSrc1 + 1;
    ALUSrc2 = ALUSrc2 + 1;
    clk = ~ clk;
    end
    
    //always #30 begin
    //ALUControl = ALUControl + 1;
    //end
    
    ALUControlUnit ALUControl_test(Instruction, ALUControl);
    BeforeALU BALU_test(ALUSrc1, ALUSrc2, ReadData1, Instruction, ReadData2, SignExtend, ALUInput1, ALUInput2);
    ALU ALU_test(clk,ALUControl, ALUInput1, ALUInput2, Result, Zero);
    
endmodule
