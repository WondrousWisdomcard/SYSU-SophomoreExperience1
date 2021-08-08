;num3.asm
data segment
      num1 db 15 dup(?)
      num2 db 15 dup(?)
      sum  db 15 dup(?)
data ends

code segment
          assume cs:code, ds:data
start:
       mov ax,data
       mov ds, ax
       ;...
       mov ah,4ch              ; 功能：结束程序，返回DOS系统
       int 21h                 ; DOS功能调用
code  ends
      end start