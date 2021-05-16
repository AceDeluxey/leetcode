import java.util.HashSet;

/*
    403. 青蛙过河
    思路：1.暴力DFS，跳到每个石头后，试着条step+1,step-1,step步，看有没有石头；
            有石头就继续DFS，没有就返回false
            数据多会超时,参考了答案后，发现可以优化
            递归的主要冗余是在会重复经历某一个点，且这个点的上一步数是一样的，
            例如[0,1,2,3,4,5,999], 5(pos) 1(last)会多次遍历，
            所以就有了：
        2. 带有记忆的递归，也就是将每次遍历的pos,last对存储下来，下一次遍历到就直接返回，不用再遍历一次
            解答里用的是hashMap,但我始终不知道用map怎么行得通
            我自己用的是set，但要注意不能重复定义数组加入hashset里，因为地址不一样，就算是两个[5,1]也都可以加进去
            改用add string到set里才可以
                所以带记忆的递归其实就是用时间换空间


            35 ms 86.8%; 45M 55%
 */
public class class403 {
    HashSet<String> set =new HashSet<>();
    public boolean canCross(int[] stones) {
        if(stones.length<=1){
            return true;
        }
        if(stones[1]-stones[0]>1){  //特判
            return false;
        }
        return DFS(1,1,stones);

    }
    public boolean DFS(int pos,int lastStep,int []stones){
        String s=pos+" "+lastStep;
        if(!set.add(s)){
            return false;  //如果走过了，那直接false就可以，因为如果可以是true，之前走的也是true
        }
        if(pos == stones.length - 1){
           return true;
        }
        int index2=indexOfNextStone(pos,lastStep,stones);       //看三种走法能不能走到岩石上
        int index3=indexOfNextStone(pos,lastStep+1,stones);
        int index1=indexOfNextStone(pos,lastStep-1,stones);

        Boolean b1=false,b2=false,b3=false;
        if(index1!=-1){                //能走到就继续DFS
            b1=DFS(index1,lastStep-1,stones);
        }
        if(b1){
            return true;
        }
        if(index2!=-1){
            b2=DFS(index2,lastStep,stones);
        }
        if(b2){
            return true;
        }
        if(index3!=-1){
            b3=DFS(index3,lastStep+1,stones);
        }
        if(b3){
            return true;
        }
        return b1 || b2 || b3;
    }
    public int indexOfNextStone(int pos,int thisStep,int []stones){  //找这种走法嫩不能走到下一个岩石，返回岩石坐标
        if(thisStep<=0){ //走0步肯定到不了
            return -1;
        }
        int i=pos;
        while(i<stones.length && stones[i] <= stones[pos]+thisStep){
            if(stones[i] == stones[pos]+thisStep){
                return i;
            }
            i++;
        }
        return -1;
    }
}
