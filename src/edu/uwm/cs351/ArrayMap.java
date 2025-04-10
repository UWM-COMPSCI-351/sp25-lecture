package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<E> extends AbstractMap<Integer,E> {
	private final E[] array;
	
	public ArrayMap(E[] a) {
		array = a;
	}
	
	@Override // required
	public Set<Entry<Integer, E>> entrySet() {
		return new AbstractSet<Entry<Integer,E>>() {

			@Override // required
			public Iterator<Entry<Integer, E>> iterator() {
				return new Iterator<Entry<Integer, E>>() {
					int index=-1;
					@Override // required
					public boolean hasNext() {
						return (index+1)< array.length;
					}

					@Override // required
					public Entry<Integer, E> next() {
						if (!hasNext()) throw new NoSuchElementException("no more");
						++index;
						return new AbstractEntry<Integer,E>() {

							@Override // required
							public Integer getKey() {
								return index;
							}

							@Override // required
							public E getValue() {
								return array[index];
							}
							
						};
					}
					
				};
			}

			@Override // required
			public int size() {
				return array.length;
			}
			
		};
	}

	@Override
	public E put(Integer key, E value) {
		E oldValue = array[key];
		array[key] = value;
		return oldValue;
	}
	
	

}
