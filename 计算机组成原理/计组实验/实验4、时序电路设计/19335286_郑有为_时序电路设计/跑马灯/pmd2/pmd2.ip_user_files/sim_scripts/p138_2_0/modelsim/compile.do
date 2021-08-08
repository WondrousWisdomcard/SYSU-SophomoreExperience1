vlib modelsim_lib/work
vlib modelsim_lib/msim

vlib modelsim_lib/msim/xil_defaultlib

vmap xil_defaultlib modelsim_lib/msim/xil_defaultlib

vlog -work xil_defaultlib -64 -incr \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/p138_2.v" \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/sim/p138_2_0.v" \


vlog -work xil_defaultlib \
"glbl.v"

