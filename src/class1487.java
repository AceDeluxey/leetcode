import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * 想错方向了，我以为是得到一个文件，先要分离出他真正的文件名，然后用map里的一个Integer通过位运算记录是否有这个文件名
 * 但其实map里记录上一个最小的index就行了，剩下的判断不用那么严格，用contains就可以了
 * 49ms 78%
 */
public class class1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name,1);
            } else{
                int index = map.get(name);
                while(map.containsKey(addSuffix(name,index))){
                    index++;
                }
                String fileName = addSuffix(name,index);
                res[i] =  fileName;
                map.put(fileName,1);
                map.put(name,index+1);
            }
        }

        return res;
    }
    private String addSuffix(String name ,int index){
        return name +"("+index+")";
    }
}
