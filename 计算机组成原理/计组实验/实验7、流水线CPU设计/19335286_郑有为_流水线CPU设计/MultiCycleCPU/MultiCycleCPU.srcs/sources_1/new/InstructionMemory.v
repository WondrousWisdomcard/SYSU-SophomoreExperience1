`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 10:44:57
// Module Name: InstructionMemory
//////////////////////////////////////////////////////////////////////////////////

module InstructionMemory(
    input [31:0] Address,
    output reg [31:0] Instruction
    );
    reg [7:0] Memory [255:0];
    initial
    begin
        //$readmemb("C:/Users/17727/Desktop/m1.txt", Memory); //实验1
        //$readmemb("C:/Users/17727/Desktop/m2.txt", Memory); //实验2
        $readmemb("C:/Users/17727/Desktop/m3.txt", Memory);
    end
    always @ (Address) 
    begin
        Instruction = {Memory[Address],Memory[Address+1],Memory[Address+2],Memory[Address+3]};
        $display("PC:",Address," INSTRUCTION: ", Instruction);
    end
endmodule
