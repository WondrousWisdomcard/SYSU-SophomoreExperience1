`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 11:45:26
// Design Name: 
// Module Name: full_adder_sim
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


module full_adder_sim();
    reg a;
    reg b;
    reg c;
    wire s;
    wire cn;
    full_adder test(a,b,c,s,cn);
    initial begin
    a = 0;
    b = 0;
    c = 0;
    end
    always #10 {a,b,c}={a,b,c}+1;
endmodule
