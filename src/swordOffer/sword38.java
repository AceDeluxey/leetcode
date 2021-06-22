package swordOffer;

import java.util.HashSet;

/**
 *      剑指 Offer 38. 字符串的排列
          输入一个字符串，打印出该字符串中字符的所有排列
          你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *      思路：容易想到使用递归去做，那么就要让递归程序在递归中知道哪些用过，也就想到要用visited数组；
 *           然后用hashset去重
 *       62ms 13%
 */
public class sword38 {
    String[]  res ;
    HashSet<String> set = new HashSet<>();
    boolean [] visited ;
    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        DFS(s, 0, "");
        res = new String[set.size()];
        int index=0;
        for(String str : set){
            res[index] = str;
            index ++ ;
        }
        return res;
    }
    private void DFS(String s, int n, String last){
        if( n == s.length() ){
            set.add(last);
        }
        for( int i=0 ; i < s.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                String temp = last + s.charAt(i);
                DFS(s, n+1 , temp);
                visited[i] = false;
            }
        }
    }
}
