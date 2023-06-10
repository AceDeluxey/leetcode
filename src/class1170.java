import java.util.Arrays;

/**
 * 1170. 比较字符串最小字母出现频次
 *
 * 模拟加二分查找
 *
 * 执行用时：
 * 24 ms
 * , 在所有 Java 提交中击败了
 * 15.00%
 * 的用户
 * 内存消耗：
 * 42.8 MB
 * , 在所有 Java 提交中击败了
 * 20.00%
 * 的用户
 */
public class class1170 {
    public static void main(String[] args) {
        class1170 test = new class1170();
        String[] queries = {"cbd"};
        String[] words = {"zaaaz"};
        test.numSmallerByFrequency(queries,words);
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int nums [] = new int[words.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = calMinLen(words[i]);
        }
        Arrays.sort(nums);
        int res [] = new int [queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = words.length - find(calMinLen(queries[i]),nums);
        }
        return res;
    }
    private int find(int target,int []nums){
        /**
         * 找到第一个大于target的位置
         */
        int left = 0 , right = nums.length-1;
        while(left<=right){
            int mid =  left+(right-left)/2;
            if(nums[mid]<=target){
                left++;
            } else{
                right--;
            }
        }
        return left;
    }
    private int calMinLen(String s ){
        int index =27;
        int res =0;
        for(int i=0 ; i<s.length();i++){
            int temp = s.charAt(i)-'a';
            if(temp<index){
                index = temp;
                res =0 ;
            }
            if(temp == index){
                res++;
            }

        }
        return res;
    }
}
