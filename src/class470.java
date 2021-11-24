/**
 *  470. 用 Rand7() 实现 Rand10()
 *  思路：看了解答真的很厉害。只要m = m1 * m2，就能构造出随机数器
    比如 Rand21() , 就是3*7,把他构造成两个3种情况的概率型和7种的概率型即可
    首先生成1到3的随机数 a，因为1,2,3生成的概率一样，拒绝掉4，5，6，7，就可以
    然后生成0到7的随机数 b
    然后 结果是b+(a-1)*7,这样揪通过两个等概率的概率型构造了一个新的概率型
 * 7 ms   27.66%
 */
public class class470 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    public int rand10() {
//        int num1,num2;
//        while((num1=rand7())>6){
//
//        }
//        while((num2=rand7())>5){
//
//        }
//        return num1%2==0?num2:num2+5;
        return 0;
    }
}
