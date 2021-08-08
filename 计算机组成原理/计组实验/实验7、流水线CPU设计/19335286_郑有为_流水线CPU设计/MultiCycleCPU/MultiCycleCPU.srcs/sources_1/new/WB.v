`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/14 20:23:48
// Module Name: WB
//////////////////////////////////////////////////////////////////////////////////


module WB(
    input MemToRegFromMEMWB,
    input [31:0] ReadDataFromMEMWB,
    input [31:0] ALUResultFromMEMWB,
    output [31:0] WriteDataFromMux3
    );
    
    Mux3 mux3(MemToRegFromMEMWB,ReadDataFromMEMWB,ALUResultFromMEMWB,WriteDataFromMux3);
    always @ (MemToRegFromMEMWB or ReadDataFromMEMWB or ALUResultFromMEMWB)
    $display("ALUResultFromMEMWB: ",ALUResultFromMEMWB);
endmodule
