// Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
// Date        : Sun Oct 25 10:36:16 2020
// Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode synth_stub -rename_top p138_0 -prefix
//               p138_0_ p138_0_stub.v
// Design      : p138_0
// Purpose     : Stub declaration of top-level module interface
// Device      : xc7a35tcpg236-1
// --------------------------------------------------------------------------------

// This empty module with port declaration file causes synthesis tools to infer a black box for IP.
// The synthesis directives are for Synopsys Synplify support to prevent IO buffer insertion.
// Please paste the declaration into a Verilog source file or add the file as an additional source.
(* X_CORE_INFO = "p138,Vivado 2017.4" *)
module p138_0(g1, g2a_l, g2b_l, a, y_l)
/* synthesis syn_black_box black_box_pad_pin="g1,g2a_l,g2b_l,a[2:0],y_l[7:0]" */;
  input g1;
  input g2a_l;
  input g2b_l;
  input [2:0]a;
  output [7:0]y_l;
endmodule
