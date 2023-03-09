/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * 一次遍历，算滑动窗口
 * 1ms 58%
 */
public class class2379 {
    public int minimumRecolors(String blocks, int k) {
        int blackNum = 0 ;
        for  ( int i =0 ;i<k;i++){
            if(blocks.charAt(i)=='B'){
                blackNum++;
            }
        }
        int left = 0 ;
        int res =Integer.MAX_VALUE;
        while(true){
            int temp = k-blackNum;
            if(temp==0){
                return 0;
            } else {
                res = Math.min(res,temp);
            }
            if(blocks.charAt(left)=='B'){
                blackNum--;
            }
            left++;
            if(left+k-1<blocks.length()){
                if(blocks.charAt(left+k-1)=='B'){
                    blackNum++;
                }
            }else{
                break;
            }
        }
        return res;
    }
}
