package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.AppState;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);


        customFieldsPanel.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField();
        customFieldsPanel.add(tfAuthors);
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            ArrayList<String> authors = new ArrayList<>(
                    Arrays.asList(tfAuthors.getText().split(","))
            );

            Book book = new Book(title, category, authors, cost);
            store.addMedia(book);
            StoreScreen.instance.refresh();

            JOptionPane.showMessageDialog(this, "Added yo book!");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "brother what thats invalid!");
        }
    }
}