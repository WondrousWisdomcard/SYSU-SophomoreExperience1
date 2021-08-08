`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 14:54:42
// Module Name: RegMEMWB
//////////////////////////////////////////////////////////////////////////////////


module RegMEMWB(
    input clk,
    input MemToRegFromEXMEM,
    input RegWriteFromEXMEM,
    input [31:0] ReadData,
    input [31:0] ALUResultFromEXMEM,
    input [4:0] ResultFromMux1FromEXMEM,
    
    output reg MemToRegFromMEMWB,
    output reg RegWriteFromMEMWB,
    output reg [31:0] ReadDataFromMEMWB,
    output reg [31:0] ALUResultFromMEMWB,
    output reg [4:0] ResultFromMux1FromMEMWB
    );
    
    reg StoreMemToReg;
    reg StoreRegWrite;
    reg [31:0] StoreReadData;
    reg [31:0] StoreALUResult;
    reg [4:0] StoreResultFromMux1;
    
    always @ (negedge clk) // WRITE
        begin
            StoreMemToReg = MemToRegFromEXMEM;
            StoreRegWrite = RegWriteFromEXMEM;
            StoreReadData = ReadData;
            StoreALUResult = ALUResultFromEXMEM;
            StoreResultFromMux1 = ResultFromMux1FromEXMEM;
            //$display("ALUResultFromEXMEM: ",ALUResultFromEXMEM);
        end
        
    always @ (posedge clk) // READ
        begin
            MemToRegFromMEMWB = StoreMemToReg;
            RegWriteFromMEMWB = StoreRegWrite;
            ReadDataFromMEMWB = StoreReadData;
            ALUResultFromMEMWB = StoreALUResult;
            ResultFromMux1FromMEMWB = StoreResultFromMux1;
        end
endmodule
