import java.util.LinkedList;
import java.util.Queue;

/*
    994. 腐烂的橘子
    在给定的网格中，每个单元格可以有以下三个值之一：
    值0代表空单元格；
    值1代表新鲜橘子；
    值2代表腐烂的橘子。
    每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

    思路：和1765相似，都是多源BFS
        最开始想的是可以不用多余的二维数组就饿可以算出来，但是遍历到1时判断不出它是在腐败的旁边已经遍历过，还是本来就是好的
           用visit数组也不太行，因为直接在grid上改的话，1的周围遍历成2，再遍历到2又被当作原来就腐败的橘子
         所以还是就用空的棋盘记录
         另外，遍历完还不够，有可能有的橘子是碰不到的，没有visit数组没有办法判断有没有剩余，所以要用cnt计数，num记录非0数

         3-4ms ; 81% 45%
 */
public class class994 {
    int[][] direct={{0,1},{1,0},{-1,0},{0,-1}};  //四个方向
    public int orangesRotting(int[][] grid) {
        int  max=0;
        int cnt=0;  //遍历时数的橘子数
        int nums=grid.length* grid[0].length;  //棋盘上的橘子数
        int [][] time=new int[grid.length][grid[0].length];
        Queue<int []> q= new LinkedList<>();
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[i].length; j++){
                if(grid[i][j] == 2) {
                    cnt++;    //遍历的源头计入
                    time[i][j] = -1;   //遍历过置为-1,放置后续重复遍历
                    int[] temp = {i, j};
                    q.add(temp);
                }else if(grid[i][j] == 0){
                    nums--;   //棋盘上的橘子数要减去0的位置
                }
            }
        }

        while(!q.isEmpty()){
            int []index=q.poll();
            for(int i=0;i<4;i++){
                int x=index[0]+direct[i][0];
                int y=index[1]+direct[i][1];
                if(x>=0 && y>=0 && x< grid.length && y< grid[0].length && grid[x][y] !=0 && time[x][y] ==0){
                    cnt++;
                    if(grid[index[0]][index[1]]==2){
                        time[x][y]=1;
                    } else{
                        time[x][y]=time[index[0]][index[1]]+1;

                    }
                    if(time[x][y]>max){
                        max=time[x][y];
                    }
                    int []temp={x,y};
                    q.add(temp);
                    if(cnt>= nums){  //数量够了直接返回
                        return  max;
                    }
                }


            }

        }
        return cnt<nums?-1:max;
    }
}
