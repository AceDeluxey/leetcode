public class NiYuan {
    /**
     * 求a mod的逆元
     * @param a
     * @param mod
     * @return
     */
    public static int calNiYuan(int a, int mod){
        int res = 0;
        for(int i =1 ; i <1000;i++){
            if(a*i%mod == 1){
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 求a的b次方mod mod
     * @param a
     * @param mod
     * @return
     */
    public static int calMod( int a , int b , int mod ){
        int temp  = 1 ;
        for( int i = 0 ; i < b ; i++){
            temp = temp *a %mod;
        }
        return temp;
    }
    public static void main(String[] args) {
        //逆元
        System.out.println(calNiYuan(3,448));

        //模
//        System.out.println(calMod(5,77,221));
    }
}
