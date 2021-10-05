/**
 *  284. 窥探迭代器
    请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。

    思路：因为java本身是有iterator的，就在原来的迭代器基础上加一个peek，也就是记录下当前peek的值就可以了

        4ms 100%
 */

import java.util.Iterator;
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    //当前Peek对应的值
    Integer now;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        now = iterator.next();
    }


    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return now;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = now;
        now = iterator.hasNext()?iterator.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return now != null;
    }
}



