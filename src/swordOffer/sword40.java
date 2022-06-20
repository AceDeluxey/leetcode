package swordOffer;
import java.util.Arrays;
public class sword40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int []a=new int[2];
        return a;
    }
    public void mergeSort(int []arr,int left,int right){
        if(left >= right){  //一个元素即有序
            return;
        }
        int mid=(left + right)/2;
        mergeSort(arr,  left, mid);
        mergeSort(arr,  mid+1, right);

        int []arr1=new int[mid-left];
        int []arr2=new int[right-mid+1];
        for( int j=0,k=left;j<mid-left;j++,k++){
            arr1[j]=arr[k];
        }
        for( int j=0,k=mid;j<right;j++,k++){
            arr2[j]=arr[k];
        }
        int i;
        int index1;
        int index2;
        for(i=0,index1=0,index2=0;index1<arr1.length && index2<arr2.length;i++ ){
            arr[i]=arr1[index1] < arr2[index2]?arr1[index1++]:arr2[index2++];
        }
        for(;index1<arr1.length;index1++){
            arr[i++]=arr1[index1++];
        }
        for(;index2<arr2.length;index2++){
            arr[i++]=arr2[index2++];
        }
    }

}
