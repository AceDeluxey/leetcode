    /*/
        1765. 地图中的最高点
        思路 : DFS不行，因为DFS先按一条路到底了，到底的时候可能周围的状态还没确定
        所以重新用BFS写
        关于为什么一定要重新创建一个数组，因为要防止重复访问，不论是visit也好，还是Height也好都是为了防止重复
        BFS最显著的特征就是用队列，所有水域先入队，先遍历水域，再依次是每个水域周围的陆地

        79ms 36%;
     */


    import java.util.LinkedList;
    import java.util.Queue;
    public class class1765 {

        //图中遍历四个方向还可以这样，以前都没想到过，值得学习
    int [][] directions={{0,-1},{0,1},{1,0},{-1,0}};

    public int[][] highestPeak(int[][] isWater) {
        Queue<int []> que =  new LinkedList<>();
        int[][] height = new int[isWater.length][isWater[0].length];
        for(int i=0;i <isWater.length; i++){
            for( int j=0;j<isWater[i].length; j++){   //遍历寻找水域，将水域点加入队列
                if(isWater[i][j] ==1){
                    int temp[]={i, j};
                    que.add(temp);
                } else{
                    height[i][j]=-1;   //height=-1,其实就是为了标识还没遍历过，防止重复
                }
            }
        }
        //BFS
        while(!que.isEmpty()){
            int []temp=que.poll();
            for(int k=0;k<4;k++){
                int x=temp[0]+directions[k][0];
                int y=temp[1]+directions[k][1];
                //合法点，且未被遍历
                if(x>=0 && y>=0 && x<isWater.length  && y<isWater[0].length && height[x][y]==-1){
                    height[x][y]=height[temp[0]][temp[1]]+1;
                    int []t={x,y};
                    que.add(t);  //遍历过的点入队
                }
            }
        }
        return height;
    }
    //DFS:
//    public int[][] highestPeak(int[][] isWater) {
//        visited=new int [isWater.length][isWater[0].length];
//        DFS (isWater,0,0);
//        return isWater;
//    }
//    public void DFS(int[][] isWater,int row,int col){
//        if(isWater[row][col]==0 || visited[row][col]==1){
//            return;
//        }
//        visited[row][col]=1;
//
//        int up;
//        if(row-1>=0){
//            up=isWater[row-1][col];
//            DFS (isWater,row-1,col);
//        } else{
//            up=Integer.MAX_VALUE;
//        }
//
//        int down;
//        if(row+1< isWater.length){
//            down=isWater[row+1][col];
//            DFS (isWater,row+1,col);
//        } else{
//            down=Integer.MAX_VALUE;
//        }
//
//        int left;
//        if(col-1>=0){
//            left=isWater[row][col-1];
//            DFS (isWater,row,col-1);
//        } else{
//            left=Integer.MAX_VALUE;
//        }
//        int right;
//        if(col+1< isWater[0].length){
//            right=isWater[row][col+1];
//            DFS (isWater,row,col+1);
//        } else{
//            right=Integer.MAX_VALUE;
//        }
//        visited[row][col]=Math.min(up,down);
//        visited[row][col]=Math.min(visited[row][col],left);
//        visited[row][col]=Math.min(visited[row][col],right);
//    }
}
