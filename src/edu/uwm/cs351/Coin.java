package edu.uwm.cs351;

public class Coin {
	private final int value;
	private final int year;
	
	/** Create a coin with teh given value and year.
	 * @param v value, must be non-negative
	 * @param y year, must be positive
	 */
	public Coin(int v, int y) {
		if (v < 0) throw new IllegalArgumentException("bad value: " + v);
		if (y <= 0) throw new IllegalArgumentException("bad year; " + y);
		value = v;
		year = y;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getYear() {
		return year;
	}
	
	
	@Override // implementation
	public String toString() {
		return "Coin(" + value + ", " + year + ")";
	}
	
	/** Return true if this coin matches the one passed in:
	 * has the same value
	 * @param p pattern coin, if null then return false
	 * @return whether this coin has the same value as the pattern coin.
	 */
	public boolean match(Coin p) {
		if (p == null) return false;
		return value == p.value;
	}
}
