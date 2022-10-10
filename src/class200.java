/**
 * 200. 岛屿数量
 * 用的并查集 寫的
 * 但是結果不對 太難調試了
 * 先鴿了
 * 因爲答案寫的并查集好像和我不太一樣
 * 找機會看看
 *
 */
public class class200 {
    public int numIslands(char[][] grid) {
        int[] set = new int[grid.length * grid[0].length];
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }


        int landsCount =0 ;
        int lessCount = 0;
        int res=0;
        int m=grid.length;
        int n =grid[0].length;
        int dirs [][]= {{-1,0},{0,-1}};
        for (int i=0;i< m;i++){
            for (int j=0;j< n;j++){
                if (grid[i][j]==0){
                    continue;
                } else{
                    landsCount++;
                }
                for(int [ ] dir:dirs){
                    int ni = i+dir[0];
                    int nj = j+dir[1];
                    if(ni>0 && nj>0){
                        if (grid[ni][nj]==1){
                            int indexA =findRoot(set,i*n+j);
                            int indexB =findRoot(set,ni*n+nj);
                            if(indexA!=indexB){
                                set[indexA] = indexB;
                                lessCount++;
                            }
                        }
                    }
                }
            }
        }
        return landsCount-lessCount;
    }
    private  int findRoot(int [] set, int i ){
        while(set[i]!=i){
            i = set[i];
        }
        return i;
    }

}
