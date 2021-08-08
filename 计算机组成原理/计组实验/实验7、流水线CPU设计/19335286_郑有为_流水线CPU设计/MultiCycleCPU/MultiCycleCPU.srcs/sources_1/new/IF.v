`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 15:24:39
// Module Name: IF
//////////////////////////////////////////////////////////////////////////////////

module IF(
    input clk,
    input reset,
    input PCSrcFromBranch, 
    input Jump,
    input [31:0] Add2ResultFromEXMEM,
    input [31:0] JumpAddress,
    output [31:0] ResultFromAdd1,
    output [31:0] Instruction,
    output [31:0] Address
    );
            
    wire [31:0] ResultFromMux4;
    //wire [31:0] Address;
    wire [31:0] ResultFromMux6;
    
    Mux4 mux4(PCSrcFromBranch,ResultFromAdd1,Add2ResultFromEXMEM, ResultFromMux4);
    
    Mux6 mux6(Jump,ResultFromMux4,JumpAddress,ResultFromMux6);
     
    PC pc(clk,reset,ResultFromMux6,Address);
    
    InstructionMemory instructionmemory(Address,Instruction);
    
    Add1 add1(Address,ResultFromAdd1);
     
endmodule
