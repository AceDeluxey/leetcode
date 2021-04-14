
    /*
        941. 有效的山脉数组
        给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
        让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

       思路：双指针，两个指针分别找两边的第一个锋，如果第一个山峰重合，说明是山脉数组
        注释部分也是对的，不过写法不是很优雅，找两个锋写在了一个for里，不美观
        新的是重写的，不过没有提升到效率
       2ms 40.5%
     */
public class class941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int index= arr.length-1;
        int i;
        for(i=0;i<arr.length-1;i++){ //找左边起第一个锋
            if(arr[i]>arr[i+1]){
                break;
            } else if( arr[i]==arr[i+1]){
                return  false;
            }
        }
        for(;index>0;index--){  //找右边起第一个锋
            if(arr[index]>arr[index-1]){
                break;
            } else if( arr[index]==arr[index-1]){
                return  false;
            }
        }
        return index==i && index!=arr.length-1 && i!=0?true:false;  //排除递增序列和递减序列

//        if(arr.length < 3){
//            return false;
//        }
//        int index= arr.length-1;
//        int flag0=0;
//        int flag1=0;
//        for(int i=0;i<arr.length-1 && index>0;){
//            if(arr[i]<arr[i+1]){
//                i++;
//            } else {
//                flag0=1;
//                if(flag1==1){
//                    if(i==index){
//                        return true;
//                    } else{
//                        return  false;
//                    }
//                }
//            }
//            if(arr[index-1]>arr[index]){
//                index--;
//
//            } else {
//                flag1=1;
//                if(flag0==1){
//                    if(i==index){
//                        return true;
//                    } else{
//                        return  false;
//                    }
//                }
//            }
//        }
//        return false;
    }
}
