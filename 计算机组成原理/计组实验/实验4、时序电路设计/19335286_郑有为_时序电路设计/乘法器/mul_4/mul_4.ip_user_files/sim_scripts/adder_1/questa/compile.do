vlib questa_lib/work
vlib questa_lib/msim

vlib questa_lib/msim/xil_defaultlib

vmap xil_defaultlib questa_lib/msim/xil_defaultlib

vlog -work xil_defaultlib -64 \
"../../../../mul_4.srcs/sources_1/ip/adder_1/sources_1/ip/full_adder_1/sources_1/new/full_adder.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_1/sources_1/ip/full_adder_1/sim/full_adder_1.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_1/sources_1/new/adder.v" \
"../../../../mul_4.srcs/sources_1/ip/adder_1/sim/adder_1.v" \


vlog -work xil_defaultlib \
"glbl.v"

