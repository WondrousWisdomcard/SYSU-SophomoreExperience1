`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 11:26:07
// Design Name: 
// Module Name: fulladder
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


module full_adder(
    input Ai,
    input Bi,
    input Ci,
    output Si,
    output Ci_1
    );
    assign Si = (Ai^Bi)^Ci;
    assign Ci_1 = ((Ai^Bi)&Ci)|(Ai&Bi);
endmodule