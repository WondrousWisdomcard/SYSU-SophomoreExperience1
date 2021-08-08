onbreak {quit -f}
onerror {quit -f}

vsim -t 1ps -lib xil_defaultlib p138_2_0_opt

do {wave.do}

view wave
view structure
view signals

do {p138_2_0.udo}

run -all

quit -force
