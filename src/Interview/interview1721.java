package Interview;

/**
 * 面试题 17.21. 直方图的水量
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，
 * 最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 和class42一样的题 2021.04.02重做
 *
 * 思路：每一个x轴点上能积累的水量，只与该点左右的最高块的长度有关
 *      每个点积累的水量是左右最高块中的最小值减去该点的高度
 *      重点就是求每个点左右两边的最大值
 *      与class123 卖股票类似，遍历时就可以求出左边的最大值
 *      提前遍历一遍求出每个点右边的最大值
 *      这样时间复杂度是ON
 *
 *      35% 38%
 *      在class42里 50% 20%,比上次做有很大提升
 *
 */
public class interview1721 {
    public static void main(String[] args) {
        int []height= {0,1,0,2,1,0,1,3,2,1,2,1};
       trap(height);
    }
    public static  int trap(int[] height) {
        int []max_right=getRightMax(height);
        int max_left=0;
        int vol=0;
        for(int i=0;i<height.length; i++){
            int temp=Math.min(max_left,max_right[i])-height[i];
            if(temp>0){
                vol+=temp;
            }
            if(height[i]>max_left){
                max_left=height[i];
            }
        }
        return vol;
    }
    private static int[] getRightMax(int[] height){
        int []max_right=new int[height.length];
        for(int i=height.length - 1; i>=0;i--){
            if(i==height.length - 1){
                max_right[i]=0;
            } else{
                if(height[i+1]>max_right[i+1]){
                    max_right[i]=height[i+1];
                } else{
                    max_right[i]=max_right[i+1];
                }
            }
        }
        return max_right;
    }
}
