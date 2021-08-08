# 软导下半学期之网络

##课程要点

1、计算机网络概念
2、网络的核心概念：速度、距离、安全
3、局域网三种基本拓扑结构：环，星，总线
4、包交换的定义与过程
5、TCP, UDP, IP 的职能
6、常见高层协议：SMTP, FTP, HTTP, DNS, POP3
7、IP 地址的表示：4 byte 32bit，能表示多少主机？
8、域名(the domain name)
9、谁将域名翻译成 IP ？
10、传输速度单位 bps 的概念，和 Bps的区别

### 计算机网络概念

**以各种方式连接的计算设备的集合，以便进行通信和共享资源**

一般通过 物理线路、电缆、无线电波或红外线信号

### 网络的核心概念：速度、距离、安全

**Data transfer rate** 数据传输速率：
数据在网络上从一个地方移动到另一个地方的速度
常见单位：**Mbps**，megabits per second的缩写，指每秒传输的位（比特）数量

局域网(LAN):在一个相对较近的地理区域内连接相对较少机器的网络

广域网(WAN):在潜在的较大地理距离上**连接两个或多个局域网络**的网络

城域网(MAN):是大城市及其周边地区发展起来的通信基础设施

### 互联网硬件连接

There are various technologies available that you can use to connect a home computer to the Internet
– 电话调制解调器将电脑数据转换成模拟音频信号，通过电话线进行传输，然后目的地的调制解调器再将其转换回数据
– 数字用户线(DSL)使用常规铜线在电话公司的中央办公室之间传输数字数据
– 电缆调制解调器使用与有线电视信号传入相同的线路来来回传输数据

Broadband 宽带传输速度超过每秒128KB的连接
-DSL连接和电缆调制解调器是宽带连接
-下载(从互联网获取数据到你的家庭电脑)和上传(从家庭电脑发送数据到互联网)的速度可能不一样

### 局域网三种基本拓扑结构：环，星，总线

A bus technology called Ethernet has become the
industry standard for local-area networks

### 包交换的定义与过程

为了提高在共享通信线路上传输信息的效率，消息被分成固定大小、编号的包

被称为路由器的网络设备被用来在网络之间引导信息包

•专有系统 使用特定商业供应商专有技术的系统

•互操作性：软件和硬件在多台机器上的能力，以及来自多个商业供应商的通信导致

•开放系统 基于网络体系结构的公共模型和在其实现中使用的一套协议

### OSI协议

Open Systems Interconnection (OSI) Reference Model

应用层（第七层）
网络服务与最终用户的一个接口。
协议有：HTTP FTP TFTP SMTP 

表示层
数据的表示、安全、压缩。（在五层模型里面已经合并到了应用层）
格式有，JPEG、ASCll、EBCDIC、加密格式等

会话层 Session
建立、管理、终止会话。（在五层模型里面已经合并到了应用层）
对应主机进程，指本地主机与远程主机正在进行的会话

传输层
定义传输数据的协议端口号，以及流控和差错校验。
协议有：**TCP UDP**，数据包一旦离开网卡即进入网络传输层

网络层
进行逻辑地址寻址，实现不同网络之间的路径选择。
协议有：ICMP IGMP **IP**（IPV4 IPV6）

数据链路层 Data Link
建立逻辑连接、进行硬件地址寻址、差错校验等功能。（由底层网络定义协议）
将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正。

物理层
建立、维护、断开物理连接。（由底层网络定义协议）

### TCP, UDP, IP 的职能

• TCP stands for Transmission Control Protocol
TCP软件**将消息分解成包**，将它们交给**IP软件进行发送**，然后在目的地**对包进行排序和重组**

• IP stands for Internet Protocol 
IP软件**处理数据包的路由**，这些数据包通过错综复杂的互连网络到达最终目的地

• UDP stands for User Datagram Protocol
是TCP协议的替代协议
主要的区别是，TCP是高可靠的，以降低性能为代价，而UDP是不太可靠，但通常更快

### 常见高层协议：SMTP, FTP, HTTP, DNS, POP3

- Simple Mail Transfer Protocol (SMTP)
- File Transfer Protocol (FTP)
- Telnet
- Hyper Text Transfer Protocol (http)
- Domain Name Service (DNS)
- Post Office Protocol (POP3)

MIME 多用途互联网邮件扩展

防火墙 一种机器或软件，作为网络的特殊网关，保护它不受不适当的访问

### IP 地址的表示：4 byte 32bit，能表示多少主机？

**Hostname 主机名是在因特网上指定特定计算机的唯一标识**
condor.develocorp.com

Network software translates a hostname into its corresponding IP address
205.39.145.18

An IP address can be split into
– **network address**, which specifies a **specific network** 
– **host number**, which specifies a **particular machine** in that network

8、域名(the domain name)

**主机名由计算机名和域名组成**

一个域名被分成两个或更多的部分，指定该组织，并可能是一个组织的子集，其中计算机是一部分

两个组织可以将一台计算机命名为相同的东西，因为域名清楚表明是指哪一台计算机

域的最后一部分称为顶级域(TLD)名称

### 谁将域名翻译成 IP ？

域名系统(DNS)主要用于将主机名转换为数字IP地址

DNS是分布式数据库的一个示例。如果该服务器可以解析主机名，它就会这样做；否则，该服务器向其他域名服务器查询

### 传输速度单位 bps 的概念，和 Bps的区别

实际书写规范中B应表示Byte(字节)，b应表示bit(比特)