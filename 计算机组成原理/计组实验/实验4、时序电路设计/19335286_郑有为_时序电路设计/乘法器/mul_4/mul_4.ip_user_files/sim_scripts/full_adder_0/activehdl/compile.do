vlib work
vlib activehdl

vlib activehdl/xil_defaultlib

vmap xil_defaultlib activehdl/xil_defaultlib

vlog -work xil_defaultlib  -v2k5 \
"../../../../mul_4.srcs/sources_1/ip/full_adder_0/sources_1/new/full_adder.v" \
"../../../../mul_4.srcs/sources_1/ip/full_adder_0/sim/full_adder_0.v" \


vlog -work xil_defaultlib \
"glbl.v"

