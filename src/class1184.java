public class class1184 {
    /**
     * 1184. 公交站间的距离
     * 这种循环的模拟起来还真有一点烦
     * 0ms 100%
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int z = 0, f = 0;
        boolean flag =false;
        if(start>destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int i = start;
        int len = distance.length;
        while(true){
            if(!flag ){
                z+=distance[i];
                if(i==(destination-1)%len){
                    flag = true;
                }


            }
            f+=distance[i];

            i=(i+1)%len;
            if(i==start){
                break;
            }
        }

        return Math.min(z,f-z);
    }
}
