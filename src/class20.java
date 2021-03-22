//20. 有效的括号
//缺点内存消耗大，优点是用时短
import java.util.HashMap;
public class class20 {
    public boolean isValid(String s) {
        //建立括号键值对,用map的get去判断括号是不是匹配上
        HashMap<String,String> map=new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        String [] stack= new String[s.length()+1];
        int base=0,top=0;
        for(int i=0;i<s.length();i++){
            stack[top++]=s.substring(i,i+1);
            if(top!=base+1){
                if(stack[top-1].equals(map.get(stack[top-2]))){
                    top = top -2;
                }
            }
        }

        return  top==base? true:false;
    }
}
//
//class20 test= new class20();
//        System.out.println(test.isValid("(]"));