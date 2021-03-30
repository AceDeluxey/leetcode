/**
 * * 买卖股票的最佳时机 III
 *  * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *  *
 *  * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *  *
 *  * method1:硬解，拆成两半用121题，
 *  *
 *  * method2:由method1我们可以知道，因为两笔交易不能同时进行，所以以i为界限分成两笔交易
 *  * 对于左侧的交易，我们在循环中可以得到i右边的最小值，那么与i的差值比较，就可以得到i左边的最大收益
 *  *  这样的话左侧是线性的
 *  *  那么对于右边的交易而言，我们只有i左侧的最小值是无法求出i右边的最大收益的
 *  *  我们需要得到i+1右边的最大值，再与i+1的差值相比。这样也可以线性地求出右边的最大收益
 *  *  问题在于我们没有办法在循环的同时求出i右边的最大值
 *  *  所以在开始前，我们先on遍历一次数组，求出每个i右边的最大值
 *  *  这样在正式循环中，我们就可以一次循环求出左边和右边的最大收益。
 *  *
 *     思路version2:写完method2思路又想了一遍，总觉得哪里不太对
 *     现在知道了，求解右边的时候其实用来贪心的思想，因为默认了直接用i+1值就可以求出最大收益
 *     再一想会感觉这样不太对，因为你怎么保证i+1以后，最大值之前，没有比i+1更低的股价了
 *     实际是不用保证的，因为无非就几种情况，我们把它都想一遍就知道，不遍历右边也没有关系
 *     例如如果i左边的最小值是a,最大值是b(a在b左边)
 *     i+1的值是c，c<b,c的右边有d<c，d的右边有e>c，d的右边有最大值e>c
 *     那么我们到i时，result=b-a+e-c,可以看出显然右边还有更大收益e-d,
 *     但是可以发现如果i遍历到c处的时候，如果c>b,result1=c-a,result2=e-d
 *     如果c<b,result1=b-a,此时result2=e-d
 *     这也就是说，当我们遍历到i时，不用管i+1右侧可能有更大的收益
 *     因为在之后的循环中，会循环到那次收益
 *     所以我们只用贪心地算i+1与max的差值就可以了
 *
 *  * 时间56% 空间73%
 */

public class class123 {
    public int maxProfit(int[] prices) {
        int len= prices.length;
        int result1=0;
        int result2=0;
        int result=0;
        if(len<=1){
            return 0;
        }

//        method2:
        int []max=new int[len];
        max[len-1]=prices[len-1];  //先遍历循环i右边的最大值
        for(int i=len-2;i>=0;i--){
            if(max[i+1]<prices[i]){
                max[i]=prices[i];
            } else{
                max[i]=max[i+1];
            }
        }
        int min1=prices[0];
        for( int i=0;i<len;i++){
                if(prices[i]>min1){  //求左侧交易的最大收益
                    if(prices[i]-min1>result1){
                        result1 = prices[i]-min1;
                    }
                }
                if(prices[i]< min1){  //循环中求i左边的最小值
                    min1=prices[i] ;
                }

                if(i+1<len){
                    if(prices[i+1] < max[i+1]){  //求右侧交易的最大收益
                        if(max[i+1]-prices[i+1]>result2){
                            result2=max[i+1]-prices[i+1];
                        }
                    }
                }
            /**
             * METHOD1代码块本来的位置
             */

            if(result2+result1>result){
                result=result2 + result1;
            }
            result2=0;
            /**
             * 因为是先买后卖，所以i左侧的交易最大值与之前的result1有关，result1不能置0
             * （但是i右侧的交易最大值与之前遍历的i没有关系，所以每次要置0）
             * version2:是因为只用贪心地算i+1处的差值就可以了
             */
        }
        return result;
    }
}

//method1就是对每边重新遍历一次求最大解
//            int min=prices[i];
//            for(int k=i;k<len;k++){
//                if(prices[k]>min){
//                    if(prices[k]-min>result2){
//                        result2 = prices[k]-min;
//                    }
//                }
//                if(prices[k]< min){
//                    min=prices[k] ;
//                }
//            }

//main:
//    class123 test=new class123();
//    int []a={3,2,6,5,0,3};
//    System.out.println(test.maxProfit(a));