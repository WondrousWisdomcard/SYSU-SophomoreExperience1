`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/09 11:18:05
// Module Name: RegIFID
//////////////////////////////////////////////////////////////////////////////////


module RegIFID(
    input clk,
    input [31:0] ResultFromAdd1,
    input [31:0] Instruction,
    output reg [31:0] AddressFromIFID,
    output reg [31:0] InstructionFromIFID
    );
    
    initial AddressFromIFID = 0;
    
    reg [31:0] StoreAdd1Result;
    reg [31:0] StoreInstruction;
    
    always @ (negedge clk) // WRITE
    begin
        StoreAdd1Result = ResultFromAdd1;
        StoreInstruction = Instruction;
    end
    
    always @ (posedge clk) // READ
    begin
        AddressFromIFID = StoreAdd1Result;
        InstructionFromIFID = StoreInstruction;
    end
    
endmodule
