package com.company;

public interface Stack<E> extends Iterable<E> {
    public void push(E item); // add an item to the head
    public E pop(); // remove and return the item located at the head
    public int size();
    public boolean isEmpty();

    // fifth method
}