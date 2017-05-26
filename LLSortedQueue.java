/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Mansur Oshanov
 */
public class LLSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private Node<T> front;
    private int size;

    public LLSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {
        Node<T> n = new Node(value);
        if (size == 0) {
            front = n;
        } else {
            //newNode goes before front
            if (value.compareTo(front.getValue()) <= 0) {
                n.setLink(front);
                front = n;
            } //newNode goes somewhere in the middle
            else {
                Node<T> curr = front.getLink();
                Node<T> prev = front;

                while (curr != null && value.compareTo(curr.getValue()) >= 0) {

                    prev = prev.getLink();
                    curr = curr.getLink();

                }
                prev.setLink(n);
                n.setLink(curr);
            }

        }
        //newNode added to the end
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("The queue is empty!");
        }

        T result = front.getValue();
        front = front.getLink();
        size--;

        if (size == 0) {
            front = null;
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;

        size = 0;
    }

    @Override
    public String toString() {
        String result = "The size of the queue is " + size
                + " and the values in the queue:\n";
        Node<T> curr = front;
        while (curr != null) {
            result = result + curr.toString() + " ";
            curr = curr.getLink();
        }
        return result;
    }
}
