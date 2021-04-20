/*
    28.实现strStr()函数。

    给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1

     思路：就暴力破解
     5ms 22.82%;

 */
public class class28 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 ){  //长度都为0的接口
            if(needle.length() == 0){
                return 0;
            }else{
                return -1;
            }
        }


        for(int i=0;i<=haystack.length()-needle.length();i++){  //暴力破解
            int flag=1;
            int temp=i;
            for(int j=0;j<needle.length(); j++){
                if(haystack.charAt(temp++)!=needle.charAt(j)){
                    flag=0;
                }
            }
            if(flag==1){
                return i;
            }
        }

        return -1;
    }
}
