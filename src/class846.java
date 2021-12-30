import java.util.Arrays;

/**
 * 846. 一手顺子
 *
 * 思路：简单做的，先排序，排序后好找顺子
 *      先算组数，然后找每个对子，手牌用Boolean标记是否使用过
 *O(n2)
 * 64 ms  24.85%
 */
public class class846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        boolean[] bool = new boolean[hand.length];

        for (int i = 0; i < (hand.length / groupSize); i++) {
            int cnt =0 ;
            int last = -1;
            boolean ifOrder = false;
             for (int j = 0; j < hand.length; j++) {
                if(!bool[j] ){
                    if(last == -1){
                        bool[j] = true;
                        last = hand[j];
                        cnt++;
                    } else{
                        if(hand[j]==last+1){
                            bool[j] = true;
                            last = hand[j];
                            cnt++;
                        }
                    }

                }
                if(cnt==groupSize){
                    ifOrder = true;
                    break;
                }
            }
             if(!ifOrder){
                 return false;
             }
        }
        return true;
    }
}
