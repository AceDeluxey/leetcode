import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2347. 最好的扑克手牌
 * 模拟题
 * 1ms 30%
 * 不过错了这么多次真的有点逆天
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 */
public class class2347 {
    public static void main(String[] args) {
        class2347 test = new class2347();
        int [] a= {4, 4, 2, 4, 4};
        char []c = {'d','a','a', 'b', 'c'};
        test.bestHand(a,c);

    }
    Map<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(1, "Flush");
            put(2, "Three of a Kind");
            put(3, "Pair");
            put(4, "High Card");
        }
    };

    public String bestHand(int[] ranks, char[] suits) {
        int numSame = 0;
        Arrays.sort(ranks);
        int tmp = 0;
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == ranks[i - 1]) {
                tmp++;
            } else {
                numSame = Math.max(numSame, tmp + 1);
                tmp=0;
            }
        }
        if(tmp!=0){
            numSame = Math.max(numSame, tmp + 1);
        }

        if (checkSameSuit(suits)) {
            return map.get(1);
        } else if (numSame >= 3) {
            return map.get(2);
        } else if (numSame == 2) {
            return map.get(3);
        } else {
            return map.get(4);
        }
    }

    private boolean checkSameSuit(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
