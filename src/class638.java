import java.util.ArrayList;
import java.util.List;

/**
    638. 大礼包

    买东西都可以DFS，在每次dfs里遍历所有买的东西
    直接暴力，有很多状态重复，可以压缩

    16ms 21%
 */
public class class638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return DFS(price,special,needs);
    }
    private int  DFS(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
            int ans =0 ;

            //每次函数里算剩下的直接买，可能更小
            for( int i=0 ;i<price.size();i++){
                ans += needs.get(i)*price.get(i);
            }

            for(List<Integer> list : special){
                //本来是要状态回溯，每次拷贝一个新的
                List<Integer> currNeeds = new ArrayList<>(needs);
                //true表示可以买这个礼包
                boolean flag = true;
                for(int i=0; i<price.size(); i++){
                    if(currNeeds.get(i)<list.get(i)){
                        //超过不能买
                        flag = false;
                        break;
                    } else{
                        currNeeds.set(i,currNeeds.get(i)-list.get(i));
                    }
                }
                if(flag){
                    //买这个礼包
                    ans = Math.min(ans,list.get(list.size() - 1)+DFS(price, special, currNeeds));
                }
            }
            return ans;
    }
}
