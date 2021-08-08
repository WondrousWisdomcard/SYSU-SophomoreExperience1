`timescale 1ns / 1ps

module timem(clk,btnl,btnr,display_out,dp,select);

    input clk,btnl,btnr;
    output display_out;
    output dp = 1;
    output select;
    
     parameter s0 = 7'b0000001, s1 = 7'b1001111, s2 = 7'b0010010, s3 = 7'b0000110, s4 = 7'b1001100;
     parameter s5 = 7'b0100100, s6 = 7'b0100000, s7 = 7'b0001111, s8 = 7'b0000000, s9 = 7'b0000100;
     
    reg [6:0] display_out;
    reg [3:0] select; //选哪个灯
    reg [3:0] num = 4; // 灯显示的数字
    reg dp = 1'b1; //小数点是否显示
    
    reg [31:0] divclk_cnt = 0;
    reg divclk = 0;
    reg [1:0] changeclk= 0;


reg lastLeft = 0;
reg lastRight = 0;
always @(posedge clk)
begin
    if(divclk_cnt == 50000) //分频,使得一个周期内的抖动只视为一次摁下
    begin
        divclk_cnt = 0;
        changeclk = changeclk + 1;
        if(changeclk == 4) begin divclk_cnt = 0; end
        
        if(lastLeft == 0 && btnl == 1)
        begin
            lastLeft = 1;
            if(num != 9) num = num + 1;
            else num = 0;
        end

        if(lastRight == 0 && btnr == 1)
        begin
            lastRight = 1;
            if(num != 0) num = num - 1;
            else num = 9;
        end

        if(lastLeft == 1 && btnl == 0)
        begin lastLeft = 0; end

        if(lastRight == 1 && btnr == 0)
        begin lastRight = 0; end

    end
    else divclk_cnt <= divclk_cnt + 1;
end

 
always @(posedge clk) //只管灯的赋值
begin
    if(changeclk == 0)
    begin
        select <= 4'b0111;
        display_out <= s1;
        dp <= 1;
    end
    if(changeclk == 1)
    begin
        select <= 4'b1011;
        display_out <= s2;
        dp <= 0;
    end
    if(changeclk == 2)
    begin
        select <= 4'b1101;
        display_out <= s3;
        dp <= 1;
    end
    if(changeclk == 3)
    begin
        select <= 4'b1110;
        dp <= 1;
        case(num)
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
            default: display_out <= 7'b1111111;
        endcase
    end
end


endmodule