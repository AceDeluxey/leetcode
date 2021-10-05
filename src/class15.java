import java.util.*;

// TIps:使用的是二重循环+MAP，参考的思想是求数组中两数之和，但是后续去重很麻烦
//去重的时候，先把三个数字的数组排序放入hashset，放得进去说明没重复，再放进List

/**
 15. 三数之和
    思路：参考了题解的排序+双指针，很巧妙
        排序，对于Num[i]如果，大于0，那么在后面不能找到三个数
            如果小于0，那么让left=i+1,right=length-1,逐步从两边向内移动指针，大了移动右边，小了移动左边

        19ms 96%  On2
 */
public class class15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 || nums.length - i <= 2) {
                return result;
            } else {
                //两个一样的数也不用判断
                if(i > 0 && nums[i] == nums[i-1]) continue;


                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> temp = new LinkedList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;


                    } else {
                        left++;

                    }
                }
            }
        }
        return result;
    }


    //超时
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list=new ArrayList<> ();
//
//        HashSet<String> list2=new HashSet<> ();
//        TreeMap<Integer,String> map = new TreeMap<>();
//        for (int i=0;i<nums.length;i++){  //构造键值可重复的哈希set
//            String str = Integer.toString(i);
//            if(map.get(nums[i])!=null){
//                String temp=map.get(nums[i]);
//                String temp1= Integer.toString(i);
//                temp = temp +" "+temp1;
//                map.put(nums[i], temp);
//            }else{
//                map.put(nums[i], str);
//            };
//        }
//        System.out.println(map);
//
//        //二重循环遍历，第三层循环使用hashmap
////        List<HashSet<Integer>> setList=new ArrayList<>();
//
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
////                HashSet res = new HashSet();
////                List<Integer> res=new ArrayList<>();
//                   int [] res =new int [3];
//                    int t=0-nums[i]-nums[j];
//                    String temp=map.get(t);
//                    int flag=1;
//                    if( temp !=null){
//                        String[] splitstring =  temp.split("\\ ");
//                        for( String k:splitstring){
//                                int a=Integer.parseInt(k);
//                                if(a==i || a==j){
//                                    flag=0;
//                                    break;
//                                }
//                                res[0]=nums[i];
//                                res[1]=nums[j];
//                                res[2]=t;
//
//                                break;
//                        }
//
//                    }else{
//                        break;
//                    }
//                    if(res.length> 0 && flag==1){
//                        Arrays.sort(res);
//                        if(list2.add(Arrays.toString(res))){
//                            List<Integer> res2=new ArrayList<>();
//                            res2.add(res[0]);
//                            res2.add(res[1]);
//                            res2.add(res[2]);
//                            list.add(res2);
//                        };
//                    }
//
//            }
//        }
//        System.out.println(list2);
//        return list;
//    }
}
