
/*
        551. 学生出勤记录 I
        给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： ALP
        如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
        你需要根据这个学生的出勤记录判断他是否会被奖赏。

        思路：统计连续出现次数，很简单

        0ms 100%
 */
public class class551 {
    public boolean checkRecord(String s) {
        int len = s.length();
        int numL=0;
        int numA=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='A'){
                numA++;
            }
            if(s.charAt(i)=='L'){
                numL++;
            } else{
                numL=0;
            }
            if(numL>2 || numA>1){
                return false;
            }
        }
        return true;
    }
}
