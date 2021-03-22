public class class134 {

        public int canCompleteCircuit(int[] gas, int[] cost) {

            int len=gas.length;
            int [] dif= new int [len];
            for (int i=0; i<len;i++){
                dif[i]=gas[i]-cost[i];
            }
            int flag =-1;
            for (int i=0;i<len;i++){

                if(dif[i]>=0){
                    int mid=dif[i];
                    int j;
                    for(j=1;j<len;j++){
                        mid = mid + dif[(i+j)%len];
                        if(mid <0){
                            break;
                        }
                    }
                    if(j==len){
                        flag=i;
                    }
                }

            }
            return flag;
        }

}
//    class134 test1=new class134();
//        int gas[] = {2,3,4};
//        int cost[] = {3,4,3};
//        System.out.println(test1.canCompleteCircuit(gas,cost));