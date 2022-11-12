import java.util.Scanner;
public class classMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = 0;
        int n=0;

            len = in.nextInt();
            n = in.nextInt();

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int [] nums = new int[len];
            for(int i = 0; i < len; i++){
                int x = in.nextInt();
                nums[i]=x;
            }
            int res=0;

            for( int i =0;i<len;i++){
                for( int j=i+1;j<len;j++){
                    if(nums[i]*nums[j]==0 && n==0){
                        res++;
                    }else{
                        //0的个数
                        int len1=0;
                        int len2 = 0;
                        int a1 = nums[i];
                        int a2 = nums[j];
                        while(a1%10==0){
                            len1++;
                            a1=a1/10;
                        }
                        while(a2%10==0){
                            len2++;
                            a2=a2/10;
                        }
                        int temp = len1+len2;
                        int c1 = a1%10;
                        int c2 = a2%10;
                        if(c1*c2%10==0){
                            temp+=1;
                        }
                        if(temp>=n){
                            res++;
                        }
                    }

                }
            }
            System.out.println(res);
        }

    }
}
