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
    input [3:0] ResultFromALUControl,
    input [31:0] ResultFromMux5,
    input [31:0] ResultFromMux2,
    output reg [31:0] ALUResult,
    output Zero
    );
    always @ (ResultFromALUControl or ResultFromMux2 or ResultFromMux5)
    begin
        case(ResultFromALUControl)
            4'b0000: ALUResult = ResultFromMux5 & ResultFromMux2;
            4'b0001: ALUResult = ResultFromMux5 | ResultFromMux2;
            4'b0010: ALUResult = ResultFromMux5 + ResultFromMux2;
            4'b0110: ALUResult = ResultFromMux5 - ResultFromMux2;
            4'b0111: ALUResult  = ResultFromMux5 < ResultFromMux2 ? 1 : 0;
            4'b1100: ALUResult = ResultFromMux5 ^ ResultFromMux2;
        endcase
    end
    assign Zero = ( ALUResult == 0) ? 1 : 0;
endmodule
