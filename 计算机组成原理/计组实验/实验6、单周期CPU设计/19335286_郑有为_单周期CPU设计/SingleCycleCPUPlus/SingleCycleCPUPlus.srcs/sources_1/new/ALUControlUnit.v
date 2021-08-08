`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/25 17:57:17
// Design Name: 
// Module Name: ALUControlUnit
//////////////////////////////////////////////////////////////////////////////////


module ALUControlUnit(
    input [31:0] Instruction,
    output reg [3:0] ALUControl
    );
    wire [5:0] Op = Instruction[31:26];
    wire [5:0] Funct = Instruction[5:0];
    always @ (Instruction)
        begin
        
            //存储器访问指令：lw sw 
            //算术逻辑运算指令：add sub addi
            //分支指令：beq j

            if(Op == 6'b100011) //LW
            ALUControl = 4'b0010;
            else if(Op == 6'b101011) //SW
            ALUControl = 4'b0010;
            else if(Op == 6'b000000 && Funct ==  6'b100000) //ADD
            ALUControl = 4'b0010;
            else if(Op == 6'b000000 && Funct ==  6'b100010) //SUB
            ALUControl = 4'b0110;
            else if(Op == 6'b001000) //ADDI
            ALUControl = 4'b0010;
            else if(Op == 6'b000100) //BEQ
            ALUControl = 4'b0110;
            else if(Op == 6'b000101) //BNE
            ALUControl = 4'b0110;
            else if(Op == 6'b000000 && Funct == 6'b101010) //SLT
            ALUControl = 4'b0111;
            else if(Op == 6'b001010) //SLTI
            ALUControl = 4'b0111;
            else if(Op == 6'b000000 && Funct == 6'b000000) //SLL
            ALUControl = 4'b1110;
            else 
            ALUControl = 4'b1111;
        end
endmodule
