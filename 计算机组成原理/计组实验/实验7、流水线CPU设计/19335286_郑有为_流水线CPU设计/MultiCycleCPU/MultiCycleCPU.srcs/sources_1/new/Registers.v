`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 19:02:44
// Module Name: Registers
//////////////////////////////////////////////////////////////////////////////////
module Registers(
    input clk,
    input [31:0] InstructionFromIFID,
    input RegWriteFromMEMWB,
    input [4:0] WriteRegisterFromMEMWB,
    input [31:0] WriteDataFromMux3,
    output [31:0] ReadData1,
    output [31:0] ReadData2
    );
    
    reg [31:0] Registers[0:31];
    initial Registers[16] = 0;
    
    wire [4:0] ReadRegister1 = {InstructionFromIFID[25:21]};
    wire [4:0] ReadRegister2 = {InstructionFromIFID[20:16]};
    
    wire [4:0] WriteRegister = WriteRegisterFromMEMWB;
    
    assign ReadData1 = (ReadRegister1 == 0) ? 0 : Registers[ReadRegister1];
    assign ReadData2 = (ReadRegister2 == 0) ? 0 : Registers[ReadRegister2];
    
    always@(negedge clk) begin 
        if (RegWriteFromMEMWB == 1 && WriteRegister != 0) begin
                $display("WriteData: ", WriteDataFromMux3, " WriteReg: ", WriteRegister);
                Registers[WriteRegister] = WriteDataFromMux3;
            end
        end
endmodule
