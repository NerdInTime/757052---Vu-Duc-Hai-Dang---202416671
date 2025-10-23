	package aims;
	import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		Cart supahOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Minecraft movie","Fantasy","Notch",120,19.95f);
		supahOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Yakuza 0","Slice of Life","John Yakuza",120,24.95f);
		supahOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Dante's Inferno","Fantasy",18.99f);
		supahOrder.addDigitalVideoDisc(dvd3);
		supahOrder.removeDigitalVideoDisc(dvd1);
		supahOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("Total Cost is: ");
		System.out.println(supahOrder.totalCost());
		int i = 0;
		while (i<20) {
			supahOrder.addDigitalVideoDisc(dvd2);
			i++;
		}
		
		System.out.println("Total Cost is: ");
		supahOrder.cartPrint();
		supahOrder.searchByID(3);
		supahOrder.searchByID(4);
		supahOrder.searchByTitle("inferno");
		supahOrder.searchByTitle("bruh");
		System.out.println(supahOrder.totalCost()); //demonstration of all messages first
		// now we take it seriously
		Cart ExtremeOrder = new Cart();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Serect ur option");
            System.out.println("1. Add a DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Display total cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	System.out.println("\nSelect a DVD to add:");
                    System.out.println("1. " + dvd1.getTitle());
                    System.out.println("2. " + dvd2.getTitle());
                    System.out.println("3. " + dvd3.getTitle());
                    System.out.print("Enter number (1-3): ");
                    int addChoice = sc.nextInt();

                    if (addChoice == 1) ExtremeOrder.addDigitalVideoDisc(dvd1);
                    else if (addChoice == 2) ExtremeOrder.addDigitalVideoDisc(dvd2);
                    else if (addChoice == 3) ExtremeOrder.addDigitalVideoDisc(dvd3);
                    else System.out.println("Invalid selection!");
                    break;
                case 2:
                	System.out.println("\nSelect a DVD to remove:");
                    System.out.println("1. " + dvd1.getTitle());
                    System.out.println("2. " + dvd2.getTitle());
                    System.out.println("3. " + dvd3.getTitle());
                    System.out.print("Enter number (1-3): ");
                    int removeChoice = sc.nextInt();

                    if (removeChoice == 1) ExtremeOrder.removeDigitalVideoDisc(dvd1);
                    else if (removeChoice == 2) ExtremeOrder.removeDigitalVideoDisc(dvd2);
                    else if (removeChoice == 3) ExtremeOrder.removeDigitalVideoDisc(dvd3);
                    else System.out.println("Invalid selection!");
                    break;

                case 3:
                    System.out.println("Total Cost is: " + ExtremeOrder.totalCost());
                    break;

                case 4:
                    System.out.println("Farewell, so long.");
                    break;

                default:
                    System.out.println("Wrong one bud.");
            }
        } while (choice != 4);

        sc.close();
    }
}
