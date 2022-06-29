import java.util.ArrayList;
import java.util.List;

/**
 * 535. TinyURL 的加密与解密
 */
public class class535 {
    List<Integer> list;
    int length;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuffer  sb = new StringBuffer();
        list = new ArrayList<>();
        length = longUrl.length();
        for (int i = 0; i < longUrl.length(); i++) {
            if (longUrl.charAt(i) == 'a') {
                list.add(i);
            } else{
                sb.append(longUrl.charAt(i));
            }
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0,index2=0;
        for (int i = 0; i < length; i++) {
            if ((list.size()>0 && index1<list.size())  && i == list.get(index1++)) {
                sb.append('a');
            } else {
                sb.append(shortUrl.charAt(index2++));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s =  "https://leetcode.com/problems/design-tinyurl";
//        this.encode(s);
//        System.out.println(this.decode(s));
    }
}
