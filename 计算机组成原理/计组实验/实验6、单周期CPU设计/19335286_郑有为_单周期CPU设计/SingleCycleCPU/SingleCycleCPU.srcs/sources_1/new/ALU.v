`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/23 23:46:13
// Module Name: ALU
// 
//////////////////////////////////////////////////////////////////////////////////

module ALU(
    input [3:0] ALUControl,
    input [31:0] ALUInput1,
    input [31:0] ALUInput2,
    output reg [31:0] Result,
    output Zero
    );
    always @ (ALUControl or ALUInput2 or ALUInput1)
    begin
        case(ALUControl)
            4'b0000: Result = ALUInput1 & ALUInput2;
            4'b0001: Result = ALUInput1 | ALUInput2;
            4'b0010: Result = ALUInput1 + ALUInput2;
            4'b0110: Result = ALUInput1 - ALUInput2;
            4'b0111: Result = ALUInput1 < ALUInput2 ? 1 : 0;
            4'b1100: Result = ALUInput1 ^ ALUInput2;
        endcase
    end
    assign Zero = (Result == 0) ? 1 : 0;
endmodule
