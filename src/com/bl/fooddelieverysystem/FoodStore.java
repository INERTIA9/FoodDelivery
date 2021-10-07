package com.bl.fooddelieverysystem;

// data layer // model layer
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FoodStore implements foodmethodinterface {
	private static FoodStore instance;

	Set<FoodItems> FoodList = new HashSet();

	private FoodStore() {

	}

	public static synchronized FoodStore getInstance() {
		if (instance == null) {
			instance = new FoodStore();
		}
		return instance;
	}

	public void add(FoodItems foodItems) {
		FoodList.add(foodItems);
	}

	public Set<FoodItems> getFoodList() {
		return FoodList;
	}

	public void remove(String foodName) {
		FoodList.remove(foodName);
	}

	public FoodItems getFood(String foodName) {
		return FoodList.stream().filter(fooditems -> foodName.equals(fooditems.itemname)).findFirst().orElse(null);
	}
}