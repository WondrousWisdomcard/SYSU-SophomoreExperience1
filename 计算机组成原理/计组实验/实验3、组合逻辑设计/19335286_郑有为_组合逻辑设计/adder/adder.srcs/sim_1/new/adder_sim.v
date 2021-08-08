`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 14:57:02
// Design Name: 
// Module Name: adder_sim
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

module adder_sim();
    reg [3:0] A;
    reg [3:0] B;
    reg M;
    wire [3:0] S;
    wire C4;
    wire o;
    /*
        adder add(.A(A),.B(B),.M(M),.S(S),.C4(C4),.o(o));
        initial begin
              A = 0;
              B = 0;
              M = 0;
        end
        always begin
            #10 {A} = {A} + 3;
            #10 {B} ={B} + 1;
        end
        */
    
    adder add(.A(A),.B(B),.M(M),.S(S),.C4(C4),.o(o));
                initial begin
                      A = 3;
                      B = 0;
                      M = 1;
                end
                always begin
                    #10 {A} = {A} + 1;
                    #10 {B} ={B} + 3;
                end
                
endmodule
