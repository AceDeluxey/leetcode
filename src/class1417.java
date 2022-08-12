import java.util.ArrayList;
import java.util.List;

/**
 * 1417. 重新格式化字符串
 * 3ms 60.63
 * 就是模拟
 */
public class class1417 {
    public String reformat(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int index1 = 0, index2 = 0;
        int cntD = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                cntD++;
            }
        }
        if (cntD > (len - cntD)) {
            while (sb.length() != len) {
                if (sb.length() % 2 == 1) {
                    while (index1 < len && Character.isDigit(s.charAt(index1))) {
                        index1++;
                    }
                    if (index1 < len) {
                        sb.append(s.charAt(index1));
                        index1++;
                    } else {
                        return "";
                    }
                } else {
                    while (index2 < len && !Character.isDigit(s.charAt(index2))) {
                        index2++;
                    }
                    if (index2 < len) {
                        sb.append(s.charAt(index2));
                        index2++;
                    } else {
                        return "";
                    }
                }
            }
        } else {
            while (sb.length() != len) {
                if (sb.length() % 2 == 0) {
                    while (index1 < len && Character.isDigit(s.charAt(index1))) {
                        index1++;
                    }
                    if (index1 < len) {
                        sb.append(s.charAt(index1));
                        index1++;
                    } else {
                        return "";
                    }
                } else {
                    while (index2 < len && !Character.isDigit(s.charAt(index2))) {
                        index2++;
                    }
                    if (index2 < len) {
                        sb.append(s.charAt(index2));
                        index2++;
                    } else {
                        return "";
                    }
                }
            }
        }

        return sb.toString();
    }
}
