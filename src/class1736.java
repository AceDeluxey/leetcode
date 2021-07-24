/**
 *
    1736. 替换隐藏数字得到的最晚时间
        给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
        有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。

    思路：就是一位一位调节

        0ma 100%
 */
public class class1736 {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();

        //决定第一位
        if (time.charAt(0) == '?') {
            if (time.charAt(1) >= '4' && time.charAt(1) <= '9') {
                arr[0] = '1';
            } else {
                arr[0] = '2';
            }
        }

        //决定第二位
        if (time.charAt(1) == '?') {
            if (arr[0] == '2') {
                arr[1] = '3';
            } else {
                arr[1] = '9';
            }
        }

        //决定第四位
        if (time.charAt(3) == '?') {

            arr[3] = '5';

        }

        //决定第五位
        if (time.charAt(4) == '?') {

            arr[4] = '9';

        }

        return new String(arr);
    }
}
