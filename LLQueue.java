/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Mansur Oshanov
 * @param <T>
 */
public class LLQueue<T> implements Queue<T>{

    private Node<T> front;
    private Node<T> back;
    private int size;
   
    public LLQueue(){
        front = null;
        back = null;
        size = 0;
    }
  
    @Override
    public void enqueue(T value) {
        Node<T> n = new Node(value);
         
        if(size==0){
       
            front = back = n;
        
      size++;}else{
        back.setLink(n);
        back=n;
        size++;
        
        }
        
    }

    @Override
    public T dequeue() throws Exception {
        
        if(size == 0){
            throw new Exception("The queue is empty!");
        }
      
        T result = front.getValue();
        front = front.getLink();
        size--;
        
        if(size == 0){
           front = back = null; 
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
        back = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result=" ";
         Node<T> curr=front;
         for(int i=0;i<size;i++){
              result+=curr.getValue()+" ";
              curr=curr.getLink();
          }  
          return result;
    }
}
