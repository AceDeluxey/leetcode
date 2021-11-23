/**
 859. 亲密字符串
    基本上思路都写在注释里了，为了保证On创了个数组，讨论了一些特殊情况
    3ms 40%
 */
public class class859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        //记录每个字母出现的次数, 判断有没有两个一样的原地换的可能
        boolean flag = false;
        int [] a =  new int[26];
        //标记两个交换位置
        int index1= -1 , index2 = -1 ;
        for( int i  =0;i<s.length();i++){
            if(s.charAt(i) != goal.charAt(i)){
                if( index1 == -1){
                    index1 = i;
                } else if ( index2 == -1){
                    index2 = i;
                } else{
                    return false;
                }
            }
            if(!flag){
                //有一个字母出现了多次
                if(++a[s.charAt(i)-'a']>1){
                    flag = true;
                }
            }
        }
        if ( index1 == index2 ){
            //两字符串相等，且有一字符串可以同类交换则true
            if(flag){
                return  true;
            } else{
                return  false;
            }
        } else if(index1*index2>=0){
            if(s.charAt(index1)==goal.charAt(index2) && s.charAt(index2)==goal.charAt(index1)){
                return  true;
            }
        }
        return false;
    }
}
