package swordOffer;

import java.util.Arrays;
import java.util.HashMap;
/**
 *      剑指 Offer 61. 扑克牌中的顺子
 *      从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
        思路：排序比较 OlognN
        1ms 88%
 */

public class sowrd61 {
    public boolean isStraight(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.put((int) 'A',1);
//        map.put((int) 'J',11);
//        map.put((int) 'Q',12);
//        map.put((int) 'K',12);
        Arrays.sort(nums);
//        计算王的个数
        int cntZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            } else if (i == nums.length - 1) {
                break;
            } else {
                //相等也无法构成顺子
                if (nums[i] == nums[i + 1]) {
                    return false;
                }

                if (nums[i] + 1 != nums[i + 1]) {
                    //检查鬼是不是够用，够用就用鬼代替
                    if (cntZero >= nums[i + 1] - nums[i] - 1) {
                        cntZero = cntZero - (nums[i + 1] - nums[i] - 1);
                    } else {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
