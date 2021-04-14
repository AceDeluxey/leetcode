/*/
        490. 迷宫
        由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
        给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。
        迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。

        思路：第一次写两个函数的嵌套递归循环
            走迷宫问题大体上都是DFS+回溯，但是之前做的都是一次走一格，所以只用写一个DFS，递归调用自己，坐标传参+1，-1即可
            但这次球只能一次滑倒底，所以要单独写滑动的函数，用DFS调用滑动函数；滑动完以后，再在滑动的终点调用DFS
            想起来看似容易，但是写起来并不容易
            首先第一个问题是start数组的传参问题，java的数组传参是类似引用传参的效果。所以传入goLeft等函数后，start数组的值就改变了。
                比如在某个点本来是要依次尝试调用left、up、down、right。 但如果直接传数组的话，调用left后，再调用up，传入up的就不是这个点坐标而是左移过的坐标
                所以我们在dfs中调用滑动函数时，只传start坐标的两个Int值，这样就不会改变原来的数组
            第二个问题是怎么防止球滑回去
                在DFS中，开始滑之前，将起点标记为2，当下次再滑动到2的地方时，说明有冗余了，不能将这个点再作为起点，返回false；
                false的情况为走到2和不能再走。这两种情况都无法走到destination，所以为false
 */

public class class490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return searched(maze, start,destination);
    }
    public boolean searched(int[][] maze,int[] start, int[] destination){
        if(start[0]== destination[0] && start[1] == destination[1]){    //找到终点
            return true;
        }
        maze[start[0]][start[1]]=2;              //标记已经走过的起点
        boolean b1=goLeft(maze,start[0],start[1] ,destination);
        boolean b2=goUp(maze,start[0],start[1], destination);
        boolean b3=goDown(maze,start[0],start[1], destination);
        boolean b4=goRight(maze,start[0],start[1], destination);
        return b1 ||b2||b3||b4;
//        return goLeft(maze,start, destination) || goUp(maze,start, destination) || goDown(maze,start, destination) || goRight(maze,start, destination);


    }
    private boolean goLeft(int[][] maze,int start0,int start1, int[] destination){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;  //flag=0表示这个方向不可移动，不能移动自然返回false
        while(start[1]>0  && maze[start[0]][start[1]-1]!=1){
            flag=1;
            start[1]--;
        }
        if(maze[start[0]][start[1]]==2){  //移动完发现终点是之前的起点，为了不陷入死循环，返回false，不再继续走
            flag=0;
        }
        return flag==1?searched(maze, start,destination):false;
    }
    private boolean goUp(int[][] maze,int start0,int start1, int[] destination){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[0]>0  && maze[start[0]-1][start[1]]!=1){
            flag=1;
            start[0]--;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination):false;
    }
    private boolean goDown(int[][] maze,int start0,int start1, int[] destination){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[0]<maze.length-1 && maze[start[0]+1][start[1] ]!=1){
            flag=1;
            start[0]++;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination):false;
    }
    private boolean goRight(int[][] maze,int start0,int start1, int[] destination){
        int [] start=new int[2];
        start[0]=start0;
        start[1]=start1;
        int flag=0;
        while(start[1]<maze[0].length-1 && maze[start[0]][start[1]+1]!=1){
            flag=1;
            start[1]++;
        }
        if(maze[start[0]][start[1]]==2){
            flag=0;
        }
        return flag==1?searched(maze, start,destination):false;
    }
}
