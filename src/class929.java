import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * 5ms 98%
 */
public class class929 {
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < emails.length; i++){
            set.add(removeDot(emails[i]));
        }
        return set.size();
    }
    private static String removeDot(String s){
        boolean flag =true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) =='@'){
                sb.append(s.substring(i));
                break;
            } else{
                if(flag){
                    if(s.charAt(i)=='+'){
                        flag = false;
                        continue;
                    }
                    if(s.charAt(i) != '.'){
                        sb.append(s.charAt(i));
                    }
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String [] s = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        String [] a = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        numUniqueEmails(a);
    }
}
