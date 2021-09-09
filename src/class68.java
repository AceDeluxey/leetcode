import java.util.ArrayList;
import java.util.List;

/**
 *
    68. 文本左右对齐
    给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本

    思路：就是业务逻辑比较复杂，但是不难；没有涉及复杂算法
        0ms 100%
 */
public class class68 {
    //现在使用的词的坐标
    int index = 0;
    List<String> result;

    public List<String> fullJustify(String[] words, int maxWidth) {
        result = new ArrayList<>();
        while (index <= words.length) {
            //每次完成一行
            addList(words, maxWidth);
        }
        return result;
    }

    private void addList(String[] words, int maxWidth) {
        //计算下一次能取多少个词
        int cnt = calCnt(index, words, maxWidth);

        //一个单词左对齐
        if (cnt == 1) {
            //添加0
            result.add(words[index] + conSpace(maxWidth - words[index].length()));
            index += 1;
        } else if (index + cnt >= words.length - 1) {
            String s = "";
            //说明是最后一行
            int length = 0;
            for (int i = index; i < words.length; i++) {
                if (length == 0) {
                    s += words[index];
                    length = words[index].length();
                } else {
                    s += " " + words[index];
                    length += words[index].length() + 1;
                }
            }
            result.add(s + conSpace(maxWidth - length));
        } else {
            //就是普通的情况
            String s = "";

            int word_length = 0;
            for (int i = 0; i < cnt; i++) {
                word_length += words[i + index].length();
            }
            //平均间隔
            int aveSpace = (maxWidth-word_length)/cnt;
            int extra = (maxWidth-word_length)%cnt;

            for (int i = 0; i < cnt; i++) {
                if(i==0){
                    s+=words[index];
                } else if(i<extra){
                    s+=conSpace(aveSpace+extra)+words[index+i];
                } else{
                    s+=conSpace(aveSpace);
                }
            }
        }
    }

    //构造空格字符串
    private String conSpace(int num) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < num; i++) {
            s.append(' ');
        }
        return s.toString();
    }

    private int calCnt(int temp_index, String[] words, int maxWidth) {
        int cnt = 0;
        int length = 0;
        while (true) {
            //第一个词不加空格，后面的加空格
            if (length == 0) {
                length = words[temp_index].length();
            } else {
                length += words[temp_index].length() + 1;
            }

            //如果还没超，就继续取；超了就跳出
            if (length <= maxWidth) {
                cnt++;

                //如果已经取到最后一个word,那么直接取出;否则就继续加
                if (temp_index == words.length - 1) {
                    return cnt;
                } else {
                    temp_index++;
                }

            } else {
                return cnt;
            }
        }
    }
}
