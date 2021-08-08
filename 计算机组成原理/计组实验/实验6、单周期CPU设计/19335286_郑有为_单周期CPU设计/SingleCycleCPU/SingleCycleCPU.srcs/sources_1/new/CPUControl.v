`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/25 22:09:08
// Design Name: 
// Module Name: CPUControl
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


module CPUControl(
    input [31:0] Instruction,
    output reg RegDst,
    output reg Jump,
    output reg Branch,
    output reg MemRead,
    output reg MemToReg,
    //output [1:0] reg ALUOp,
    output reg MemWrite,
    output reg ALUSrc1,
    output reg ALUSrc2,
    output reg RegWrite
    );
    
    wire [5:0] OP = Instruction[31:26];
    
    //存储器访问指令：lw sw 
    //算术逻辑运算指令：add sub addi
    //分支指令：beq j

    always @ (OP)
    begin
        if(OP == 6'b100011) //LW
            begin
                    RegDst = 0;
                    Jump = 0;
                    Branch = 0; 
                    MemRead = 1;
                    MemToReg = 1;
                    MemWrite = 0;
                    ALUSrc1 = 0;
                    ALUSrc2 = 1;
                    RegWrite = 1;
            end
        else if(OP == 6'b101011) //SW
            begin
                    RegDst = 0;
                    Jump = 0;
                    Branch = 0;
                    MemRead = 0;
                    MemToReg = 0;
                    MemWrite = 1;
                    ALUSrc1 = 0;
                    ALUSrc2 = 1;
                    RegWrite = 0;    
            end
        else if(OP == 6'b000000) //ADD SUB
            begin
                    RegDst = 1;
                    Jump = 0;
                    Branch = 0;
                    MemRead = 0;
                    MemToReg = 0;
                    MemWrite = 0;
                    ALUSrc1 = 0;
                    ALUSrc2 = 0;
                    RegWrite = 1;                                        
            end 
        else if(OP == 6'b001000) //ADDI
            begin
                    RegDst = 0;
                    Jump = 0;
                    Branch = 0;
                    MemRead = 0;
                    MemToReg = 0;
                    MemWrite = 0;
                    ALUSrc1 = 0;
                    ALUSrc2 = 1;
                    RegWrite = 1;                           
            end
        else if(OP == 6'b000100) //BEQ
            begin
                    RegDst = 0;
                    Jump = 0;
                    Branch = 1;
                    MemRead = 0;
                    MemToReg = 0;
                    MemWrite = 0;
                    ALUSrc1 = 0;
                    ALUSrc2 = 0;
                    RegWrite = 0;                            
            end
        else if(OP == 6'b000010) //J
            begin
                    RegDst = 0;
                    Jump = 1;
                    Branch = 0;
                    MemRead = 0;
                    MemToReg = 0;
                    MemWrite = 0;
                    ALUSrc1 = 0;
                    ALUSrc2 = 0;
                    RegWrite = 0;                                   
            end
    end
endmodule
