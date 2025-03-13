package edu.uwm.cs351;

public interface Bag {
	/** Return whether the bad is empty */
	public boolean isEmpty();
	
	/** Add a coin to teh bag. */
	public void add(Coin c);
	
	/** Remove a coin (arbitrary) from the bag.
	 * The bag must not be empty
	 * @return coin from bag
	 * @throws llegalStateException if bag is empty.
	 */
	public Coin remove();
	
	/* Sample midterm question */
	
	/**
	 * remove all coins that match the pattern
	 * @param p pattern to match
	 * @return number of cons removed
	 */
	public int removeAll(Coin p);
}
