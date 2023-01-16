/**
 * 1813. 句子相似性 III
 * 测试案例有问题啊，这怎么可能加一次加成下面那个
 * "A"
 * "a A b A"
 * 其他应该是没啥问题了，加了两个锁来保证添加元素一次
 *
 *
 */
public class class1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1, s2;
        if (sentence1.length() < sentence2.length()) {
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        } else {
            s2 = sentence1.split(" ");
            s1 = sentence2.split(" ");
        }
        /**
         * 为了确保句子中只能添加一次元素
         */
        //判断有没有添加过元素了
        Boolean isAdd = false;
        //判断还能不能添加元素
        Boolean canAdd = true;
        int index1 = 0, index2 = 0;
        while (index1 < s1.length && index2 < s2.length) {
            if (s1[index1].equals(s2[index2])) {
                if(isAdd){
                    //加过就不能再加了
                    canAdd=false;
                }
                index1++;
                index2++;
            } else {
                if (canAdd) {
                    index2++;
                    isAdd = true;
                } else {
                    return false;
                }
            }
        }
        //如果加还没用完，可以长的直接加上
        if(canAdd){
            index2=s2.length;
        }
        return index1 >= s1.length && index2 >= s2.length;
    }
}
