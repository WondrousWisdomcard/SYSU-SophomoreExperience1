// Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
// --------------------------------------------------------------------------------
// Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
// Date        : Sun Oct 25 13:38:39 2020
// Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
// Command     : write_verilog -force -mode funcsim -rename_top full_adder_0 -prefix
//               full_adder_0_ full_adder_0_sim_netlist.v
// Design      : full_adder_0
// Purpose     : This verilog netlist is a functional simulation representation of the design and should not be modified
//               or synthesized. This netlist cannot be used for SDF annotated simulation.
// Device      : xc7a35tcpg236-1
// --------------------------------------------------------------------------------
`timescale 1 ps / 1 ps

module full_adder_0_full_adder
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

(* CHECK_LICENSE_TYPE = "full_adder_0,full_adder,{}" *) (* DowngradeIPIdentifiedWarnings = "yes" *) (* X_CORE_INFO = "full_adder,Vivado 2017.4" *) 
(* NotValidForBitStream *)
module full_adder_0
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
  full_adder_0_full_adder inst
       (.Ai(Ai),
        .Bi(Bi),
        .Ci(Ci),
        .Ci_1(Ci_1));
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
