`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 15:18:43
// Module Name: Mux3
//////////////////////////////////////////////////////////////////////////////////


module Mux3(
    input MemToRegFromMEMWB,
    input [31:0] ReadDataFromMEMWB,
    input [31:0] ALUResultFromMEMWB,
    output [31:0] WriteDataFromMux3
    );
    assign WriteDataFromMux3 = (MemToRegFromMEMWB == 0) ? ALUResultFromMEMWB : ReadDataFromMEMWB;
    always @ (MemToRegFromMEMWB or ALUResultFromMEMWB or ReadDataFromMEMWB)
    $display("WriteDataFromMux3: ",WriteDataFromMux3);
endmodule
