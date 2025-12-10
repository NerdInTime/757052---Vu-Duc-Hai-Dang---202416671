package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        customFieldsPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        customFieldsPanel.add(tfDirector);

        customFieldsPanel.add(new JLabel("Length (seconds):"));
        tfLength = new JTextField();
        customFieldsPanel.add(tfLength);
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            StoreScreen.instance.refresh();

            JOptionPane.showMessageDialog(this, "Added yo DVD.");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "brother what thats invalid!");
        }
    }
}
