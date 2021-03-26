//3. 无重复字符的最长子串
/***
 * 2021.3.26：就有点懒得想更好的解法
 * 先这样吧，就是O(N2)的循环把数组放入hashset判断
 * 时间13%，空间18%效果还挺差的
 * 可以用滑动窗口解
 */


import java.util.HashSet;
public class class3 {
    public int lengthOfLongestSubstring(String s) {
        int cnt=0;
        int num=0;
        for(int i=0;i<s.length(); i++){
            HashSet set =  new HashSet();
            for(int j=i;j < s.length(); j++){
                if(!set.add(s.charAt(j))){
                    if(cnt>num){
                        num=cnt;
                    }
                    cnt=0;
                    break;
                } else{
                    cnt++;
                }
            }

            if(cnt==s.length()-i){
                if(cnt>num){
                    num=cnt;
                }
            }
            cnt=0;
        }

        return num;
    }
}
