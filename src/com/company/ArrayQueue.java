package com.company;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E> {
    int head;
    int tail;
    int count;
    int n;
    private E[] items;

    public ArrayQueue() {
        items = (E[]) new Object[8];
        head = -1;
        tail = -1;
        n = 0;
    }

    @Override
    public void enqueue(E item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (head==tail && (tail!=-1 && head!=-1)) {
            resize(items.length*2);
        }
        else{
            if (head == -1) { // queue is empty
                head = 0;
                tail = 0;
            }

        }
        items[tail] = item;
        n++;
        tail = (tail + 1) % items.length;
    }

    @Override
    public E dequeue() {
        E item;
        if (head == -1)
            throw new ArrayIndexOutOfBoundsException();
        item = items[head];
        head = (head + 1) % items.length;
        // if it was only one element left
        if (tail == head) {
            head = -1;
            tail = -1;
        }

        if(n>2 && n == items.length/4)
            resize(items.length/2);
        n--;
        return item;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    public void resize(int newCapacity){
        E[] temp = (E[]) new Object[newCapacity];
        for(int i=head; i+1<n; i=(i+1)%(n)) {
            temp[i] = items[i];
            tail++;
        }
        items = temp;
    }

    private class myIterator implements Iterator<E>{
        int ptr = head; // head is located at n-1
        @Override
        public boolean hasNext() {
            return count<n;
        }

        @Override
        public E next() {
            E tmp = items[ptr];
            ptr=(ptr+1)%items.length;
            count++;
            return tmp;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new myIterator();
    }
}