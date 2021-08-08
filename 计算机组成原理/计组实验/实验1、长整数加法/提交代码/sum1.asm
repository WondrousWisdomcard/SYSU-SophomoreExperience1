;num1.asm
data segment
      num1 db 23H, 45H, 67H, 89H ;Integer 0x89674523
      num2 db 19H, 13H, 25H, 49H ;Integer 0x49251319
      sum db 4 dup(?) ; 重复定义了4个字元素，占用4*2=8个字节
data ends

code segment
          assume cs:code, ds:data
start:
       mov ax,data
       mov ds, ax

       lea si,num1;si指向num1
       lea di,num2;di指向num2
       lea bx,sum;bx指向sum

       mov cx,4;循环进行4次求和运算
 next: mov al,[si];
       adc al,[di];
       daa;
       mov [bx],al;
       inc si;
       inc di;
       inc bx;
       loop next;
      
       mov ah,4ch              ; 功能：结束程序，返回DOS系统
       int 21h                 ; DOS功能调用
code  ends
      end start