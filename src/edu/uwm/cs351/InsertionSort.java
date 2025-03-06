package edu.uwm.cs351;

import java.util.Comparator;

/** Insertion sort utility class. 
 * @param E element type
 */
public class InsertionSort<E> {
	private final Comparator<E> comparator;
	
	/**
	 * Initialize the utility using the given comparator
	 * @param comp comparator to use, must not be null
	 */
	public InsertionSort(Comparator<E> comp) {
		comparator = comp;
	}
	
	/**
	 * Sort the array.
	 * @param array to sort, must not be null
	 */
	public void sort(E[] array) {
		// Sort the array by placing elements in their correct places
		for(int currIdx = 1; currIdx< array.length;currIdx++) {
			//Create temporary variable for Current Index value
			E value = array[currIdx];
			int prevIdx = currIdx -1;
			/*Find the current place for a current value (value)
			Stop when we reach the starting position or the 
			previous element is smaller than the current
			*/
			while(prevIdx >=0 && comparator.compare(array[prevIdx],value)>0) {
				array[prevIdx+1] = array[prevIdx];
				prevIdx--;
			}
			//Place the value in the correct identified slot
			array[prevIdx+1] = value;
		}
/*
		if (array.length < 2) return;
		int u = 1;
		while (u < array.length) {
			E elem = array[u];
			int hole = u;
			while (hole >= 0 && comparator.compare(array[hole-1],elem) > 0) {
				array[hole] = array[hole-1];
				--hole;
			}
			++u;
		}
	*/
	}
}
