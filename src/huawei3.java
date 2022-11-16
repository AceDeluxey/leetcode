import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class huawei3 {
    public void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner scan = new Scanner(System.in);
//        String s = scan.next();
//        List<String> resverse = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//        int index =0;
//        //入栈
//        while(index<s.length()){
//            while(s.charAt(index)==' '){
//                index++;
//            }
//            int temp =index;
//            while(index<s.length() && !judge(s.charAt(index)) && !judgeKuohao(s.charAt(index))){
//                index++;
//            }
//            //变量
//            String variable = s.substring(temp,index);
//            if(!judgeZimu(variable.charAt(0))){
//                return ;
//            }
//            //变量入栈
//            resverse.add(variable);
//            if(index<s.length()){
//                char fu =s.charAt(index);
//                if(judge(fu)){
//                    //栈空 符号入栈
//                    if(stack.isEmpty()){
//                        stack.push(new String(String.valueOf(s.charAt(index))));
//                    } else{
//                        char top = stack.peek().charAt(0);
//                        if (judgeYouxian(fu, top)) {
//                            stack.push(String.valueOf(fu));
//                        } else{
//                            while(!stack.isEmpty() && judgeYouxian(fu, top)){
//                                resverse.add(stack.pop());
//                            }
//                            stack.push(String.valueOf(fu));
//                        }
//                    }
//                } else{
//                    if(fu=='('){
//                        stack.push((String.valueOf(s.charAt(index))));
//                    } else if(fu==')'){
//                        while(stack.peek()!= String.valueOf('(')){
//                            resverse.add(stack.pop());
//                        }
//                        stack.pop();
//                    }
//                }
//            }
//
//        }
//        Stack<TreeNode> stack2= new Stack<>();
//
//        for( int i =0 ; i<resverse.size();i++){
//            String temp1 = resverse.get(i);
//            if(temp1.length()==1 && judge(temp1.charAt(0))){
//                TreeNode node = new TreeNode(temp1);
//                node.right =  stack2.pop();
//                node.left = stack2.pop();
//            } else{
//                stack2.push(new TreeNode(resverse.get(i)));
//            }
//        }
//        TreeNode root  =stack2.pop();
        System.out.println("false");
    }
    public class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode(String s) {
            value=s;
        }

    }
    private static boolean judgeYouxian(char c1,char c2){
        if(c1=='*'||c1=='/'){
            if(c2=='+'||c2=='-'){
                return true;
            }
        }
        return false;
    }
    private static void printFalse(){
        System.out.println("false");
    }
    private static boolean judgeKuohao(char c){
        if(c=='(' || c==')'){
            return true;
        } else{
            return false;
        }
    }
    private static boolean judgeZimu(char c){
        if('a'<=c && c<='z'){
            return true;
        } else if('A'<=c && c<='Z'){
            return true;
        } else{
             return false;
        }
    }
    private static boolean judge(char c){
        //如果c是加减乘除返回true;
        if(c=='+' || c=='-' || c=='*' || c=='/'){
            return true;
        } else{
            return false;
        }
    }
}
