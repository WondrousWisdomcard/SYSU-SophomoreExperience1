---
author: "Wondrous WisdomCard"
date: 2020-11-12
linktitle: Creating a New Theme
title: Java - The Learning Experience 5
categories: [
    "JavaNote"
]
tags: [
    "Java",
    "Thread"
]
---

# Thread 线程 I

Concurrent Programming

Java 给多线程编程提供了内置的支持。 

基本概念：

线程：指的是进程中一个单一顺序的控制流，**一个进程中可以并发多个线程，每条线程并行执行不同的任务**。

进程：一个进程包括由操作系统分配的内存空间，包含一个或多个线程。一个线程不能独立的存在，它必须是进程的一部分。一个进程一直运行，直到所有的非守护线程都结束运行后才能结束。

**每个线程都是通过某个特定 Thread 对象所对应的方法 run() 来完成其操作的，方法 run() 称为线程体。通过调用 Thread 类的 start() 方法来启动一个线程。**

**run 方法运行结束， 此线程终止。然后 CPU 再调度其它线程。**

### 线程的生命周期

![1](../../images/java5/1.jpg)


#### 新建状态New:
**使用 new 关键字和 Thread 类或其子类建立一个线程对象**后，该线程对象就处于新建状态。它保持这个状态**直到程序 start() 这个线程**。

#### 就绪状态Ready:
当线程对象调用了start()方法之后，**该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度**。

#### 运行状态Running:
如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。

#### 阻塞状态Waiting:
**如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法**，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在**睡眠时间已到或获得设备资源后可以重新进入就绪状态**。可以分为三种：

等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。

同步阻塞：线程在获取 synchronized **同步锁**失败(因为同步锁被其他线程占用)。

其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

#### 死亡状态Dead:
一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

### 线程的创建

Java 提供了三种创建线程的方法：

**通过实现 Runnable 接口；**
**通过继承 Thread 类本身；**
通过 Callable 和 Future 创建线程。

#### 通过Runnable接口

为了实现 Runnable，一个类只需要执行一个方法调用run()，run() 可以调用其他方法，使用其他类，并声明变量，就像主线程一样。在创建一个实现 Runnable 接口的类之后，你可以**在类中实例化一个线程对象**。

#### 通过继承Thread来创建线程

该类继承 Thread 类，然后创建一个该类的实例。

继承类必须重写 run() 方法，**该方法是新线程的入口点**。它也必须**调用 start() 方法才能执行**。


### 

参考：https://www.runoob.com/java/java-multithreading.html

#### Yield
public static void yield()

暂停当前正在执行的线程对象，并执行其他线程。

#### Sleep
public static void sleep(long millisec)

在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。

*让当前的休眠就可以让别的线程在这个时间开始工作，如果sleep时间到了但那个插队的线程还没有做完，他就会继续等待知道插队的线程运行结束。*

#### Interrupt
public void interrupt()

中断线程，An interrupt is an indication to a thread that it should stop what it is doing and do something else.

#### Join
public final void join(long millisec)
等待该线程终止的时间最长为 millis 毫秒，The join method allows one thread to wait for the completion of another. 

t.join();
**causes the current thread to pause execution until t's thread terminates.**

*join是这样的，插队，让正在运行的那个线程先停下来，直到插队的线程结束后，才让原线程继续运行，如果 join(int a)，表示让这个插队的线程最多运行a秒，如果插队的进程还没结束就强制关掉它，让他在后面等，重新继续原来的线程。如果在a秒内插队的进程就运行结束了，那么就重新继续原来的线程。*

---

资料来源，参考：

**陈老师的Java课网站：http://inpluslab.com:8000/java2020/**

**菜鸟教程：https://www.runoob.com/java/java-exceptions.html**