/**
 * 1684. 统计一致字符串的数目
 * 存字符串中的字母出现与否，就不用set了，用int 的二进制就可以了
 *
 * 6ms 81%
 */
public class class1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ald = 0;
        int res =0 ;
        for( int i =0 ; i <allowed.length();i++){
            int temp =  allowed.charAt(i)-'a';
            int a = 1;
            a = a<<temp;
            ald = ald | a;
        }
        for (String word: words){
            int mask = 0;
            for( int i=0;i<word.length();i++){
                mask = mask | 1<<word.charAt(i)-'a';
            }
            if((ald | mask) ==ald){
                res ++;
            }
        }
        return res;
    }
}
