;msort.asm
data segment
     nums1 db 100,34,78,9,160,200,90,65
     nums2 db 212,152,8,49,83,35,79,51
     buffer db 8 dup(?)               ; 用于两个有序数列进行合并的缓冲区
     bufptr dw 0                      ; buffer中已合并数据的个数
data ends

code segment
      assume cs:code
      
start:     
     mov ax,data
     mov ds,ax
     mov es,ax

     ;对nums1中的数据排序并显示
     mov bx,offset nums1
     mov cx,8
     call mergesort
     call showdecs
     
     ;显示换行和回车
     mov dl,0ah
     mov ah, 02h
     int 21h
     mov dl,0dh
     mov ah, 02h
     int 21h
     
     ;对nums2中的数据排序并显示
     mov bx,offset nums2
     mov cx,8
     call mergesort
     call showdecs

     mov ah,4ch              ; 功能：返回DOS系统
     int 21h                 ;       DOS功能调用

; 对一组数据进行归并排序（采用递归方法实现）
; bx--基地址 addr cx--数据个数
mergesort proc near

      ret
mergesort endp

; 对两组已分别排序的数据进行合并和排序，两组数据的个数相同
;    中间结果可以存放到buffer中，最后结果要放到原区域
; 参数：bx--基地址（两部分连续存放）,cx--每组数据的个数
mergepart proc near

    ret
mergepart endp

; 把buffer中的数据拷贝到bx开始的存储区中
; 参数：bx--基地址,cx--数据个数
copyFromBufferToNums proc


    ret
copyFromBufferToNums endp

; 把al的数据保存到buffer中
saveToBuffer proc

    ret
saveToBuffer endp

; 把一组十六进制数据转换为十进制数并显示出来
; 参数：ds:bx --基地址 cx -- 数据个数
showdecs proc near


      ret
showdecs endp

;把al中的二进制数转换为十进制数并显示出来。
showdec proc near

     ret
showdec endp
code  ends
      end start