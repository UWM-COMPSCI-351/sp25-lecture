package edu.uwm.cs351;

public class Queue<E> {
	private static final int INITIAL_CAPACITY=0;
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
		if(rear>front) return rear-front;	
		return queue.length-front+rear;
	}


	public void enqueue(E data) {
		ensureCapacity(size()+1);
		queue[(rear++)%queue.length] = data;
	}


	private void ensureCapacity(int cap) {
           if(queue.length>cap) return;
           int newsize=0;
           if(cap>queue.length*2) newsize=cap;
           else
        	   newsize = queue.length*2;
           E[] newQueue = makeArray(newsize);
           int cnt = 0;
           while(front!=rear) {
        	   newQueue[cnt++]= queue[front++];
           }
           front=0;
           rear= cnt;
           
	}


	public E front() {
		if(isEmpty()) throw new IllegalStateException("Empty Queue"); 
		return queue[front];
	}


	public E dequeue() {
		if(isEmpty()) throw new IllegalStateException("Empty Queue"); 
		return queue[front--];
	}

}
