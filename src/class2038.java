/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * 说是游戏 但是决策根本没有用 因为A选根本不会影响到B
 *
 *12 ms 43%
 */
public class class2038 {
    public boolean winnerOfGame(String colors) {
        int A=0,B=0;
        int i =0 ;
        while ( i<colors.length() ){
            if(i<colors.length() &&  colors.charAt(i) =='A'){
                int start = i;
                i++;
                while(i<colors.length() && colors.charAt(i) == 'A'){
                    i++;
                }
                int cnt = i-start;
                A+= cnt>2? cnt -2:0;
            }

            if( i<colors.length() &&  colors.charAt(i) =='B'){
                int start = i;
                i++;
                while(i<colors.length() && colors.charAt(i) == 'B'){
                    i++;
                }
                int cnt = i-start;
                B+= cnt>2? cnt -2:0;
            }
        }
        System.out.println(A);
        System.out.println(B);
        return A>B;
    }
}
