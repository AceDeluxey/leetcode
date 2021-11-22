/**
 * 384. 打乱数组
 *
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 思路：就是写一个类
 *
 * On 101ms 6%
 */
class class384 {
    int [] nums;
    int [] shuffle = null;
    public class384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        shuffle = null;
        return nums;
    }

    public int[] shuffle() {
        if (shuffle == null) {
            shuffle = nums.clone();
            for(int i = 0; i < nums.length; i++){
                double d = Math.random();
                int rand =  (int)(d* nums.length);
                if(rand !=i){
                    shuffle[i] +=shuffle[rand];
                    shuffle[rand] = shuffle[i] - shuffle[rand];
                    shuffle[i] = shuffle[i] - shuffle[rand];
                }
            }
        }
        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */