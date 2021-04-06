import java.util.Stack;
/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  思路： 代码块1：容易想到对于坐标为i的点，如果要以i为左边构建最大矩形，那么它的左右两边的长度都不能比他小
 *              可以想到使用单调栈。最开始写的代码块1，栈里存储的是高度，这样在出栈时难以求解width,所以
 *              修改为代码块2.
 *        代码块2：循环如果Height大于栈顶就入栈；如果小于栈顶，就不断出栈，并求以每个出栈元素为高的最大面积
 *                  例如[3,6,5,7,4,8,1,0]，在1入栈之前，栈里有0 4 5，可以求出4对应的width为6-0-1=5，
 *                  因为时单调递增栈，所以index为0和4之间一定时height>4的，index4到i也是height>4
 *                这样循环就可以求出一部分的最大面积
 *                循环后栈内剩余元素我们重新遍历一次即可求出最大面积（看到解答中可以在height数组的开头结尾
 *                增加两个0作为哨兵代替这次遍历）
 *
 * 7ms 99% ; 47.6M  65%
 */


public class class84 {
    public int largestRectangleArea(int[] heights) {
    //代码块2：栈里存的位置
        int []stack=new int[heights.length+1];
        int top=0;
        int S=0;
        for(int i=0;i<heights.length; i++){
            if(top==0 || heights[i]>=heights[stack[top-1]]){    //单调递增入栈
                stack[top++]=i;
                continue;
            }

            while( top!=0 && heights[i]<heights[stack[top-1]] ){  //小于时开始出栈
                top--;
                int width;
                if(top==0){
                    width=i;  // 当top==0,说明该处元素之前全部大于他，或者没有前序元素，所以从最开始到i全部是大于它的元素
                } else{
                    width=i-stack[top-1]-1;   //top-1个元素到i都大于top处的元素
                }

                S=Math.max(S,heights[stack[top]]*(width));
            }


            stack[top++]=i;

        }
        for( int i=0;i<top;i++){   //最后留在栈里，说明i后没有比i处更小的元素，所以计算heights.length-stack[i-1]中间的元素个数即为width
            if(i==0){
                S=Math.max(S, heights[stack[i]] *heights.length );  //i=0等价于top=0
            } else if(i==top-1){
                S=Math.max(S, heights[stack[i]] *(stack[i]-stack[i-1]));
            } else {
                S=Math.max(S, heights[stack[i]] *(heights.length-stack[i-1]-1));
            }

        }
        return S;
//        代码段1：栈里存的高度
//        int []stack=new int[heights.length+1];
//        int top=0;
//        int S=0;
//        for(int i=0;i<heights.length; i++){
//            if(top==0 || heights[i]>=stack[top-1]){
//                stack[top++]=heights[i];
//                continue;
//            }
//            int temp=top;
//            while( top!=0 && heights[i]<stack[top-1] ){
//                top--;
//            }
//            S=Math.max(S,stack[top]*(temp-top));
//            stack[top++]=heights[i];
//
//        }
//        for( int i=0;i<top;i++){
//            S=Math.max(S, stack[i] *(top-i) );
//        }
//        return S;
    }
}
