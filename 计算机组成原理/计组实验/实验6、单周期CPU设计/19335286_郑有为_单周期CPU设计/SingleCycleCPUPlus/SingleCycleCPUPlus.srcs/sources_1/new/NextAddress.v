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
    input JR,
    input BranchNot,
    input [31:0] CurAddress,
    input [31:0] Instruction,
    input [31:0] SignExtend,
    input [31:0] fromReg31,
    output reg [31:0] NewAddress
    );
    
        
    reg [1:0] Mux;
    wire [31:0] TempAddress = CurAddress + 4;
    always @ (Jump or Branch or Zero or CurAddress or JR or BranchNot)
    begin
        if(JR == 1)
        begin
        $display("JR");
        NewAddress = fromReg31;
        end
        else if(Jump == 1 && Branch == 0)
        begin
        $display("JUMP");
        NewAddress = {4'b0000,Instruction[25:0],2'b00};
        end
        else if(Jump == 0 && Branch == 1 && Zero == 1)
        begin
        $display("Branch");
        NewAddress = TempAddress + SignExtend * 4;
        end
        else if(Jump == 0 && BranchNot == 1 && Zero == 0)
        begin
        $display("BranchNot");
        NewAddress = TempAddress + SignExtend * 4;
        end
        else
        begin
        $display("Normal");
        NewAddress = CurAddress + 4;
        end
    end
endmodule
