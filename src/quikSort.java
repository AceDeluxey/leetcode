public class quikSort {
    public  void quikSortImplementation(int [] arr, int startIndex, int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int index = partSort(startIndex,endIndex,arr);
        quikSortImplementation(arr,startIndex,index-1);
        quikSortImplementation(arr,index+1,endIndex);
    }

    public int partSort(int startIndex, int endIndex, int [] arr)
    {
        int left = startIndex,right = endIndex;
        int num = arr[left];
        while(right>left){

            while(right>left){
                if(arr[right]>=num){
                    right--;
                } else{
                    arr[left++] = arr[right];
                    break;
                }
            }



            while(right>left){
                if(arr[left]<=num){
                    left++;
                } else{
                    arr[right--] = arr[left];
                    break;
                }
            }
        }
        arr[left]=num;
        return left;
    }
}
