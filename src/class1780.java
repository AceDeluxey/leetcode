/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * 拆分成3进制位，没有2就可以了
 * 0ms 100
 *
 */
public class class1780 {
    public boolean checkPowersOfThree(int n) {
        while(n!=0){
            if(n%3==2){
                return false;
            }
            n = n/3;
        }
        return true;
    }

//        while(true){
//            if(!isM(n)){
//                if(n%3==0){
//                    n = n/3;
//                    continue;
//                }
//                //减去3的0次幂
//                if(!isM(n-1)){
//                    //减1都不行说明不是
//                    return false;
//                } else{
//                    n = (n-1)/3;
//                }
//            } else{
//                //如果余数是0，要判断n是不是n的三次幂
////                if( isM(n) ){
////                    break;
////                } else{
////                    return false;
////                }
////                return false;
//                break;
//            }
//        }
//        return  true;
//    }
//    private boolean isM( int n){
//        if(n==1){
//            return true;
//        }
//
//        while(n%3==0){
//            n=n/3;
//            if(n==1){
//                return true;
//            }
//        }
//        return false;
//    }
}
