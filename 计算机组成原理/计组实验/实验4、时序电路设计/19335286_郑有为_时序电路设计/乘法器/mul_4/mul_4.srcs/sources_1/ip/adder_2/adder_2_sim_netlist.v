// Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
// Date        : Tue Nov 10 21:31:21 2020
// Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode funcsim -rename_top adder_2 -prefix
//               adder_2_ adder_1_sim_netlist.v
// Design      : adder_1
// Purpose     : This verilog netlist is a functional simulation representation of the design and should not be modified
//               or synthesized. This netlist cannot be used for SDF annotated simulation.
// Device      : xc7a35tcpg236-1
// --------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

module adder_2_adder
   (A,
    B,
    M,
    S,
    C4,
    o);
  input [3:0]A;
  input [3:0]B;
  input M;
  output [3:0]S;
  output C4;
  output o;

  wire [3:0]A;
  wire [3:0]B;
  wire Bi0;
  wire Bi00_out;
  wire Bi02_out;
  wire Bi04_out;
  wire C0;
  wire C1;
  wire C2;
  wire C4;
  wire M;
  wire [3:0]S;
  wire o;

  (* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) 
  (* DowngradeIPIdentifiedWarnings = "yes" *) 
  (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
  adder_2_full_adder_1__1 add1
       (.Ai(A[0]),
        .Bi(Bi0),
        .Ci(M),
        .Ci_1(C0),
        .Si(S[0]));
  (* SOFT_HLUTNM = "soft_lutpair0" *) 
  LUT2 #(
    .INIT(4'h6)) 
    add1_i_1
       (.I0(B[0]),
        .I1(M),
        .O(Bi0));
  (* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) 
  (* DowngradeIPIdentifiedWarnings = "yes" *) 
  (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
  adder_2_full_adder_1__2 add2
       (.Ai(A[1]),
        .Bi(Bi00_out),
        .Ci(C0),
        .Ci_1(C1),
        .Si(S[1]));
  (* SOFT_HLUTNM = "soft_lutpair0" *) 
  LUT2 #(
    .INIT(4'h6)) 
    add2_i_1
       (.I0(B[1]),
        .I1(M),
        .O(Bi00_out));
  (* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) 
  (* DowngradeIPIdentifiedWarnings = "yes" *) 
  (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
  adder_2_full_adder_1__3 add3
       (.Ai(A[2]),
        .Bi(Bi02_out),
        .Ci(C1),
        .Ci_1(C2),
        .Si(S[2]));
  (* SOFT_HLUTNM = "soft_lutpair1" *) 
  LUT2 #(
    .INIT(4'h6)) 
    add3_i_1
       (.I0(B[2]),
        .I1(M),
        .O(Bi02_out));
  (* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) 
  (* DowngradeIPIdentifiedWarnings = "yes" *) 
  (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
  adder_2_full_adder_1 add4
       (.Ai(A[3]),
        .Bi(Bi04_out),
        .Ci(C2),
        .Ci_1(C4),
        .Si(S[3]));
  (* SOFT_HLUTNM = "soft_lutpair1" *) 
  LUT2 #(
    .INIT(4'h6)) 
    add4_i_1
       (.I0(B[3]),
        .I1(M),
        .O(Bi04_out));
  LUT2 #(
    .INIT(4'h6)) 
    o_INST_0
       (.I0(C4),
        .I1(C2),
        .O(o));
endmodule

(* CHECK_LICENSE_TYPE = "adder_1,adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* X_CORE_INFO = "adder,Vivado 2017.4" *) 
(* NotValidForBitStream *)
module adder_2
   (A,
    B,
    M,
    S,
    C4,
    o);
  input [3:0]A;
  input [3:0]B;
  input M;
  output [3:0]S;
  output C4;
  output o;

  wire [3:0]A;
  wire [3:0]B;
  wire C4;
  wire M;
  wire [3:0]S;
  wire o;

  adder_2_adder inst
       (.A(A),
        .B(B),
        .C4(C4),
        .M(M),
        .S(S),
        .o(o));
endmodule

module adder_2_full_adder
   (Ci_1,
    Ci,
    Bi,
    Ai);
  output Ci_1;
  input Ci;
  input Bi;
  input Ai;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;

  LUT3 #(
    .INIT(8'hE8)) 
    Ci_1__0
       (.I0(Ci),
        .I1(Bi),
        .I2(Ai),
        .O(Ci_1));
endmodule

(* ORIG_REF_NAME = "full_adder" *) 
module adder_2_full_adder_0
   (Ci_1,
    Ci,
    Bi,
    Ai);
  output Ci_1;
  input Ci;
  input Bi;
  input Ai;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;

  LUT3 #(
    .INIT(8'hE8)) 
    Ci_1__0
       (.I0(Ci),
        .I1(Bi),
        .I2(Ai),
        .O(Ci_1));
endmodule

(* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
module adder_2_full_adder_1
   (Ai,
    Bi,
    Ci,
    Si,
    Ci_1);
  input Ai;
  input Bi;
  input Ci;
  output Si;
  output Ci_1;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;
  wire Si;

  LUT3 #(
    .INIT(8'h96)) 
    Si_INST_0
       (.I0(Bi),
        .I1(Ai),
        .I2(Ci),
        .O(Si));
  adder_2_full_adder inst
       (.Ai(Ai),
        .Bi(Bi),
        .Ci(Ci),
        .Ci_1(Ci_1));
endmodule

(* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* ORIG_REF_NAME = "full_adder_1" *) 
(* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
module adder_2_full_adder_1__1
   (Ai,
    Bi,
    Ci,
    Si,
    Ci_1);
  input Ai;
  input Bi;
  input Ci;
  output Si;
  output Ci_1;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;
  wire Si;

  LUT3 #(
    .INIT(8'h96)) 
    Si_INST_0
       (.I0(Bi),
        .I1(Ai),
        .I2(Ci),
        .O(Si));
  adder_2_full_adder_2 inst
       (.Ai(Ai),
        .Bi(Bi),
        .Ci(Ci),
        .Ci_1(Ci_1));
endmodule

(* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* ORIG_REF_NAME = "full_adder_1" *) 
(* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
module adder_2_full_adder_1__2
   (Ai,
    Bi,
    Ci,
    Si,
    Ci_1);
  input Ai;
  input Bi;
  input Ci;
  output Si;
  output Ci_1;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;
  wire Si;

  LUT3 #(
    .INIT(8'h96)) 
    Si_INST_0
       (.I0(Bi),
        .I1(Ai),
        .I2(Ci),
        .O(Si));
  adder_2_full_adder_1__4 inst
       (.Ai(Ai),
        .Bi(Bi),
        .Ci(Ci),
        .Ci_1(Ci_1));
endmodule

(* CHECK_LICENSE_TYPE = "full_adder_1,full_adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* ORIG_REF_NAME = "full_adder_1" *) 
(* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
module adder_2_full_adder_1__3
   (Ai,
    Bi,
    Ci,
    Si,
    Ci_1);
  input Ai;
  input Bi;
  input Ci;
  output Si;
  output Ci_1;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;
  wire Si;

  LUT3 #(
    .INIT(8'h96)) 
    Si_INST_0
       (.I0(Bi),
        .I1(Ai),
        .I2(Ci),
        .O(Si));
  adder_2_full_adder_0 inst
       (.Ai(Ai),
        .Bi(Bi),
        .Ci(Ci),
        .Ci_1(Ci_1));
endmodule

(* ORIG_REF_NAME = "full_adder" *) 
module adder_2_full_adder_1__4
   (Ci_1,
    Ci,
    Bi,
    Ai);
  output Ci_1;
  input Ci;
  input Bi;
  input Ai;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;

  LUT3 #(
    .INIT(8'hE8)) 
    Ci_1__0
       (.I0(Ci),
        .I1(Bi),
        .I2(Ai),
        .O(Ci_1));
endmodule

(* ORIG_REF_NAME = "full_adder" *) 
module adder_2_full_adder_2
   (Ci_1,
    Ci,
    Bi,
    Ai);
  output Ci_1;
  input Ci;
  input Bi;
  input Ai;

  wire Ai;
  wire Bi;
  wire Ci;
  wire Ci_1;

  LUT3 #(
    .INIT(8'hE8)) 
    Ci_1__0
       (.I0(Ci),
        .I1(Bi),
        .I2(Ai),
        .O(Ci_1));
endmodule
`ifndef GLBL
`define GLBL
`timescale  1 ps / 1 ps

module glbl ();

    parameter ROC_WIDTH = 100000;
    parameter TOC_WIDTH = 0;

//--------   STARTUP Globals --------------
    wire GSR;
    wire GTS;
    wire GWE;
    wire PRLD;
    tri1 p_up_tmp;
    tri (weak1, strong0) PLL_LOCKG = p_up_tmp;

    wire PROGB_GLBL;
    wire CCLKO_GLBL;
    wire FCSBO_GLBL;
    wire [3:0] DO_GLBL;
    wire [3:0] DI_GLBL;
   
    reg GSR_int;
    reg GTS_int;
    reg PRLD_int;

//--------   JTAG Globals --------------
    wire JTAG_TDO_GLBL;
    wire JTAG_TCK_GLBL;
    wire JTAG_TDI_GLBL;
    wire JTAG_TMS_GLBL;
    wire JTAG_TRST_GLBL;

    reg JTAG_CAPTURE_GLBL;
    reg JTAG_RESET_GLBL;
    reg JTAG_SHIFT_GLBL;
    reg JTAG_UPDATE_GLBL;
    reg JTAG_RUNTEST_GLBL;

    reg JTAG_SEL1_GLBL = 0;
    reg JTAG_SEL2_GLBL = 0 ;
    reg JTAG_SEL3_GLBL = 0;
    reg JTAG_SEL4_GLBL = 0;

    reg JTAG_USER_TDO1_GLBL = 1'bz;
    reg JTAG_USER_TDO2_GLBL = 1'bz;
    reg JTAG_USER_TDO3_GLBL = 1'bz;
    reg JTAG_USER_TDO4_GLBL = 1'bz;

    assign (strong1, weak0) GSR = GSR_int;
    assign (strong1, weak0) GTS = GTS_int;
    assign (weak1, weak0) PRLD = PRLD_int;

    initial begin
	GSR_int = 1'b1;
	PRLD_int = 1'b1;
	#(ROC_WIDTH)
	GSR_int = 1'b0;
	PRLD_int = 1'b0;
    end

    initial begin
	GTS_int = 1'b1;
	#(TOC_WIDTH)
	GTS_int = 1'b0;
    end

endmodule
`endif
