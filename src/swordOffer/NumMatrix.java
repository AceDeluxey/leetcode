package swordOffer;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 * 叫写构造函数 ， 就是应该在初始化的时候处理  我没意识到就直接暴力了
 * 所以效果不好
 * 在clone的时候可以计算前缀和，这样每行的差值就很容易算了
 *
 */
public class NumMatrix {
    int [][] m;
    public NumMatrix(int[][] matrix) {
        m=matrix.clone();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i= row1;i<=row2; i++){
            for( int j = col1; j <= col2; j++){
                sum += m[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */