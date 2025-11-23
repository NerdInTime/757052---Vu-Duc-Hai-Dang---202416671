package hust.soict.dsai.aims.cart;
import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    public int compare(Media m1, Media m2) {
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}