`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Create Date: 2020/12/13 14:36:08
// Module Name: SetPCSrc
//////////////////////////////////////////////////////////////////////////////////


module SetPCSrc(
    input ZeroFromEXMEM,
    input BranchFromEXMEM,
    output reg PCSrcFromBranch
    );
    
    initial PCSrcFromBranch = 0;
    
    always @ (ZeroFromEXMEM or BranchFromEXMEM) 
        PCSrcFromBranch = ZeroFromEXMEM & BranchFromEXMEM;
endmodule
