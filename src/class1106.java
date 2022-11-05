import java.util.ArrayList;
import java.util.List;

/**
 * 1106. 解析布尔表达式
 * 这题其实难度不在于题目本身，因为其实就是用递归函数，先判断第一个符号，再分解符号的变量就可以了
 * 难就难再分解符号后面的变量  比如|(f,&(t,t)) 要用split逗号其实是分不开的，
 * 所以要循环判断，逗号分开的情况主要是括号要闭合完全，否则不能分开 然后特殊情况有好几种 要想一想
 * 难度其实就是在这个分开变量
 * 2ms 85%
 */
public class class1106 {
    public static void main(String[] args) {
        class1106 test = new class1106();
        test.parseBoolExpr("|(f,&(t,t))");
    }
    public boolean parseBoolExpr(String expression) {
        return calBoolean(expression);
    }

    private boolean calBoolean(String s) {
        if (s.charAt(0) == 't') {
            return true;
        } else if (s.charAt(0) == 'f') {
            return false;
        }
        String temp = s.substring(2, s.length() - 1);
        if (s.charAt(0) == '!') {
            return !calBoolean(temp);
        } else if (s.charAt(0) == '|') {
            String[] szs = mySplit( temp );
            boolean res = false;
            for(String sz:szs){
                res = res||calBoolean(sz);
            }
            return res;
        } else {
            String[] szs = mySplit( temp );
            boolean res = true;
            for(String sz:szs){
                res = res&&calBoolean(sz);
            }
            return res;
        }

    }

    private String[] mySplit(String s ){
        int num =0 ;
        List<String> res = new ArrayList<>();

        while(s.contains(",")){
            int i =0;
            //还有逗号就要继续找
            while(i<s.length()){
                char c = s.charAt(i);
                if(c=='(' || c=='{'){
                    num ++;
                } else if(c==')' || s.charAt(i)=='}'){
                    num--;
                } else if(c==','){
                    if(num==0){
                        res.add(s.substring(0,i));
                        s = s.substring(i+1);
                        break;
                    }
                }
                i++;
            }
            if(i==s.length()){
                break;
            }

        }
        res.add(s);
        String [] res2 = new String[res.size()];
        for (int i =0 ;i <res2.length;i++){
            res2[i] = res.get(i);
        }
        return  res2;
    }


}
