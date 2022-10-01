/**
 * 1694. 重新格式化电话号码
 * 就模拟就好
 * On 1ms 99%
 */
public class class1694 {
    public String reformatNumber(String number) {
        number = number.replace(" ","").replace("-","");
        int index =0 ;
        int len = number.length();
        StringBuilder sb = new StringBuilder();
        while(true){
            int temp = len - index ;
            if(temp<=4){
                if(temp==2){
                    for (int i =0 ; i<2;i++){
                        sb.append(number.charAt(index++));
                    }
                } else  if(temp==3){
                    for (int i =0 ; i<3;i++){
                        sb.append(number.charAt(index++));
                    }
                } else{
                    for (int i =0 ; i<2;i++){
                        sb.append(number.charAt(index++));
                    }
                    sb.append("-");
                    for (int i =0 ; i<2;i++){
                        sb.append(number.charAt(index++));
                    }
                }
                break;
            } else{
                for (int i =0 ; i<3;i++){
                    sb.append(number.charAt(index++));
                }
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
