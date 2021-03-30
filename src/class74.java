/**
 * 74. 搜索二维矩阵
 * 思路：先查找在哪行，再用二分法找在不在行里
 * 空间100%,时间21%
 */

public class class74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_len= matrix.length;
        int col_len= matrix[0].length;
        int i;
        if(target<matrix[0][0]||target>matrix[row_len-1][col_len-1]){
            return false;
        }
            for(i=0;i<row_len; i++){
                if(target<=matrix[i][col_len-1]){
                    break;
                }
            }


        int index= (int) Math.floor((col_len-1)/2);
        int left=0,right=col_len-1;
        if(matrix[i][left]==target || matrix[i][right]==target){  //一个元素的特例
            return true;
        }
        while(index!=left && index!=right){ //二分法
            if(matrix[i][index]==target){
                return true;
            } else if(matrix[i][index]>target){
                right=index;
            } else{
                left=index;
            }
            index=(int) Math.floor((right+left)/2);
        }
        return false;
    }
}
