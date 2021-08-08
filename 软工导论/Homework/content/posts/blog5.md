---
author: "Wondrous WisdomCard"
date: 2020-10-20
title: Pseudocode of Washing Machine
tags: [  
    "Pseudocode"
]
categories: [
    "Experience & Practice"
]
---

### 项目5：用伪代码描述算法。
#### 介绍“自顶向下，逐步求精”的编程方法；以你观察的洗衣机为案例，用伪代码描述洗衣机洗衣的程序。

“自顶向下”的具体内涵是将复杂、大的问题划分为小问题，找出问题的关键、重点所在，然后用精确的思维定性、定量地去描述问题。而“逐步求精”的具体内涵是是将现实世界的问题经抽象转化为逻辑空间或求解空间的问题。复杂问题经抽象化处理变为相对比较简单的问题。经若干步抽象（精化）处理，最后到求解域中只是比较简单的编程问题。[<sup>1</sup>](#refer1)

假设洗衣机可执行的基本操作如下： 

    water_in_switch(open_close)  // open 打开上水开关，close关闭 
    water_out_switch(open_close)  // open 打开排水开关，close关闭 
    get_water_volume()  //返回洗衣机内部水的高度
    motor_run(direction) // 电机转动。left左转，right右转，stop停 
    time_counter()  // 返回当前时间计数，以秒为单位
    halt(returncode) //停机，success 成功 failure 失败

##### 1）伪代码分解“正常洗衣”程序的大步骤。

洗衣机洗衣服时，这些子程序被顺序地一一调用

    start_up(); //开机
    mode_selection(); //模式选择
    get_water(num_of_mode); //注水
    soak_clothes(num_of_mode); //浸泡
    wash_clothes(num_of_mode); //洗衣
    drain_away_water(); //排水
    spin_dry(); //甩干
    power_off(); //关机

##### 2）进一步用基本操作、控制语句（IF、FOR、WHILE等）、变量与表达式，写出每个步骤的伪代码 

这台洗衣机有三种洗衣模式1，2，3，分别对应不同的洗衣量。不同模式的注水体积，浸泡时间，洗衣，甩干时间有所不同。

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

---

<div id="refer1"></div>

-[1] [“自顶向下，逐步求精”的方法](https://blog.csdn.net/wenhlin/article/details/78641308)
