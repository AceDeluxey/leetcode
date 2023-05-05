/**
 * 2432. 处理用时最长的那个任务的员工
 * 1，ms 98
 *
 */
public class class2432 {

    public static void main(String[] args) {
        class2432 test = new class2432();
        int a[][] = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        test.hardestWorker(10, a);
    }

    public int hardestWorker(int n, int[][] logs) {
        int max_time = 0;
        int max_id = -1;
        int last_end_time = 0;

        for (int[] log : logs) {
            int time = log[1] - last_end_time;
            last_end_time = log[1];
            if (time > max_time) {
                max_time = time;


                max_id = log[0];


            } else if (time == max_time) {
                max_id = Math.min(log[0], max_id);
            }

        }
        return max_id;
    }
}
