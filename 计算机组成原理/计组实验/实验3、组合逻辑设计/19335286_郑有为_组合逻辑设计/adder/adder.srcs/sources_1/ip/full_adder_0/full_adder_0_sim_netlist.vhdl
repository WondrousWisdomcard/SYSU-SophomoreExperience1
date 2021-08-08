-- Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
-- Date        : Sun Oct 25 13:38:40 2020
-- Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode funcsim
--               c:/Users/17727/Desktop/VivadoArea/adder/adder.srcs/sources_1/ip/full_adder_0/full_adder_0_sim_netlist.vhdl
-- Design      : full_adder_0
-- Purpose     : This VHDL netlist is a functional simulation representation of the design and should not be modified or
--               synthesized. This netlist cannot be used for SDF annotated simulation.
-- Device      : xc7a35tcpg236-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity full_adder_0_full_adder is
  port (
    Ci_1 : out STD_LOGIC;
    Ci : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ai : in STD_LOGIC
  );
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of full_adder_0_full_adder : entity is "full_adder";
end full_adder_0_full_adder;

architecture STRUCTURE of full_adder_0_full_adder is
begin
\Ci_1__0\: unisim.vcomponents.LUT3
    generic map(
      INIT => X"E8"
    )
        port map (
      I0 => Ci,
      I1 => Bi,
      I2 => Ai,
      O => Ci_1
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity full_adder_0 is
  port (
    Ai : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ci : in STD_LOGIC;
    Si : out STD_LOGIC;
    Ci_1 : out STD_LOGIC
  );
  attribute NotValidForBitStream : boolean;
  attribute NotValidForBitStream of full_adder_0 : entity is true;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of full_adder_0 : entity is "full_adder_0,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of full_adder_0 : entity is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of full_adder_0 : entity is "full_adder,Vivado 2017.4";
end full_adder_0;

architecture STRUCTURE of full_adder_0 is
begin
Si_INST_0: unisim.vcomponents.LUT3
    generic map(
      INIT => X"96"
    )
        port map (
      I0 => Bi,
      I1 => Ai,
      I2 => Ci,
      O => Si
    );
inst: entity work.full_adder_0_full_adder
     port map (
      Ai => Ai,
      Bi => Bi,
      Ci => Ci,
      Ci_1 => Ci_1
    );
end STRUCTURE;
