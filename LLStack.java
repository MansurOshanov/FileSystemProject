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
public class LLStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LLStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node(value);

        if (size == 0) {
            node.setLink(null);
        } else {
            node.setLink(top);
        }
        top = node;
        size++;
    }

    @Override
    public T pop() throws Exception {
        T val;
        if (size == 0) {
            throw new Exception("Trying to pop from the empty Stack");
        } else {
            val = top.getValue();
            top = top.getLink();
        }
        size--;
        return val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        String outp = "top[";
        Node<T> lnkPrint = top;
        while (lnkPrint != null) {

            outp += lnkPrint.getValue();
            if (lnkPrint.getLink() != null) {
                outp += ", ";
            }
            //for the last comma
            lnkPrint = lnkPrint.getLink();
        }
        outp += "]bottom";
        return outp + " Size is: " + size;
    }
}
