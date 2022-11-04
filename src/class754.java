/**
 * 754. 到达终点数字
 * 脑筋急转弯 没做说出来
 */
public class class754 {
    int res = Integer.MAX_VALUE ;
    Boolean isFind = false;
    public int reachNumber(int target) {
        if(target<0){
            target = target*-1;
        }


        DFS(target,0,0,1);
        return res;

    }
    private void DFS(int target,int index , int temp,int step){
        if(isFind){
            return ;
        }
        if(index== target){
            res = Math.min(res,temp);
            isFind = true;
            return;
        } else if(index>target){
            return ;
        } else{
            if(index+step<= target){
                DFS(target,index+step,temp+1,step+1);
            }
            DFS(target,index-step,temp+1,step+1);
        }
    }
}
