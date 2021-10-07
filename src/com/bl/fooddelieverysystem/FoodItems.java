package com.bl.fooddelieverysystem;

import java.util.Objects;

public class FoodItems {
	enum Taste {
		SWEET, SOUR, SPICY
	};

	@Override
	public int hashCode() {
		return Objects.hash(itemname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItems other = (FoodItems) obj;
		return Objects.equals(itemname, other.itemname);
	}

	enum Category {
		MAINCOURSE, STARTER, DESSERT, SHAKES
	};

	enum Type {
		VEG, NON_VEG
	};

	protected Taste taste;
	protected Category category;
	private int price;
	protected Type type;
	protected String itemname;

	public int getPrice() {
		return price;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setPrice(int price) {
		this.price = price;

	}

	@Override
	public String toString() {
		return "FoodItems [taste=" + taste + ", category=" + category + ", price=" + price + ", type=" + type
				+ ", item name=" + itemname + "]";
	}

}
