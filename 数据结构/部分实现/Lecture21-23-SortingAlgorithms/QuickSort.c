#include<stdio.h>
int getMid(int* a, int l, int r){
    int mid;
    if(a[r] > a[(l+r)/2] && a[r] < a[l] || a[r] < a[(l+r)/2] && a[r] > a[l]){
        mid = a[r];
        a[r] = a[l];
        a[l] = mid;
    }
    else if(a[(l+r)/2] > a[l] && a[(l+r)/2] < a[r] || a[(l+r)/2] < a[l] && a[(l+r)/2] > a[r]){
        mid = a[(l+r)/2];
        a[(l+r)/2] = a[l];
        a[l] = mid;
    }
    else{
        mid = a[l];
    }
    return mid;
}
void QuickSort(int* a,int head,int end)
{
    if(end - head <= 2){
        for(int i = head; i <= end; i++){
            for(int j = head; j < i; j++){
                if(a[j] > a[i]){
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
    }
	else
	{
		int left = head,right = end;
		int key = getMid(a,left,right);

		while(left < right)
		{
			while(left < right && key <= a[right])
			{
				right--;
			}
			a[left] = a[right];

			while(left < right && key > a[left])
			{
				left++;
			}
			a[right] = a[left];
		}
		a[right] = key;
		QuickSort(a, head, right-1);
		QuickSort(a, right+1, end);
	}
}
int main()
{
	int arr[20] = {27,9,12,26,13,55,33,40,5,7,14,22,20,27,56,34,41,6,8,15};
    QuickSort(arr,0,19);
    for(int i = 0; i < 20; i++){
        printf("%d ",arr[i]);
    }
	
	return 0;
}
