-- Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
-- Date        : Sat Nov  7 10:44:36 2020
-- Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode funcsim
--               c:/Users/17727/Desktop/VivadoArea/pmd2/pmd2.srcs/sources_1/ip/p138_2_0/p138_2_0_sim_netlist.vhdl
-- Design      : p138_2_0
-- Purpose     : This VHDL netlist is a functional simulation representation of the design and should not be modified or
--               synthesized. This netlist cannot be used for SDF annotated simulation.
-- Device      : xc7a35tcpg236-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity p138_2_0 is
  port (
    g1 : in STD_LOGIC;
    g2a_l : in STD_LOGIC;
    g2b_l : in STD_LOGIC;
    a : in STD_LOGIC_VECTOR ( 2 downto 0 );
    y_l : out STD_LOGIC_VECTOR ( 7 downto 0 )
  );
  attribute NotValidForBitStream : boolean;
  attribute NotValidForBitStream of p138_2_0 : entity is true;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of p138_2_0 : entity is "p138_2_0,p138_2,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of p138_2_0 : entity is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of p138_2_0 : entity is "p138_2,Vivado 2017.4";
end p138_2_0;

architecture STRUCTURE of p138_2_0 is
begin
\y_l[0]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0000000000000002"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(2),
      I4 => a(0),
      I5 => a(1),
      O => y_l(0)
    );
\y_l[1]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0000000000020000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(2),
      I4 => a(0),
      I5 => a(1),
      O => y_l(1)
    );
\y_l[2]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0000000000020000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(2),
      I4 => a(1),
      I5 => a(0),
      O => y_l(2)
    );
\y_l[3]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0002000000000000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(2),
      I4 => a(0),
      I5 => a(1),
      O => y_l(3)
    );
\y_l[4]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0000000000020000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(0),
      I4 => a(2),
      I5 => a(1),
      O => y_l(4)
    );
\y_l[5]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0002000000000000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(1),
      I4 => a(0),
      I5 => a(2),
      O => y_l(5)
    );
\y_l[6]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0002000000000000"
    )
        port map (
      I0 => g1,
      I1 => g2a_l,
      I2 => g2b_l,
      I3 => a(0),
      I4 => a(1),
      I5 => a(2),
      O => y_l(6)
    );
\y_l[7]_INST_0\: unisim.vcomponents.LUT6
    generic map(
      INIT => X"0008000000000000"
    )
        port map (
      I0 => a(2),
      I1 => g1,
      I2 => g2a_l,
      I3 => g2b_l,
      I4 => a(0),
      I5 => a(1),
      O => y_l(7)
    );
end STRUCTURE;
