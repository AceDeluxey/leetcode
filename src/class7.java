
/*
        7. 整数反转
        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
        如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
        假设环境不允许存储 64 位整数（有符号或无符号）。

        思路：method1:将Int转换为stringBuffer，直接调用reverse，
                但是问题在于为了判断溢出还是要一位一位地加，所以效率不高，2ms 29%
             metho2:就是最普通的用除法反转，反而更快一些 1ms 100%

             判断溢出可以把result设为long，每相加依次，判断是否大于MAX_VALUE 是否小于MIN_VALUE 即可
                注意要每次加都判断，否则负数溢出为正，再加负数可能就判断不出溢出了


 */
public class class7 {
    public int reverse(int x) {
        //method2:
        long result=0;
        for(;x!=0;){
            result = result*10+(x%10);
            if(result>Integer.MAX_VALUE  ||result<Integer.MIN_VALUE){
                return 0;
            }
            x/=10;
        }
        return (int)result;
//      method1:转换成字符串reverse
//        int flag;
//        if(x>0){
//            flag=1;
//        } else if(x==0){
//            return x;
//        } else{
//            flag=-1;
//        }
//        StringBuffer s=new StringBuffer();
//        s.append(Math.abs(x));
//        s.reverse();
////        String s1=s.toString();
//        long result=0;
//        for( int i=0;i<s.length();i++){
//
//            result +=flag*(s.charAt(i)-'0')*Math.pow(10,s.length()-i-1);
//            if(result>Integer.MAX_VALUE  ||result<Integer.MIN_VALUE){
//                return 0;
//            }
//        }
//
//        return (int) result;
    }
}
//class7 test = new class7();
//    System.out.println(test.reverse(123));