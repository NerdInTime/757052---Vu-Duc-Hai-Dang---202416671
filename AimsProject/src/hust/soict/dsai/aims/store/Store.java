package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore;
	public Store(ArrayList<DigitalVideoDisc> dvdlist) {
		super();
		this.itemsInStore = dvdlist;
	}
	public void addDVD() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter DVD title: ");
        String title = sc.nextLine();
        System.out.print("Enter DVD category: ");
        String category = sc.nextLine();
        System.out.print("Enter DVD director: ");
        String director = sc.nextLine();
        System.out.print("Enter DVD length (minutes): ");
        int length = sc.nextInt();
        System.out.print("Enter DVD cost: ");
        float cost = sc.nextFloat();
        sc.nextLine();
        DigitalVideoDisc newDvd = new DigitalVideoDisc(title, category, director, length, cost);
        this.itemsInStore.add(newDvd);
        System.out.println("DVD added. Aw yeah.");
	}
	public void removeDVD(DigitalVideoDisc rdisc) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).equals(rdisc)) {
                found = true;
                itemsInStore.remove(i);
                System.out.println("The disc \"" + rdisc.getTitle() + "\" has been exterminated. Yee haw.");
                break;
            }
        }

        if (!found) {
            System.out.println("Disc's ain't even in the shop, bub. You messin' with me?");
        }
		
	}
	
}
