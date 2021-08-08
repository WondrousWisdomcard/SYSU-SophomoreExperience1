`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/23 11:06:56
// Design Name: 
// Module Name: Registers
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


module Registers(
    input clk,
    input [31:0] Instruction,
    input RegDst,
    input RegWrite,
    input [31:0] WriteData,
    input JAL,
    input [31:0] CurAddress,
    output [31:0] ReadData1,
    output [31:0] ReadData2,
    output [31:0] fromReg31
    );
    
    reg [31:0] Registers[0:31];
    
    wire [4:0] RS = {Instruction[25:21]};
    wire [4:0] RT = {Instruction[20:16]};
    wire [4:0] RD = {Instruction[15:11]};
    
    wire [4:0] WriteRegister;
    
    assign ReadData1 = (RS == 0) ? 0 : Registers[RS];
    assign ReadData2 = (RT == 0) ? 0 : Registers[RT];
    assign fromReg31 = Registers[31];
    assign WriteRegister = (RegDst == 1) ? RD : RT;
    
    always@(posedge clk) begin 
        
    end
    
    always@(negedge clk) begin 
        if (RegWrite == 1 && WriteRegister != 0) begin
                $display("WriteData: ", WriteData, " WriteReg: ", WriteRegister);
                Registers[WriteRegister] <= WriteData;
            end
        else if(JAL == 1)begin
                Registers[31] <= CurAddress + 4;
            end
        end
        
    
endmodule
