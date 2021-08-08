vlib work
vlib activehdl

vlib activehdl/xil_defaultlib

vmap xil_defaultlib activehdl/xil_defaultlib

vlog -work xil_defaultlib  -v2k5 \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/p138_2.v" \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/sim/p138_2_0.v" \


vlog -work xil_defaultlib \
"glbl.v"

