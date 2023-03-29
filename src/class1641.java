/**
 * 1641. 统计字典序元音字符串的数目
 * 数学
 * 把n个小球放到5个盒子里
 * 排列组合数
 * 0ms  100%
 */
public class class1641 {
    public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
