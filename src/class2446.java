/**
 * 2446. 判断两个事件是否存在冲突
 * compareTo可以比object
 * 比string就是比大小
 * 如果a.compareTo a>b 1 ; a==b 0 ;a<b -1
 * 0ms 100%
 */
public class class2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        if(event1[1].compareTo(event2[0])<0){

        } else{
            if(event2[1].compareTo(event1[0])>=0){
                return true;
            }

        }
        return false;
    }
}
