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
    reg [8:0] S; //��������е�Carry-out P A,����λ
    reg [8:0] T; //��B���з���λ��չ��Ϊ�˼��㷽�㣬��λ��T�д�ŵ���0 B 0000��
    
    always @(posedge clk) begin
        case (state)
            s0: begin //��ʼ����ʱ��������
                count = 0;
                S = {{5{1'b0}},A}; 
                T = {{1{1'b0}},B,{4{1'b0}}};
                state = s1;
            end
            s1: begin //��λ������̣��ظ��Ĵ�
                if(count == 3'b100) 
                    state = s2;
                else begin
                    if(S[0] == 1'b1) S = S + T;
                    else S = S;
                    
                    S = S >> 1; //��������<= ��Ȼ������һ����־�������������������
                    count = count + 1;
                    state = s1;
                end
            end
            s2: begin //������
                PA = {S[7:0]};
                state = s0;
            end
            default: ;
        endcase
    end

endmodule
