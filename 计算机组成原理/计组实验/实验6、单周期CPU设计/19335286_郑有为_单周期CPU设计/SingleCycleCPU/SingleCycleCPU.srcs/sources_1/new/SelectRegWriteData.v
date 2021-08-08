`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/25 22:03:12
//////////////////////////////////////////////////////////////////////////////////


module SelectRegWriteData(
    input MemToReg,
    input [31:0] ReadData,
    input [31:0] ALUResult,
    output reg [31:0] WriteData
    );
    
    always @ (MemToReg or ReadData or ALUResult)
    begin
        if(MemToReg == 1) WriteData = ReadData;
        else WriteData = ALUResult;
    end
endmodule
