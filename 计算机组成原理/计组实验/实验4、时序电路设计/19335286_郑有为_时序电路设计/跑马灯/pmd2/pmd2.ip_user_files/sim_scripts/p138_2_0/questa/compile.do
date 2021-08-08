vlib questa_lib/work
vlib questa_lib/msim

vlib questa_lib/msim/xil_defaultlib

vmap xil_defaultlib questa_lib/msim/xil_defaultlib

vlog -work xil_defaultlib -64 \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/p138_2.v" \
"../../../../pmd2.srcs/sources_1/ip/p138_2_0/sim/p138_2_0.v" \


vlog -work xil_defaultlib \
"glbl.v"

