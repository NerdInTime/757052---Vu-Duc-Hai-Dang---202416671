package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> items = new ArrayList<>();

    public void addMedia(Media m) {
        items.add(m);
    }

    public boolean removeMediaByTitle(String title) {
        Media m = findByTitle(title);
        if (m != null) {
            items.remove(m);
            return true;
        }
        return false;
    }

    public Media findByTitle(String title) {
        for (Media m : items) {
            if (m.getTitle().equalsIgnoreCase(title.trim())) return m;
        }
        return null;
    }

    public List<Media> getItems() {
        return items;
    }

    public void printStore() {
        System.out.println("=== Store Items ===");
        if (items.isEmpty()) {
            System.out.println("(store is empty)");
            return;
        }
        for (Media m : items) {
            m.displayInfo();;
        }
    }
}
