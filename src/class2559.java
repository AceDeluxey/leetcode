import java.util.HashSet;

/**
 * 2559. 统计范围内的元音字符串数
 * 11ms 17%
 * 前缀和
 * 看答案也可以用二分，就是先把所有check合格的记录在数组里，然后二分查找l r 的下标 小的和大的
 * 时间复杂度差不多
 */
public class class2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int [] res = new int[queries.length];
        int [] sum = new int [words.length+1];
        for ( int i =0 ; i<words.length;i++){
            if (check(words[i])) {
                sum[i+1] = sum[i]+1;
            } else{
                sum[i+1] = sum[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int [] query = queries[i];
            res[i] = sum[query[1]+1]-sum[query[0]];
        }
        return res;
    }
    private  boolean check (String s ){
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        if(set.contains(s.charAt(0))&&set.contains(s.charAt(s.length()-1))){
            return true;
        }
        return false;
    }

}
