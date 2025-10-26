package aims;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreTest {
	public static void main(String[] args) {
		final ArrayList<DigitalVideoDisc> dvdlist = new ArrayList<>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Minecraft movie","Fantasy","Notch",120,19.95f);
		dvdlist.add(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Yakuza 0","Slice of Life","John Yakuza",120,24.95f);
		dvdlist.add(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Dante's Inferno","Fantasy",18.99f);
		dvdlist.add(dvd3);
		Store fangamer = new Store(dvdlist);
		fangamer.addDVD();
		fangamer.removeDVD(dvd3);
	}
}