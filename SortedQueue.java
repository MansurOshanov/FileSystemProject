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
public interface SortedQueue<T extends Comparable> {

    /**
     * adds the element to the queue in a position that preserves the ordering
     * of the queue
     *
     * @param value element to be added to the queue
     */
    public void insert(T value);

    /**
     *
     * @return the front most value of the queue
     * @throws Exception if the queue is empty
     */
    public T dequeue() throws Exception;

    /**
     *
     * @return the size of the queue
     */
    public int getSize();

    /**
     * clears the queue and sets the size to zero
     */
    public void clear();

    /**
     *
     * @return the String representation of the sorted queue
     */
    @Override
    public String toString();
}
