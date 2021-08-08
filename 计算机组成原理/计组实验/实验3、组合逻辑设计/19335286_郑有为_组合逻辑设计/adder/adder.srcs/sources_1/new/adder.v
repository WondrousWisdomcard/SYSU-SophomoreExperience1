`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 13:37:14
// Design Name: 
// Module Name: adder
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


module adder(
    input [3:0]A,
    input [3:0]B,
    input M,
    output [3:0]S,
    output C4,
    output o
    );
    wire C0,C1,C2;
    full_adder_1 add1(A[0],B[0]^M,M,S[0],C0);
    full_adder_1 add2(A[1],B[1]^M,C0,S[1],C1);
    full_adder_1 add3(A[2],B[2]^M,C1,S[2],C2);
    full_adder_1 add4(A[3],B[3]^M,C2,S[3],C4);
    assign o = C4^C2;
endmodule
