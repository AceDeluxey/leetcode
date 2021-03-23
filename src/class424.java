//424. 替换后的最长重复字符
public class class424 {
    public int characterReplacement(String s, int k) {
        int base=0,mid=0,top=0;
        int change_num= 0;
        int cnt=0;
        int result=0;
        String temp=new String();
        for(int i=0;i<=s.length()+1;i++){
            if(result==s.length()){
                break;
            }
            int index=i%s.length();
            if(base==top || s.substring(index,index+1).equals(temp)  ){
                if(base==top){
                    temp=s.substring(base,base+1);
                }

                top=(top+1)%s.length();
                cnt++;
                if(cnt>result){
                    result=cnt;
                }
            } else{
                    if(k==0){
                        base=index;
                        top=index;
                        index--;
                        cnt=0;
                        change_num=0;
                    } else if(change_num==0 ){
                        cnt++;
                        top++;
                        if(cnt>result){
                            result=cnt;
                        }
                        mid=index;
                        change_num++;
                    } else if(change_num==k ){
                        i=mid;
                        base=mid;
                        top=mid;
                        if(cnt>result){
                            result=cnt;
                        }

                        change_num=0;
                        cnt=0;
                        continue;
                    } else{
                        cnt++;
                        top++;
                        if(index==s.length()-1){
                            if(cnt>result){
                                result=cnt;
                            }
                        }
                        change_num++;
                    }



            }
        }

        return result;
    }
}
