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

     mov ah,4ch              ; ���ܣ�����DOSϵͳ
     int 21h                 ;       DOS���ܵ���

; ��һ��ʮ����������ת��Ϊʮ����������ʾ����
; ������ds:bx --����ַ cx -- ���ݸ���
showdecs proc near

      ret
showdecs endp

;��al�еĶ�������ת��Ϊʮ����������ʾ������
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