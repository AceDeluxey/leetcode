
/*
    1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
    思路：主要就是 if((float)(sum+candiesCount[query[0]])/(query[1]+1)>=1 && (float)sum/query[1]<=query[2] )
           我的思路就是吃完前query[0]堆，每天平均颗数要小于query2
         但是调试麻烦，用例数量太多了看不出哪个错
        没做出来
 */
public class class1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean [] bool = new boolean [queries.length];
        for( int i=0 ; i<queries.length; i++){
            bool[i] = ifCanEar(candiesCount, queries[i]);
        }
        return bool;
    }
    private boolean ifCanEar(int[] candiesCount, int[] query){
        int sum=0;
        for ( int i=0;i<query[0];i++){
            sum+=candiesCount[i];
        }
        //如果要吃到第0堆，那么每天吃1颗可以即为true，否则吃不到
        if(query[0]==0){
            if(query[1]<=candiesCount[0]){
                return true;
            } else{
                return false;
            }
        } else if (query[1]==0){
            if(query[2]>=sum+candiesCount[query[0]] ){
                return true;
            }
        } else if((float)(sum+candiesCount[query[0]])/(query[1]+1)>=1 && (float)sum/query[1]<=query[2] ){
            return  true;
        }
        return false;
    }
}

//        [true,true,true,true,true,true,true,true,false,false, true,true,false,false,false,true,true,false,false,false, false,false,false,false,false,true,false,false,false,false,  true,true,false,true,true,false,false,false,true,false,false,false,false,false,true,true,true,false,false,false,false,true,false,false,true,false,true,true,false,true,false,false,true,true,true,true,true,false,false,false,true,true,false,false,true,false,true]
//        [true,true,true,true,true,true,true,true,false,false, true,true,false,false,false,true,true,false,false,false, false,false,false,false,false,true,false,false,false,false,  false,true,false,true,true,false,false,false,true,false,false,false,false,false,true,true,true,false,false,false,false,true,false,false,true,false,true,true,false,true,false,false,true,true,true,true,true,false,false,false,true,true,false,false,true,false,true]