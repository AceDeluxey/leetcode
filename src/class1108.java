/**
 * 1108. IP 地址无效化
 * 0ms 100%
 */
public class class1108 {
    public static String defangIPaddr(String address) {
        String [] s = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        int num =0;
        for(String temp : s ){
            sb.append(temp);

            if(++num!=4){
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "1.1.1.1";
        defangIPaddr(s);
    }
}
