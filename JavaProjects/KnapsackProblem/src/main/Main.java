package main;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void simulate(Knapsack knapsack) {
		System.out.println(knapsack);

		System.out.println("Greedy approach:");
		System.out.println(knapsack.greedySolve());

		System.out.println("Bottom-Up approach:");
		System.out.println(knapsack.bottomUp());
		
		System.out.println("Top-Down approach: ");
		System.out.println(knapsack.topDown());
	}

	public static void main(String[] args) {
		List<Item> items;
		Knapsack knapsack;

		System.out.println("Case 1: Greedy approach gives optimal solution\n");
		items = Arrays.asList(new Item(4, 12), new Item(2, 2), new Item(2, 1), new Item(1, 1), new Item(10, 4));
		knapsack = new Knapsack(items, 15);
		simulate(knapsack);

		System.out.println("----------------------------------------------");

		System.out.println("Case 2: Greedy approach doesn't give optimal solution\n");
		items = Arrays.asList(new Item(18, 30), new Item(10, 20), new Item(10, 20));
		knapsack = new Knapsack(items, 40);
		simulate(knapsack);

	}

}
