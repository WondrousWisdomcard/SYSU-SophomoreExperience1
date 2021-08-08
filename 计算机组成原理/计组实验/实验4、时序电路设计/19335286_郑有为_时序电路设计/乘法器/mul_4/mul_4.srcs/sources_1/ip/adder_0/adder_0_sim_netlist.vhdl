-- Copyright 1986-2017 Xilinx, Inc. All Rights Reserved.
-- --------------------------------------------------------------------------------
-- Tool Version: Vivado v.2017.4 (win64) Build 2086221 Fri Dec 15 20:55:39 MST 2017
-- Date        : Tue Nov 10 21:31:21 2020
-- Host        : LAPTOP-D025KD3I running 64-bit major release  (build 9200)
-- Command     : write_vhdl -force -mode funcsim -rename_top adder_0 -prefix
--               adder_0_ adder_1_sim_netlist.vhdl
-- Design      : adder_1
-- Purpose     : This VHDL netlist is a functional simulation representation of the design and should not be modified or
--               synthesized. This netlist cannot be used for SDF annotated simulation.
-- Device      : xc7a35tcpg236-1
-- --------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity adder_0_full_adder is
  port (
    Ci_1 : out STD_LOGIC;
    Ci : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ai : in STD_LOGIC
  );
end adder_0_full_adder;

architecture STRUCTURE of adder_0_full_adder is
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
entity adder_0_full_adder_0 is
  port (
    Ci_1 : out STD_LOGIC;
    Ci : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ai : in STD_LOGIC
  );
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of adder_0_full_adder_0 : entity is "full_adder";
end adder_0_full_adder_0;

architecture STRUCTURE of adder_0_full_adder_0 is
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
entity \adder_0_full_adder_1__4\ is
  port (
    Ci_1 : out STD_LOGIC;
    Ci : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ai : in STD_LOGIC
  );
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of \adder_0_full_adder_1__4\ : entity is "full_adder";
end \adder_0_full_adder_1__4\;

architecture STRUCTURE of \adder_0_full_adder_1__4\ is
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
entity adder_0_full_adder_2 is
  port (
    Ci_1 : out STD_LOGIC;
    Ci : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ai : in STD_LOGIC
  );
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of adder_0_full_adder_2 : entity is "full_adder";
end adder_0_full_adder_2;

architecture STRUCTURE of adder_0_full_adder_2 is
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
entity adder_0_full_adder_1 is
  port (
    Ai : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ci : in STD_LOGIC;
    Si : out STD_LOGIC;
    Ci_1 : out STD_LOGIC
  );
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of adder_0_full_adder_1 : entity is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of adder_0_full_adder_1 : entity is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of adder_0_full_adder_1 : entity is "full_adder,Vivado 2017.4";
end adder_0_full_adder_1;

architecture STRUCTURE of adder_0_full_adder_1 is
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
inst: entity work.adder_0_full_adder
     port map (
      Ai => Ai,
      Bi => Bi,
      Ci => Ci,
      Ci_1 => Ci_1
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity \adder_0_full_adder_1__1\ is
  port (
    Ai : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ci : in STD_LOGIC;
    Si : out STD_LOGIC;
    Ci_1 : out STD_LOGIC
  );
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of \adder_0_full_adder_1__1\ : entity is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of \adder_0_full_adder_1__1\ : entity is "yes";
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of \adder_0_full_adder_1__1\ : entity is "full_adder_1";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of \adder_0_full_adder_1__1\ : entity is "full_adder,Vivado 2017.4";
end \adder_0_full_adder_1__1\;

architecture STRUCTURE of \adder_0_full_adder_1__1\ is
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
inst: entity work.adder_0_full_adder_2
     port map (
      Ai => Ai,
      Bi => Bi,
      Ci => Ci,
      Ci_1 => Ci_1
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity \adder_0_full_adder_1__2\ is
  port (
    Ai : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ci : in STD_LOGIC;
    Si : out STD_LOGIC;
    Ci_1 : out STD_LOGIC
  );
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of \adder_0_full_adder_1__2\ : entity is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of \adder_0_full_adder_1__2\ : entity is "yes";
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of \adder_0_full_adder_1__2\ : entity is "full_adder_1";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of \adder_0_full_adder_1__2\ : entity is "full_adder,Vivado 2017.4";
end \adder_0_full_adder_1__2\;

architecture STRUCTURE of \adder_0_full_adder_1__2\ is
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
inst: entity work.\adder_0_full_adder_1__4\
     port map (
      Ai => Ai,
      Bi => Bi,
      Ci => Ci,
      Ci_1 => Ci_1
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity \adder_0_full_adder_1__3\ is
  port (
    Ai : in STD_LOGIC;
    Bi : in STD_LOGIC;
    Ci : in STD_LOGIC;
    Si : out STD_LOGIC;
    Ci_1 : out STD_LOGIC
  );
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of \adder_0_full_adder_1__3\ : entity is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of \adder_0_full_adder_1__3\ : entity is "yes";
  attribute ORIG_REF_NAME : string;
  attribute ORIG_REF_NAME of \adder_0_full_adder_1__3\ : entity is "full_adder_1";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of \adder_0_full_adder_1__3\ : entity is "full_adder,Vivado 2017.4";
end \adder_0_full_adder_1__3\;

architecture STRUCTURE of \adder_0_full_adder_1__3\ is
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
inst: entity work.adder_0_full_adder_0
     port map (
      Ai => Ai,
      Bi => Bi,
      Ci => Ci,
      Ci_1 => Ci_1
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity adder_0_adder is
  port (
    A : in STD_LOGIC_VECTOR ( 3 downto 0 );
    B : in STD_LOGIC_VECTOR ( 3 downto 0 );
    M : in STD_LOGIC;
    S : out STD_LOGIC_VECTOR ( 3 downto 0 );
    C4 : out STD_LOGIC;
    o : out STD_LOGIC
  );
end adder_0_adder;

architecture STRUCTURE of adder_0_adder is
  signal Bi0 : STD_LOGIC;
  signal Bi00_out : STD_LOGIC;
  signal Bi02_out : STD_LOGIC;
  signal Bi04_out : STD_LOGIC;
  signal C0 : STD_LOGIC;
  signal C1 : STD_LOGIC;
  signal C2 : STD_LOGIC;
  signal \^c4\ : STD_LOGIC;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of add1 : label is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of add1 : label is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of add1 : label is "full_adder,Vivado 2017.4";
  attribute SOFT_HLUTNM : string;
  attribute SOFT_HLUTNM of add1_i_1 : label is "soft_lutpair0";
  attribute CHECK_LICENSE_TYPE of add2 : label is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings of add2 : label is "yes";
  attribute X_CORE_INFO of add2 : label is "full_adder,Vivado 2017.4";
  attribute SOFT_HLUTNM of add2_i_1 : label is "soft_lutpair0";
  attribute CHECK_LICENSE_TYPE of add3 : label is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings of add3 : label is "yes";
  attribute X_CORE_INFO of add3 : label is "full_adder,Vivado 2017.4";
  attribute SOFT_HLUTNM of add3_i_1 : label is "soft_lutpair1";
  attribute CHECK_LICENSE_TYPE of add4 : label is "full_adder_1,full_adder,{}";
  attribute DowngradeIPIdentifiedWarnings of add4 : label is "yes";
  attribute X_CORE_INFO of add4 : label is "full_adder,Vivado 2017.4";
  attribute SOFT_HLUTNM of add4_i_1 : label is "soft_lutpair1";
begin
  C4 <= \^c4\;
add1: entity work.\adder_0_full_adder_1__1\
     port map (
      Ai => A(0),
      Bi => Bi0,
      Ci => M,
      Ci_1 => C0,
      Si => S(0)
    );
add1_i_1: unisim.vcomponents.LUT2
    generic map(
      INIT => X"6"
    )
        port map (
      I0 => B(0),
      I1 => M,
      O => Bi0
    );
add2: entity work.\adder_0_full_adder_1__2\
     port map (
      Ai => A(1),
      Bi => Bi00_out,
      Ci => C0,
      Ci_1 => C1,
      Si => S(1)
    );
add2_i_1: unisim.vcomponents.LUT2
    generic map(
      INIT => X"6"
    )
        port map (
      I0 => B(1),
      I1 => M,
      O => Bi00_out
    );
add3: entity work.\adder_0_full_adder_1__3\
     port map (
      Ai => A(2),
      Bi => Bi02_out,
      Ci => C1,
      Ci_1 => C2,
      Si => S(2)
    );
add3_i_1: unisim.vcomponents.LUT2
    generic map(
      INIT => X"6"
    )
        port map (
      I0 => B(2),
      I1 => M,
      O => Bi02_out
    );
add4: entity work.adder_0_full_adder_1
     port map (
      Ai => A(3),
      Bi => Bi04_out,
      Ci => C2,
      Ci_1 => \^c4\,
      Si => S(3)
    );
add4_i_1: unisim.vcomponents.LUT2
    generic map(
      INIT => X"6"
    )
        port map (
      I0 => B(3),
      I1 => M,
      O => Bi04_out
    );
o_INST_0: unisim.vcomponents.LUT2
    generic map(
      INIT => X"6"
    )
        port map (
      I0 => \^c4\,
      I1 => C2,
      O => o
    );
end STRUCTURE;
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
library UNISIM;
use UNISIM.VCOMPONENTS.ALL;
entity adder_0 is
  port (
    A : in STD_LOGIC_VECTOR ( 3 downto 0 );
    B : in STD_LOGIC_VECTOR ( 3 downto 0 );
    M : in STD_LOGIC;
    S : out STD_LOGIC_VECTOR ( 3 downto 0 );
    C4 : out STD_LOGIC;
    o : out STD_LOGIC
  );
  attribute NotValidForBitStream : boolean;
  attribute NotValidForBitStream of adder_0 : entity is true;
  attribute CHECK_LICENSE_TYPE : string;
  attribute CHECK_LICENSE_TYPE of adder_0 : entity is "adder_1,adder,{}";
  attribute DowngradeIPIdentifiedWarnings : string;
  attribute DowngradeIPIdentifiedWarnings of adder_0 : entity is "yes";
  attribute X_CORE_INFO : string;
  attribute X_CORE_INFO of adder_0 : entity is "adder,Vivado 2017.4";
end adder_0;

architecture STRUCTURE of adder_0 is
begin
inst: entity work.adder_0_adder
     port map (
      A(3 downto 0) => A(3 downto 0),
      B(3 downto 0) => B(3 downto 0),
      C4 => C4,
      M => M,
      S(3 downto 0) => S(3 downto 0),
      o => o
    );
end STRUCTURE;
