`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/11/27 18:09:40
// Design Name: 
// Module Name: ToFPGA
//////////////////////////////////////////////////////////////////////////////////


module ToFPGA(
    input rclk,
    input clk,
    input reset,
        
    output [6:0] display_out,//�߶������
    output dp,//С�����Ƿ���ʾ
    output [3:0] select, //ѡ�ĸ���
    output [15:0] PCandWriteData
    );
    
    wire [31:0] Instruction;
    //wire [15:0] PCandWriteData;
    
    CPU_top CPU_test(clk,reset,PCandWriteData,Instruction);
    
    Light light(rclk,PCandWriteData,display_out,dp,select);
    
endmodule

