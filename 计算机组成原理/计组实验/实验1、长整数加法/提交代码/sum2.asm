;num2.asm
;从键盘输入两个8位十进制整数
;并采用压缩的BCD码保存在NUM1和NUM2中
;然后把它们求和并保存在SUM中
;最后把SUM的内容显示出来。
;参考指令: mov,int,add,adc,daa,loop,shl,and

data segment

      notice db 0dh, 0ah,'Please input decimal number with 8 chararcter',0dh,0ah,'$'
      result db 0dh, 0ah,'the sum is:$'

      num1 db 4 dup(?)
      num2 db 4 dup(?)
      sum  db 4 dup(?)

      input1 db 10
             db ?
             db 10 dup(?)
      input2 db 10
             db ?
             db 10 dup(?)
      strsum db 10
             db ?
             db 10 dup(?),'$'
data ends

code segment
          assume cs:code, ds:data
start:
      mov ax,data
      mov ds, ax

;step1:显示提示信息,然后输出数据以字符串的形式
      mov ah, 09h
      lea dx, notice
      int 21h

      mov ah, 0ah
      lea dx, input1
      int 21h
     
      mov ah, 09h
      lea dx, notice
      int 21h

      mov ah, 0ah
      lea dx, input2
      int 21h

;step2:把input里的数据转化到num里
      lea si, input1 ;si指向input1
      lea di, num1 ;di指向num1
      mov cx, 4 ;循环4次
      add di, 4 ;
      dec di
next1: mov al, [si+2]
      sub al, 30h

      shl al, 1
      shl al, 1
      shl al, 1
      shl al, 1

      inc si
      mov ah, [si+2]
      sub ah, 30h
      add al, ah
      mov [di], al 
      inc si
      dec di
      loop next1;

      lea si, input2 ;si指向input2
      lea di, num2 ;di指向num2
      mov cx, 4 ;循环4次
      add di, 4 ;
      dec di
next2: mov al, [si+2]
      sub al, 30h

      shl al, 1
      shl al, 1
      shl al, 1
      shl al, 1

      inc si
      mov ah, [si+2]
      sub ah, 30h
      add al, ah
      mov [di], al 
      inc si
      dec di
      loop next2;

;step3:像sum1.asm文件里的那样相加
      lea si,num1 ;si指向num1
      lea di,num2 ;di指向num2
      lea bx,sum ;bx指向sum
      mov cx,5 ;循环进行4次求和运算
      clc
next: mov al,[si];
      adc al,[di];
      daa;
      mov [bx],al;
      inc si;
      inc di;
      inc bx;
      loop next;

;step4:把BCD-sum转化到字符串-Strsum中
      lea si, sum ;si指向sum
      add si, 3
      lea di, strsum ;di指向strsum
      mov cx, 4 ;循环4次
next3: mov al, [si]

      shr al, 1
      shr al, 1
      shr al, 1
      shr al, 1 

      add al, 30h
      mov [di], al
      inc di

      mov al, [si]
      and al, 0fh
      add al, 30h

      mov [di], al
      inc di
      dec si
      loop next3

;step5:显示提示信息,sum字符串的形式输出
      mov ah, 09h
      lea dx, result
      int 21h
      
      mov ah, 09h
      lea dx, strsum
      int 21h

      mov ah,4ch              ; 功能：结束程序，返回DOS系统
      int 21h                 ; DOS功能调用
code  ends
      end start

