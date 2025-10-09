	package aims;

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
		System.out.println(supahOrder.totalCost());
	}

}
