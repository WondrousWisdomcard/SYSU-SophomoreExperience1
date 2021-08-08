`timescale 1ns / 1ps

module mul_4_sim();
    reg clk = 0;
    reg[3:0] A;
    reg[3:0] B;
    wire[7:0] PA;
    mul_4 mul(clk,A,B,PA);
    initial
    begin
        clk = 0;
        A = 6;
        B = 8;
     
    end
    always #1
    begin
        clk =~ clk;
    end
    always #28
    begin
        A = A + 1;
        B = B + 2;
    end
endmodule
