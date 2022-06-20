public class class464 {
    boolean grid[];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal){
            return false;
        }
        grid = new boolean [maxChoosableInteger];

        return DFS(maxChoosableInteger,0,desiredTotal);
    }
    private  boolean DFS(int maxChoosableInteger , int nowTotal,int desiredTotal){
        int index = maxChoosableInteger-1;
        int temp =0  ;
        while(index>=0){
            if(!grid[index]){
                 temp = nowTotal+index+1;
                 break;
            }
        }
        if (temp>=desiredTotal){
            return true;
        }else{
            return false;
        }
    }
}
