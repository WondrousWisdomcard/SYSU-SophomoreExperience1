`timescale 1ns / 1ps

module Light(rclk,Address,display_out,dp,select);

    input rclk;
    input [15:0] Address;
    output reg [6:0] display_out;
    output reg dp = 1;//小数点是否显示
    output reg [3:0] select; //选哪个灯
    
     parameter s0 = 7'b0000001, s1 = 7'b1001111, s2 = 7'b0010010, s3 = 7'b0000110, s4 = 7'b1001100;
     parameter s5 = 7'b0100100, s6 = 7'b0100000, s7 = 7'b0001111, s8 = 7'b0000000, s9 = 7'b0000100;
     parameter sa = 7'b0001000, sb = 7'b1100000, sc = 7'b0110001, sd = 7'b1000010, se = 7'b0110000, sf = 7'b0111000;
     
    // 灯显示的数字
    wire [3:0] num1; 
    wire [3:0] num2;
    wire [3:0] num3;
    wire [3:0] num4;
    
    reg [31:0] divclk_cnt = 0;
    reg divclk = 0;
    reg [1:0] changeclk= 0;

    assign num1 = Address[15:12];
    assign num2 = Address[11:8];
    assign num3 = Address[7:4];
    assign num4 = Address[3:0];
    
always @(posedge rclk)
begin
        if(divclk_cnt == 20000) begin
        divclk_cnt = 0;
        changeclk = changeclk + 1;
        if(changeclk == 4) begin divclk_cnt = 0; end
        end
        else divclk_cnt = divclk_cnt + 1;
end

always @(posedge rclk) //只管灯的赋值
begin
    if(changeclk == 0)
    begin
        select <= 4'b0111;
        case(num1)
                    0: display_out <= s0;
                    1: display_out <= s1;
                    2: display_out <= s2;
                    3: display_out <= s3;
                    4: display_out <= s4;
                    5: display_out <= s5;
                    6: display_out <= s6;
                    7: display_out <= s7;
                    8: display_out <= s8;
                    9: display_out <= s9;
                    10: display_out <= sa;
                    11: display_out <= sb;
                    12: display_out <= sc;
                    13: display_out <= sd;
                    14: display_out <= se;
                    15: display_out <= sf;
                    default: display_out <= 7'b1111111;
                endcase
    end
    if(changeclk == 1)
    begin
        select <= 4'b1011;
        case(num2)
                    0: display_out <= s0;
                    1: display_out <= s1;
                    2: display_out <= s2;
                    3: display_out <= s3;
                    4: display_out <= s4;
                    5: display_out <= s5;
                    6: display_out <= s6;
                    7: display_out <= s7;
                    8: display_out <= s8;
                    9: display_out <= s9;
                    10: display_out <= sa;
                    11: display_out <= sb;
                    12: display_out <= sc;
                    13: display_out <= sd;
                    14: display_out <= se;
                    15: display_out <= sf;
                    default: display_out <= 7'b1111111;
                endcase
    end
    if(changeclk == 2)
    begin
        select <= 4'b1101;
        case(num3)
                    0: display_out <= s0;
                    1: display_out <= s1;
                    2: display_out <= s2;
                    3: display_out <= s3;
                    4: display_out <= s4;
                    5: display_out <= s5;
                    6: display_out <= s6;
                    7: display_out <= s7;
                    8: display_out <= s8;
                    9: display_out <= s9;
                    10: display_out <= sa;
                    11: display_out <= sb;
                    12: display_out <= sc;
                    13: display_out <= sd;
                    14: display_out <= se;
                    15: display_out <= sf;
                    default: display_out <= 7'b1111111;
                endcase
    end
    if(changeclk == 3)
    begin
        select <= 4'b1110;
        case(num4)
            0: display_out <= s0;
            1: display_out <= s1;
            2: display_out <= s2;
            3: display_out <= s3;
            4: display_out <= s4;
            5: display_out <= s5;
            6: display_out <= s6;
            7: display_out <= s7;
            8: display_out <= s8;
            9: display_out <= s9;
            10: display_out <= sa;
            11: display_out <= sb;
            12: display_out <= sc;
            13: display_out <= sd;
            14: display_out <= se;
            15: display_out <= sf;
            default: display_out <= 7'b1111111;
        endcase
    end
end

endmodule