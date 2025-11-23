package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
			System.out.println("Full cart, buddy. Hold off on your greed.");
		}
		else {
			itemsOrdered.add(media);
			System.out.println("Media " + media.getTitle() + " has been added to your cart.");
			if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED-5) {
				System.out.println("Woah pardner. Media " + media.getTitle() + " has been added but..." + (MAX_NUMBERS_ORDERED-itemsOrdered.size()) + " more medias and you're full. Watch out.");
			}
		}
	}
	public void addMedia(Media [] media) {
		if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
			System.out.println("Full cart, buddy. Hold off on your greed.");
		}
		else {
			for (Media i: media) {
				if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
					System.out.println("Full cart, buddy. Hold off on your greed.");
					break;
				}
				else {
					itemsOrdered.add(i);
					System.out.println("Media " + i.getTitle() + " has been added to your cart.");
					if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED-5) {
						System.out.println("Woah pardner. Media " + i.getTitle() + " has been added but..." + (MAX_NUMBERS_ORDERED-itemsOrdered.size()) + " more medias and you're full. Watch out.");
					}
				}
			}
		}
	}
	public void addMedia(Media media1, Media media2) {
		if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
			System.out.println("Full cart, buddy. Hold off on your greed.");
		}
		else {
			itemsOrdered.add(media1);
			System.out.println("Media " + media1.getTitle() + " has been added to your cart.");
			if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED-5) {
				System.out.println("Woah pardner. Media " + media1.getTitle() + " has been added but..." + (MAX_NUMBERS_ORDERED-itemsOrdered.size()) + " more medias and you're full. Watch out.");
			}		
		}
		if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED) {
			System.out.println("Full cart, buddy. Hold off on your greed.");
		}
		else {
			itemsOrdered.add(media2);
			System.out.println("Media " + media2.getTitle() + " has been added to your cart.");
			if (itemsOrdered.size()>=MAX_NUMBERS_ORDERED-5) {
				System.out.println("Woah pardner. Media " + media2.getTitle() + " has been added but..." + (MAX_NUMBERS_ORDERED-itemsOrdered.size()) + " more medias and you're full. Watch out.");
			}		
		}
	}
    public void removeMedia(Media media) {
        boolean found = itemsOrdered.contains(media);
        if (found){
        		itemsOrdered.remove(media);
                System.out.println("The disc \"" + media.getTitle() + "\" has been exterminated. Yee haw.");
        }
    	else {
            System.out.println("Disc's ain't even in the cart, bub. You messin' with me?");
        }
    }
    public void cartPrint() {
    	int count = 0;
    	System.out.println("***********************CART*********************** ");
    	System.out.println("Ordered Items: ");
    	for (Media i: itemsOrdered) {
    		count++;
    		System.out.print(count + ". Media - ");
    		i.displayInfo();
    	}
    	System.out.println("Total Cost: " + this.totalCost());
    	System.out.println("*************************************************** ");
    }
    public void searchByID(long searchID) {
    	boolean found=false;
    	for (Media i: itemsOrdered) {
    		if (searchID == i.getId()) {
    			found=true;
    			i.displayInfo();
    			break;
    		}
    	}
    	if (found==false) {
    		System.out.println("Ain't no disc with that ID in your cart, bub.");
    	}
    }
    public void searchByTitle(String keyword) {
    	boolean found=false;
    	for (Media i: itemsOrdered) {
    		if (i.isMatch(keyword)) {
    			found=true;
    			i.displayInfo();
    			break;
    		}
    	}
    	if (found==false) {
    		System.out.println("Ain't no disc with that title in your cart, bub.");
    	}
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
}
