/**
 * 1217. 玩筹码
 * 其实是脑经急转弯
 * 相隔一个的筹码互相之间都是0代价，所以最终可以用0代价把所有筹码分为相邻两列，一列是偶数 一列是奇数
 * 所以只要选择奇数和偶数中少的那一列移动就可以了
 * 0ms 100%
 */
public class class1217 {
    public int minCostToMoveChips(int[] position) {
        int num1=0,num2=0;
        for(int i = 0; i < position.length; i++){
            if(position[i] %2==0){
                num1++;
            } else{
                num2++;
            }
        }
        return Math.min(num1, num2);
    }
}
