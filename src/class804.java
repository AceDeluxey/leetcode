import java.util.HashSet;
    /*/
    804. 唯一摩尔斯密码词
        国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

        思路：就循环拼接放到hashset里就能去重了

        3ms 50%(使用String ，然后使用+拼接字符串的情况)
        2ms 99% (使用stringBuffer.append的情况，变快了
     */
public class class804 {
    String [] dic={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set= new HashSet<>();
        int cnt=0;
        for(int i=0;i< words.length;i++){
//            String temp="";
            StringBuffer temp=new StringBuffer();
            for(int j=0;j< words[i].length();j++){
//                temp+=dic[words[i].charAt(j)-'a'];
                temp.append(dic[words[i].charAt(j)-'a']);
            }
            if(set.add(temp.toString())){
                cnt++;
            }
        }
        return cnt;
    }
}
