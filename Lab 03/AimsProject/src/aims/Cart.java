package aims;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered>=MAX_NUMBERS_ORDERED) {
			System.out.println("Full cart, buddy. Hold off on your greed.");
		}
		else {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered++;
			System.out.println("Disc " + disc.getTitle() + " has been added to your cart.");
			if (qtyOrdered>=MAX_NUMBERS_ORDERED-5) {
				System.out.println("Woah pardner. Disc " + disc.getTitle() + " has been added but..." + (MAX_NUMBERS_ORDERED-qtyOrdered) + " more discs and you're full. Watch out.");
			}
		}
	}
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been exterminated. Yee haw.");
                break;
            }
        }

        if (!found) {
            System.out.println("Disc's ain't even in the cart, bub. You messin' with me?");
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
