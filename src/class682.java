/**
 * 682. 棒球比赛
 * 1ms 100%
 */
public class class682 {
    public int calPoints(String[] ops) {
        int [] score = new int [ops.length];
        int index =0;
        int sum = 0 ;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("C")){
                sum -= score[--index];
            } else if (ops[i].equals("D")) {
                sum += score[index-1]*2;
                score[index]= score[index-1] * 2;
                index ++;
            } else if (ops[i].equals("+")) {
                score[index] = score[index-1] + score[index-2];
                sum += score[index];
                index ++;
            } else{
                int val = Integer.parseInt(ops[i]);
                sum += val;
                score[index++] = val;
            }
        }
        return sum ;
    }
}
