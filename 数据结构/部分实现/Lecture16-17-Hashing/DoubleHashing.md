# Lab Work 08-1. Double Hashing

### Consider a hash table with M = 64 bins. Given a 12-bit unsigned number, take the lowest 6 bits as the primary hash function to get the bin number and the highest 6 bits as the secondary hash function to get the jump size.

## Description of Work 08-1 and data structures applied

    unsigned int M[64]; 
    //data structures: use an array to represent the hash table with M = 64 bins (2^6)

    unsigned int hash_bin(unsigned int n); 
    //first hashing to get the bin num

    unsigned int hash_jump(unsigned int n); 
    //second hashing to get the jump num if there is a collision

    int double_hashing(unsigned int * ranArr, int n);
    //double hashing and save the result to M[64]

## Testing cases of Work 08-1

### Test Function

    void test2(){
        unsigned int arr[40];
        randomGetArray(arr); //get the random array
        int n = 40;

        double_hashing(arr,n);
        for(int i = 0; i < 64; i++){
            printf("Bin:%2d Val:%4d |",i,M[i]);
            if((i+1) % 8 == 0) printf("\n");
        }
        printf("Total Num of Probe: %d \n",num_of_probes);
        printf("Average Num of Probe: %lf \n",(double)num_of_probes/n);
    }

### Test Result:

#### Test1:

    Bin: 0 Val:3584 |Bin: 1 Val:1281 |Bin: 2 Val:   0 |Bin: 3 Val:1219 |Bin: 4 Val:3908 |Bin: 5 Val: 965 |Bin: 6 Val:   0 |Bin: 7 Val:1351 |   
    Bin: 8 Val:   0 |Bin: 9 Val:3209 |Bin:10 Val:3530 |Bin:11 Val:2187 |Bin:12 Val:   0 |Bin:13 Val:   0 |Bin:14 Val:   0 |Bin:15 Val: 975 |   
    Bin:16 Val:1040 |Bin:17 Val:   0 |Bin:18 Val:   0 |Bin:19 Val:1216 |Bin:20 Val:1659 |Bin:21 Val: 469 |Bin:22 Val:2902 |Bin:23 Val:2775 |   
    Bin:24 Val: 213 |Bin:25 Val:  24 |Bin:26 Val: 655 |Bin:27 Val:   0 |Bin:28 Val:2844 |Bin:29 Val:   0 |Bin:30 Val:3433 |Bin:31 Val:1567 |   
    Bin:32 Val:   0 |Bin:33 Val:   0 |Bin:34 Val:   0 |Bin:35 Val:2467 |Bin:36 Val:   0 |Bin:37 Val:1044 |Bin:38 Val:3890 |Bin:39 Val:4008 |   
    Bin:40 Val:1111 |Bin:41 Val:  40 |Bin:42 Val:   0 |Bin:43 Val:2283 |Bin:44 Val:1004 |Bin:45 Val:3309 |Bin:46 Val:   0 |Bin:47 Val:2692 |   
    Bin:48 Val:1559 |Bin:49 Val:   0 |Bin:50 Val:1266 |Bin:51 Val:2995 |Bin:52 Val:   0 |Bin:53 Val:1333 |Bin:54 Val:   0 |Bin:55 Val:   0 |   
    Bin:56 Val:   0 |Bin:57 Val:2681 |Bin:58 Val:   0 |Bin:59 Val:2427 |Bin:60 Val:   0 |Bin:61 Val:   0 |Bin:62 Val:1195 |Bin:63 Val:2520 |   
    Total Num of Probe: 58
    Average Num of Probe: 1.450000


#### Test2:

    Bin: 0 Val: 384 |Bin: 1 Val:3592 |Bin: 2 Val:   0 |Bin: 3 Val:   0 |Bin: 4 Val: 260 |Bin: 5 Val:   0 |Bin: 6 Val:   0 |Bin: 7 Val:   0 |   
    Bin: 8 Val:1416 |Bin: 9 Val:  73 |Bin:10 Val:1418 |Bin:11 Val: 855 |Bin:12 Val:   0 |Bin:13 Val:3213 |Bin:14 Val:1678 |Bin:15 Val: 207 |   
    Bin:16 Val:2157 |Bin:17 Val:   0 |Bin:18 Val: 722 |Bin:19 Val:2771 |Bin:20 Val:2644 |Bin:21 Val:   0 |Bin:22 Val:   0 |Bin:23 Val:3799 |   
    Bin:24 Val:   0 |Bin:25 Val:   0 |Bin:26 Val:   0 |Bin:27 Val:1051 |Bin:28 Val:3378 |Bin:29 Val:   0 |Bin:30 Val:3870 |Bin:31 Val:   0 |   
    Bin:32 Val:1184 |Bin:33 Val:   0 |Bin:34 Val:   0 |Bin:35 Val: 419 |Bin:36 Val:1508 |Bin:37 Val:   0 |Bin:38 Val:   0 |Bin:39 Val:3559 |   
    Bin:40 Val:1192 |Bin:41 Val:   0 |Bin:42 Val:3885 |Bin:43 Val:1067 |Bin:44 Val:3820 |Bin:45 Val:4013 |Bin:46 Val:1966 |Bin:47 Val:3957 |   
    Bin:48 Val:2672 |Bin:49 Val:1713 |Bin:50 Val:2546 |Bin:51 Val:   0 |Bin:52 Val:   0 |Bin:53 Val:2357 |Bin:54 Val:   0 |Bin:55 Val:3511 |   
    Bin:56 Val:   0 |Bin:57 Val:3257 |Bin:58 Val: 890 |Bin:59 Val: 443 |Bin:60 Val:3196 |Bin:61 Val:   0 |Bin:62 Val:4032 |Bin:63 Val:1727 |   
    Total Num of Probe: 55
    Average Num of Probe: 1.375000

#### Test3:

    Bin: 0 Val: 256 |Bin: 1 Val:   0 |Bin: 2 Val:   0 |Bin: 3 Val:   0 |Bin: 4 Val:3680 |Bin: 5 Val:   0 |Bin: 6 Val:1158 |Bin: 7 Val:3207 |   
    Bin: 8 Val:   0 |Bin: 9 Val:2185 |Bin:10 Val: 714 |Bin:11 Val:3403 |Bin:12 Val: 327 |Bin:13 Val:3100 |Bin:14 Val:   0 |Bin:15 Val:2724 |   
    Bin:16 Val:1936 |Bin:17 Val:   0 |Bin:18 Val:2130 |Bin:19 Val: 522 |Bin:20 Val: 468 |Bin:21 Val: 272 |Bin:22 Val:   0 |Bin:23 Val:   0 |   
    Bin:24 Val:   0 |Bin:25 Val:1689 |Bin:26 Val:   0 |Bin:27 Val:   0 |Bin:28 Val:1950 |Bin:29 Val:   0 |Bin:30 Val:1502 |Bin:31 Val:1290 |   
    Bin:32 Val:3424 |Bin:33 Val:  33 |Bin:34 Val:   0 |Bin:35 Val:   0 |Bin:36 Val: 292 |Bin:37 Val:   0 |Bin:38 Val:2873 |Bin:39 Val:2535 |   
    Bin:40 Val:2055 |Bin:41 Val:3632 |Bin:42 Val:1578 |Bin:43 Val:  40 |Bin:44 Val:3245 |Bin:45 Val:3757 |Bin:46 Val:   0 |Bin:47 Val:2692 |   
    Bin:48 Val:1685 |Bin:49 Val:1137 |Bin:50 Val:   0 |Bin:51 Val:2948 |Bin:52 Val:   0 |Bin:53 Val:   0 |Bin:54 Val:3645 |Bin:55 Val:1015 |   
    Bin:56 Val:   0 |Bin:57 Val:3449 |Bin:58 Val: 825 |Bin:59 Val:   0 |Bin:60 Val:   0 |Bin:61 Val:1597 |Bin:62 Val: 830 |Bin:63 Val:   0 |   
    Total Num of Probe: 72
    Average Num of Probe: 1.800000

#### Test4:

    Bin: 0 Val:3520 |Bin: 1 Val:   0 |Bin: 2 Val: 386 |Bin: 3 Val:   0 |Bin: 4 Val:1348 |Bin: 5 Val:3781 |Bin: 6 Val:3014 |Bin: 7 Val:1927 |   
    Bin: 8 Val: 584 |Bin: 9 Val:3913 |Bin:10 Val:   0 |Bin:11 Val: 331 |Bin:12 Val: 140 |Bin:13 Val:   0 |Bin:14 Val: 139 |Bin:15 Val:   0 |   
    Bin:16 Val:   0 |Bin:17 Val:   0 |Bin:18 Val:2322 |Bin:19 Val:   0 |Bin:20 Val: 916 |Bin:21 Val:   0 |Bin:22 Val:   0 |Bin:23 Val:   0 |   
    Bin:24 Val:   0 |Bin:25 Val:   0 |Bin:26 Val:   0 |Bin:27 Val:   0 |Bin:28 Val:   0 |Bin:29 Val:3116 |Bin:30 Val:1566 |Bin:31 Val:1887 |   
    Bin:32 Val:3808 |Bin:33 Val:2849 |Bin:34 Val:1762 |Bin:35 Val:   0 |Bin:36 Val:   0 |Bin:37 Val:   0 |Bin:38 Val:2598 |Bin:39 Val:2727 |   
    Bin:40 Val:   0 |Bin:41 Val:2921 |Bin:42 Val:2346 |Bin:43 Val:2923 |Bin:44 Val: 876 |Bin:45 Val:1837 |Bin:46 Val:   0 |Bin:47 Val:   0 |   
    Bin:48 Val:3120 |Bin:49 Val:3185 |Bin:50 Val:2994 |Bin:51 Val: 499 |Bin:52 Val: 734 |Bin:53 Val:   0 |Bin:54 Val:1654 |Bin:55 Val:2423 |   
    Bin:56 Val:2827 |Bin:57 Val:1849 |Bin:58 Val:3770 |Bin:59 Val: 507 |Bin:60 Val: 370 |Bin:61 Val: 829 |Bin:62 Val:1790 |Bin:63 Val:   0 |   
    Total Num of Probe: 47
    Average Num of Probe: 1.175000

## Making collision analysis

四次测试的平均插入数分别是：1.450000，1.375000，1.800000，1.175000。可见平均插入数主要分布在1-2之间，如果随机数数组生成的好，平均插入数则会相对较小。
随后，综合总共10次测试，我们得到这是十次测试的平均插入数为：1.4625，大致反映了此Double Hashing的插入效率，基本上满足O(1)的插入效率。


