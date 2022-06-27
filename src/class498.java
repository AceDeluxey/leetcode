/**]
 * 498. 对角线遍历
 * 用flag标注向上还是向下 ， 不过边界条件很烦 还是写的比较冗余 不太好
 * 2ms 67%
 */
public class class498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int [] res  = new int[mat.length* mat[0].length];
        //标注遍历方向
        int flag =0,index=0;
        int row=0,col=0;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        while(row <rowLen && col<colLen){
            //从下到上
            if(flag%2==0){
                res[index++]=mat[row][col];
                while(row!=0 && col!=colLen-1){
                    row -=1;
                    col+=1;
                    res[index++]=mat[row][col];
                }
                if(row==0 && col!=colLen-1){
                    col +=1;
                } else{
                    row +=1;
                }

                flag++;
            }
            //从上倒下
            else{
                res[index++]=mat[row][col];
                while(col!=0 && row!=rowLen-1){
                    row +=1;
                    col-=1;
                    res[index++]=mat[row][col];
                }
                if(col ==0 && row!=rowLen-1 ){
                    row +=1;
                } else{
                    col +=1;
                }

                flag++;
            }

        }
        return res;
    }
}
