package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {

	private List<Item> items;
	private final int nbItems;
	private final int maxWeight;

	public Knapsack(List<Item> items, int maxWeight) {
		this.items = items;
		Item.resetId();
		this.nbItems = items.size();
		this.maxWeight = maxWeight;
	}

	public Solution greedySolve() {
		Collections.sort(items, (Item i1, Item i2) -> {
			double i1Ratio = (double) i1.getValue() / i1.getWeight();
			double i2Ratio = (double) i2.getValue() / i2.getWeight();
			if (i1Ratio < i2Ratio)
				return 1;
			if (i1Ratio > i2Ratio)
				return -1;
			return 0;
		});

		int maxValue = 0;
		List<Item> chosenItems = new ArrayList<>();
		int currentWeight = maxWeight;

		for (int i = 0; i < nbItems; ++i) {
			Item currentItem = items.get(i);
			if (currentItem.getWeight() <= currentWeight) {
				maxValue += currentItem.getValue();
				chosenItems.add(currentItem);
				currentWeight -= currentItem.getWeight();
			}
		}

		return new Solution(chosenItems, maxValue);
	}

	public Solution dynamicSolve() {
		int[][] bestValues = new int[nbItems + 1][maxWeight + 1];
		for (int i = 0; i <= maxWeight; ++i) {
			bestValues[0][i] = 0;
		}

		for (int i = 1; i <= nbItems; ++i) {
			Item currentItem = items.get(i - 1);
			for (int j = 0; j <= maxWeight; ++j) {
				if (currentItem.getWeight() > j) {
					bestValues[i][j] = bestValues[i - 1][j];
				} else {
					bestValues[i][j] = Math.max(bestValues[i - 1][j],
							bestValues[i - 1][j - currentItem.getWeight()] + currentItem.getValue());
				}
			}
		}

		int maxValue = bestValues[nbItems][maxWeight];
		int currentWeight = maxWeight;
		List<Item> chosenItems = new ArrayList<>();

		for (int i = nbItems; i > 0 && maxValue > 0; --i) {
			if (maxValue != bestValues[i - 1][currentWeight]) {
				Item currentItem = items.get(i - 1);
				maxValue -= currentItem.getValue();
				chosenItems.add(currentItem);
				currentWeight -= currentItem.getWeight();
			}
		}

		return new Solution(chosenItems, bestValues[nbItems][maxWeight]);
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("Knapsack\n");
		b.append("Capacity: " + maxWeight + '\n');
		for (Item i : items) {
			b.append(i.toString() + '\n');
		}
		return b.toString();
	}
}
