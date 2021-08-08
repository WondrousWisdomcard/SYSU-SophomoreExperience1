; int 1ch系统中断是每秒发生18.2次,即调用每秒它18次，原来的中断处理程序只有一个语句iret
; 本程序通过修改中断1ch的中断向量表中的中断处理程序入口地址，显示一个时间变化

data segment
    n           dw 0
    m           dw 0
    min         db 0
    sec         db 0
    tsec        db 0
    int_seg     dw 0
    int_off     dw 0
    msg db "press any key to continue...",0ah,0dh,'$'
data ends

stack segment STACK 'STACK'
	dw 100 dup(?)
stack ends

code segment 
	assume cs:code,ss:stack,ds:data
main proc far
start:
    mov ax,data
    mov ds,ax
 
 ; 保留原中断处理程序入口地址
    mov al, 1ch             ; 中断号
    mov ah, 35h            ; DOS中断调用35H
    int    21h                 ; 取出入口地址,放于ES:BX中
    mov  ax, es
    mov  int_seg, ax      ; 保存原来的入口地址，以便退出时恢复
    mov  int_off, bx

    cli                             ; 设置入口地址前需要关中断
    mov dx,offset second  
    mov ax,seg second
    mov ds,ax
    mov al,1ch               ; 指出要修改的中断号，1ch为时钟中断的中断号
    mov ah,25h              ; 用ds:dx修改入口地址
    int 21h
    sti                             ; 开中断

    ; 本程序常驻内存
    ; mov dx,offset s3     ; 常驻内存程序的长度  
    ; sub dx,offset second
    ; mov cl,4
    ; shr dx,cl
    ; mov ax,3100h         ; ah=31h 程序常驻内存
    ; int 21h

    ; 显示字符串msg
    mov ax, seg msg
    mov ds, ax
    mov dx, offset msg
    mov ah,09h               ; ah=09h 程序常驻内存
    int 21h

lp: mov ah,0bh        ; dos功能号:0bh 判断有无按键
    int 21h                ; al=00 有按键 al=FF 无按键
    test al,0FFh;
    je lp
ex:      
    ; 在退出本中断之后回复原中断向量
    cli                              ; 先要关中断 
    mov ax,data
    mov ds,ax
    mov al, 1ch
    mov dx, int_off
    mov bx, int_seg
    mov ds, bx
    mov ah, 25h              ; 恢复原来的入口地址
    int    21h
    sti                              ; 开中断
   
    mov ah, 4ch
    int 21h
main endp
	
second  proc near
    push ds
    push ax
    push bx
    push cx
    push dx	

    sti
    mov ax, data
    mov ds, ax

    ; 读取当前光标位置并保存
    mov bx,0       ;bh为页号
    mov ah,03h   ;
    int 10h
    mov n,dx       ; dh  行 dl  列
    mov m,cx      ; ch  光标开始行  cl 光标结束行  
	
    mov ah, '.'
    mov al, ah
    mov dx,0075h
    call showchar

    mov ah, ':'
    mov al, ah
    mov dx,0072h
    call showchar

    ; tsec加1，加至18时设置为0	
    mov al, [tsec]
    add al ,1
    daa
    mov [tsec],al
    cmp al,18h
    jne  s2
    mov [tsec],0

    ; sec加1，加至60时设置为0
    mov ah, [sec]
    add ah ,1

    mov bl,al
    mov al,ah
    daa
    mov ah,al
    mov al,bl

    mov [sec],ah
    cmp ah,60h
    jne  s4
    mov [sec],0

    ; min加1，加至60时设置为0
    mov dh, [min]
    add dh ,1
    
    mov bl,al
    mov al,dh
    daa
    mov dh,al
    mov al,bl

    mov [min],dh
    cmp dh,60h
    jne  s5
    mov [min],0

   ;显示字符
s2:
    mov al, [tsec]   ; 要显示的字符
    mov ah, al
    mov cl,4
    shr al,cl           
    add al,'0' 
    mov dx,0076h
    call showchar

    and ah, 0fh
    add ah, '0'
    mov al, ah
    mov dx,0077h
    call showchar
s4:
    mov al, [sec]   ; 要显示的字符
    mov ah, al
    mov cl,4
    shr al,cl           
    add al,'0' 
    mov dx,0073h
    call showchar

    and ah, 0fh
    add ah, '0'
    mov al, ah
    mov dx,0074h
    call showchar

s5:
    mov al, [min]   ; 要显示的字符
    mov ah, al
    mov cl,4
    shr al,cl           
    add al,'0' 
    mov dx,0070h
    call showchar

    and ah, 0fh
    add ah, '0'
    mov al, ah
    mov dx,0071h
    call showchar

    ;把光标设置回之前的位置
    mov bx,0         ; bh -- 页号
    mov dx,n         ; dh-行  dl--列
    mov ah,02h
    int 10h

    ; 设置光标开始行和光标结束行
    mov cx,m       ; ch  光标开始行  cl 光标结束行  
    mov ah,01h
    int 10h
    pop dx
    pop cx
    pop bx
    pop ax
    pop ds
    iret
s3:
second endp


; al-ascii,  dh-行，dl-列
showchar  proc near
    push ax
    push bx
    push cx
    push dx

    mov bx, 002fh  ; 显示页码和属性(颜色)
    mov ah, 2         ; 设置光标位置(dh-行，dl-列)
    int  10h	

    mov cx,1           ; 重复显示al中的字符若干(cx)次
    mov ah, 09h
    int 10h
    
    pop dx
    pop cx
    pop bx
    pop ax
    ret
showchar endp

code ends
  end start