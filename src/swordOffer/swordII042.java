package swordOffer;

/**
 * 剑指 Offer II 042. 最近请求次数
 * 先还以为要二分查找 ， 后面发现指针东就行了
 * 18ms 96% 而且发现同样是队列的原理 你用数组加指针写的话只要18  但是用封装的que就要38ms了
 *
 */
public class swordII042 {
    int index =0 ;
    int end = 0 ;
    int [] p ;
    public swordII042() {
        p = new int [10001];

    }

    public int ping(int t) {
        p[end++] = t;
        while(p[index]<t-3000){
            index++;
        }
        return end - index ;
    }
}
