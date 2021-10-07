package com.bl.fooddelieverysystem;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

// controller Layer
public class Application {

	public static void main(String[] args) {

		UserInterface userinterface = UserInterface.getInstance();
		userinterface.showUserMenu();
	}

	public void HandleUserSelection(int n) {
		Scanner sc = new Scanner(System.in);
		FoodStore foodstore = FoodStore.getInstance();
		UserInterface userinterface = UserInterface.getInstance();
		FoodItems fooditem = new FoodItems();

		switch (n) {
		case 1:
			fooditem = userinterface.creatingfoodItem();
			foodstore.add(fooditem);
			break;

		case 2:

			System.out.println("Enter the name which you want to remove:");
			String foodName = sc.nextLine();
			foodstore.remove(foodName);

			break;

		case 3:
			userinterface.display(foodstore.getFoodList());
			break;

		case 4:
			Scanner ss = new Scanner(System.in);
			System.out.println("Enter the item which you want to edit:");
			String editName = ss.nextLine();

			try {
				fooditem = foodstore.getFood(editName);
				if (fooditem == null) {
					throw new NoSuchElementException();
				} else {
					userinterface.edit(fooditem);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Item is Not Present in the List!");
			}

			break;
		}
	}
}
