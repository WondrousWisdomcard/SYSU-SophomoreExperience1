-- Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
-- Date        : Tue Nov 10 21:31:21 2020
-- Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode synth_stub -rename_top adder_2 -prefix
--               adder_2_ adder_1_stub.vhdl
-- Design      : adder_1
-- Purpose     : Stub declaration of top-level module interface
-- Device      : xc7a35tcpg236-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity adder_2 is
  Port ( 
    A : in STD_LOGIC_VECTOR ( 3 downto 0 );
    B : in STD_LOGIC_VECTOR ( 3 downto 0 );
    M : in STD_LOGIC;
    S : out STD_LOGIC_VECTOR ( 3 downto 0 );
    C4 : out STD_LOGIC;
    o : out STD_LOGIC
  );

end adder_2;

architecture stub of adder_2 is
attribute syn_black_box : boolean;
attribute black_box_pad_pin : string;
attribute syn_black_box of stub : architecture is true;
attribute black_box_pad_pin of stub : architecture is "A[3:0],B[3:0],M,S[3:0],C4,o";
attribute X_CORE_INFO : string;
attribute X_CORE_INFO of stub : architecture is "adder,Vivado 2017.4";
begin
end;
