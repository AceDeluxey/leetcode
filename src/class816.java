import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * 实际上就是模拟，整数就是注意第一位，小数就是注意第一位和最后一位是不是0就可以了
 * 不难
 * 7ms 84%
 */
public class class816 {
    public static void main(String[] args) {
        class816 test = new class816();
        String a = "(123)";
        test.ambiguousCoordinates(a);
        System.out.println(a);
    }
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length()-1);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length() ; i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            List<String> list1 = getAllPoss(s1);
            List<String> list2 = getAllPoss(s2);
            for (String temp : list1) {
                for (String temp2 : list2) {
                    res.add("(" + temp + ", " + temp2 + ")");
                }
            }
        }
        return res;
    }

    private List<String> getAllPoss(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(s);
            return res;
        }
        if (s.charAt(0) != '0') {
            res.add(s);
        }
//        //前缀和数0的数量
//        int [] numZero = new int[s.length()+1];
//        for( int i =1 ; i <=s.length();i++){
//            if(s.charAt(i)=='0'){
//                numZero[i]=numZero[i-1]+1;
//            } else{
//                numZero[i]=numZero[i-1];
//            }
//        }
        if (s.charAt(s.length() - 1) != '0') {
            if (s.charAt(0) == '0') {
                res.add("0." + s.substring(1, s.length()));
                return res;
            } else{
                for (int i = 0; i < s.length()-1; i++) {
                    res.add(s.substring(0,i+1)+'.'+s.substring(i+1));
                }
            }
        }

        return res;
    }

}



