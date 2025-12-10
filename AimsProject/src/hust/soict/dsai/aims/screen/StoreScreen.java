package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import hust.soict.dsai.aims.AppState;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {

	private final Store store;
	private final Cart cart;
	private CartScreen cartScreen;   
	public static StoreScreen instance;


	public StoreScreen() {
	    this.store = AppState.STORE;
	    this.cart = AppState.CART;
	    instance=this;
	    setupUI();
	}
    private void setupUI() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);

        setTitle("AIMS");
        setSize(1024, 768);
        setVisible(true);
    }


    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");


        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBook);


        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        smUpdateStore.add(addCD);


        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        smUpdateStore.add(addDVD);


        menu.add(smUpdateStore);


        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            this.setVisible(true);
            this.toFront();
        });
        menu.add(viewStore);


        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> openCartScreen());
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private void openCartScreen() {
        if (cartScreen == null) {
            cartScreen = new CartScreen(cart); 
        }
        cartScreen.setVisible(true);
        cartScreen.toFront();
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.BLUE);

        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.addActionListener(e -> openCartScreen());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItems();
        int itemCount = Math.min(mediaInStore.size(), 9);

        for (int i = 0; i < itemCount; i++) {
            center.add(new MediaStore(mediaInStore.get(i)));
        }
        for (int i = itemCount; i < 9; i++) {
            center.add(new JPanel()); 
        }

        return center;
    }


    public void refresh() {
        getContentPane().removeAll();
        setupUI();     
        revalidate();
        repaint();
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
       

        return store;
    }


    public static void main(String[] args) {
        seedSampleData(AppState.STORE);
        new StoreScreen();
    }
}
