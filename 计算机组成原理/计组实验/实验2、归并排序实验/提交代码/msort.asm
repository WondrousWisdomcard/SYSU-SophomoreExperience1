;msort.asm
data segment
     nums1 db 100,34,78,9,160,200,90,65
     nums2 db 212,152,8,49,83,35,79,51
     buffer db 8 dup(?)               ; ���������������н��кϲ��Ļ�����
     bufptr dw 0                      ; buffer���Ѻϲ����ݵĸ���
data ends

code segment
      assume cs:code
      
start:     
     mov ax,data
     mov ds,ax
     mov es,ax

     ;��nums1�е�����������ʾ
     mov bx,offset nums1
     mov cx,8
     call mergesort
     call showdecs
     
     ;��ʾ���кͻس�
     mov dl,0ah
     mov ah, 02h
     int 21h
     mov dl,0dh
     mov ah, 02h
     int 21h
     
     ;��nums2�е�����������ʾ
     mov bx,offset nums2
     mov cx,8
     call mergesort
     call showdecs

     mov ah,4ch              ; ���ܣ�����DOSϵͳ
     int 21h                 ;       DOS���ܵ���

; ��һ�����ݽ��й鲢���򣨲��õݹ鷽��ʵ�֣�
; bx--����ַ addr cx--���ݸ���
mergesort proc near

      ret
mergesort endp

; �������ѷֱ���������ݽ��кϲ��������������ݵĸ�����ͬ
;    �м������Դ�ŵ�buffer�У������Ҫ�ŵ�ԭ����
; ������bx--����ַ��������������ţ�,cx--ÿ�����ݵĸ���
mergepart proc near

    ret
mergepart endp

; ��buffer�е����ݿ�����bx��ʼ�Ĵ洢����
; ������bx--����ַ,cx--���ݸ���
copyFromBufferToNums proc


    ret
copyFromBufferToNums endp

; ��al�����ݱ��浽buffer��
saveToBuffer proc

    ret
saveToBuffer endp

; ��һ��ʮ����������ת��Ϊʮ����������ʾ����
; ������ds:bx --����ַ cx -- ���ݸ���
showdecs proc near


      ret
showdecs endp

;��al�еĶ�������ת��Ϊʮ����������ʾ������
showdec proc near

     ret
showdec endp
code  ends
      end start