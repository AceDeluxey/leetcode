/*
    1140. 石子游戏 II
    想错了，没有考虑lee的水平最高
 */

public class class1140 {

    int memory [][];
    public int stoneGameII(int[] piles) {
        int max=0;
        memory = new int[piles.length][piles.length];
        for( int i=1; i<=2;i++){
            max=Math.max(max,search(i,0,piles,1));
        }
        return max;
    }
    private int search(int thisNum,int startIndex,int [] piles,int M){
        System.out.print(thisNum);
        System.out.print(' ');
        System.out.println(startIndex);
        int sum=0;
        int max=0;
        int i;
        for(  i=0; i<thisNum;i++){
            sum+=piles[startIndex+i];
        }
        max=Math.max(max, sum);
        startIndex+=thisNum;

        M=Math.max(thisNum,M);
        int j,k;
        for( j=1;j<=2*M && startIndex+j<=piles.length; j++ ){
            int M2=Math.max(j,M);
            for(  k=1;k<2*M2 && startIndex+j+k<=piles.length; k++){
                if(memory[startIndex+j][k]!=0){
                    max=Math.max(max,sum+memory[startIndex+j][k]);
                } else{
                    max=Math.max(max,sum+search(k,startIndex+j,piles,M2));
                }
            }
        }
        return max;
    }
}
