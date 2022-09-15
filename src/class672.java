/**
 * 672. 灯泡开关 Ⅱ
 * 实际上是类似模拟的题，主要就是考你想不想得到简化，如果能简化出来 那就很简单那
 * 这种再面试的时候反而是比较害怕的 因为就看你想不想的出来
 *
 * 要不然就只能写搜索遍历 或是啥遍历的
 *
 * 0ms 100%
 */
public class class672 {
    public int flipLights(int n, int presses) {
        //不按按钮
        if (presses == 0) {
            return 1;
        }
        // 两个数的情况下，反转4和奇数是一种情况 所以等于三个里面选
        if (n == 2) {
            if(presses == 1){
                //一次三选一
                return 3;
            } else  if (presses==2){
                return  3 +1;// C 32 和抵消
            } else if (presses == 3){
                return 1+3; //C33 和 抵消然后选一个
            } else{
                return 4;//总共只有3种 再加2就相当于抵消了 再怎么样 2个也只有4种状态
            }


        }

        if (n>2){
            if (presses==1){
                return 4;
            } else if (presses == 2){
                return 6+1; //C42 +1
            } else if ( presses ==3 ){
                return 4 + 4;//c43 +4;
            } else if (presses ==4){
                return 6 + 1 +1;//C42 两个空 四个都选
            } else{
                //再往上就是3和4继续+2，都遍历过了，不会有其他情况出现了
                return 8;
            }
        }
        return 2;
    }

}
