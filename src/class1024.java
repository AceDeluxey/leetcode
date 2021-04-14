/*
        1024. 视频拼接
        你将会获得一系列视频片段，这些片段来自于一项持续时长为T秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
        视频片段clips[i]都用区间进行表示：开始于clips[i][0]并于clips[i][1]结束。我们甚至可以对这些片段自由地再剪辑，例如片段[0, 7]可以剪切成[0, 1] +[1, 3] + [3, 7]三部分。
        我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回-1

        思路：先将clip按照开始时间排序，对于相同的开始时间，我们将结束时间大的排在前面，因为很容易想到拿长的总数会少
        假设排完序后是[0,4],[0,3],[0,2],[0,1],[1,4],[2,6],[4,7],[5,7],[6,9],[6,8]
            首先要取第一块0,4，那么第二块的要求是开始时间要小于等于4; 且结束时间要在满足前一条件的情况下，最大
                根据这一要求，我们遍历[0,3],[0,2],[0,1],[1,4],[2,6],[4,7]，可以找到最大的是[4,7]
            同理取第三块的要求是，开始时间要小于等于7，找最大就是[6,9]
        本质是贪心的思想，每次找最大的。

         2ms 54.68%
 */
public class class1024 {
    public int videoStitching(int[][] clips, int T) {
        for(int i=0;i<clips.length-1;i++){  //冒泡排序
            for(int j=0;j< clips.length-1-i;j++){
                if(clips[j][0]>clips[j+1][0]){
                    int[] tenp=clips[j];
                    clips[j]=clips[j+1];
                    clips[j+1]=tenp;
                } else if(clips[j][0]==clips[j+1][0]){
                    if(clips[j][1]<clips[j+1][1]){
                        int[] tenp=clips[j];
                        clips[j]=clips[j+1];
                        clips[j+1]=tenp;
                    }
                }
            }
        }
        if(T==0){         //特判
            return  0;
        }
        if(clips[0][0]>0){  //最小时间>0, 肯定不合格
            return -1;
        }
        if(clips[0][0]==0 && clips[0][1]>=T){   //一块的情况
            return 1;
        }
        //排去特判，剩下的情况就是，第一块起始时间是0，且最大，所以这块必须取，直接cnt=1
        int cnt=1;

        for(int i=0;i< clips.length;i++){  //对于上一块取的，找它的下一块； 因为第一块一定取，所以i=0开始找
                                            //之后找的从index，即下一块开始找
            int index=-1;   //下一块的坐标
            for(int j=i+1;j< clips.length && clips[j][0]<=clips[i][1];j++){    //要满足下一块的起始时间小于等于上一块的结束时间
                if(  clips[i][1]< clips[j][1]){  //满足调教的下一块中找结束时间的最大值
                    if(index==-1){
                        index=j;
                    } else {
                        if(clips[j][1]>clips[index][1]){
                            index=j;   //找到最大值
                        }
                    }
                }
            }
            if(index==-1){  //等于-1，说明找不到下一块，且此时还没有>=T,所以剪辑不出来
                return -1;
            } else if(clips[index][1]<T){  //还不够T，还要继续找
                i=index-1;  //下一次是从index开始找，-1是因为for循环结束时要+1
                cnt++;
            } else{         //找到了，最后时间够T，返回cnt
                return  cnt+1;
            }

        }
        return cnt;
    }
}
//    class1024 test=new class1024();
//
//    int [][] maze={{0,1}, {6,8}, {0,2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7},
//            {6, 9}};
//    System.out.println( test.videoStitching(maze,9));