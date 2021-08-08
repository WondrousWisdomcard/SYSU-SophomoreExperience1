`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/07 19:46:45
// Design Name: 
// Module Name: mul
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

module mul(clk, A, B, PA);
    
    input clk;
    input [3:0] A, B;
    output [7:0] PA;

    reg [7:0] PA;

    parameter s0 = 0, s1 = 1, s2 = 2;
    reg [2:0] count = 0;
    reg [1:0] state = 0;
    reg [8:0] S; //计算过程中的Carry-out P A,共九位
    reg [8:0] T; //对B进行符号位扩展，为了计算方便，九位的T中存放的是0 B 0000。
    
    always @(posedge clk) begin
        case (state)
            s0: begin //初始化临时变量过程
                count = 0;
                S = {{5{1'b0}},A}; 
                T = {{1{1'b0}},B,{4{1'b0}}};
                state = s1;
            end
            s1: begin //移位计算过程，重复四次
                if(count == 3'b100) 
                    state = s2;
                else begin
                    if(S[0] == 1'b1) S = S + T;
                    else S = S;
                    
                    S = S >> 1; //不可以用<= 不然会与上一句出现竞争，导致输出结果错误
                    count = count + 1;
                    state = s1;
                end
            end
            s2: begin //保存结果
                PA = {S[7:0]};
                state = s0;
            end
            default: ;
        endcase
    end

endmodule
