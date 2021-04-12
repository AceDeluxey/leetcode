/*
    179. 最大数
    给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
    注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

    思路: 将数组里的int转换成string，然后再比较两个string，然后排序
          思路很简单，但写的时候由于不知道两个string可以直接比较，也就是一位一位地比较
          导致重新实现了比较方法，但是对于前缀相同的两个数比如 432 43243不知道应该怎么比较了
          看答案发现Java有compareTo可以直接比较s1+s2和s2+s3
          缺陷就是1.比较有一半是自己写的 2.排序用的冒泡排序
          所以很慢
          16ms 8%
 */
public class class179 {
    public String largestNumber(int[] nums) {
        StringBuffer s= new StringBuffer();
        for(int i=0;i<nums.length-1 ;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(!leftGreaterRight(nums[j],nums[j+1])){
                    nums[j] = nums[j+1]+nums[j];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] = nums[j] - nums[j+1];
                }
            }
        }
        for(int n: nums){
            if(s.length()==0 && n==0){   //特殊情况前面有0不加入string
                continue;
            }
            s.append(n);
        }
        return s.length()>0?s.toString():"0";
    }
    private boolean leftGreaterRight(int num1, int num2){
        String s1=Integer.toString(num1);
        String s2=Integer.toString(num2);
        int min = Math.min(s1.length(), s2.length());
        for(int i = 0; i< min; i++){
            if(s1.charAt(i)>s2.charAt(i)){
                return true;
            } else if(s1.charAt(i)<s2.charAt(i)){
                return false;
            } else{
                if((s1+s2).compareTo(s2+s1)>0){
                    return true;
                } else{
                    return false;
                }

                //原来写的前缀相同的判断情况，有问题
//                if(i== (min -1)){
//                    if(s1.length() < s2.length()){
//                        for(int j=i+1;j<s2.length(); j++){
//                            if(s2.charAt(j)>s1.charAt(0)){
//                                return false;
//                            }
//                        }
//                        return true;
//                    } else if((s1.length() > s2.length())){
//                        for(int j=i+1;j<s1.length(); j++){
//                            if(s1.charAt(j)>s2.charAt(0)){
//                                return true;
//                            }
//                        }
//                        return false;
//                    } else{
//                        return false;
//                    }
//                }
            }
        }
        return false;
    }


//    private  int getNumLenght(int num){
//        num = num>0?num:-num;
//        return String.valueOf(num).length();
//    }
}
