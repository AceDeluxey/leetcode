import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class classtest {
    public static void main(String[] args) {
        classtest test = new classtest();
        String a = "a";
        List<String> res = test.returnLongest(a);
        for(int i =0 ; i < res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public List<String> returnLongest(String s ){
        List<String> res = new ArrayList<>();
        Map<Integer,List<String>> map = new HashMap<>();
        int maxLen =0 ;
        int index =0 ;
        int len = s.length();
        while(index<len){
            int start = index;
            while(index<len-1 && s.charAt(index+1)==s.charAt(index)){
                index++;
            }
            String sub = s.substring(start,index+1);
            maxLen = Math.max(sub.length(),maxLen);
            if(sub.length()>=maxLen){
                if(map.containsKey(maxLen)){
                    List<String> temp = map.get(maxLen);
                    temp.add(sub);
                    map.put(maxLen,temp);
                } else{
                    List<String> temp = new ArrayList<>();
                    temp.add(sub);
                    map.put(maxLen,temp);
                }

            }
            index++;
        }
        return map.get(maxLen);
    }
}
