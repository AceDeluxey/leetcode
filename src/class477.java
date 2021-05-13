
/*
    477. 汉明距离总和
    两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
    计算一个数组中，任意两个数之间汉明距离的总和。

    思路：先两两与或，与或完的数字中的1的个数就是位不同的数量
        求1的个数，与0001,0010,0100,1000想与，看每一位是不是1，统计数量

    但是超时了
 */
public class class477 {
    public int totalHammingDistance(int[] nums) {
        int len=nums.length;
        int num=CN2(len);  //组合数，n个里面取两个

        int max=0; //求数组最大值，计算相与的最大值
        int []xor= new int [num];
        for(int i=0,index=0;i<len;i++){
            for(int j=i+1; j<len; j++){   //  求两两相与或的结果
                int temp=nums[i]^nums[j];
                if(temp>max){
                    max=temp;
                }
                xor[index++]=temp;
            }
        }
        int result=0;
        for(int n=0;max>=n;){
            int temp= (int) Math.pow(2,n++);
            for(int i=0;i<num;i++){
                if((xor[i]&temp)==temp){
                    result++;
                }
            }
        }
        return result;

    }
    private int  CN2(int n){
        return (n-1)*n/2;
    }
}
