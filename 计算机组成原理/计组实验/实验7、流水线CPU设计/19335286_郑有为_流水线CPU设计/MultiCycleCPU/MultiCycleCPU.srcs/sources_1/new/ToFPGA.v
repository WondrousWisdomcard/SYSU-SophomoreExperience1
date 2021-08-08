`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2020/12/15 08:40:49
//////////////////////////////////////////////////////////////////////////////////

module ToFPGA(
    input rclk,
    input clk,
    input reset,
        
    output [6:0] display_out,//七段数码管
    output dp,//小数点是否显示
    output [3:0] select, //选哪个灯
    output [15:0] result
    );
    
    CPU cpu(clk,reset,result);
    
    Light light(rclk,result,display_out,dp,select);
    
endmodule