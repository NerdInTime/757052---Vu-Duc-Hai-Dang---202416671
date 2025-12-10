package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextArea taTracks;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        customFieldsPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        customFieldsPanel.add(tfArtist);

        customFieldsPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        customFieldsPanel.add(tfDirector);

        customFieldsPanel.add(new JLabel("Tracks (format: name-length, one per line):"));
        taTracks = new JTextArea(5, 20);
        customFieldsPanel.add(new JScrollPane(taTracks));
    }

    @Override
    protected void addItemToStore() {
        try {
        	int fullLength = 0;
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();
            String director = tfDirector.getText();

            ArrayList<Track> tracks = new ArrayList<>();
            String[] lines = taTracks.getText().split("\n");

            for (String line : lines) {
                String[] parts = line.split("-");
                String name = parts[0].trim();
                int length = Integer.parseInt(parts[1].trim());
                tracks.add(new Track(name, length));
                fullLength+=length;
            }

            CompactDisc cd = new CompactDisc(title, category, director, fullLength, cost, artist, tracks);
            store.addMedia(cd);
            StoreScreen.instance.refresh();

            JOptionPane.showMessageDialog(this, "Added yo CD.");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "brother what thats invalid!");
        }
    }
}
