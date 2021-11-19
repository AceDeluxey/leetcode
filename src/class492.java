/**
 * 492. 构造矩形
 * 0ms 100%
 * 就遍历就行了
 */
public class class492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        double len = Math.sqrt((double) area);
        if (Math.floor(len) == len) {
            res[0] = (int) len;
            res[1] = (int) len;
        } else {
            for (int i = (int) Math.floor(len); i >= 0; i--) {
                if(area%i==0){
                    res[1] = i;
                    res[0] = area/i;
                    break;
                }
            }
        }
        return res;
    }
}
