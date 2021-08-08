---
author: "Wondrous WisdomCard"
date: 2020-10-07
linktitle: Creating a New Theme
title: Homework of Week 6
tags: [  
    "Computing Components",
    "CPU",
    "RAM",
    "ROM",
    "Bus",
    "Parallel Computing"
]
categories: [
    "Homework"
]
---

### 1. According to the von Neumann architecture, List basic parts of a computer:

运算器(processing unit)、控制器(control unit)、存储器(memory)、输入设备、输出设备(input and output mechanisms)

---

### 2. A computer has 64 MB (megabytes) of memory. How many bits are needed to address any single byte in memory? 

The memory address space is 64 MB, or 2^26 (2^6 x 2^20). This means it needs log2(2^26) or 26 bits, to address each single byte.

---

### 3. List basic parts of a CPU, include cache or not? 

传统上，CPU由**控制器和运算器**这两个主要部件组成。
随着集成电路技术的不断发展和进步，新型CPU纷纷集成了一些原先置于CPU之外的分立功能部件，如浮点处理器、**高速缓存Cache**等，在大大提高CPU性能指标的同时，也使得CPU的内部组成日益复杂化。

控制器通常由程序计数器（PC）、指令寄存器（IR）、指令译码器（ID）、时序发生器和操作控制器组成。

运算器由算术逻辑单元(ALU)、累加寄存器（AC）、数据寄存器（DR）和程序状态字寄存器（PSW）组成。

**因此是新型CPU集成了Cache。**

*内容来自
https://software.intel.com/content/www/cn/zh/develop/articles/book-processor-architecture_cpu_function_and_composition.html*

---

### 4.What mean secondary storage. List some on your PC. 

Secondary Storage: A data storage device that is not the main memory of a computer

二级存储器也称为外部存储器,是指计算机用来存储数据和程序的各种存储介质。

二级存储设备有（固定/移动）硬盘、光碟、闪存卡、U盘和其他速度缓慢但拥有很高容量的设备。

---

### 5.使用维基百科，解释以下概念： CPU、RAM、ROM、Bus (computing)、Parallel Computing

#### CPU

Central processing unit: the key component of a computer system, containing the circuitry necessary to interpret and execute program instructions. 

#### RAM

Random access memory: semiconductor memory in which all storage locations can be rapidly accessed in the same amount of time. It **forms the main memory of a computer**, used by applications to perform tasks while the device is operating.
It is **volatile** computer memory, used for creating, loading, and running programs and for manipulating and temporarily storing data.

#### ROM

Computer hardware that holds permanently stored data. After the data is installed in ROM, it cannot be added to, modified, or deleted. ROM usually contains instructions that enable the computer's operating system to communicate with other hardware.  It is a nonvolatile, nonmodifiable computer memory.

#### Bus(computing)

A bus is a communication system that transfers data between components inside a computer, or between computers. This expression covers all related hardware components (wire, optical fiber, etc.) and software, including communication protocols.

The bus connecting the CPU and memory is one of the defining characteristics of the system, and often referred to simply as the system bus.

#### Parallel Computing 

Parallel computing is a type of computation in which many calculations or the execution of processes are carried out simultaneously. 

Large problems can often be divided into smaller ones, which can then be solved at the same time. There are several different forms of parallel computing: bit-level, instruction-level, data, and task parallelism. 

Parallelism has been employed for many years, mainly in high-performance computing, but interest in it has grown lately due to the physical constraints preventing frequency scaling.

---

### 6. 写一段文字，简单解释云计算（cloud computing）

云计算是一种分布式计算，通过网络将巨大的数据计算处理程序分解成多个小程序，然后，通过多部服务器组成的系统进行处理和分析这些小程序得到结果并返回给用户。

云计算是计算服务的提供，用户可以利用网络来享用服务器、存储、数据库、网络、软件、分析和智能等计算服务。云计算使得用户摆脱了对高性能硬件的需求，降低了用户的计算成本，同时云计算具备高性能和安全性高的优势。

云计算有公用，私有，混合模型，公有云为第三方云服务提供商所拥有和运营，他们通过 Internet 提供其计算资源（如服务器和存储空间）；私有云是指专供一个企业或组织使用的云计算资源。

云服务类型有：基础结构即服务 (IaaS)、平台即服务 (PaaS)、无服务器和软件即服务 (SaaS)。

*参考 https://azure.microsoft.com/zh-cn/overview/what-is-cloud-computing/#benefits*

---

### 7. 小孙买了计算机主板，说明书表明“支持双通道DDR3-1333内存，最大支持16G” 

#### 1）DDR3内存，“3”和“1333”的含义是什么？ 

3指第三代，DDR3为第三代双倍数据率同步动态随机存取存储器 

1333代表着内存频率，频率越高，内存运算速度越快，内存也就越好，价格也就越高。

#### 2）小孙买8G DDR3-1600的内存能提高性能吗？

内存条的标注频率代表该内存最高可以稳定在这个频率下工作

主板支持1333MHZ频率的内存，当使用了1600MHZ频率的内存之后，1600MHZ内存仍可以工作，但实际工作频率仅为1333MHZ，并不能提高性能。

#### 3）小孙买4G*2 DDR3-1333的内存能提高性能吗？

从理论上说双通道两个内存通过CPU可分别寻址、读取数据，从而使内存的带宽增加一倍，数据存取速度也相应增加一倍，所以能提高性能。

#### 4）16G需要多少位地址？

内存地址空间为16 GB，即2^34 (2^4 x 2^30)，这意味着它需要log2(2^34)即34位来寻址每个字节。
