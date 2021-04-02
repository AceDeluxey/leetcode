//42. 接雨水
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */


public class class42 {
    public int trap(int[] height) {
        /**2021.3.25
         * 思想和132范式那题类似，都是以中间为轴遍历，这样一边的最大值可以直接得出
         * 时间15%,空间8%，还有很大优化空间，可以用栈 */

        int max_left=0;
        int vol=0;
        for(int i=0;i<height.length;i++){  //只循环右边即可
            int max_right=0;
            if(i!=height.length-1){
                max_right=height[i+1];
                for(int j=i+1;j<height.length;j++){
                    if(height[j]>max_right){
                        max_right = height[j];
                    }
                }
            }
            int sur=Math.min(max_left,max_right)-height[i];
            if(sur>0){
                vol+=sur;
            }
            if(height[i]>max_left){
                max_left=height[i]; //一次遍历时就可以求出右边的最大值
            }
        }
        return vol;

        //2021. 3.23 以行为基本单位，写了个死循环检验程序状态，但是这个死循环条件难以斟酌，数据较大时超时
        /**int base=0,vol=0;
        int cnt=9;
        if(height.length ==0||height.length ==1){
            vol =0;
        } else{
            while(true){
                cnt=0;
                base=-1;
                for (int i=0;i<height.length; i++){
                    if(base !=-1 && height[i]>0){
                        vol+= i-base-1;
                    }
                    if(height[i]>0){
                        base=i;
                    }

                    if(--height[i]>0){
                        cnt++;
                    }

                }
                if(cnt<=1){
                    break;
                }
            }
        }



        return vol;*/
    }
}
//class42 test =new class42();
//        int [] a={0,1,0,2,1,0,1,3,2,1,2,1};
//        int []b={4,2,0,3,2,5};
//        int []c={2,0,2};
//        System.out.println(test.trap(b));