	package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        seedSampleData();
        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": viewStore(); break;
                case "2": updateStore(); break;
                case "3": seeCurrentCart(); break;
                case "0":
                    System.out.println("Exiting AIMS. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void viewStore() {
        store.printStore();
        while (true) {
            storeMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": seeMediaDetails(); break;
                case "2": addMediaToCart(); break;
                case "3": playMedia(); break;
                case "4": seeCurrentCart(); return;
                case "0": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    private static void seeMediaDetails() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) {
            System.out.println("No media found with that title.");
            return;
        }
        System.out.println("=== Media Details ===");
        m.displayInfo();
        while (true) {
            mediaDetailsMenu(m);
            String opt = scanner.nextLine().trim();
            switch (opt) {
                case "1":
                    cart.addMedia(m);
                    System.out.println("Added to cart.");
                    System.out.println("Number of DVDs in cart: " + cart.countDVDs());
                    break;
                case "2":
                    if (m instanceof Playable) {
                        ((Playable) m).Play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void mediaDetailsMenu(Media m) {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void addMediaToCart() {
        System.out.print("Enter title to add: ");
        String title = scanner.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) {
            System.out.println("No such media in store.");
            return;
        }
        cart.addMedia(m);
        System.out.println("Added to cart. Number of DVDs in cart: " + cart.countDVDs());
    }

    private static void playMedia() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) {
            System.out.println("No such media in store.");
            return;
        }
        if (m instanceof Playable) {
            ((Playable) m).Play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore() {
        System.out.println("\nUpdate store:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        String c = scanner.nextLine().trim();
        switch (c) {
            case "1": addMediaToStore(store, scanner); break;
            case "2": removeMediaFromStore(); break;
            case "0": break;
            default: System.out.println("Invalid option.");
        }
    }

    public static void addMediaToStore(Store store, Scanner sc) {
        System.out.println("Choose type of media to add:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. Compact Disc");
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        switch (choice) {


            case 1:
                ArrayList<String> authors = new ArrayList<>();

                System.out.print("Enter number of authors: ");
                int numAuthors = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < numAuthors; i++) {
                    System.out.print("Author " + (i+1) + ": ");
                    authors.add(sc.nextLine());
                }

                System.out.print("Enter cost: ");
                float bookCost = Float.parseFloat(sc.nextLine());

                Book book = new Book(title, category, authors, bookCost);
                store.addMedia(book);
                System.out.println("Book added to store!");
                break;

            case 2:
                System.out.print("Enter director: ");
                String dvdDirector = sc.nextLine();

                System.out.print("Enter length (minutes): ");
                int dvdLength = Integer.parseInt(sc.nextLine());

                System.out.print("Enter cost: ");
                float dvdCost = Float.parseFloat(sc.nextLine());

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, dvdDirector, dvdLength, dvdCost);
                store.addMedia(dvd);
                System.out.println("DVD added to store!");
                break;


            case 3:
                System.out.print("Enter director: ");
                String cdDirector = sc.nextLine();

                System.out.print("Enter length (minutes): ");
                int cdLength = Integer.parseInt(sc.nextLine());

                System.out.print("Enter artist: ");
                String artist = sc.nextLine();

                ArrayList<Track> tracks = new ArrayList<>();
                System.out.print("Enter number of tracks: ");
                int numTracks = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < numTracks; i++) {
                    System.out.println("Track " + (i+1) + ":");
                    System.out.print("  Track title: ");
                    String tTitle = sc.nextLine();
                    System.out.print("  Track length: ");
                    int tLength = Integer.parseInt(sc.nextLine());

                    tracks.add(new Track(tTitle, tLength));
                }

                System.out.print("Enter cost: ");
                float cdCost = Float.parseFloat(sc.nextLine());

                CompactDisc cd = new CompactDisc(
                        title, category, cdDirector, cdLength, cdCost,
                        artist, tracks
                );

                store.addMedia(cd);
                System.out.println("CD added to store!");
                break;

            default:
                System.out.println("Invalid option.");
                return;
        }
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine().trim();
        boolean removed = store.removeMediaByTitle(title);
        if (removed) System.out.println("Removed from store.");
        else System.out.println("No media with that title.");
    }

    private static void seeCurrentCart() {
        cart.cartPrint();
        while (true) {
            cartMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": filterMediasInCart(); break;
                case "2": sortMediasInCart(); break;
                case "3": removeMediaFromCart(); break;
                case "4": playMediaFromCart(); break;
                case "5": placeOrder(); return;
                case "0": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void filterMediasInCart() {
        System.out.println("Filter by: 1=ID, 2=Title");
        String c = scanner.nextLine().trim();
        if ("1".equals(c)) {
            System.out.print("Enter id: ");
            try {
                int id = Integer.parseInt(scanner.nextLine().trim());
                Media m = cart.filterById(id);
                if (m == null) System.out.println("No media with that ID in cart.");
                else m.displayInfo();
            } catch (NumberFormatException e) {
                System.out.println("Invalid id.");
            }
        } else if ("2".equals(c)) {
            System.out.print("Enter title (or substring): ");
            String t = scanner.nextLine().trim();
            List<Media> res = cart.filterByTitle(t);
            if (res.isEmpty()) System.out.println("No matches.");
            else for (Media m : res) m.displayInfo();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void sortMediasInCart() {
        System.out.println("Sort by: 1=Title then cost, 2=Cost then title");
        String c = scanner.nextLine().trim();
        if ("1".equals(c)) {
            cart.sortByTitleCost();
            System.out.println("Cart sorted by title then cost.");
        } else if ("2".equals(c)) {
            cart.sortByCostTitle();
            System.out.println("Cart sorted by cost then title.");
        } else {
            System.out.println("Invalid choice.");
        }
        cart.cartPrint();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title to remove from cart: ");
        String title = scanner.nextLine().trim();
        boolean removed = cart.removeMediaByTitle(title);
        if (removed) System.out.println("Removed from cart.");
        else System.out.println("Not found in cart.");
    }

    private static void playMediaFromCart() {
        System.out.print("Enter title to play from cart: ");
        String title = scanner.nextLine().trim();
        Media m = cart.findByTitle(title);
        if (m == null) {
            System.out.println("No such media in cart.");
            return;
        }
        if (m instanceof Playable) {
            ((Playable) m).Play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }
        System.out.println("Order created. Thank you for your purchase!");
        cart.clear();
    }

    public static Store seedSampleData() {
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

        return store;
    }
}

