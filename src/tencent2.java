import java.util.HashSet;

public class tencent2 {
    public static void main(String[] args) {
        tencent2 test = new tencent2();
        String[] list ={"ab","ca","ccb"};
        System.out.println(test.findNum(3,list));
    }
    int res =0 ;
    HashSet<String > set ;
    public int findNum(int N, String [] list) {
        set = new HashSet<>();
        boolean[] visited = new boolean[26];
        dfs(0,list,visited,"");
        return set.size();
    }
    private void dfs(int index,String[] list,boolean[] visited,String last)
    {
        if(index>=list.length){
            set.add(new String(last));
            return;
        }
        String s =  list[index];
        for(int i =0 ; i < s.length();i++){
            int n = s.charAt(i)-'a';
            if(!visited[n]){
                visited[n] = true;
                dfs(index+1, list, visited,last+s.charAt(i));
                visited[n] = false;
            }
        }
    }
}
