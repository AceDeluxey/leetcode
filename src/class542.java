import java.util.LinkedList;
import java.util.Queue;

/**
 *      542. 01 矩阵
 *      给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *      两个相邻元素间的距离为 1
 *
 *      思路：多源BFS，先遍历找到所有0加入队列，1改为-1，说明还没遍历过。
 *          然后就是说明为什么只用遍历一次，就是最小值。因为每次遍历完一圈，都是和0距离相同的点。第一次是和0距离1的，第二次是距离2的。
 *              队列保证，如果这一圈没遍历到，说明距离只可能比这次的距离大。所以一圈一圈遍历最后一定是最小值。
 *
 *       19ms 21.9%
 */
public class class542 {
    public int[][] updateMatrix(int[][] mat) {
        int dir [][] ={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int []>que = new LinkedList<>();
        for( int i=0;i<mat.length; i++ ){
            for( int j=0;j<mat[0].length; j++){
                if(mat[i][j]==0){
                    int [] temp = new int [2];
                    temp[0]=i;
                    temp[1]=j;
                    que.offer(temp);
                } else{
                    mat[i][j]=-1;
                }
            }
        }
        while (!que.isEmpty()){
            int []temp=que.poll();
            for(int i=0;i<4;i++){
                int newX=temp[0]+dir[i][0];
                int newY=temp[1]+dir[i][1];
                if(newX>=0 && newX<mat.length && newY>=0 && newY<mat[0].length
                && mat[newX][newY]==-1){
                    mat[newX][newY]=mat[temp[0]][temp[1]]+1;
                    que.offer(new int[] {newX, newY});
                }
            }
        }
        return  mat;
    }
}
