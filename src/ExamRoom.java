import java.util.TreeSet;

/**
 * 855. 考场就座
 * 有序set
 * treeset
 * treeset的move是logn
 */
public class ExamRoom {

    int N;
    TreeSet<Integer> s ;
    public ExamRoom(int n) {
        this.N=n;
        s= new TreeSet<>();
    }

    public int seat() {
        int student =0 ;
        if( s.size()>0){
            //一开始试着坐0，距离就是s.first
            int dist = s.first();
            int prev =-1;
            for(int num:s){
                if(prev!=-1){
                    int d = (num-prev)/2;
                    if(d>dist){
                        dist =d ;
                        student=prev+d;
                    }
                }
                prev = num;
            }
            if(N-1-s.last()> dist){
                student=N-1;
            }
        }
        s.add(student);
        return student;
    }

    public void leave(int p) {
        s.remove(p);
    }
}
