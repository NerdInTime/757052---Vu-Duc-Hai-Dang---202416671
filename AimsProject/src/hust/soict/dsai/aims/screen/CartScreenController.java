package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JLabel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	public static CartScreenController instance;

	static Store store;

    private Cart cart;
    @FXML
    private Label lbTotalCost;
    private FilteredList<Media> filteredList;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController() {
    	instance=this;
    }

    // This is called from CartScreen after load()
    public void setCart(Cart cart) {
        this.cart = cart;
        
        cart.getItems().addListener((javafx.collections.ListChangeListener<Media>) change -> {
            updateTotalCost();
        });

        // Wrap the cart's ObservableList in a FilteredList
        filteredList = new FilteredList<>(cart.getItems(), m -> true);

        // Set the filtered list to the TableView
        if (tblMedia != null) {
            tblMedia.setItems(filteredList);
        }
        updateTotalCost();
        
    }
    public void updateTotalCost() {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(this::updateTotalCost);
            return;
        }

        float cost = cart.totalCost();
        lbTotalCost.setText(String.format("%.2f $", cost));
    }

    private void updateButtonBar(Media media) {

        btnRemove.setVisible(true);


        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    @FXML
    private void btnPlayPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media instanceof Playable playable) {
            try {
                String output = playable.Play().replace("\n", "<br>");

                JDialog dialog = new JDialog();
                dialog.setTitle("Playing: " + media.getTitle());
                dialog.setSize(300, 200);

                JLabel lbl = new JLabel(
                    "<html><body style='text-align:center'>" 
                    + output + "</body></html>",
                    JLabel.CENTER
                );

                dialog.add(lbl);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

            } catch (PlayerException e) {

                JDialog errDialog = new JDialog();
                errDialog.setTitle("Play Error");
                errDialog.setSize(300, 150);

                JLabel lbl = new JLabel(
                    "<html><body style='color:red; text-align:center'>" 
                    + e.getMessage() + "</body></html>",
                    JLabel.CENTER
                );

                errDialog.add(lbl);
                errDialog.setLocationRelativeTo(null);
                errDialog.setVisible(true);
            }
        }
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost")
        );
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);


        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable,
                                    Media oldValue,
                                    Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {

                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                }
            });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
        	@Override
        	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		showFilteredMedia(newValue);
        	}
        });

        //tblMedia.setItems(this.cart.getItems());
    }
    @FXML
    private void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }
    @FXML
    private void openAddBookScreen() {
        new AddBookToStoreScreen(store);
    }

    @FXML
    private void openAddCDScreen() {
        new AddCompactDiscToStoreScreen(store);
    }

    @FXML
    private void openAddDVDScreen() {
        new AddDigitalVideoDiscToStoreScreen(store);
    }

    @FXML
    private void openStoreScreen() {
    	new StoreScreen();     
    }

    @FXML
    private void openCartScreen() {
        new CartScreen(cart);
    }
    @FXML
    private void placeOrder() {
        cart.clear();
        updateTotalCost();
        tblMedia.refresh();
        JDialog dialog = new JDialog();
        dialog.setTitle("Order Placed");
        dialog.setSize(300, 200);
        JLabel lbl = new JLabel("<html><body style='text-align:center'>" 
                                + "Order Placed" + "</body></html>",
                                JLabel.CENTER);

        dialog.add(lbl);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    private void showFilteredMedia(String filter) {


        if (filter == null || filter.isEmpty()) {
            filteredList.setPredicate(m -> true);
            return;
        }

        String lower = filter.toLowerCase();


        if (radioBtnFilterId.isSelected()) {
            filteredList.setPredicate(media -> 
                String.valueOf(media.getId()).contains(lower)
            );
        }


        else if (radioBtnFilterTitle.isSelected()) {
            filteredList.setPredicate(media -> 
                media.getTitle().toLowerCase().contains(lower)
            );
        }
    }
}
