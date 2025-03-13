package edu.uwm.cs351;

public class LinkedListBag implements Bag {
	private static class Node {
		Node next;
		Coin data;
		
		Node(Coin d, Node n) { 
			data = d;
			next = n;
		}
	}
	
	private Node head;

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void add(Coin c) {
		head = new Node(c, head);
	}

	@Override
	public Coin remove() {
		if (isEmpty()) throw new IllegalStateException("bad is empty");
		Coin result = head.data;
		head = head.next;
		return result;
	}

	@Override
	public int removeAll(Coin p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
