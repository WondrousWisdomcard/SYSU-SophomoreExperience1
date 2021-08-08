`timescale 1ns / 1ps
module xlfsq2(input clk,output led);
reg led;
reg[31:0] divclk_cnt = 0;
reg divclk=0;
reg [2:0] state=state_A;
parameter
state_A=3'b000,state_B=3'b001,state_C=3'b010,state_D=3'b011,state_E=3'b100;
always@(posedge clk)
begin
if(divclk_cnt==25000000)
begin
divclk =~ divclk;
divclk_cnt = 0;
end
else
begin
divclk_cnt = divclk_cnt+1'b1;
end
end
always@(posedge divclk)
begin
case (state)
state_A:
begin
state<=state_B; led<=1;
end
state_B:
begin
state<=state_C; led<=0;
end
state_C:
begin
state<=state_D; led<=0;
end
state_D:
begin
state<=state_E; led<=1;
end
state_E:
begin
state<=state_A; led<=1;
end
default:
begin
state<=state_A; led<=1;
end
endcase
end
endmodule
