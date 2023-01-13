package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeQueue<E> implements Queue<E> {

    private Node<E> head, tail;
    private int n;
    public NodeQueue(){
        n=0;
        head=null; tail=null;
    }

    @Override
    public void enqueue(E item) { //O(1)
        if(item == null)
            throw new IllegalArgumentException();
        if(isEmpty()){
            // i have a corner case
            tail = new Node<E>(item);
            head = tail;
        }else{
            Node<E> oldTail = tail;
            tail = new Node<E>(item);
            oldTail.setNext(tail);
        }
        n++;
    }

    @Override
    public E dequeue() { // O(1)
        if(isEmpty())
            throw new NoSuchElementException();
        E tmp = head.getItem();
        head = head.getNext();
        if(head == null){
            tail = null;
        }
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


    // to be done by the student
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}