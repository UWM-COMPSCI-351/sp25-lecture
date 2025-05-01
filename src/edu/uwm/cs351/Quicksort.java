package edu.uwm.cs351;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Quicksort<E> {
	private final Comparator<E> comparator;
	
	public Quicksort(Comparator<E> c) {
		comparator = c;
	}
	
	/**
	 * Sort the collection (without changing it) and return a new sorted collection
	 * @param source collection to sort, must not be null
	 * @return sorted collection.
	 */
	public Collection<E> sort(Collection<E> source) {
		List<E> result = new ArrayList<E>(source);
		quickSort(result,0,result.size()-1);
		return result;
	}

	private void quickSort(List<E> result, int min, int max) {
		// TODO
	}

}
