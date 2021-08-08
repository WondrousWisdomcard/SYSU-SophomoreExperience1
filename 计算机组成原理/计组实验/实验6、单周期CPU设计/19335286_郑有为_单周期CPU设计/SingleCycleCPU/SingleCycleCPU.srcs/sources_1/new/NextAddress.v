`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/11/19 21:37:26
// Design Name: 
// Module Name: NextAddress
// Description: 负责实现下一个Address是哪里，包含了图中的地址Add+4加法器，左移操作，3to1数据选择器
//////////////////////////////////////////////////////////////////////////////////

module NextAddress(
    input Jump,
    input Branch,
    input Zero,
    input [31:0] CurAddress,
    input [31:0] Instruction,
    input [31:0] SignExtend,
    output reg [31:0] NewAddress
    );
    
        
    reg [1:0] Mux;
    wire [31:0] TempAddress = CurAddress + 4;
    always @ (Jump or Branch or Zero or CurAddress)
    begin
        if(Jump == 0 && Branch == 1 && Zero == 1)
        NewAddress = TempAddress + SignExtend * 4;
        else if(Jump == 1)
        NewAddress = {TempAddress[31:28],Instruction[25:0],2'b00};
        else
        NewAddress = CurAddress + 4;
    end
endmodule
