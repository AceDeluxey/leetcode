
/*
    1376. 通知所有员工所需的时间

    思路:
        带记忆的递归，遍历时去自底向上查找时间，最后求出遍历中的最大值
        因为对每个节点都向上遍历到顶，难免会有重复路径
        所以递归时，把每个节点到top的时间都记录在int []sinTimes 里
        遍历到节点时，先检查sinTimes，如果没有再递归

    第一次写的时候，忘记把值赋进sinTimes里，也就是没有记忆
        执行用时：1672 ms, 在所有 Java 提交中击败了5.59%的用户

    后来再加上，变成11ms 100%,足可以看出带记忆的递归可以节省很多时间
 */
public class class1376 {
    int []sinTimes ;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        sinTimes= new int[n];
        int max=0;
        for(int i=0; i<n;i++){   //遍历manager数组，都从下往上到top
            int temp=singleTime(i,n,headID,manager, informTime);
            max = max>temp ? max : temp;
        }
        return max;
    }
    public int singleTime(int index,int n, int headID, int[] manager, int[] informTime){
        if(manager[index]==-1){
            return 0;
        }
        int preIndex=manager[index];
        int thisTime =  informTime[preIndex];          //这个人到他直接上级的时间

        if(sinTimes[preIndex]==0){  //数组里没有再递归
            int thisToTopTime=thisTime+singleTime(preIndex,n,headID,manager, informTime);
            sinTimes[index]=thisToTopTime;  //把Index处到顶的时间记录到数组里
            return  thisToTopTime;
        } else{      //数组里有就直接用
            int thisToTopTime=thisTime+sinTimes[preIndex];
            sinTimes[index]=thisToTopTime;
            return thisToTopTime;
        }
    }
}
