import java.util.Arrays;

/**
 * 825. 适龄的朋友
 * 思路：排序后判断条件一就行，因为条件二已经在循环中判断了；
 * ，可以从前往后加，所以要记录上一个加的好友数量，如果年龄一样直接加last
 *
 * O(n方) 34 ms 17.79%
 */
public class class825 {
    public int numFriendRequests(int[] ages) {
        int cnt  =0 ;
        int last = 0 ;
        Arrays.sort(ages);
        for (int i =  ages.length - 1; i >=0; i -- ) {
            //考虑到相同的可以互相加，所以相同的等于第一次算的添加数量
            if(i<ages.length - 1){
                if(ages[i]==ages[i+1]){
                    cnt +=last;
                    continue;
                }
            }
            for (int j = i-1; j>=0; j--) {
                if(ages[j] <= 0.5*ages[i]+7 ){
                    cnt+= i-j-1;
                    last = i-j-1;
                    break;
                } else if (j==0){
                    cnt+= i-j;
                    last =  i-j;
                    break;
                }
            }
        }
        return cnt;
    }
}
