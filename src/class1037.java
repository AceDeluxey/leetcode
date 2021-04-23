/*
    1037. 有效的回旋镖
    就是验证三个点是否在一条直线

    思路：如果直接用两个斜率判断存在除零问题，所以直接用交叉相乘
        当三点垂直于x轴，deltaX为0时，交叉相乘相等于0也满足

     0ms 100%p;
 */

public class class1037 {
    public boolean isBoomerang(int[][] points) {
        if((points[0][1]-points[1][1]) *(points[2][0]-points[1][0])==(points[2][1]-points[1][1])*(points[0][0]-points[1][0])  ){
            return false;
        }else{
            return true;
        }
    }
}
