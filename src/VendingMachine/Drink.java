package VendingMachine;

public class Drink {
	private String name;
	private double price;
	private int index;
	private int quantityRemaining;
	private boolean isInStock;
	
	public Drink () {
		name = "";
		price = 0.00;
		index = 0;
		isInStock = false;
	}
	
	public Drink (String drinkName, double drinkPrice, int selectionNumber){
		name = drinkName;
		price = drinkPrice;
		index = selectionNumber;
		isInStock = true;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getQuantityRemaining() {
		return quantityRemaining;
	}
	
	public boolean getIsInStock() {
		return isInStock;
	}

	public void setName(String drinkName) {
		name = drinkName;
	}
	
	public void setPrice(double drinkPrice) {
		price = drinkPrice;
	}
	
	public void setIndex(int selectionNumber) {
		index = selectionNumber;
	}
	
	public void setQuantityRemaining(int drinkQuantityRemaining) {
		quantityRemaining = drinkQuantityRemaining;
	}

	public void setIsInStock(boolean drinkIsInStock) {
		isInStock = drinkIsInStock;
	}
	
	public String toString() {
		String output;
		output = "Name: " + name + "\n" + "Price: $" + price + "\n" + "Selection Number: " + index + "\n";
		return output;
	}
}
