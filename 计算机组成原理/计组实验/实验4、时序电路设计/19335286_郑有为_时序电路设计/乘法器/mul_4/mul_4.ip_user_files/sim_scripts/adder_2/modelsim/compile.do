vlib modelsim_lib/work
vlib modelsim_lib/msim

vlib modelsim_lib/msim/xil_defaultlib

vmap xil_defaultlib modelsim_lib/msim/xil_defaultlib

vlog -work xil_defaultlib -64 -incr \
"../../../../mul_4.srcs/sources_1/ip/adder_2/sources_1/ip/full_adder_1/sources_1/new/full_adder.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_2/sources_1/ip/full_adder_1/sim/full_adder_1.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_2/sources_1/new/adder.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_2/sim/adder_2.v" \


vlog -work xil_defaultlib \
"glbl.v"

