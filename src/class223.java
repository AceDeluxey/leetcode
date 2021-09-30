/**
    223. 矩形面积
    给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积

    思路：数学题 容斥原理
 */

public class class223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //第一个矩形的面积
        int S1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        //第二个矩形的面积
        int S2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        //相交的长和宽,如果减出来小于0，说明不相交，相交长宽取0
        int x = Math.max(0, Math.min(bx2, ax2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        return S1+S2-x*y;

    }
}
