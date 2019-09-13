package main;

import java.util.List;

public class Solution {

	private List<Item> items;
	private int value;

	public Solution(List<Item> items, int value) {
		this.items = items;
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Solution with value " + value + '\n');
		for (Item i : items) {
			b.append(i.toString() + '\n');
		}
		return b.toString();
	}
}
