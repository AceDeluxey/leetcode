import java.util.Stack;

public class classMax {
    public int histogram_max_area (int[] histogram) {
        // write code here

        int len = histogram.length;
        if(len==0){
            return 0;
        }
        int res =0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        res = histogram[0];
        for (int i =1;i<len;i++){
            while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[i]){
                int h = histogram[stack.pop()];
                int width=0;
                if(stack.size()==0){
                    width = i;
                } else{
                    width= i - stack.peek()-1;
                }

                res = Math.max(res,h*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h = histogram[stack.pop()];
            int width=0;
            if(stack.size()==0){
                width = len;
            } else{
                width= len - stack.peek()-1;
            }

            res = Math.max(res,h*width);
        }
        return res;
    }
}
