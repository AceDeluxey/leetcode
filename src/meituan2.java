import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int matirx[ ][] = new int[n+1][n+1];
        for (int i =1;i<n;i++){
            int temp =in.nextInt();
            matirx[i+1][temp] = 1;
            matirx[temp][i+1] = 1;
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int res = dfs(matirx,a,b)+dfs(matirx,b,a);
        System.out.println(res-1);
    }
    public  static  int dfs(int [][]matrix,int a ,int b){
        int max = 0;
        for ( int i =1 ;i<matrix[b].length;i++){
            if(i!=a){
                if(matrix[b][i]==1){
                    max = Math.max(0,dfs(matrix,b,i));
                }
            }

        }
        return max +1;
    }
}
