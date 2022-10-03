/**
 * 1784. 检查二进制字符串字段
 * 简单模拟
 * 0ms 100%
 */
ublic class class1784 {
    public boolean checkOnesSegment(String s) {
        int index =0 ,len =s.length();
        while(index<len && s.charAt(index)=='0'){
            index++;
        }
        while(index<len && s.charAt(index)=='1'){
            index++;
        }
        while(index<len ){
            if (s.charAt(index) == '1') {
                return false;
            }
            index++;
        }

        return true;
    }
}
