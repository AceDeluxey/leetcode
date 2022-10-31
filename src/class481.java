/**
 * 481. 神奇字符串
 * 字符串
 * 字符串拼接+不要在循环里使用 否则很慢，因为循环里每次+都创建了一个StringBuffer对象 就很慢
 * 应该在拼接之前创建一个StringBuffer对象，在循环里就一直用这个对象
 * 1051ms 6%
 */
public class class481 {
    public static void main(String[] args) {
        class481 test = new class481();
        test.magicalString(5);
    }
    public int magicalString(int n) {
        String s ="122";
        int res=1;
        //下一段有几位长
        int index =2;
        if(n<3){
            return res;
        }
        while(s.length()<n){

            if(s.charAt(s.length()-1)=='1'){
                for(int i =0;i<s.charAt(index)-'0';i++){
                    s +='2';
                }

            } else{
                for(int i =0;i<s.charAt(index)-'0';i++){
                    s +='1';
                    if(s.length()<=n){
                        res++;
                    }
                }

            }

            index++;
        }
        return res;
    }
}
