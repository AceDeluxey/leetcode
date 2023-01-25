/**
 * 2303. 计算应缴税款总额
 * 简单
 */
public class class2303 {
    public static void main(String[] args) {
        class2303 test = new class2303();
        int bra[][] = {{3, 50},{7, 10},{12, 25}};
        int income =10;
        test.calculateTax(bra,income);
    }
    public double calculateTax(int[][] brackets, int income) {
        double res =0 ;
        int last = 0 ;
        for (int []bracket:brackets){
            if(income>=bracket[0]){
                res+= (bracket[0]-last)*(bracket[1])/100.0;
                last = bracket[0];
            } else{
                res+= (income-last)*(bracket[1])/100.0;
                break;
            }
        }
        return  res;
    }
}
