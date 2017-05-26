/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mansur Oshanov
 */

public class LLSet<T> implements Set<T> {

    private LLQueue<T> queue;

    public LLSet() {
        queue = new LLQueue<>();
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            queue.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < queue.getSize(); i++) {
            try {
                T bla = queue.dequeue();
                queue.enqueue(bla);
                if (bla.equals(value)) {
                    return true;
                }
            } catch (Exception ex) {
                //This shouldn't happen
            }
        }
        return false;
    }

    @Override
    public void remove(T value) {
        if (contains(value) == false) {
            
        } else {
            
            T temp = null;
            for (int i = 0; i < queue.getSize(); i++) {
                try {
                    temp = queue.dequeue();
                } catch (Exception ex) {
                    System.out.println();
                }
                if (temp.equals(value) == false) {
                    queue.enqueue(temp);
                }
            }
            
        }
    }

    @Override
    public T removeAny() throws Exception {

     
        if (queue.getSize() == 0) {
            throw new Exception("Trying to pop from the empty stack");
        } else {
            return queue.dequeue();
        }

    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue = new LLQueue<>();
    }

    public String toString() {
        return queue.toString();
    }

}
   

