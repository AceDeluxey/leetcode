/**
    717. 1比特与2比特字符
    有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10或11)来表示
    现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。

    思路:最开始想的是递归和dp的组合，先假设可以不为0bit，然后倒退，记录中间的值，但是感觉简单题用这个太复杂了
        其实只用从头到尾检查就好，检查每一位，如果为1直接 i+=2，因为不可能有01这样的数
        遇到0直接为i++；这样到最后，如果i指向len-1，说明最后一位是1bit，如果指向len，则说明是2bit

    0ms 100%
 */
public class class717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i=0;
        for( ; i<len-1 ;){
            if(bits[i] == 0){
                i++;
            } else{
                i+=2;
            }
        }
        //恰好到len-1，最后一位为0，说明最后一位一定是1bit
        if(i==len-1){
            return true;
        } else{
            return false;
        }
    }
}
