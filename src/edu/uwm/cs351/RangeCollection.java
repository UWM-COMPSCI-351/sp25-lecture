package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;

public class RangeCollection extends AbstractCollection<Integer> {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override //Required
	public int size() {
		return hi-lo;
	}

}
