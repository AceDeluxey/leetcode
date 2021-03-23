//42. 接雨水
//2021. 3.23 写了个死循环检验程序状态，但是这个死循环条件难以斟酌，数据较大时超时
public class class42 {
    public int trap(int[] height) {

        int base=0,vol=0;
        int cnt=9;
        if(height.length ==0||height.length ==1){
            vol =0;
        } else{
            while(true){
                cnt=0;
                base=-1;
                for (int i=0;i<height.length; i++){
                    if(base !=-1 && height[i]>0){
                        vol+= i-base-1;
                    }
                    if(height[i]>0){
                        base=i;
                    }

                    if(--height[i]>0){
                        cnt++;
                    }

                }
                if(cnt<=1){
                    break;
                }
            }
        }



        return vol;
    }
}
