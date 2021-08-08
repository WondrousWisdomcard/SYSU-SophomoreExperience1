`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/25 21:49:43
// Design Name: 
// Module Name: DataMemory
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

module DataMemory(
    input clk,
    input MemWrite,
    input MemRead,
    input [31:0] MemoryAddress, //ALUResult
    input [31:0] WriteData,
    output reg [31:0] ReadData
    );
    
     reg [7:0] Memory [0:255];
       
     //4£º32'h00000006
     //8£º32'h00000009
  
     initial 
     begin
        Memory[4] <= 8'b00000000;
        Memory[5] <= 8'b00000000;
        Memory[6] <= 8'b00000000;
        Memory[7] <= 8'b00000110;
        Memory[8] <= 8'b00000000;
        Memory[9] <= 8'b00000000;
        Memory[10] <= 8'b00000000;
        Memory[11] <= 8'b00001001;
     end
     
     always @ (MemRead or MemoryAddress) begin 
         if (MemRead == 1) begin
             ReadData[31:24] <= Memory[MemoryAddress];
             ReadData[23:16] <= Memory[MemoryAddress + 1];
             ReadData[15:8] <= Memory[MemoryAddress + 2];
             ReadData[7:0] <= Memory[MemoryAddress + 3];
         end
     end
   
     always @ (negedge clk) begin 
         if (MemWrite == 1) begin
             Memory[MemoryAddress + 3] <= WriteData[7:0];
             Memory[MemoryAddress + 2] <= WriteData[15:8];
             Memory[MemoryAddress + 1] <= WriteData[23:16];
             Memory[MemoryAddress] <= WriteData[31:24];
             $display("Memory:",MemoryAddress," WriteData: ", WriteData);
         end
     end
       
endmodule
