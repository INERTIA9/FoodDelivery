package com.bl.fooddelieverysystem;

import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;

// view layer
public class UserInterface {
	public static UserInterface instance;

	public UserInterface() {

	}

	public static synchronized UserInterface getInstance() {
		if (instance == null) {
			instance = new UserInterface();
		}
		return instance;
	}

	public void display(Set<FoodItems> foodList) {
//		for (int i = 0;is i < foodList.size(); i++) {
//			System.out.println(foodList.get(i) + "\n");
//		}
		// foodList.stream().forEach(fooditems -> System.out.println(fooditems));
		foodList.forEach(System.out::println);
	}

	public FoodItems creatingfoodItem() {
		FoodItems fooditems = new FoodItems();
		FoodStore foodstore = FoodStore.getInstance();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the FoodItem to add");
		fooditems.itemname = sc.nextLine();
		System.out.println("Enter Your Preferred Tatse 1.SWEET, 2.SOUR, 3.SPICY");
		int tastechoice = sc.nextInt();
		switch (tastechoice) {
		case 1:
			fooditems.setTaste(FoodItems.Taste.SWEET);
			break;
		case 2:
			fooditems.setTaste(FoodItems.Taste.SOUR);
			break;
		case 3:
			fooditems.setTaste(FoodItems.Taste.SPICY);
			break;
		}

		System.out.println("Enter Your Preferred category you want 1.Starters 2.MainCourse 3.Shakes");
		int categorytype = sc.nextInt();
		switch (categorytype) {
		case 1:
			fooditems.setCategory(FoodItems.Category.STARTER);
			break;
		case 2:
			fooditems.setCategory(FoodItems.Category.MAINCOURSE);
			break;
		case 3:
			fooditems.setCategory(FoodItems.Category.SHAKES);

			break;

		}
		System.out.println("Enter Your Preferred type  1.veg 2.non veg");
		int type = sc.nextInt();
		switch (type) {
		case 1:
			fooditems.setType(FoodItems.Type.VEG);
			break;
		case 2:
			fooditems.setType(FoodItems.Type.NON_VEG);
			break;

		}

		System.out.println("Enter the price");
		int price = sc.nextInt();
		fooditems.setPrice(price);
		return fooditems;

	}

	public FoodItems edit(FoodItems fooditems) {

		FoodStore foodstore = FoodStore.getInstance();
		Scanner sc = new Scanner(System.in);

		System.out.println("What Specifications you want to edit: 1.Taste 2.Category 3 .Type 4.price");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:

			System.out.println("Enter the Preferred taste 1.Sweet 2.Sour 3.Spicy");
			int taste = sc.nextInt();
			if (taste == 1) {
				fooditems.setTaste(FoodItems.Taste.SWEET);
			} else if (taste == 2) {
				fooditems.setTaste(FoodItems.Taste.SOUR);
			} else if (taste == 3) {
				fooditems.setTaste(FoodItems.Taste.SPICY);

			} else {
				System.out.println("Invalid choice");
			}
			break;
		case 2:
			System.out.println("Enter the Preferred Category 1.Starter 2.Maincourse 3.Shakes");
			int category = sc.nextInt();
			if (category == 1) {
				fooditems.setCategory(FoodItems.Category.STARTER);
			} else if (category == 2) {
				fooditems.setCategory(FoodItems.Category.MAINCOURSE);

			} else if (category == 3) {
				fooditems.setCategory(FoodItems.Category.SHAKES);
			} else {
				System.out.println("Invalid choice");
			}
			break;
		case 3:
			System.out.println("Enter the Preferred Type 1.Veg 2.NonVeg ");
			int type = sc.nextInt();
			if (type == 1) {
				fooditems.setType(FoodItems.Type.VEG);
			} else if (type == 2) {
				fooditems.setType(FoodItems.Type.NON_VEG);
			} else {
				System.out.println("Invalid choice");
			}
			break;
		case 4:
			System.out.println("Enter price");
			int price = sc.nextInt();
			fooditems.setPrice(price);
			break;
		}
		return fooditems;
	}

	public void showUserMenu() {
		Scanner sc = new Scanner(System.in);
		// String again;
		int n = 0;
		int exitvalue = 5;
		Application application = new Application();

		while (n != exitvalue) {
			System.out.println("Press 1 for Adding FoodItem");
			System.out.println("press 2 for Removing FoodItem");
			System.out.println("Press 3 for Printing FoodItem");
			System.out.println("Press 4 for Editing FoodItem");
			System.out.println("Press" + " " + exitvalue + " for exiting");
			n = sc.nextInt();
			application.HandleUserSelection(n);
		}
	}
}