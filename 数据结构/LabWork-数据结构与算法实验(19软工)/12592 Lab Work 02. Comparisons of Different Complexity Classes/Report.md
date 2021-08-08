# 第一次实验报告

### 实验内容及实验目的：Let n be a positive integer with specified initial value. Design and implement a program to find the least number N such that g(n)>=f(n) when n>N.

(1) n=1, f(n)=n and g(n)=nln(n).

(2) n=1, f(n)=n^10 and g(n)=2^n.

(3) n=2, f(n)=2^n and g(n)=n!

### 试验结果：

程序输出：
part1: 3 g(n)= 3.295837 f(n)= 3
part1: 4 g(n)= 5.545177 f(n)= 4
part1: 5 g(n)= 8.047190 f(n)= 5
part1: 6 g(n)= 10.750557 f(n)= 6
part1: 7 g(n)= 13.621371 f(n)= 7
part1: 8 g(n)= 16.635532 f(n)= 8
part1: 9 g(n)= 19.775021 f(n)= 9
part1: 10 g(n)= 23.025851 f(n)= 10
part1: 11 g(n)= 26.376848 f(n)= 11
part1: 12 g(n)= 29.818880 f(n)= 12

part2: 1 is the such that g(n)>=f(n)
part2: 59 is the least number such that g(n)>=f(n)

part2: 59 g(n)= 576460752303423488.000000 f(n)= 511116753300641408.000000 
part2: 60 g(n)= 1152921504606846976.000000 f(n)= 604661760000000000.000000 
part2: 61 g(n)= 2305843009213693952.000000 f(n)= 713342911662882560.000000 
part2: 62 g(n)= 4611686018427387904.000000 f(n)= 839299365868340224.000000 
part2: 63 g(n)= 9223372036854775808.000000 f(n)= 984930291881790848.000000 
part2: 64 g(n)= 18446744073709551616.000000 f(n)= 1152921504606846976.000000 
part2: 65 g(n)= 36893488147419103232.000000 f(n)= 1346274334462890752.000000 
part2: 66 g(n)= 73786976294838206464.000000 f(n)= 1568336880910795776.000000 
part2: 67 g(n)= 147573952589676412928.000000 f(n)= 1822837804551761408.000000 
part2: 68 g(n)= 295147905179352825856.000000 f(n)= 2113922820157210624.000000 

part3: 4 is the least number such that g(n)>=f(n)

part3: 4 g(n)= 96 f(n)= 16.000000 
part3: 5 g(n)= 480 f(n)= 32.000000 
part3: 6 g(n)= 2880 f(n)= 64.000000 
part3: 7 g(n)= 20160 f(n)= 128.000000 
part3: 8 g(n)= 161280 f(n)= 256.000000 
part3: 9 g(n)= 1451520 f(n)= 512.000000 
part3: 10 g(n)= 14515200 f(n)= 1024.000000 
part3: 11 g(n)= 159667200 f(n)= 2048.000000 
part3: 12 g(n)= 1916006400 f(n)= 4096.000000 
part3: 13 g(n)= 24908083200 f(n)= 8192.000000 

### 实验结论

(1)对于实验一：n=1, f(n)=n and g(n)=nln(n)

实验表明 3 is the least number such that g(n)>=f(n) **when n>N**.

(2)对于实验二：n=1, f(n)=n^10 and g(n)=2^n.

实验表明 59 is the least number such that g(n)>=f(n)  **when n>N**.

实验发现当 n=1时，满足g(n)>=f(n)，但n=2时，不满足g(n)>=f(n)，也就是说1 is not the least number such that g(n)>=f(n) when n>N.

(3)对于实验三：n=2, f(n)=2^n and g(n)=n!

实验表明 4 is the least number such that g(n)>=f(n) **when n>N**.
