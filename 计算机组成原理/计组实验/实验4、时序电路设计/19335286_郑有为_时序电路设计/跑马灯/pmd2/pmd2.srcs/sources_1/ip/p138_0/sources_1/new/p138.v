`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/10/25 09:11:51
// Design Name: 
// Module Name: p138
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


module p138(g1,g2a_l,g2b_l,a,y_l);
input g1,g2a_l,g2b_l;
input [2:0] a;
output [7:0] y_l;
reg [7:0] y_l=0;
always @ (g1 or g2a_l or g2b_l or a)
begin
    if(g1 && ~g2a_l && ~g2b_l)
        case (a)
            7:y_l=8'b01111111;
            6:y_l=8'b10111111;
            5:y_l=8'b11011111;
            4:y_l=8'b11101111;
            3:y_l=8'b11110111;
            2:y_l=8'b11111011;
            1:y_l=8'b11111101;
            0:y_l=8'b11111110;
            default:y_l=8'b11111111;
        endcase
    else
        y_l=8'b11111111;
    end;
endmodule
