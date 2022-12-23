/**
 * 2011. 执行操作后的变量值
 * 这是在干嘛 简单的离谱
 * ）ms 100%
 */
public class class2011 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '-' ) {
                res--;
            } else {
                res++;
            }
        }
        return res;
    }
}
