import java.util.*;
// TIps:使用的是二重循环+MAP，参考的思想是求数组中两数之和，但是后续去重很麻烦
//去重的时候，先把三个数字的数组排序放入hashset，放得进去说明没重复，再放进List
public class class15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<> ();

        HashSet<String> list2=new HashSet<> ();
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i=0;i<nums.length;i++){  //构造键值可重复的哈希set
            String str = Integer.toString(i);
            if(map.get(nums[i])!=null){
                String temp=map.get(nums[i]);
                String temp1= Integer.toString(i);
                temp = temp +" "+temp1;
                map.put(nums[i], temp);
            }else{
                map.put(nums[i], str);
            };
        }
        System.out.println(map);

        //二重循环遍历，第三层循环使用hashmap
//        List<HashSet<Integer>> setList=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
//                HashSet res = new HashSet();
//                List<Integer> res=new ArrayList<>();
                   int [] res =new int [3];
                    int t=0-nums[i]-nums[j];
                    String temp=map.get(t);
                    int flag=1;
                    if( temp !=null){
                        String[] splitstring =  temp.split("\\ ");
                        for( String k:splitstring){
                                int a=Integer.parseInt(k);
                                if(a==i || a==j){
                                    flag=0;
                                    break;
                                }
                                res[0]=nums[i];
                                res[1]=nums[j];
                                res[2]=t;

                                break;
                        }

                    }else{
                        break;
                    }
                    if(res.length> 0 && flag==1){
                        Arrays.sort(res);
                        if(list2.add(Arrays.toString(res))){
                            List<Integer> res2=new ArrayList<>();
                            res2.add(res[0]);
                            res2.add(res[1]);
                            res2.add(res[2]);
                            list.add(res2);
                        };
                    }

            }
        }
        System.out.println(list2);
        return list;
    }
}
