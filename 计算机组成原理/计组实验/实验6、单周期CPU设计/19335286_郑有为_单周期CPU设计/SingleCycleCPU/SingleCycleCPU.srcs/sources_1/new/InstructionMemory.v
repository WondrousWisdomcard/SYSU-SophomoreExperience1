`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/23 09:42:11
// Module Name: InstructionMemory
//////////////////////////////////////////////////////////////////////////////////

module InstructionMemory(
    input [31:0] ReadAddress,
    output reg [31:0] Instruction
    );
    
    reg [7:0] Memory [255:0];
    initial
    begin
        $readmemb("C:/Users/17727/Desktop/m1.txt", Memory);
    end
    always @ (ReadAddress) 
    begin
        Instruction = {Memory[ReadAddress],Memory[ReadAddress+1],Memory[ReadAddress+2],Memory[ReadAddress+3]};
 
        $display("PC:",ReadAddress," INSTRUCTION: ", Instruction);
    end

endmodule