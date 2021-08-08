onbreak {quit -f}
onerror {quit -f}

vsim -t 1ps -lib xil_defaultlib adder_2_opt

do {wave.do}

view wave
view structure
view signals

do {adder_2.udo}

run -all

quit -force
