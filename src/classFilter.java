import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//        Map<Integer, Integer> map = new HashMap<>();
//        for( int i =0 ;i<st.length();i++){
//            char temp =  st.charAt(i);
//            int key =temp-'a';
//            map.put(key,map.getOrDefault(key,0)+1);
//        }
//        StringBuilder sb = new StringBuilder();
//        for( int i =0 ;i<st.length();i++){
//            char temp =  st.charAt(i);
//            int key =temp-'a';
//            if(map.get(key)<3){
//                sb.append(st.charAt(i));
//            }
//        }
//        return sb.toString();
public class classFilter {
    public String get_substr (String st) {
        // write code here

        while(true){
            String s = new String(st);
            st = filter(st);
            if(st.equals(s)){
                return st;
            }
        }
    }
    private String filter(String s){
        int index =0 ;
        StringBuilder sb = new StringBuilder();
        while(index<s.length()){
            int temp = index;
            while(index+1 <s.length() && s.charAt(index+1)==s.charAt(index)){
                index++;
            }
            int cnt = index - temp+1;
            if(cnt<3){
                for (int i =0 ; i<cnt;i++){
                    sb.append(s.charAt(temp));
                }
            }
            index++;
        }
        return sb.toString();
    }
}
