package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeStack<E> implements Stack<E> {

    private Node<E> head;
    private int n;

    public NodeStack(){
        n=0;
        head = null;
    }

    @Override
    public void push(E item) {
        if(item ==null)
            throw new IllegalArgumentException();
        Node<E> oldHead = head;
        head = new Node<E>(item);
        head.setNext(oldHead);
        n++;
    }

    @Override
    public E pop() {
        if(isEmpty())
            throw new NoSuchElementException();
        E tmp = head.getItem();
        head = head.getNext();
        n--;
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

        private Node<E> ptr = head;

        @Override
        public boolean hasNext() {
            return ptr != null;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E tmp = ptr.getItem();
            ptr = ptr.getNext();
            return tmp;
        }
    }
}