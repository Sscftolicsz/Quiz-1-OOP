package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<IceCream> icecream = new ArrayList<>();
	Random r = new Random();

	public void cls() {
		for(int i=0;i<27;i++) {
			System.out.println("");
		}
	}
	
	public void view() {
		if(icecream.isEmpty()) {
			System.out.println("No Ice Cream");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			return;
		}else {
			System.out.println("============================================================================================================");
			System.out.println("| ID    | Name                            | Size       | Toppings                           | Price        |");
			System.out.println("============================================================================================================");
			for(int i=0;i<icecream.size();i++) {
				System.out.printf("| %-6s| %-32s| %-11s| %-35s| %-13d|\n", icecream.get(i).getID(), icecream.get(i).getName(), icecream.get(i).getSize(), icecream.get(i).getTopping(), icecream.get(i).getPrice());
			}
			System.out.println("============================================================================================================");
			scan.nextLine();
		}
	}
	
	public void add() {
		String name;
		String size;
		int choice = 0;
		int price = 0;
		
		String ID = "IC";
		for(int i=0;i<3;i++) {
			Integer a = r.nextInt(10);
			ID+=a;
		}
		
		do {
			System.out.print("Input Ice Cream Name : ");
			name = scan.nextLine();
		}while(name.isEmpty());
		do {
			System.out.print("Choose Ice Cream Size [Small | Medium | Large] : ");
			size = scan.nextLine();
		}while(!size.equals("Small") && !size.equals("Medium") && !size.equals("Large"));
		if(!size.equals("Small")) {
			price += 5000;
		}else if(!size.equals("Medium")) {
			price += 8000;
		}else if(!size.equals("Large")) {
			price += 10000;
		}
		do {
			System.out.println("1. Chocolate - 2000");
			System.out.println("2. Vanilla - 3000");
			System.out.println("3. Strawberry - 3500");
			System.out.print("Pick topping [1-3] [0 to skip] : ");
			try {
				choice = scan.nextInt(); scan.nextLine();
			}catch(Exception e) {
				scan.nextLine();
			}
		}while(choice != 0 && choice < 1 || choice > 3);
		if(choice == 0) {
			
		}else if(choice == 1) {
			
			price+= 2000;
		}else if(choice == 2) {
			price+= 3000;
		}else if(choice == 3) {
			price+= 3500; 
		}
		icecream.add(new IceCream(ID, name, size, price));
		System.out.println("Success Insert Ice Cream");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	public boolean IDtrue(String str) {
		for(int i=0;i<icecream.size();i++) {
			if(icecream.get(i).getID().equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	public void delete() {
		if(icecream.isEmpty()) {
			System.out.println("No Ice Cream");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			return;
		}else {
			String str;
			int idx = -1;
			view();
			do {
				System.out.print("Choose Ice Cream ID to be deleted ['cancel' to cancel]: ");
				str = scan.nextLine();
			}while(str.equals("cancel") || !IDtrue(str));
			if(str.equals("cancel")) {
				return;
			}
			for(int i=0;i<icecream.size();i++) {
				if(icecream.get(i).getID().equals(str)) {
					idx = i;
					break;
				}
			}
			if(idx == -1) {
				System.out.println("Wrong ID");
				scan.nextLine();
				return;
			}else {
				icecream.remove(idx);
			}
		}
	}

	public Main() {
		// TODO Auto-generated constructor stub
		int choice = 0;
		do {
			cls();
			System.out.println("Ice Cream Shop");
			System.out.println("1. View Ice Cream");
			System.out.println("2. Add Ice Cream");
			System.out.println("3. Delete Ice Cream");
			System.out.println("4. Exit");
			System.out.print("Choose : ");
			choice = scan.nextInt(); scan.nextLine();
			switch(choice) {
				case 1:
					view();
					break;
				case 2:
					add();
					break;
				case 3:
					delete();
					break;
			}
		}while(choice != 4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
