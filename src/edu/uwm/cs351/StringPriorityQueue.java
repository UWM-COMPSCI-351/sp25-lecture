package edu.uwm.cs351;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StringPriorityQueue {
	List<String> heap = new ArrayList<>();
	
	private void siftUp(int from) {
		String value = heap.get(from);
		while (from != 0) {
			int front = (from - 1) / 2;
			String other = heap.get(front);
			if (other.compareTo(value) > 0) {
				heap.set(front, value);
				heap.set(from, other);
				from = front;
			} else {
				break;
			}
		}
	}
	
	/**
	 * Add a string to the pq
	 * @param x string to add, must not be null
	 * @return true
	 */
	public boolean add(String x) {
		heap.add(x);
		siftUp(heap.size()-1);
		return true;
	}

	/**
	 * Remove and return the first string alphabetically.
	 * @return first string
	 */
	public String remove() {
		if (isEmpty()) throw new NoSuchElementException("no more");
		String result = heap.get(0);
		String last = heap.remove(heap.size()-1);
		heap.set(0, last);
		// TODO: siftDown
		return result;
	}
	
	/**
	 * Check whether the pq is empty.
	 * @return whether it is empty.
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
}
