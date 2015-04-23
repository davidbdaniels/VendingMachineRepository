package VendingMachine;

import VendingMachine.Drink;

public class Machine {
	private final int maxDrinkStorage = 80;
	
	public Drink[] availableDrinks;
	
	private int numberDrinkOptions;
	private double amountReceived;
	private double amountOwed;
	private double drinkCost;

	private boolean isAcceptingDollars;
	private boolean isAcceptingCoins;
	
	public Machine() {
		numberDrinkOptions = 4;
		availableDrinks = new Drink[numberDrinkOptions];
		
		isAcceptingDollars = true;
		isAcceptingCoins = true;
	}
	
	public Machine(int options) {
		numberDrinkOptions = options;
		availableDrinks = new Drink[numberDrinkOptions];
		
		isAcceptingDollars = true;
		isAcceptingCoins = true;
	}
	
	public double calculateAmountOwed() {
		amountOwed = amountReceived - drinkCost;
		return amountOwed;
	}
	
	public boolean checkAvailability(Drink d) {
		if (d.getQuantityRemaining() > 0) {
			d.setIsInStock(true);
			return true;
		}
		else {
			d.setIsInStock(false);
			return false;
		}
	}
	
	public int getMaxDrinkStorage() {
		return maxDrinkStorage;
	}

	public int getNumberDrinkOptions() {
		return numberDrinkOptions;
	}
	
	public double getAmountReceived() {
		return amountReceived;
	}

	public double getAmountOwed() {
		return amountOwed;
	}

	public double getDrinkCost() {
		return drinkCost;
	}

	public boolean getIsAcceptingDollars() {
		return isAcceptingDollars;
	}
	
	public boolean getIsAcceptingCoins() {
		return isAcceptingCoins;
	}

	public void setNumberDrinkOptions(int numberDrinkOptions) {
		this.numberDrinkOptions = numberDrinkOptions;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public void setAmountOwed(double amountOwed) {
		this.amountOwed = amountOwed;
	}

	public void setDrinkCost(double drinkCost) {
		this.drinkCost = drinkCost;
	}

	public void setIsAcceptingDollars(boolean isAcceptingDollars) {
		this.isAcceptingDollars = isAcceptingDollars;
	}
	
	public void setIsAcceptingCoins(boolean isAcceptingCoins) {
		this.isAcceptingCoins = isAcceptingCoins;
	}
	
	public String toString() {
		String output = "";
		int i;
		
		if (availableDrinks.length > 0) {
			for (i=0; i < availableDrinks.length; i++) {
				if(availableDrinks[i].getIsInStock() == true) {
					output += availableDrinks[i].toString() + "\n";
				}
			}
		}
		else {
			output = "There are no drinks currently available in this vending machine.";
		}
		
		return output;
	}
}
