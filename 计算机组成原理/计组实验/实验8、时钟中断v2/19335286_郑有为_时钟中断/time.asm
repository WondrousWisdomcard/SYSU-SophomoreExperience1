; int 1chϵͳ�ж���ÿ�뷢��18.2��,������ÿ����18�Σ�ԭ�����жϴ������ֻ��һ�����iret
; ������ͨ���޸��ж�1ch���ж��������е��жϴ��������ڵ�ַ����ʾһ��ʱ��仯

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
 
 ; ����ԭ�жϴ��������ڵ�ַ
    mov al, 1ch             ; �жϺ�
    mov ah, 35h            ; DOS�жϵ���35H
    int    21h                 ; ȡ����ڵ�ַ,����ES:BX��
    mov  ax, es
    mov  int_seg, ax      ; ����ԭ������ڵ�ַ���Ա��˳�ʱ�ָ�
    mov  int_off, bx

    cli                             ; ������ڵ�ַǰ��Ҫ���ж�
    mov dx,offset second  
    mov ax,seg second
    mov ds,ax
    mov al,1ch               ; ָ��Ҫ�޸ĵ��жϺţ�1chΪʱ���жϵ��жϺ�
    mov ah,25h              ; ��ds:dx�޸���ڵ�ַ
    int 21h
    sti                             ; ���ж�

    ; ������פ�ڴ�
    ; mov dx,offset s3     ; ��פ�ڴ����ĳ���  
    ; sub dx,offset second
    ; mov cl,4
    ; shr dx,cl
    ; mov ax,3100h         ; ah=31h ����פ�ڴ�
    ; int 21h

    ; ��ʾ�ַ���msg
    mov ax, seg msg
    mov ds, ax
    mov dx, offset msg
    mov ah,09h               ; ah=09h ����פ�ڴ�
    int 21h

lp: mov ah,0bh        ; dos���ܺ�:0bh �ж����ް���
    int 21h                ; al=00 �а��� al=FF �ް���
    test al,0FFh;
    je lp
ex:      
    ; ���˳����ж�֮��ظ�ԭ�ж�����
    cli                              ; ��Ҫ���ж� 
    mov ax,data
    mov ds,ax
    mov al, 1ch
    mov dx, int_off
    mov bx, int_seg
    mov ds, bx
    mov ah, 25h              ; �ָ�ԭ������ڵ�ַ
    int    21h
    sti                              ; ���ж�
   
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

    ; ��ȡ��ǰ���λ�ò�����
    mov bx,0       ;bhΪҳ��
    mov ah,03h   ;
    int 10h
    mov n,dx       ; dh  �� dl  ��
    mov m,cx      ; ch  ��꿪ʼ��  cl ��������  
	
    mov ah, '.'
    mov al, ah
    mov dx,0075h
    call showchar

    mov ah, ':'
    mov al, ah
    mov dx,0072h
    call showchar

    ; tsec��1������18ʱ����Ϊ0	
    mov al, [tsec]
    add al ,1
    daa
    mov [tsec],al
    cmp al,18h
    jne  s2
    mov [tsec],0

    ; sec��1������60ʱ����Ϊ0
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

    ; min��1������60ʱ����Ϊ0
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

   ;��ʾ�ַ�
s2:
    mov al, [tsec]   ; Ҫ��ʾ���ַ�
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
    mov al, [sec]   ; Ҫ��ʾ���ַ�
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
    mov al, [min]   ; Ҫ��ʾ���ַ�
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

    ;�ѹ�����û�֮ǰ��λ��
    mov bx,0         ; bh -- ҳ��
    mov dx,n         ; dh-��  dl--��
    mov ah,02h
    int 10h

    ; ���ù�꿪ʼ�к͹�������
    mov cx,m       ; ch  ��꿪ʼ��  cl ��������  
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


; al-ascii,  dh-�У�dl-��
showchar  proc near
    push ax
    push bx
    push cx
    push dx

    mov bx, 002fh  ; ��ʾҳ�������(��ɫ)
    mov ah, 2         ; ���ù��λ��(dh-�У�dl-��)
    int  10h	

    mov cx,1           ; �ظ���ʾal�е��ַ�����(cx)��
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