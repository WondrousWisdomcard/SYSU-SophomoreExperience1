`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 14:43:52
// Module Name: DataMemory
//////////////////////////////////////////////////////////////////////////////////

module DataMemory(
    input clk,
    input MemWriteFromEXMEM,
    input MemReadFromEXMEM,
    input [31:0] ALUResultFromEXMEM,
    input [31:0] ReadData2FromEXMEM,
    output reg [31:0] ReadData
    );
    
     reg [7:0] Memory [0:64];
       
     //4£º32'h00000006
     //8£º32'h00000009
  
     initial 
     begin
        Memory[0] = 8'b00000000;
        Memory[1] = 8'b00000000;
        Memory[2] = 8'b00000000;
        Memory[3] = 8'b00000000;
        Memory[4] = 8'b00000000;
        Memory[5] = 8'b00000000;
        Memory[6] = 8'b00000000;
        Memory[7] = 8'b00000110;
        Memory[8] = 8'b00000000;
        Memory[9] = 8'b00000000;
        Memory[10] = 8'b00000000;
        Memory[11] = 8'b00001001;
     end
     always @ (MemReadFromEXMEM or ALUResultFromEXMEM) begin 
         if (MemReadFromEXMEM == 1) begin
             ReadData[31:24] = Memory[ALUResultFromEXMEM];
             ReadData[23:16] = Memory[ALUResultFromEXMEM + 1];
             ReadData[15:8] = Memory[ALUResultFromEXMEM + 2];
             ReadData[7:0] = Memory[ALUResultFromEXMEM + 3];
         end
     end
     always @ (posedge clk) begin 
         if (MemWriteFromEXMEM == 1) begin
             Memory[ALUResultFromEXMEM + 3] = ReadData2FromEXMEM[7:0];
             Memory[ALUResultFromEXMEM + 2] = ReadData2FromEXMEM[15:8];
             Memory[ALUResultFromEXMEM + 1] = ReadData2FromEXMEM[23:16];
             Memory[ALUResultFromEXMEM] = ReadData2FromEXMEM[31:24];
             $display("Memory:",ALUResultFromEXMEM," ReadData2FromEXMEM: ", ReadData2FromEXMEM);
         end
     end
endmodule

