import java.util.Arrays;
    /*
    914. 卡牌分组
        给定一副牌，每张牌上都写着一个整数。
        此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
        每组都有张牌。
        组内所有的牌上都写着相同的整数。
        仅当你可选的 X >= 2 时返回true

        思路：将数组排序
             排序后在数组中统计每个数的出现次数，判断后一个数的出现次数和前一个数的出现次数的最大公约数是否大于1
             大于1说明可以找到大于1的数X

             3ms 84%
     */
public class class914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        int cnt=1;
        int temp=0;
        for(int i=0;i<deck.length-1; i++){
            if(deck[i]!=deck[i+1]){   //判断是否依旧相等
                if( temp==0 || greatesCommonDiv(temp,cnt)!=1 ){  //temp=0说明还没数出第一次
                    temp=cnt;
                    cnt=1;
                } else{
                    return false;    //最大公约数是1直接返回
                }

            } else{
                cnt++;
            }

        }
        if(temp==0){
            if(cnt>1){  //[1,1]
                return true;
            } else{   //[1]
                return false;
            }
        } else{
            return  greatesCommonDiv(temp,cnt)!=1?true:false;
        }

    }
    public int greatesCommonDiv(int a , int b){
        if(a<b){
            int tmp=a;
            a=b;
            b = tmp;
        }
        int remind;
        while(true){
            remind = a%b;
            if(remind==0){
                break;
            } else{
                a=b;
                b=remind;
            }
        }
        return b;
    }

}
