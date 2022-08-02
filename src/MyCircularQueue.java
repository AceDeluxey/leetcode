/**
 * 622. 设计循环队列
 * 622. 设计循环队列
 * 比较简单 就是一个数组循环指针就可以了
 * 4ms 100%
 */
public class MyCircularQueue {
    int[] que;
    int frontIndex = 0;
    int rearIndex = 0;
    int num = 0;
    int len;
    public MyCircularQueue(int k) {
        que = new int[k];
        this.len=k;
    }

    public boolean enQueue(int value) {
        if(num==len){
            return false;
        } else{
            que[rearIndex]=value;
            rearIndex = (rearIndex+1)%len;
            num++;
        }
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        } else{
            frontIndex = (frontIndex+1)%len;
            num--;
            return true;
        }
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        } else{

            return que[frontIndex];
        }
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        } else{
            int index = rearIndex-1<0?len-1:rearIndex-1;
            return que[index];
        }
    }

    public boolean isEmpty() {
        return num==0;
    }

    public boolean isFull() {
        return num==len;
    }
}
