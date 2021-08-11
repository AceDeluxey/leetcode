/**
     * 1871. 跳跃游戏 VII
        思路:测试用例太长了，DFS会超时
         改用滑动窗口。本质上是将第二重循环，也就是寻找位置i的元素是否可达的那重循环，改为用前缀和保存，只要窗口内的和大于1，就代表可达，这样就省略了一重循环

        10ms 91%
 */

public class class1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)=='1'){
            return false;
        }
        boolean dp[] = new boolean[s.length()];
        dp[0]=true;
        //pre数组就是从0到i中dp为true的个数
        int pre[] = new int[s.length()];

        //先初始化0到minJump,因为只有i=0时候可达，所以pre为1
        for (int i = 0; i < minJump; i++) {
            pre[i]=1;
        }
        for (int i = minJump; i < s.length(); i++) {
            int left= i-maxJump, right = i-minJump;
            if(s.charAt(i)=='0'){
                //计算窗口内的可达个数
                /*
                    要减去pre[left-1]；如果减pre[left]，如果Left处可达，就被减去了
                    left<1时，pre[left-1]恒为0
                    相差大于0说明可以达到
                 */
                if(pre[right]-(left<1?0:pre[left-1])>0){
                    dp[i]=true;
                }
            }
            //加上dp[i]对应的是不是true
            pre[i]=pre[i-1]+(dp[i]?1:0);
        }
        return dp[s.length()-1];
    }

    /*
        DFS
     */
//    boolean visited[];
//    boolean result;
//    public boolean canReach(String s, int minJump, int maxJump) {
//
//        if(s.charAt(s.length()-1)=='1'){
//            return false;
//        }
//
//        visited = new boolean[s.length()];
//
//        DFS(s,minJump,maxJump,0);
//
//        return  result;
//    }
//    private void DFS(String s, int minJump, int maxJump, int index){
//        if(result){
//            return;
//        }
//
//        visited[index] = true;
//        if(index == s.length()-1){
//            result = true;
//            return;
//        }
//
//        for( int i = Math.min(index+maxJump, s.length()-1); i>=index+minJump; i--){
//            if (s.charAt(i)=='0'){
//                if(!visited[i]){
//                    DFS(s,minJump,maxJump,i);
//                }
//            }
//        }
//    }
}
