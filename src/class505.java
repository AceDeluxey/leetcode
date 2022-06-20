//505. 迷宫 II
/*
    和490相似，但是DFS好像求不出最小路径不知道为啥
 */
public class class505 {
    int min=Integer.MAX_VALUE;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        searched(maze, start,destination,0);
        return min;
    }
    public boolean searched(int[][] maze,int[] start, int[] destination,int path){
        if(start[0]== destination[0] && start[1] == destination[1]){    //找到终点
            if(path<min){
                min=path;
            }
            return true;
        }
        maze[start[0]][start[1]]=2;              //标记已经走过的起点
        boolean b1=goLeft(maze,start[0],start[1] ,destination,path);
        boolean b2=goUp(maze,start[0],start[1], destination,path);
        boolean b3=goDown(maze,start[0],start[1], destination,path);
        boolean b4=goRight(maze,start[0],start[1], destination,path);
        return b1 ||b2||b3||b4;
//        return goLeft(maze,start, destination) || goUp(maze,start, destination) || goDown(maze,start, destination) || goRight(maze,start, destination);


    }
    private boolean goLeft(int[][] maze,int start0,int start1, int[] destination,int path){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;  //flag=0表示这个方向不可移动，不能移动自然返回false
        while(start[1]>0  && maze[start[0]][start[1]-1]!=1){
            flag=1;
            start[1]--;
            path++;
        }
        if(maze[start[0]][start[1]]==2){  //移动完发现终点是之前的起点，为了不陷入死循环，返回false，不再继续走
            flag=0;
        }
        return flag==1?searched(maze, start,destination,path):false;
    }
    private boolean goUp(int[][] maze,int start0,int start1, int[] destination,int path){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[0]>0  && maze[start[0]-1][start[1]]!=1){
            flag=1;
            start[0]--;
            path++;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination,path):false;
    }
    private boolean goDown(int[][] maze,int start0,int start1, int[] destination,int path){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[0]<maze.length-1 && maze[start[0]+1][start[1] ]!=1){
            flag=1;
            start[0]++;
            path++;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination,path):false;
    }
    private boolean goRight(int[][] maze,int start0,int start1, int[] destination,int path){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[1]<maze[0].length-1 && maze[start[0]][start[1]+1]!=1){
            flag=1;
            start[1]++;
            path++;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination,path):false;
    }
}
