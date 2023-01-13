package com.company;
public interface List<E> { // Abstract data type
    public void append(E item); // append an item to the end of the list

    public void insert(int index, E item); // insert an item at a given index in the list

    public int size();

    public boolean isEmpty();

    public E get(int index);

    public void set(int index, E item);

    public E remove(int index);

    public E remove(); // remove item located at the end of list
}

