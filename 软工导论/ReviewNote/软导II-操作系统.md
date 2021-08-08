# 软导下半学期之操作系统

# 1、操作系统和文件系统

### 章节任务

• Describe the two main responsibilities of an operating system

• Define memory and process management
    – Timesharing creates the virtual machine illusion
    – Explain the relationship between logical and physical addresses
    – Compare memory management techniques
        • Distinguish between fixed and dynamic partitions
        • Define and apply partition selection algorithms
        • Explain how demand paging creates the virtual memory illusion
    – Explain the stages and transitions of the process life cycle
    – Explain the processing of various CPU scheduling algorithms

#### 1、软件的分类

应用软件：用于解决特定的需要，解决现实的问题。

系统软件：用于底层管理计算机系统，它提供了应用软件运行的工具和环境。

#### 2、操作系统的概念

操作系统管理计算机资源，管理CPU，内存和外部设备，提供了人机交互的接口，允许应用程序使用计算机资源。

操作系统（英语：Operating System，简称OS）是**管理计算机硬件与软件资源**的程序，同时也是计算机系统的核心与基石。操作系统身负诸如**管理与配置内存**、**决定系统资源供需的优先次序**、**控制输入与输出设备**、**操作网络与管理文件系统**等基本事务。

#### 3、操作系统的历史
在1980年代以前：
    • 第一部计算机并没有操作系统。
        – 早期计算机的创建方式（如同建造机械算盘）与性能不足以运行如此程序。
    • 1947年发明了晶体管，以及莫里斯·威尔克斯发明的微程序方法
    • 1964年，**IBM System/360**,都共用代号为
    **OS/360**的操作系统。
        – 硬盘驱动器的面世
        – 分时概念的创建
    • 1969年，AT&T贝尔实验室的丹尼斯·里奇与肯·汤普逊所创建的Unix系统
        – 1971年在PDP-11上运行
在1980个人计算机时代：
    • 第一代微型计算机，没有装设操作系统的需求或能力
        – 基本输入输出系统（BIOS）
        – BASIC程序
    • 1980年微软公司，比尔·盖茨推出MSDOS
        – **软盘操作系统**（Disk Operating System，DOS）
        – MS-DOS的成功使得微软成为地球上最赚钱的公司之一
    • 80年代操作系统异数是Mac OS
        – 此时一位施乐·伯拉图实验室的员工Dominik Hagen访问了苹果，展示了施乐开发的图型用户界面
        – 苹果公司开启了图形化OS进程
在1990多媒体界面OS开启
    • 1997年发布新操作系统——MacOS X的测试版
        – Steve Jobs风光再现 
    • 微软发布Windows系列产品
        – 1993年7月27日推出Windows 3.1
        – 1995年8月15日推出Windows 95
        – 2000年所推出的Windows 2000
        – Windows XP在2001年10月25日发布
        – 2004年占领90%PC及PC服务器市场
    • 1991 年, 芬兰学生林纳斯·托瓦兹根据类 Unix 系统 ，发布了Linux操作系统内核
现代OS发展趋势
    • 手机OS
        – IOS（Apple）
        – Android（Google） 
    • 互联网及云服务OS
        – Chrome OS（Google） 
    • 都采用Linux内核 – 微软何去何从？

#### 4、操作系统的资源管理

Multiprogramming 在**主存储器中同时保存多个程序**的技术，这些程序竞争CPU的访问，以便它们能够执行

Memory management **跟踪**哪些程序在内存中以及它们在内存中**所处位置**的过程

Process 进程 

**进程（Process）是*计算机中的程序关于某数据集合上的一次运行活动*，是系统进行资源分配和调度的基本单位**

CPU scheduling CPU调度决定某时某刻CPU执行内存中的哪个进程

#### 5、批处理 Batch Processing

In early systems, human operators would organize jobs into batches

#### 6、分时技术 Timesharing

**A system that allows multiple users to interact with a computer at the same time。**就是你用户同时可以运行多个程序。

Multiprogramming 
一种允许多个进程同时活跃的技术，允许程序员直接与计算机系统交互，同时仍然共享其资源

#### 7、内存管理

– A OS must be able to convert logical addresses into actual addresses

Logical address (sometimes called a virtual or relative address) 
    A value that specifies a generic location, relative to the program but not to the reality of main memory **一个指定相对位置的值，该位置相对于程序而不是主存的实际位置**

Physical address 
    **An actual address in the main memory device 放在寻址总线上的地址。**

Single Contiguous Memory Management
    • To produce a physical address, we add a logical address to the starting address of the program in physical main memory

Partition Memory Management（分布式内存管理）

    Fixed partitions 
        Main memory is divided into a particular number of partitions

    Dymanic partitions 
        Partitions are created to fit the needs of the programs

    • Base register A register that holds the beginning address of the current partition
    
    • Bounds register A register that holds the length of the current partition

##### Which partition should we allocate to a new program?

• **First fit** 将程序分配到第一个足够大的分区，以便容纳它

• **Best fit** 将程序分配到足够容纳它的最小分区

• **Worst fit** 将程序分配到足够容纳它的最大分区

#### 8、Paged memory technique
    分页是一种操作系统里存储器管理的一种技术，**可以使电脑的主存可以使用存储在辅助存储器中的数据**。
    A memory management technique in which processes are divided into fixed-size pages and stored in memory frames when loaded into memory 
        – Frame A **fixed-size portion of main memory** that holds a process page
        – Page A **fixed-size portion of a process** that is stored into a memory frame
        – Page-map table (PMT) A table used by the operating system to keep track of page/frame relationships.

    To produce a physical address, you first **look up the page in the PMT to find the frame number** in which it is stored

    Then **multiply the frame number** **by the frame size** and **add the offset** to get the physical address

    virtual memory, the illusion that there are no restrictions on the size of a program.

    Demand paging 分页请求

    并不是程序的所有部分都必须同时在内存中
    —在请求分页中，页面根据需要被带入内存

    Page swap 分页交换

    页面交换从辅助内存引入一个页的行为，这通常会导致另一个页面被写回辅助内存

#### 9、进程管理

**进程的五个状态：New Ready Running Waiting Terminated**

#### 10、CPU调度 CPU Scheduling

The act of determining which process in the ready state should be moved to the running state. **确定处于就绪状态的哪个进程应该移动到运行状态。**

    – Many processes may be in the ready state

    – Only one process can be in the running state,making progress at any one time

**Nonpreemptive scheduling(非抢占式调度)** 
    当前正在执行的进程自动放弃CPU

**Preemptive scheduling(抢占式调度)**
    操作系统决定使用另一个进程，抢占当前正在执行的进程

**Turnaround time(时间片)** 
    The amount of time between when a process arrives in the ready state the first time and when it exits the running state for the last time
    进程第一次到达就绪状态与最后一次退出运行状态之间的时间长度

##### 三种调度算法（要背）
**First-Come, First-Served(排队服务策略)**
    FCFS
    – Processes are moved to the CPU in the order in which they arrive in the running state
    进程按照它们到达运行状态的顺序移动到CPU

**Shortest Job Next(最短时间优先)**
    SJN
    – Process with shortest estimated running time in the ready state is moved into the running state first 
    在就绪状态中估计运行时间最短的流程首先移动到运行状态

**Round Robin(分时循环)**
    RR
    – Each process runs for a specified time slice and moves from the running state to the ready state to await its next turn if not finished 
    每个进程运行一个指定的时间片，如果时间片内没有结束的话，从运行状态移动到就绪状态，以等待下一个回合

### 课程要点

1、The role of Operation System
2、Key Concept: Multiprogramming, Process, Timesharing
3、Resource management: Memory management , Process
management , CPU scheduling
4、Memory management：Logical Address, Physical Address,
Fixed partitions, Dynamic partitions, (First, Best, Worst) fit
5、Process management：process states 

