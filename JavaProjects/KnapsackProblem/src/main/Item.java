package main;

public class Item {

	private int value;
	private int weight;
	private int identity;
	private static int id = 0;

	public Item(int val, int w) {
		this.value = val;
		this.weight = w;
		this.identity = id++;
	}
	
	public static void resetId() {
		id = 0;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "- Item " + identity + ": (Value: " + value + ", weight: " + weight + ")";
	}

}
