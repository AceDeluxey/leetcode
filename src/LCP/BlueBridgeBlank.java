package LCP;
    /*
       蓝桥杯填空题
       哈密顿图，给定N个点1-N,对于其中任意两个点，如果标号互质，那么有通路
       求从1号点走一圈回到1点，每个点走一次的走法

        思路:DFS+回溯
     */
public class BlueBridgeBlank {
    int cnt=0;
    int []visited;
    public  int Hamilton(int N) {
        int [][]NV=new int [N][N];
        visited = new int[N];
        for( int i=0;i<N;i++){   //生成质点的n-v表
            for(int j=0;j<N ;j++){
                if(isComprime(i+1,j+1)){
                    NV[i][j]=1;
                }
            }
        }
        DFS(NV,1);
        return cnt;
    }
    public void DFS(int[][]NV ,int node){
        if(node==1 ){
            //1号既是起点又是终点。如果遍历到1，判断visit函数，如果全1说明找到了一条哈密顿图
            //如果有0，且1已经走过，说明没找到，返回
            //如果有0，且第一个没遍历过，说明刚出发
            if(haszero(visited) ){
                if(visited[0]==1){
                    return;
                }
            } else{
                cnt++;
            }
        }
        if(visited[node-1]==0){  //visit置零，因为判断过1了，所以其他点都不能再走第二次
        } else{
            return;
        }

        for(int i=0;i<NV.length;i++){ //走到每个点，遍历它那一行的通路
            if(NV[node-1][i]==1){
                DFS(NV ,i+1);
            }
        }
        visited[node-1]=0;  //遍历完这个点以后回退，visit状态置为0
    }
    public boolean haszero(int []num){   //判断visit数组是否全零
        for(int i=0;i<num.length; i++){
            if(num[i]==0){
                return true;
            }
        }
        return false;
    }
    public boolean isComprime(int m,int n){  //辗转相除判断两数是否互质
        if(m<n){
            int temp=n;
            n=m;
            m=temp;
        }
        while(m%n!=0){
            int temp=n;
            n=m%n;
            m=temp;
        }
        if(n==1){
            return true;
        } else{
            return false;
        }
    }
}
