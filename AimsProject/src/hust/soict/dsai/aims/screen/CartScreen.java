package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setSize(1024, 768);
        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                	FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("cart.fxml"));
                    
                    Parent root = loader.load();


                    CartScreenController controller = loader.getController();
                    controller.setCart(cart);

                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    public static void main(String[] args) {
    	ArrayList<Track> songs = new ArrayList<Track>();
    	Cart supahOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Minecraft movie","Fantasy","Notch",120,19.95f);
		supahOrder.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Yakuza 0","Slice of Life","John Yakuza",120,24.95f);
		supahOrder.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Dante's Inferno","Fantasy",18.99f);
		supahOrder.addMedia(dvd3);
		Book book1 = new Book("Mass Synthesis");
		supahOrder.addMedia(book1);
		CompactDisc cd1 = new CompactDisc("Remember that you will die", "Punk Rock", "Tim Henson", 289, 38f, "Tim Henson", songs);
		supahOrder.addMedia(cd1);
	    new CartScreen(supahOrder);              
	}
}