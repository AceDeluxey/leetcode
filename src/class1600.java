import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *      1600. 皇位继承顺序
 *          一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 *          这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数Successor(x, curOrder)，给定一个人x和当前的继承顺序，该函数返回 x的下一继承人。
 *
 *      思路：题目意思就是继承顺序是王，儿1，孙1，孙2，儿3这样，如果我们要构建链表就要按照这样的顺序，
 *          ①如果先生了儿1，孙1，孙2，后生儿3，那么要把3插到孙2后面；②如果先生了儿3，那么要把孙1，孙2插到儿1，儿2后面。
 *          可以用last标识父亲的最后一个儿子，这样就能很轻易地满足②
 *          每个节点存到map里，节省遍历时间
 *
 *      307ms 93; 93M 100%
 */
//ThroneInheritance=class1600
public class class1600 {
    class node{
       String name;
       node next=null;
       node last=null;
       public node (String name){
           this.name = name;
       }
    }
    HashMap<String,node> map = new HashMap<>();
    node root;
    public class1600(String kingName) {
        root = new node(kingName);
        map.put(kingName,root);
    }

    public void birth(String parentName, String childName) {
        node parentNode = map.get(parentName);
        node childNode = new node(childName);
        node temp = parentNode;
        //找到父亲的最小儿子的最小儿子的...,因为先要遍历完前面所有才到
        while (temp.last != null){
            temp = temp.last;
        }
        childNode.next = temp.next;
        temp.next =childNode;
        map.put(childName,childNode);
        parentNode.last =childNode;
    }

    public void death(String name) {
        map.remove(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        node temp = root;
        while ( temp != null){
            if(map.containsKey(temp.name)){
                list.add(temp.name);
            }
            temp = temp.next;
        }
        return list;
    }
}
/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */