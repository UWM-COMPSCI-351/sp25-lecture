package edu.uwm.cs351;

import java.util.NoSuchElementException;

public class Queue<E> {
	private static final int INITIAL_CAPACITY=1;
	private E[] queue;
	private int front;
	private int rear;
	
	public Queue(){
		queue = makeArray(INITIAL_CAPACITY);
		front=0;
		rear=0;
	}
	
	
	@SuppressWarnings("unchecked")
	private E[] makeArray(int cap) {
		return (E[]) new Object[cap];
	}


	/**
	 * @return true is empty otherwise false
	 */
	public boolean isEmpty() {
		return front==rear;
	}

	/**
	 * @return the size of queue
	 */
	public int size() {
		if(rear>=front) return rear-front;	
		return queue.length-front+rear;
	}


	public void enqueue(E data) {
		if(data==null)throw new IllegalArgumentException("NUlls are not Allowed");
        System.out.println("BeQ"+front+" "+rear+"Size"+size());
		ensureCapacity(size()+1);

		queue[rear%queue.length] = data;
		rear++;
        System.out.println("AeQ"+front+" "+rear);

	}


	private void ensureCapacity(int cap) {
		    System.out.println("Length"+queue.length+"Cap"+cap);
           if(queue.length>=cap) return;
           int newsize=0;
           if(cap>queue.length*2) newsize=cap;
           else
        	   newsize = queue.length*2;
           E[] newQueue = makeArray(newsize);
           int size;
           if (rear >= front) {
               size = rear - front;
           }
          else {
               size = queue.length - front + rear;
          }
           for (int i = 0; i < size; i++) {
               newQueue[i] = queue[(front + i) % queue.length];
           }
           front = 0;
           rear = size;
           queue = newQueue;
	}


	public E front() {
		if(isEmpty()) throw new NoSuchElementException("Empty Queue"); 
		return queue[front];
	}


	public E dequeue() {
		if(isEmpty()) throw new IllegalStateException("Empty Queue"); 
		return queue[front++%queue.length];
	}

}
