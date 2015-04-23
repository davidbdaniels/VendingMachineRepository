import VendingMachine.Drink;
import VendingMachine.Machine;

import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	private static int drinkSelected;
	private static int[] drinkQuantityRemaining;
	private static double amountReceived;
	private static double amountOwed;
	
	public static void main(String[] args) {
		String strMoney = "";
		String strDrink = "";
		String strExtra = "";
		double amountExtra = 0;
		
		Machine m = new Machine(4);
		
		m.availableDrinks[0] = new Drink("Coke", 1.75, 1);
		m.availableDrinks[1] = new Drink("Diet Coke", 1.75, 2);
		m.availableDrinks[2] = new Drink("Dr Pepper", 1.50, 3);
		m.availableDrinks[3] = new Drink("Sprite", 1.25, 4);
		
		drinkQuantityRemaining = new int[m.getNumberDrinkOptions()];
		
		for(int i=0; i < drinkQuantityRemaining.length; i++) {
			drinkQuantityRemaining[i] = m.getMaxDrinkStorage()/m.getNumberDrinkOptions();
			m.availableDrinks[i].setQuantityRemaining(drinkQuantityRemaining[i]);
		}
		
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			
			while((m.checkAvailability(m.availableDrinks[0]) == true) 
					|| (m.checkAvailability(m.availableDrinks[1]) == true)
					|| (m.checkAvailability(m.availableDrinks[2]) == true)
					|| (m.checkAvailability(m.availableDrinks[3]) == true)) {
				
				System.out.println("\n");
				System.out.println("***************************************");
				System.out.println("Welcome to the Virtual Vending Machine!");
				System.out.println("***************************************");
				System.out.println("The drink options for purchase are: \n");
				System.out.println(m);
				
				//State 0: Ready to start transaction by receiving money from user
				System.out.println("Please input the appropriate amount of money for the drink you wish to purchase: ");
				System.out.println("Enter '1' for 1 cent.");
				System.out.println("Enter '5' for 5 cents.");
				System.out.println("Enter '10' for 10 cents.");
				System.out.println("Enter '25' for 25 cents.");
				System.out.println("Enter '100' for 1 dollar.");
				System.out.println("Enter '500' for 5 dollars.");
				strMoney = br.readLine();
				System.out.println("You have entered " + strMoney + ".");
				
				//State 1: Ready to receive drink selection from user
				System.out.println("Please select a drink (1, 2, 3, or 4): ");
				strDrink = br.readLine();
				System.out.println("You have entered " + strDrink + ".");
				
				drinkSelected = Integer.parseInt(strDrink) - 1;	//i.e. Coke is selection 1 but index 0
				amountReceived = (Double.parseDouble(strMoney))/100;
				
				m.setDrinkCost(m.availableDrinks[drinkSelected].getPrice());
				m.setAmountReceived(amountReceived);
				amountOwed = m.calculateAmountOwed();
				
				System.out.println("You have selected " + m.availableDrinks[drinkSelected].getName() + ".");
				System.out.println("This drink costs $" + m.getDrinkCost() + ".");
				
				//State 2: Need more money from user
				while (amountOwed < 0) {
					System.out.println("Please input more money: ");
					strExtra = br.readLine();
					amountExtra = (Double.parseDouble(strExtra))/100;
					amountReceived = amountReceived + amountExtra;
					m.setAmountReceived(amountReceived);
					amountOwed = m.calculateAmountOwed();
				}
				
				//State 3: Dispensing in Process
				System.out.println("You have provided enough money for the drink you wish to purchase.");
				if (amountOwed == 0) {
					System.out.println("You did not receive any change.");
				}
				else {
					System.out.println("You received change in the amount of $" + amountOwed + ".");
				}
				
				//State 4: Transaction Complete
				System.out.println("One bottle of " + m.availableDrinks[drinkSelected].getName() + " has been successfully dispensed.");
				System.out.println("Thank you for your purchase.");
				
				drinkQuantityRemaining[drinkSelected] = drinkQuantityRemaining[drinkSelected] - 1;
				m.availableDrinks[drinkSelected].setQuantityRemaining(drinkQuantityRemaining[drinkSelected]);
				if (m.checkAvailability(m.availableDrinks[drinkSelected]) == false) {
					System.out.println(m.availableDrinks[drinkSelected].getName() + " is no longer in stock. Please choose another type of drink.");
				}
			}
			System.out.println("The vending machine is empty. Please restock all drinks and restart the machine.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
