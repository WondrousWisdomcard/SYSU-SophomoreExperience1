`timescale 1ns / 1ps
module mul_4(clk, A, B, PA);
    input clk;
    input [3:0] A, B;
    output [7:0] PA;
    reg [7:0] PA;
    parameter s0 = 0, s1 = 1, s2 = 2;
    reg [1:0] state = 0;
    reg [2:0] count = 0;
    reg [3:0] P = 0;
    reg Carryout = 0;
    reg [8:0] Temp;
    reg [3:0] TempA = 0;
    wire [3:0] TempP;
    wire TempCarryout;
    wire Non;
    adder_0 add(P, B, 0, TempP, TempCarryout, Non);
    always @ (posedge clk)
    begin
        case(state)
            s0: begin
                count <= 0;
                P <= 0;
                TempA <= A;
                state <= s1;
            end
            s1:begin
                if(count == 4) state <= s2;
                else
                begin
                    if(TempA[0] == 1)
                    begin 
                        P = TempP; 
                        Carryout = TempCarryout;
                    end
                    Temp = {Carryout,P,TempA};
                    Temp = Temp >> 1;
                    Carryout = Temp[8];
                    P = {Temp[7:4]};
                    TempA = {Temp[3:0]};
                    count = count + 1;
                end
            end
            s2:begin
                PA = Temp[7:0];
                state <= s0;
            end
        endcase        
    end
endmodule
