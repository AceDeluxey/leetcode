import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 * 简单
 * 0ms 100%
 */
public class class1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String [] temp = text.split(" ");
        List<String> list = new ArrayList<String>();
        for(int i =0 ; i < temp.length; i++){
            if(temp[i].equals(first)){
                if(i+1< temp.length && temp[i+1].equals(second)){
                    if(i+2< temp.length  ){
                        list.add(temp[i+2]);
                    }
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
