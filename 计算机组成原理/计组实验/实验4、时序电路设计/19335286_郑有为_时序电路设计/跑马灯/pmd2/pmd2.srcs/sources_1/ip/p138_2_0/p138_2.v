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


module p138_2(g1,g2a_l,g2b_l,a,y_l);
input g1,g2a_l,g2b_l;
input [2:0] a;
output [7:0] y_l;
reg [7:0] y_l=0;
always @ (g1 or g2a_l or g2b_l or a)
begin
    if(g1 && ~g2a_l && ~g2b_l)
        case (a)
            7:y_l=8'b10000000;
            6:y_l=8'b01000000;
            5:y_l=8'b00100000;
            4:y_l=8'b00010000;
            3:y_l=8'b00001000;
            2:y_l=8'b00000100;
            1:y_l=8'b00000010;
            0:y_l=8'b00000001;
            default:y_l=8'b00000000;
        endcase
    else
        y_l=8'b00000000;
    end;
endmodule
