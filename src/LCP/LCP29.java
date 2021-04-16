package LCP;
/*
    LCP 29. 乐团站位
    某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。

    为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示


    思路:先确定这个人在哪个圈，算出这个圈之前有多少个人，再试他在这个圈的哪条边

         思路不难，难在细节，比如怎么求在第几个圈，怎么求在哪条边
         就算是这样，JAVA也做不出来
         因为给的示例特别大694755836,601953258,632852842
         所以如果直接用公式算之前的人数，肯定会溢出
         只能用循环算，循环里每次都%9.但是这样的话就从O1变成了ON
         不知道怎么解决，解答里也没有JAVA做的
 */
public class LCP29 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        int layer=Math.min(xPos+1,yPos+1);  //求该位置在第几个圈
        layer=Math.min(layer,num-xPos);
        layer=Math.min(layer,num-yPos);
        int start=1;
        for(int i=1;i<layer; i++){
            start+=((num-1-(i-1)*2))%9*4%9;
        }
        int remind=0;
        if(xPos == layer-1){
            remind=(start+(yPos-layer+1))%9;
            return remind==0?9:remind;
        } else{
            start += (num-1-(layer-1)*2)%9;
        }

        if(yPos == num-layer){
            remind=(start+(xPos-layer+1))%9;
            return remind==0?9:remind;
        } else{
            start += (num-1-(layer-1)*2)%9;
        }

        if(xPos == num-layer){
            remind= (start+(num-layer-yPos))%9;
            return remind==0?9:remind;
        } else{
            start += (num-1-(layer-1)*2)%9;
        }

        if(yPos == layer-1){
            remind=(start+(num-layer-xPos))%9;
            return remind==0?9:remind;
        } else{
            start += (num-1-(layer-1)*2)%9;
        }

        return -1;
    }
}
