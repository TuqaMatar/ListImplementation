package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {

    private E[] items;
    private int n;

    public ArrayStack(){
        items = (E[]) new Object[2];
        n = 0;
    }

    public void resize(int newCapacity){
        items = Arrays.copyOf(items, newCapacity);
    }

    @Override
    public void push(E item) {
        if(item == null)
            throw new IllegalArgumentException();
        if(n == items.length)
            resize(items.length * 2);
        items[n] = item;
        n++;
    }

    @Override
    public E pop() {
        if(isEmpty())
            throw new NoSuchElementException();
        E tmp = items[n-1]; // head od stack
        items[n-1] = null;
        n--;
        if(n>2 && n == items.length/4)
            resize(items.length/2);
        return tmp;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<E>{
        int ptr = n-1; // head is located at n-1

        @Override
        public boolean hasNext() {
            return ptr >= 0 ;
        }

        @Override
        public E next() {
            E tmp = items[ptr];
            ptr--;
            return tmp;
        }
    }
}