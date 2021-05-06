
    /*
        468. 验证IP地址
        编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
            如果是有效的 IPv4 地址，返回 "IPv4" ；
            如果是有效的 IPv6 地址，返回 "IPv6" ；
            如果不是上述类型的 IP 地址，返回 "Neither" 。

         不是很难，但是很麻烦
        Integer.parseInt(splitIP[i],16);可以把16进制字符串转为整数

        Operator '==' cannot be applied to 'char
        char类型== 要使用''

        用.分割要用 String splitIP[]=IP.split("[.]");
·
        可以用正则表达式，可能会更快
        4ms 41.27%;
     */
public class class468 {
    public String validIPAddress(String IP) {
        if(IP.length()==0 || IP.charAt(0)==':' || IP.charAt(IP.length() - 1)==':'
        || IP.charAt(IP.length() - 1)=='.' || IP.charAt(0)=='.'){
            return "Neither";                      //特判
        }

        String splitIP[]=IP.split("[.]");  //分割IPV4
        boolean ifIllegal = false;
        //要判断IPV6 0的格式是否一致，ifEllipse用于标定是否都省略
        boolean ifEllipse = false;
        if(splitIP.length==4){
            for(int i = 0; i < splitIP.length; i++){
                //splitIP[i]=="" 这样写不知道为什么不对
                if (splitIP[i].length()==0){
                    ifIllegal=true;
                    break;
                }
                if(splitIP[i].charAt(0)=='0'&& splitIP[i].length()>1){
                    ifIllegal=true;
                    break;
                }
                int temp;
                try
                //要检查的程序语句
                {
                    temp= Integer.parseInt(splitIP[i]);
                }
                catch(Exception e)
                //异常发生时的处理语句
                {
                    ifIllegal=true;
                    break;
                }
                finally
                //这个代码块一定会被执行
                {
                }

                if(temp<0 || temp>255){
                    ifIllegal=true;
                    break;
                }
            }
            if(!ifIllegal){
                return "IPv4";
            }
        }

        splitIP=IP.split(":");
        if(splitIP.length==8){
            for(int i = 0; i < splitIP.length; i++){
                if (splitIP[i].length()==0 || splitIP[i].length()>4){
                    ifIllegal=true;
                    break;
                }
                //十六进制字符串可以直接用parseInt转换为十进制整数，但是字符串不能有0x开头
                int temp;
                try
                //要检查的程序语句
                {
                    temp= Integer.parseInt(splitIP[i],16);
                }
                catch(Exception e)
                //异常发生时的处理语句
                {
                    ifIllegal=true;
                    break;
                }
                finally
                //这个代码块一定会被执行
                {
                }

                if(temp<0 || temp>0xffff){
                    ifIllegal=true;
                    break;
                }
//                else if(temp==0){
//                    if(ifEllipse){
//                        if(splitIP[i].length()!=1){
//                            ifIllegal=true;
//                            break;
//                        }
//                    } else{
//                        if(splitIP[i].length()==1){
//                            ifEllipse=true;
//                        }
//                    }
//                }
            }
            if(!ifIllegal){
                return "IPv6";
            }
        }

        return "Neither";
    }
}
/*
    String IP="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        class468 test = new class468();
        test.validIPAddress(IP);


        try
        //要检查的程序语句
        {
            System.out.println(Integer.parseInt("1e1"));
        }
        catch(Exception e)
        //异常发生时的处理语句
        {
            System.out.println("返回");
        }
        finally
        //这个代码块一定会被执行
        {
            System.out.println("*****");
        }
 */