/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 模拟 100%
 */
public class class1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if( s1.equals(s2)){
            return true;
        }
        if(s1.length()!=s2.length() ){
            return false;
        }
        int index1=-1,index2=-1;
        for( int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(index1==-1){
                    index1=i;
                } else{
                    if (index2==-1){
                        index2=i;
                    } else{
                        return  false;
                    }
                }
            }
        }
        if(index1==-1 || index2==-1){
            return false;
        }
        if(s1.charAt(index1)==s2.charAt(index2) && s1.charAt(index2)==s2.charAt(index1)){
            return true;
        } else{
            return false;
        }
    }
}
