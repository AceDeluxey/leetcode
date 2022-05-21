import java.util.Random;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * 属于是从来没有想过的方法，因为数组里必然存在很多重复的数，而且已经高达了一半，所以可以直接用概率模拟，在短期内就可以直接找到目标
 * 0ms 100%
 */
public class class961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }

    }
}
