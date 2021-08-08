// Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
// Date        : Sun Oct 25 13:38:39 2020
// Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode synth_stub -rename_top full_adder_1 -prefix
//               full_adder_1_ full_adder_0_stub.v
// Design      : full_adder_0
// Purpose     : Stub declaration of top-level module interface
// Device      : xc7a35tcpg236-1
// --------------------------------------------------------------------------------

// This empty module with port declaration file causes synthesis tools to infer a black box for IP.
// The synthesis directives are for Synopsys Synplify support to prevent IO buffer insertion.
// Please paste the declaration into a Verilog source file or add the file as an additional source.
(* X_CORE_INFO = "full_adder,Vivado 2017.4" *)
module full_adder_1(Ai, Bi, Ci, Si, Ci_1)
/* synthesis syn_black_box black_box_pad_pin="Ai,Bi,Ci,Si,Ci_1" */;
  input Ai;
  input Bi;
  input Ci;
  output Si;
  output Ci_1;
endmodule
