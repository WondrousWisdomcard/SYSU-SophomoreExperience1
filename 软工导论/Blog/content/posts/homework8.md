---
author: "Wondrous WisdomCard"
date: 2020-10-20
linktitle: Creating a New Theme
title: Homework of Week 8
tags: [  
    "Top-down design",
    "Work breakdown structure"
]
categories: [
    "Homework"
]
---

### 1、阅读 PseudocodeStandard。

##### 1）用伪代码描述将十进制转换成16进制的方法

    void octToHex(十进制数 num,十六进制存储数组 hex[10])
    {
        if num为负数  
            取num的绝对值;
            将hex数组的首字符置为负号;
        endif
        index指向数组最后一位;
        while 若num大于零
            t = num对16取模;
            if t大于9
                hex[index] = (t-10) + 'A';
            endif
            else
                hex[index] = t + '0';
            end else
            index指向当前index的前一位;
            num = num/16得到的余数
        end while
    }
    void showHex(int num)
    {
        // 对hex赋初始值为{0,0,0,0,0,0,0,0,'0',0}
        // 调用octToHex(num,hex);
        // 遍历数组，输出非空字符;
    }
 
##### 2）C语言实现（先用注释写好算法，然后翻译）

    void octToHex(int num,char hex[10])
    {
        if(num < 0)
        {
            num = -num;
            hex[0] = '-';
        }
        int i = 8;
        while(num != 0)
        {
            int t = num % 16;
            hex[i--] = t > 9 ? t % 10 + 'A' : t + '0';
            num /= 16;
        }
    }
    void showHex(int num)
    {
        char hex[10] = {0,0,0,0,0,0,0,0,'0',0};
        octToHex(num,hex);
        for(int i = 0 ; i < 10; i++) //遍历数组，输出非空字符
        {
            if(hex[i] != 0)
            printf("%c",hex[i]);
        }
        printf("\n");
    }
 
##### 3）使用 -1,0,1,15,26,3265 最为输入测试你的程序

    showHex(-1); // output: -1
    showHex(0); // output: 0
    showHex(1); // output: 1 
    showHex(15); // output: F
    showHex(26); // output: 1A
    showHex(3265); // output: CC1

---

### 2、名词解释与对比 from Wekipedia

##### 1）Top-down design 

A design methodology that proceeds from the highest level to the lowest and from the general to the particular, and that provides a formal mechanism for breaking complex process designs into functional descriptions, reviewing progress, and allowing modifications.

##### 2） Work breakdown structure (WBS)

A division of a project into tasks and subtasks. The tasks are numbered to indicate their relationship to each other. WBSs are indespensible for project planning, particularly when estimating time and resource requirements. Some industries use established work breakdown structure systems for billing and reporting purposes.

##### 3）简述管理学WBS 与 信息学Top-down设计 的异同

相同点：二者都是将一个复杂的问题细化，分成许多的子问题再解决；不同点：WBS是一个描述思路的规划和设计工具，它还可以帮助项目经理和项目团队确定和有效地管理项目的工作：清晰地表示各项目工作之间的相互联系，展现项目全貌，详细说明为完成项目所必须完成的各项工作，WBS定义了里程碑事件，可以向高级管理层和客户报告项目完成情况，作为项目状况的报告工具。而Top-down design对要完成的任务进行分解，先对最高层次中的问题进行定义、设计、编程和测试，而将其中未解决的问题作为一个子任务放到下一层次中去解决。这样逐层、逐个地进行定义、设计、编程和测试，直到所有层次上的问题均由实用程序来解决，就能设计出具有层次结构的程序。最后会通过由顶层模块调用子模块来实现整体功能。

---

### 3. 仔细观察您洗衣机的运作过程，运用Top-down设计方法和Pseudocode 描述洗衣机控制程序。

假设洗衣机可执行的基本操作如下： 

    water_in_switch(open_close)  // open 打开上水开关，close关闭 
    water_out_switch(open_close)  // open 打开排水开关，close关闭 
    get_water_volume()  //返回洗衣机内部水的高度
    motor_run(direction) // 电机转动。left左转，right右转，stop停 
    time_counter()  // 返回当前时间计数，以秒为单位
    halt(returncode) //停机，success 成功 failure 失败

##### 1）请使用伪代码分解“正常洗衣”程序的大步骤。包括注水、浸泡等

    start_up(); //开机
    mode_selection(); //模式选择
    get_water(num_of_mode); //注水
    soak_clothes(num_of_mode); //浸泡
    wash_clothes(num_of_mode); //洗衣
    drain_away_water(); //排水
    spin_dry(); //甩干
    power_off(); //关机

##### 2）进一步用基本操作、控制语句（IF、FOR、WHILE等）、变量与表达式，写出每 个步骤的伪代码 

    start_up(open_close){

    }
    mode_selection(){
        get num_of_mode;
        return num_of_mode;
    }
    get_water(num_of_mode){
        switch(num_of_mode){
            case 1: target_volume_of_water = 2L;
            case 2: target_volume_of_water = 3L;
            case 3: target_volume_of_water = 4L;
        }
        water_in_switch(open);
        while(get_water_volume() < target_water_volume);
        water_in_switch(close);
    }
    soak_clothes(num_of_mode){
        switch(num_of_mode){
            case 1: target_soak_time = 1min;
            case 2: target_soak_time = 2min;
            case 3: target_soak_time = 3min;
        }
        init time_counter();
        while(time_counter() >= target_soak_time);
    }
    wash_clothes(num_of_mode){
        switch(num_of_mode){
            case 1: target_wash_time = 10min;
            case 2: target_wash_time = 15min;
            case 3: target_wash_time = 20min;
        }
        init time_counter;
        while(time_counter() <= target_wash_time){
            if(time_counter() % 2 == 0)
            motor_run(left);
            else
            motor_run(right);
        }
        motor_run(stop);
    }
    drain_away_water(){
        water_out_switch(open);
        while(get_water_volume() > 0);
        water_out_switch(close);
    }
    spin_dry(){
        switch(num_of_mode){
            case 1: target_dry_time = 4min;
            case 2: target_dry_time = 6min;
            case 3: target_dry_time = 8min;
        }
        init time_counter();
        motor_run(left);
        while(time_counter() <= target_dry_time);
        motor_run(stop);
    }
    power_off(){
        halt(success);
    }

##### 3）根据你的实践，请分析“正常洗衣”与“快速洗衣”在用户目标和程序上的异同。 你认为是否存在改进（创新）空间，简单说明你的改进意见？ 

两者相同点在于都要经过接水，洗衣，排水，甩干这样的基本流程，不同点在于接水量和洗衣，排水，甩干时间。可以为用户设计多种洗衣模式，减少不必要的浪费并方便用户使用。

##### 4）通过步骤3），提取一些共性功能模块（函数），简化“正常洗衣”程序，使程序 变得更利于人类理解和修改维护。例如： wait(time) //等待指定的时间； 注水(volume,timeout) //在指定时间内完成注水，否则停机； 排水(timeout)等子程序

    wait(time,method()){
        init time_counter();
        method(open);
        while(time_counter() <= time);
        method(close);
    }

    get_water(volume,timeout){
        init time_counter();
        water_in_switch(open);
        while(get_water_volume() < volume){
            if(time_counter > time){
                water_in_switch(close);
                halt(failure);
            }
        }
    }
    
    drain_away_water(timeout){
        water_out_switch(open);
        init time_counter();
        while(get_water_volume() > 0){
            if(time_counter >= timeout){
                water_out_switch(close);
                halt(failure);
            }
        }
        water_out_switch(close);
    }