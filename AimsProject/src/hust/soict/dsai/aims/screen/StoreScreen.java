package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class StoreScreen extends JFrame{
	static Store store;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore=new JMenu ("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
		
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ArrayList<Media> mediaInStore = store.getItems();
		for (int i=0; i<9;i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	public static void main(String[] args) {
	    store = new Store();                
	    store = seedSampleData(store);       
	    new StoreScreen(store);              
	}
	public static Store seedSampleData(Store store) {
        ArrayList<String> authors1 = new ArrayList<>(List.of("J.K. Rowling"));
        ArrayList<String> authors2 = new ArrayList<>(List.of("George R.R. Martin"));
        store.addMedia(new Book("Harry Potter", "Fantasy", authors1, 29.99f));
        store.addMedia(new Book("A Game of Thrones", "Fantasy", authors2, 39.99f));

        store.addMedia(new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 89, 19.99f
        ));
        store.addMedia(new DigitalVideoDisc(
                "The Dark Knight", "Action", "Christopher Nolan", 152, 24.99f
        ));

        ArrayList<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track("ABC", 180));
        tracks1.add(new Track("Playing God", 210));

        store.addMedia(new CompactDisc(
                "Remember that you will die",
                "Music",
                "Polyphia",
                50,
                14.99f,
                "Tim Henson",
                tracks1
        ));

        ArrayList<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("Tian Tian", 60));
        tracks2.add(new Track("world.execute.me", 300));

        store.addMedia(new CompactDisc(
                "Robot Sympathy",
                "Soundtrack",
                "Mili",
                60,
                19.99f,
                "Cassie Wei",
                tracks2
        ));
        store.addMedia(new DigitalVideoDisc(
                "The Lion King 2", "Animation", "Roger Allers", 89, 19.99f
        ));
        store.addMedia(new DigitalVideoDisc(
                "The Lion King 3", "Animation", "Roger Allers", 89, 19.99f
        ));
        store.addMedia(new DigitalVideoDisc(
                "The Lion King 4", "Animation", "Roger Allers", 89, 19.99f
        ));

        return store;
    }

	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
	}

}
