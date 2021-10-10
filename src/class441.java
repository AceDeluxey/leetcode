/**
  441. 排列硬币
   你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。

   思路：反过来从最后一层开始算就不会溢出了

    6ms 43%
 */
public class class441 {
    public int arrangeCoins(int n) {
        //每层的数量
        int num = 1;
        while (n >= num) {
            n -=num;
            num ++;
        }
        return num - 1;
    }
}
