package edu.uwm.cs351;

public class DynamicArrayBag implements Bag {
	private static final int INITIAL_CAPACITY = 1;
	private Coin[] data;
	private int used;
	
	public DynamicArrayBag() {
		data = new Coin[INITIAL_CAPACITY];
		used = 0;
	}

	private void ensureCapacity(int cap) {
		if (data.length >= cap) return;
		int newCap = data.length*2;
		if (newCap < cap) newCap = cap;
		Coin[] newData = new Coin[newCap];
		for (int i=0; i < used; ++i) {
			newData[i] = data[i];
		}
		data = newData;
	}

	@Override
	public boolean isEmpty() {
		return used == 0;
	}

	@Override
	public void add(Coin c) {
		ensureCapacity(used+1);
		data[used++] = c;
	}

	@Override
	public Coin remove() {
		if (used == 0) throw new IllegalArgumentException("bad is empty");
		Coin result = data[--used];
		data[used] = null; // optional clean up
		return result;
	}

	@Override
	public int removeAll(Coin p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
