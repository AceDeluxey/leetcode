package swordOffer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 简单的递归
 * 100 37
 */
public class sword64 {
    public int sumNums(int n) {
        if(n!=0){
            return n+ sumNums(n-1);
        } else{
            return n;
        }

    }
}
//      sword64 test=new sword64();
//        System.out.println(test.sumNums(0));