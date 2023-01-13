package com.company;

public interface Queue<E> extends Iterable<E> {

    public void enqueue(E item); // add an item to the tail

    public E dequeue(); // remove and return the item located at the head

    public int size();

    public boolean isEmpty();

}
