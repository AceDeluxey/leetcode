/**
 * 334. 递增的三元子序列
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
    思路：很巧妙的贪心算法，a记录最小值，b记录小值，当出现比a和c都大的说明有递增3元
        例如1..2..4，递归中a是1 b是2 true
        特殊情况如 7 1 8， a是1 b是MAX_INTEGER 所以不会成立
        4 5 0 7； 到5时 a=4 b=5, 因为b有值了，说明前面一定存在过比b小的值，前两个递增已经成立，只要有比5大的就行
        到0 a=0 b =5，虽然 a变了，但是b=5仍然说明b前面有小于5的数，这时候b没变，实际上是比c和5的大小
        只有当b再次改变时，c比较的对象才改变 例如 4 5  1 2 3 到2时 a=1 b=2 c=3 成立
        综上所述，特殊情况均成立

    2ms 76.9%
 */
public class class334 {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            } else if (nums[i] <= b) {
                b = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
