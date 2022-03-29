/**
 * 2024. 考试的最大困扰度
 * 滑动窗口
 * 在窗口内连上K的最大链需
 * 19ms 16.&
 */
public class class2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(this.maxCon(answerKey,k,'T'),this.maxCon(answerKey,k,'F'));
    }
    private int maxCon(String s , int k, char c){
        int res =0;
        for( int left=0,right = 0, used =0  ; right < s.length(); right++){
            if(s.charAt(right)!=c){
                if(used<k){
                    used++;
                } else{
                    //找到左边第一个替换过的地方
                    while (left < right && s.charAt(left)==c){
                        left++;
                    }
                    left++;
                }
            }
           res=Math.max(res, right-left+1);

        }
        return res;
    }
}
