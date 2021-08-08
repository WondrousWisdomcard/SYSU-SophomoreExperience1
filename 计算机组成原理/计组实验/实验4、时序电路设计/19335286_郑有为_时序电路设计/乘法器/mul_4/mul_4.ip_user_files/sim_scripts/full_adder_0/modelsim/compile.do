vlib modelsim_lib/work
vlib modelsim_lib/msim

vlib modelsim_lib/msim/xil_defaultlib

vmap xil_defaultlib modelsim_lib/msim/xil_defaultlib

vlog -work xil_defaultlib -64 -incr \
"../../../../mul_4.srcs/sources_1/ip/full_adder_0/sources_1/new/full_adder.v" \
"../../../../mul_4.srcs/sources_1/ip/full_adder_0/sim/full_adder_0.v" \


vlog -work xil_defaultlib \
"glbl.v"

