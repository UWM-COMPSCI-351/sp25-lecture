package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;

public class RangeCollection extends AbstractCollection<Integer> {
    
		@Override    //Efficiency
 	public boolean contains(Object o) {
		if(!(o instanceof Integer)) return false;
		Integer x = (Integer)o;
		return lo <=x && x < hi;
	}
  
	private final int hi, lo;
	/**
	 * Initiate a range collection from lo to hi
	 * @param lo is lower inclusive limit
	 * @param hi is upper exclusive limit
	 */
	public RangeCollection(int lo, int hi) {
		this.hi = hi;
		this.lo = lo;
	}

	@Override //Required
	public Iterator<Integer> iterator() {
		return new myIterator();
	}

	@Override //Required
	public int size() {
		return hi-lo;
	}

	private class myIterator implements Iterator<Integer>{
        private int current = lo-1;
		@Override //Required 
		public boolean hasNext() {
			return current + 1< hi;
		}

		@Override //Required
		public Integer next() {
			current++;
			return current;
		}
		
	}
}
