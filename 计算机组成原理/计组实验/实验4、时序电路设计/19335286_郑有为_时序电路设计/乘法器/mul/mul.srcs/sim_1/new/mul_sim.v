`timescale 1ns / 1ps
module mul_sim;
reg clk;
reg [3:0] x;
reg [3:0] y;
wire [7:0] result;
mul u1(clk,x,y,result);
initial begin
    clk = 0;
    x = 4;
    y = 8;
end
always #1 begin clk =~ clk; end
always #14 begin x = x + 1; y = y + 2; end
endmodule
