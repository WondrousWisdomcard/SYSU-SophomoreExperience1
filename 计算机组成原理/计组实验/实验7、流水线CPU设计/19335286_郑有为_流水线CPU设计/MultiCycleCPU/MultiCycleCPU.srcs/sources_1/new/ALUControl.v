`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 11:26:36
// Module Name: ALUControl
//////////////////////////////////////////////////////////////////////////////////

module ALUControl(
    input [31:0] InstructionFromIDEX,
    output reg [3:0] ResultFromALUControl
    );
    wire [5:0] Op = InstructionFromIDEX[31:26];
    wire [5:0] Funct = InstructionFromIDEX[5:0];
    always @ (InstructionFromIDEX)
        begin
        
            //存储器访问指令：lw sw 
            //算术逻辑运算指令：add sub addi
            //分支指令：beq j

            if(Op == 6'b100011) //LW
            ResultFromALUControl = 4'b0010;
            else if(Op == 6'b101011) //SW
            ResultFromALUControl = 4'b0010;
            else if(Op == 6'b000000 && Funct ==  6'b100000) //ADD
            ResultFromALUControl = 4'b0010;
            else if(Op == 6'b000000 && Funct ==  6'b100010) //SUB
            ResultFromALUControl = 4'b0110;
            else if(Op == 6'b001000) //ADDI
            ResultFromALUControl = 4'b0010;
            else if(Op == 6'b000100) //BEQ
            ResultFromALUControl = 4'b0110;
            else 
            ResultFromALUControl = 4'b1111;
        end
endmodule

