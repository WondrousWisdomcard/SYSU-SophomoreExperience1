`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/12/14 19:31:25
// Design Name: 
// Module Name: EX
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


module EX(
    input clk,
    input RegDstFromIDEX,
    input ALUSrc1FromIDEX,
    input ALUSrc2FromIDEX,
    input [31:0] AddressFromIDEX,
    input [31:0] ReadData1FromIDEX,
    input [31:0] ReadData2FromIDEX,
    input [31:0] ExtendedDataFromIDEX, 
    input [31:0] InstructionFromIDEX,
    output [31:0] ResultFromAdd2,
    output Zero,
    output [31:0] ALUResult,
    output [4:0] ResultFromMux1
    );
    
    wire [31:0] ResultFromMux5, ResultFromMux2;
    wire [3:0] ResultFromALUControl;
    
    Add2 add2(AddressFromIDEX, ExtendedDataFromIDEX,ResultFromAdd2);
    
    Mux5 mux5(ALUSrc1FromIDEX,ReadData1FromIDEX,InstructionFromIDEX,ResultFromMux5);
    
    Mux2 mux2(ALUSrc2FromIDEX,ReadData2FromIDEX,ExtendedDataFromIDEX,ResultFromMux2);
    
    Mux1 mux1(RegDstFromIDEX,InstructionFromIDEX,ResultFromMux1);
    
    always @ (RegDstFromIDEX or InstructionFromIDEX) 
    $display("ResultFromMux1: ",ResultFromMux1);
    
    ALUControl alucontrol(InstructionFromIDEX,ResultFromALUControl);
        
    ALU alu(ResultFromALUControl,ResultFromMux5,ResultFromMux2,ALUResult,Zero);
    
endmodule
