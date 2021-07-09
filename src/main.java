import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import DataStructure.ListNode;
import  DataStructure.TreeNode;
public class main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2019-01-03 10:59:27";
        Date date = simpleDateFormat.parse(dateStr);
        System.out.println(date);

        int []a={1,2,4};
        ListNode node1 = new ListNode(a);

        int []b={1,3,4};
        ListNode node2 = new ListNode(b);
        char c='中';
        class21 test = new class21();
        test.mergeTwoLists(node1,node2);
        //qxh
//        System.out.println((int)c);
//        class455 test = new class455();
//        class1510 test1 = new class1510();
////        System.out.println(test1.winnerSquareGame(15));
//        class1600 test3 = new class1600("king");
//        test3.birth("king","andy");
//        test3.birth("king","bob");
//        test3.birth("andy","s");
//        System.out.println(test3.getInheritanceOrder());
//        class870 test2 = new class870();
//        System.out.println(test2.advantageCount(a,b));
//        class1140 test = new class1140();
//        System.out.println(test.stoneGameII(a));


//        树的构造
//        Integer [] a={1,2,3};
//        TreeNode root1 =new TreeNode(a);
//        Integer [] b={1,3,2};
//        TreeNode root2 =new TreeNode(b);
//        class872 test1 = new class872();
//        System.out.println(test1.leafSimilar(root1,root2));

    }
}
