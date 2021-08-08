`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/12/13 16:26:06
// Design Name: 
// Module Name: ID
//////////////////////////////////////////////////////////////////////////////////

module ID(
    input clk,
    input [31:0] AddressFromIFID,
    input [31:0] InstructionFromIFID,
    
    input RegWriteFromMEMWB,
    input [4:0] WriteRegisterFromMEMWB,
    input [31:0] WriteDataFromMux3,
    
    output RegDst,
    output Jump,
    output Branch,
    output MemRead,
    output MemToReg,
    output MemWrite,
    output ALUSrc1,
    output ALUSrc2,
    output RegWrite,
    output [31:0] ReadData1,
    output [31:0] ReadData2,
    output [31:0] ExtendedData,
    output [31:0] JumpAddress
    );
    
    Registers registers(clk,InstructionFromIFID,RegWriteFromMEMWB,WriteRegisterFromMEMWB,WriteDataFromMux3,ReadData1,ReadData2);
    
    SignExtend signextend(clk,InstructionFromIFID,ExtendedData);
    
    Control control(InstructionFromIFID,RegDst,Jump,Branch,MemRead,MemToReg,MemWrite,ALUSrc1,ALUSrc2,RegWrite);
    
    JumpUnit jumpunit(AddressFromIFID,InstructionFromIFID,JumpAddress);
    
endmodule
