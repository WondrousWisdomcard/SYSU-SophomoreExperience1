`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/25 21:49:43
// Design Name: 
// Module Name: DataMemory
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
       
     //5£¬20£¬15£¬12£¬36£¬45£¬47£¬18
  
     initial 
     begin
        //5
        Memory[0] <= 8'b00000000;
        Memory[1] <= 8'b00000000;
        Memory[2] <= 8'b00000000;
        Memory[3] <= 8'b00000101;
        //20
        Memory[4] <= 8'b00000000;
        Memory[5] <= 8'b00000000;
        Memory[6] <= 8'b00000000;
        Memory[7] <= 8'b00010100;
        //15
        Memory[8] <= 8'b00000000;
        Memory[9] <= 8'b00000000;
        Memory[10] <= 8'b00000000;
        Memory[11] <= 8'b00001111;
        //12
        Memory[12] <= 8'b00000000;
        Memory[13] <= 8'b00000000;
        Memory[14] <= 8'b00000000;
        Memory[15] <= 8'b00001100;
        //36
        Memory[16] <= 8'b00000000;
        Memory[17] <= 8'b00000000;
        Memory[18] <= 8'b00000000;
        Memory[19] <= 8'b00100100;
        //45
        Memory[20] <= 8'b00000000;
        Memory[21] <= 8'b00000000;
        Memory[22] <= 8'b00000000;
        Memory[23] <= 8'b00101101;
        //47
        Memory[24] <= 8'b00000000;
        Memory[25] <= 8'b00000000;
        Memory[26] <= 8'b00000000;
        Memory[27] <= 8'b00101111;
        //18
        Memory[28] <= 8'b00000000;
        Memory[29] <= 8'b00000000;
        Memory[30] <= 8'b00000000;
        Memory[31] <= 8'b00010010;
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
