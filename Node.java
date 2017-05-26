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
public class Node<T> {

    private T value;
    private Node<T> link;

    public Node(T value) {
        this.value = value;
        link = null;
    }

    ;
    
    public T getValue() {
        return this.value;
    }

    ;
    
    public void setValue(T value) {
        this.value = value;
    }

    ;  
    
    public Node<T> getLink() {
        return this.link;
    }

    ; 
    
    public void setLink(Node<T> link) {
        this.link = link;
    }

    ;
    
    @Override
    public String toString() {
        return this.value.toString();
    }

}
