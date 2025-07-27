package ru.job4j.iterator;

import java.rmi.NotBoundException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length) {
            if (data[index]==null)
                index++;
            else return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return data[index++];
    }

    public static void main(String[] args) {
        NonNullIterator ob = new NonNullIterator(new Integer[]{1,null,2,null,null});
        while (ob.hasNext())
            System.out.println(ob.next());
    }


}
