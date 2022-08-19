package main;

import java.util.ArrayList;

public class IceCream {

	private String ID;
	private String name;
	private String size;
	private ArrayList<Topping> topping = new ArrayList<>();
	private int price;

	public IceCream(String iD, String name, String size, int price) {
		super();
		ID = iD;
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void addTopping(String topp) {
		topping.add(new Topping(topp));
	}
	
	public void viewToping() {
		for(int i=0;i<topping.size();i++) {
			System.out.printf("%s",topping.get(i).getTopping());
		}
	}

	public ArrayList<Topping> getTopping() {
		return topping;
	}

	public void setTopping(ArrayList<Topping> topping) {
		this.topping = topping;
	}
	
	
}
