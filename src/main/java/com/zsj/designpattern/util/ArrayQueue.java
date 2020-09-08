package com.zsj.designpattern.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<E> {
    List<E> list = new ArrayList<>();
    long count = 0;
    public void in(E data){
        this.list.add(data);
        count++;
    }

    public E out(){
        if (this.list.isEmpty()) {
            return null;
        }
        count --;
        return this.list.remove(0);
    }
}
