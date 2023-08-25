/**
 * 74. 搜索二维矩阵
 * 思路：先查找在哪行，再用二分法找在不在行里
 * 空间100%,时间21%
 * <p>
 * ps:二分法写的有点问题
 */

public class class74 {
    /**
     * 74. 搜索二维矩阵
     * 上一次做是两年前了相当于2021 3月
     * 这次做是2023年 2月
     * 这次终于算是搞懂了这个二分法
     * 就是判断mid时用2 和 3比划一下 循环能不能继续就可以了
     *
     * 第一个找行号的二分要用左开右闭，分析在底下
     * 第二个都可以 我用的左闭右闭
     * 0ms 100%
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int colLen = matrix[0].length;

        //判断是不是在外面
        if(target<matrix[0][0] || target>matrix[len-1][colLen-1]){
            return false;
        }
        //为什么是左开右闭呢，这要从left =mid说起，因为mid<target的时候，可能还是在mid这一行，所以要left=mid
        /**
         * 那么这样带来的结果就是变成左开右闭，
         * 左开右闭 这个mid写法就要+1，不然遇到2 3 这种 2+3/2还是2，但是left=mid
         * 这时就会一直循环出不来，所以左开右闭我认为就要+1，
         * 而反过来左闭右开就不用 ，因为 2+3/2是2，但是left会mid+1,还能继续运行下去
         * 还有一点就是mid+1的话，left边界上mid算出来是0，可以正常运行
         */
        int left = -1, right = len-1;
        while(left<right){
            int mid = left +(right-left+1)/2;
            if(matrix[mid][0]==target){
                return  true;
            } else if(matrix[mid][0]>target){
                //>target 肯定不在这一行了
                right = mid -1;
            } else {
                //但是 <target 可能还是在这行
                left = mid;
            }
        }
        /**
         * left =right，所以哪个都一样
         */
        int row = left;
        //第二次二分查找
        left =0;
        right =colLen-1;
        /**
         * 左闭右闭，
         * 没找到就是False
         */
        while(left<=right){
            int mid =left +(right-left)/2;
            if(matrix[row][mid]==target){
                return  true;
            } else if(matrix[row][mid]>target){
                right = mid -1;
            } else {
                left = mid+1;
            }
        }
        return  false;
    }
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row_len= matrix.length;
//        int col_len= matrix[0].length;
//        int i;
//        if(target<matrix[0][0]||target>matrix[row_len-1][col_len-1]){
//            return false;
//        }
//            for(i=0;i<row_len; i++){
//                if(target<=matrix[i][col_len-1]){
//                    break;
//                }
//            }
//
//
//        int index= (int) Math.floor((col_len-1)/2);
//        int left=0,right=col_len-1;
//        if(matrix[i][left]==target || matrix[i][right]==target){  //一个元素的特例
//            return true;
//        }
//        while(index!=left && index!=right){ //二分法
//            if(matrix[i][index]==target){
//                return true;
//            } else if(matrix[i][index]>target){
//                right=index;
//            } else{
//                left=index;
//            }
//            index=(int) Math.floor((right+left)/2);
//        }
//        return false;
//    }
}
//class74 test= new class74();
//        int [][]a= {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
//        System.out.println(test.searchMatrix(a,13));