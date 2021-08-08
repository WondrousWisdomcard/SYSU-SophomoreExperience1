;msort.asm
data segment
     nums1 db 100,34,78,9,160,200,90,65
data ends

code segment
      assume cs:code
      
start:     
     mov ax,data
     mov ds,ax
     mov es,ax

     mov bx,offset nums1
     mov cx,8
     call showdecs

     mov ah,4ch              ; 功能：返回DOS系统
     int 21h                 ;       DOS功能调用

; 把一组十六进制数据转换为十进制数并显示出来
; 参数：ds:bx --基地址 cx -- 数据个数
showdecs proc near

      ret
showdecs endp

;把al中的二进制数转换为十进制数并显示出来。
showdec proc near
     push ax
     push bx
     push cx
     push dx

     pop dx
     pop cx
     pop bx
     pop ax
     ret
showdec endp

code  ends
      end start