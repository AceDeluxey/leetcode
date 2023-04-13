/**
 * 1041. 困于环中的机器人
 * 其实原理不难，但是需要绕个弯
 * 就是只要一圈下来不朝向北，最终几次下来位移就会叠加回0,0
 * 只有一直朝向北方，才会叠加位移
 * 不然的话方向会变，位移的方向就抵消了
 * 0ms 100%
 *
 */
public class class1041 {
    public boolean isRobotBounded(String instructions) {
        int k =0 ;
        int []dist = new int[4];
        for (int i =0 ; i < instructions.length();i++){
            char c = instructions.charAt(i);
            if (c == 'L') {
                k=(k+1)%4;

            } else if(c=='R'){
                k=(k+3)%4;
            } else {
                ++dist[k];
            }
        }
        return (dist[0] == dist[2] && dist[1] == dist[3]) || (k != 0);
    }
}
