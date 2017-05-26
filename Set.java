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
interface Set<T> {

    public void add(T value);

    public boolean contains(T value);

    public void remove(T value);

    public T removeAny() throws Exception;

    public int getSize();

    public void clear();

    public String toString();

}
