# 软导上半学期

我们主要是自己看课件 总结知识 然后刷考题涨经验。

需要背概念，有空可‘以考虑看书。

## 课程大纲

当Fortran（公式翻译）语言出现后，人们可以用一种高级的结构化的语言思考科学计算问题； 当面对“人工智能”领域的逻辑推理问题时，人们提出了Lisp（表处理）语言；当我们把世界万物都抽象为对象（Object），面向对象思考的语言（Smalltalk,Java…）就产生了。

首先你的了解做软件的基本步骤与开发流程；然后你得用行业标准化的图表、文字去定义、描述或设计软件，以便于多个企业或团队协同生产；其次在软件制作过程中，需要许多检查表或测试以保证软件的质量；最后运用项目管理，综合考虑软件生产的需求、时间、成本、质量、团队、风险等要素，确保软件按时、按要求交付给用户。

## 1、介绍

#### 知识点1、计算机系统的层次？（6个）

（由外到里） 交流 应用 操作系统 程序 硬件 信息 

#### 知识点2、抽象是什么？它与计算有什么关系？

一个抽去复杂细节的思维模型

#### 知识点3、描述计算机软硬件的历史。

软件：按照特定顺序组织的计算机数据和指令的集合

硬件：计算机系统中由电子，机械和光电元件等组成的各种物理装置的总称。微机由主机箱和外部设备组成。主机箱内主要包括CPU、内存、主板、硬盘驱动器、光盘驱动器、各种扩展卡、连接线、电源等；外部设备包括鼠标、键盘等。

#### 阅读点1、早期计算机发展的历史

算盘 步进计算器

雅卡尔提花机
这种革命性的织布机利用预先打孔的卡片来控制织物的编织式样，速度比老式手工提花机快了25倍，就好比从自行车到汽车的飞跃。

差分机
Charles Babbage 从法国人杰卡德发明的提花编织机上获得了灵感。第一台差分机，它可以处理3个不同的5位数，计算精度达到6位小数，当即就演算出好几种函数表。

分析机
Charles Babbage 构想了一个更复杂的机器——分析机。分析机包括的存储和碾磨，就非常类似于今天计算机中采用的内存和处理器。输入和输出都采用打孔卡（十九世纪Jacquard发明的一种卡片）进行。分析机是“通用计算机”，他可以计算很多问题，而不单单是某一种特定的问题，它有内存，可以暂时存放中间的计算数据，甚至一个很原始的打印机，当然，这种概念机太超前了，它也没有建造成功。但是，这种”自动计算机“的概念是一个跨时代的概念，预示着计算机程序的诞生。

世界上第一位程序员
英国数学家Ada Lovelace（阿达·洛芙莱斯）给分析机写了假象的程序，因此Ada Lovelace被认为是世界上第一位程序员。

分析机激励了第一代计算机科学家，所以：Charles Babbage 经常被认为是“计算之父”

世界上第一台通用计算机“ENIAC”于1946年2月14日在美国宾夕法尼亚大学诞生。

#### 阅读点2、计算机硬件的发展

第一台计算机 电子管计算机 (1951-1959年)

Vacuum Tubes
Large, not very reliable, generated a lot of heat
Magnetic Drum
Memory device that rotated under a read/write head
Card Readers  Magnetic Tape Drives
Sequential auxiliary storage devices

二、第二代计算机 晶体管计算机 (1959-1965年)

Transistor
Replaced vacuum tube, fast, small, durable, cheap
Magnetic Cores
Replaced magnetic drums, information available
instantly
Magnetic Disks
Replaced magnetic tape, data can be accessed directly

三、第三代计算机 中小规模集成电路计算机 (1965-1971)

Integrated Circuits
Replaced circuit boards, smaller, cheaper, faster, more
reliable.
Transistors
Now used for memory construction
Terminal
An input/output device with a keyboard and screen

四、第四代计算机 大规模集成电路计算机 (1971年至今)

Large-scale Integration
Great advances in chip technology
PCs, the Commercial Market, Workstations
Personal Computers were developed as new companies
like Apple and Atari came into being. Workstations
emerged

摩尔定律是英特尔创始人之一戈登·摩尔的经验之谈，其核心内容为：**集成电路上可以容纳的晶体管数目在大约每经过18-24个月便会增加一倍。换言之，处理器的性能每隔两年翻一倍。**

#### 阅读点3、计算机软件的发展

##### First Generation Software (1951-1959)

Machine Language
Computer programs were written in binary (1s and 0s)

Assembly Languages and translators
Programs were written in artificial programming
languages and were then translated into machine
language

Programmer Changes
Programmers divide into **application programmers** and
**systems programmers**

##### Second Generation Software (1959-1965)

High Level Languages
Use English-like statements and make programming
easier.
Fortran, COBOL, Lisp are examples. 
世界上第一个高级语言——FORTRAN

##### Third Generation Software (1965-1971)

• Systems Software
– utility programs,
– language translators,
– and the **operating system**, which decides which
programs to run and when. 

• Separation between Users and Hardware
Computer programmers began to write
programs to be used by people who did not
know how to program 

层次（由外到内）： Application Package - Systems Software - High-Level Languages - Assembly Language - Machine Language

##### Fourth Generation Software (1971-1989)

**Structured** Programming
Pascal, C, C++

New Application Software for Users
Spreadsheets, word processors, database management
systems

##### Fifth Generation Software (1990- present)

Microsoft
The Windows operating system, and other Microsoft
application programs dominate the market

**Object-Oriented Design**
Based on a hierarchy of data objects (i.e. Java)

**World Wide Web**
Allows easy global communication through the Internet

New Users
Today’s user needs no computer knowledge

#### 作业概念

**计算机是一种设备，它可以被指令自动地执行一组任意的算术或逻辑操作。**

**计算机科学是对构成计算机设计和使用基础的理论、实验和工程的研究。**

**软件工程是工程应用于软件开发的一种系统方法。**

**软件是一系列按照特定顺序组织的计算机数据和指令的集合。**

## 2、数字系统

就解释几个概念：

1)Information

**2)Positional notation 位置表示法是一种表示数字或编码数字的方法。**

**3)Algorithm 为解决某一特定任务而规定的一个有穷指令序列。**

**4)Software bug 软件错误是指计算机程序或系统中的一种错误、缺陷、故障，它会导致不正确的意外的结果，或表现出非预期的行为**。

## 3、数据呈现I（负数，小数和浮点数）

#### 知识点1、补码

 10的补： $Negative(i)=10^k-i$ k是i的（最大）位数
一次可以类推 1的补（反码），2的补（补码）

#### 知识点2、二进制单位

 • bit
 – A bit is the basic unit of information in
 computing and digital communications. A bit can
 have only one of two values.
 • byte
 – 8 bits. (c types maybe **int8_t, uint8_t, char** )
 • integer
 – A natural number, a negative number

 ##### 溢出

  Overflow occurs when the value that we compute cannot fit into the number of bits we have allocated for the result.

  二进制有符号数溢出的判定 – 一个数不在 [-2K-1, 2K-1-1]范围内 – 两个正数相加，结果是负数 – 两个负数相加，结果是正数

 ##### 为什么浮点数不可以等号比较？

  **因为浮点数系统不能精确表示数轴上的每一个点，只能表示部分的点，并且不是均匀的，越接近0就越稠密，越远离0就越稀疏。**(是二进制本身的原因)

#### 知识点3、浮点表示法

 Mantissa（小数部分）

 科学计数法  12001.32708 would be written as 1.200132708E+4.

 ##### IEEE STANDARDS 754－2008
 |name|sign|exponent|mantissa|
 | :-- | :-- | :-- | :-- |
 |float|1|8|23|
 |double|1|11|52|

 float的指数部分加127
 exponent的指数部分加1023

  +26*1.01000111001
 • The sign is positive.
 • The Excess_127 representation of the exponent is 133(**127+**6). In binary, this is 10000101(**记得加127**)
 • The mantissa is 01000111001.You add extra 0s on the right to make it 23 bits.
 • The number in memory is stored as: 0 10000101 010001110010000000000000

 NaN (“Not a Number”) An IEEE floating point representation.

## 3、数据呈现II（数字量与模拟量、ASCII、数据压缩、颜色、声音）

模拟数据是一种连续的表示，类似于它所表示的实际信息。

数字数据是一种离散的表示，它把信息分解成分离的元素。

Computers, cannot work well with analog
information. So we digitize information by
breaking it into pieces and representing those pieces separately

• ASCII stands for American Standard Code
for Information Interchange. 
    A-65 0-48 a-97
    Note that the first 32 characters in the ASCII character chart do not have a simple character representation that you could print to the screen.

 The Unicode character set uses 16 bits per character. Therefore, the Unicode character set can represent 256, or over 65 thousand, characters.

颜色是我们对到达视网膜的各种频率的光的感知。三原色：红绿蓝

16进制RGB表达
RGB
HSB
CYM

•HiColor是一个表示16位颜色深度的术语。5位用于RGB值中的每个数字，额外的位有时用于表示透明度。TrueColor 24位颜色深度。因此，RGB值中的每个数字都得到8位。(Red,Green,Blue)

Digitizing a picture is the act of representing it as a collection of individual dots called pixels. 像素
The number of pixels used to represent a picture is called the resolution. 分辨率
The storage of image information on a pixel-by-pixel basis is called a rastergraphics format. Several popular raster file formats including bitmap (BMP).

**300dpi指的是在一英寸的面积中有300个像素单位。**

air compressions vibrate 空气按压震动 stereo 立体声 sampling 采样

信号中的电压与声波成正比。

MP3是MPEG-2的缩写，MP3同时使用有损压缩和无损压缩

Data compression
 Reduction in the amount of space needed to store a piece of data. 
 
Compression ratio 
 The size of the compressed data divided by the size of the original data.

A data compression techniques can be

– lossless, which means the data can be retrieved without any loss of the original information

– lossy, which means some information may be lost in the process of compaction.

BMP: Uncompressed

TIFF Lossless: Document scanning and imaging format.

PNG	Lossless: improve and replace GIF. Based on the DEFLATE algorithm.

JPEG Lossy: big compression ratio, good for photographic images

Winrar压缩文件是无损压缩(lossless)

## 4、逻辑门与电路

Base 1 时 Outpit 0
Base 0 时 Output 1

By using transistors, the easiest gates to create are the NOT,
NAND, and NOR gates

布尔表达式，逻辑电路符号表示，真值表表示

XOR exclusive OR 异或 不一样输出1

NAND 与非门 NOR 或非门（先或后非）

##### 时序电路和组合电路
– In a combinational circuit, the input values explicitly determine the output
– In a sequential circuit, the output is a function of the input values as well as **the existing state of the circuit**

加法器 sum = a 异或 b , carry = ab

全加器 sum = a 异或 b 异或 carry in , carry = ab + (a异或b)c

• Integrated circuit (also called a chip) A piece of silicon on which multiple gates have been embedded 集成电路(也称为芯片):一块嵌有多个栅极的硅

##### 概念

逻辑门：逻辑门是实现布尔函数的一种理想化的或物理的设备

布尔代数：在数学和数学逻辑中，布尔代数是代数的一个分支，其中变量的值为真值和假值，通常分别表示为1和0。

## 5、计算元件

冯诺依曼计算机 输入输出设备，内存单元（存储器），中央处理单元（控制器和运算器）

部分内存单位： 
    KiloByte K 2^10 approx to 10^3
    MegaByte K 2^20 approx to 10^6
    GigaByte K 2^30 approx to 10^9
    TeraByte K 2^40 approx to 10^12

一个PC主板，支持最多16G物理内存，它有多少地址线（bit）？ 34

• Instruction level parallelism
    – Instruction pipelining
    – Superscalar
        • SIMD (Single Instructions Multiple Data);
        • VLIW (very long instruction word) 
    
• Thread level parallelism
    – MIMD (Multiple Instructions-Multiple Data)
    – MP (multiprocessing) 

• Data parallelism
    – Vector processor and SIMD

每个CPU都有其额定的主频、外频和倍频。我们通过改变其外频与倍频以提高CPU主频的方法就叫做超频，其实简单说就是**改变CPU的工作频率**。

云计算是一种分布式计算，通过网络将巨大的数据计算处理程序分解成多个小程序，然后，通过多部服务器组成的系统进行处理和分析这些小程序得到结果并返回给用户。

小孙买了计算机主板，说明书表明“支持双通道DDR3-1333内存，最大支持16G”
1）DDR3内存，“3”和“1333”的含义是什么？
3指第三代，DDR3为第三代双倍数据率同步动态随机存取存储器

1333代表着**内存频率，频率越高，内存运算速度越快**，内存也就越好，价格也就越高。

2）小孙买8G DDR3-1600的内存能提高性能吗？
内存条的标注频率代表该内存最高可以稳定在这个频率下工作

主板支持1333**MHZ**频率的内存，当使用了1600MHZ频率的内存之后，1600MHZ内存仍可以工作，但实际工作频率仅为1333MHZ，并不能提高性能。

3）小孙买4G*2 DDR3-1333的内存能提高性能吗？
从理论上说双通道两个内存通过CPU可分别寻址、读取数据，从而使内存的带宽增加一倍，数据存取速度也相应增加一倍，所以能提高性能。

4）16G需要多少位地址？
内存地址空间为16 GB，即2^34 (2^4 x 2^30)，这意味着它需要log2(2^34)即34位来寻址每个字节。

## 6、编程语言

 A computer is a programmable electronic device that can store, retrieve, and process data

 编译器，解释器和汇编器

 • Interpreter （解释）A translating program that translates and executes the statements in sequence
    – Unlike an assembler or compiler which produce machine code as output, which is then executed in a separate step
    – An interpreter translates a statement and then immediately executes the statement
    – Interpreters can be viewed as simulators

##### 作业内容

一个指令运行周期内：内存 –> 取指令 –> 指令译码 –> 寄存器 –> 取数据 –> 执行指令 –> 处理数据 -> 存储数据 -> 内存

命令式编程是一种编程范式，它使用语句来改变程序的状态。

函数式编程将计算视为数学函数的求值，避免状态变化和数据变化。它是一种声明式编程范式，这意味着编程是用表达式或声明来完成的，而不是用语句。

过程式编程是一种编程范式，源于结构化编程，基于过程调用的概念。过程包含一系列要执行的计算步骤。

## 7、解决问题和算法设计

Algorithm A set of instructions for solving a problem or subproblem in a finite amount of time using a finite amount of data.

在有限的时间内使用有限的数据解决一个问题或子问题的一组指令。

“自顶向下”的具体内涵是将复杂、大的问题划分为小问题，找出问题的关键、重点所在，然后用精确的思维定性、定量地去描述问题。

而“逐步求精”的具体内涵是是将现实世界的问题经抽象转化为逻辑空间或求解空间的问题。复杂问题经抽象化处理变为相对比较简单的问题。经若干步抽象（精化）处理，最后到求解域中只是比较简单的编程问题。

最后会通过由顶层模块调用子模块来实现整体功能。

## 8、面向对象设计

“面向对象”的诞生
– 1971年，Key在施乐PRAC中心开始设计Smalltalk。Smalltalk基于单独个体（即“细胞”）生物学模型来设计的，个体之间可通过彼此发送“信息”交流，来解决问题。

A problem-solving methodology that produces a solution to a problem in terms of self-contained entities called objects. 一种问题解决方法，根据被称为对象的自包含实体生成问题的解决方案。

• A group of similar objects is described by an object class, or class
• A class contains fields that represent the properties and behaviors of the class 属性和方法
    – A field can contain data value(s) and/or methods (subprograms) 
    – A method is a named algorithm that manipulates the data values in the object


对象之间的关系：
Containment 
    – “part-of” 
    – An address class may be part of the definition of a student class
Inheritance
    – Classes can inherit data and behavior from other classes 
    – “is-a”

Information Hiding and Abstraction are two sides of the same coin.
    – Information Hiding 为了**控制对模块细节的访问而**隐藏模块细节的实践。 
    – Abstraction 只向访问者提供必要的细节，抽象是信息隐藏的结果。
        数据抽象，过程抽象和控制抽象。

类与对象模拟的是现实世界的事物，必须是名词，不可为动词。

## 9、数据抽象类型（ADT）

从三个视角来认识ADT，应用层，（数理）逻辑层，（底层）实现层

容器类：用来持有和操纵其他对象的类

用自己的语言，简单总结高级语言与机器语言的区别与联系。
区别：

机器语言是计算机最原始的语言，是由0和1的代码构成，面向硬件，而高级语言采用接近于人类自然语言的单词和符号来表示一组低级语言程序，使编程变得更加简单，易学，且写出的程序可读性强。
使用高级语言我们无需考虑数据是在寄存器中还是内存中，而机器语言需要考虑这些；
高级语言的书写更加灵活，机器语言的指令语法更加严格，也更加精简；
一条高级语言指令往往需要翻译成数条机器指令，意味着一般一条自然语言代码比一行汇编指令更加复杂。
高级语言更偏向人的思考方式，机器语言则是“机器的思考方式”的体现。
联系：

为了在计算机中执行高级语言程序，需先翻译成机器语言；
一条高级语言指令往往能翻译成数条机器指令。
