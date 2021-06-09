import java.util.ArrayList;

/**
        168. Excel表列名称
        给定一个正整数，返回它在 Excel 表中相对应的列名称。
         1 -> A
         2 -> B
         3 -> C

        思路：很奇怪的进制转换，十进制转26进制，但是0没有对应字符
                这样的话每次要在n的基础上-1，不知道为什么。但是我觉得可以硬背下来。
            有个点可以改善，可以不用list再反转，可以先拼接，再用reverse反向
        8ms 12%

 */
public class class168 {
    public String convertToTitle(int columnNumber) {
        ArrayList<Integer> list = new ArrayList<>();

        while (columnNumber !=0){
            columnNumber -=1;
            int reminder=columnNumber%26;
            columnNumber /=26;
            list.add(reminder);
        }
        String res="";
        for(int i=list.size() - 1; i >= 0; i--){
            res +=(char)(list.get(i)+'A');
        }
        return res;
    }
}
