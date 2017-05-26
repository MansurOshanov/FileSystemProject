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
public interface Queue<T> {

    public void enqueue(T value);

    public T dequeue() throws Exception;

    public int getSize();

    public void clear();

    public String toString();

}
