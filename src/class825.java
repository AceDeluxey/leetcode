import java.util.Arrays;

/**
 * 825. 适龄的朋友
 */
public class class825 {
    public int numFriendRequests(int[] ages) {
        int cnt  =0 ;
        Arrays.sort(ages);
        for (int i = 1; i < ages.length; i++) {

            for (int j = i-1; j>=0; j--) {
                if(ages[j] <= 0.5*ages[i]+7 || j==0){
                    cnt+= i-j-1;
                    continue;
                }
            }
        }
        return cnt;
    }
}
