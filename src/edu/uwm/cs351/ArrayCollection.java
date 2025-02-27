package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<E> extends AbstractCollection<E> {
     private final int INITIAL_CAPACITY = 1; 
	 @SuppressWarnings("unchecked")
	private E[] makeArray(int cap) {
		return (E[]) new Object[cap];
	}

	@Override //Efficiency
	public void clear() {
		 data = makeArray(INITIAL_CAPACITY);
		 if(manyItems!=0) {
			 manyItems = 0;
			 version++;
		 }
	}

	E[] data;
	int manyItems;
	int version;
	 /**
	  * Return the element at given index
	  * @param index
	  * @return
	  */
	 // Implementation
	 public E getData(int index) {
		 return data[index];
	}
	@Override //Implementation
	public boolean add(E e) {
		ensureCapacity(manyItems+1);
		data[manyItems] = e;
		manyItems++;
		version++;
		return true;
	}
	
	@Override //Required
	public int size() {
		return manyItems;
	}
	private void ensureCapacity(int cap) {
		if(data.length > cap) return;
        int newSize = cap; 
		if(data.length*2 < cap) newSize = data.length*2;
		E[] newData = makeArray(newSize);
		for(int i=0;i<manyItems;i++) {
			newData[i]= data[i];
		}
	}
	public ArrayCollection() {
		 data = makeArray(INITIAL_CAPACITY);
		 manyItems = 0;
		 version =0;
	 }
	@Override //Required
	public Iterator<E> iterator() {
		return new myIterator();
	}
	
	private class myIterator implements Iterator<E>{
        int currentIndex;
        boolean canRemove;
        int colVersion;
        
        private void checkVersion() {
        	if(colVersion!=version) throw new ConcurrentModificationException("Stale State");
        }
        myIterator(){
        	currentIndex  = -1;
        	canRemove = false;
        	colVersion = version;
        }
		@Override //Required
		public boolean hasNext() {
			checkVersion();
			return (canRemove?currentIndex+1:currentIndex)<manyItems;
		}

		@Override //Required
		public E next() {
			checkVersion();
			canRemove = true;
			return data[++currentIndex];
		}
		@Override //Implementation
		public void remove() {
			if(!canRemove) throw new NoSuchElementException("Can't Remove");
			 for(int index = currentIndex+1;index < manyItems;index++) {
				 data[index-1] = data[index];
			 }
			 --manyItems;
			 ++colVersion;
			 canRemove = false;
		}
		
	}

}
