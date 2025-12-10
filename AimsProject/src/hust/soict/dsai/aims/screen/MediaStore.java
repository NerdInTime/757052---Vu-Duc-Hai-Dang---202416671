package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.AppState;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));


        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {

            AppState.CART.addMedia(media);


            if (CartScreenController.instance != null) {
                javafx.application.Platform.runLater(() -> {
                    CartScreenController.instance.updateTotalCost();
                });
            }


            JDialog confirm = new JDialog();
            confirm.setTitle("Confirmed");
            confirm.setSize(300, 200);
            JLabel lblc = new JLabel(
                "<html><body style='text-align:center'>" +
                "Added " + media.getTitle() + " to cart" +
                "</body></html>",
                JLabel.CENTER
            );
            confirm.add(lblc);
            confirm.setLocationRelativeTo(null);
            confirm.setVisible(true);
        });

        container.add(btnAddToCart);


        if (media instanceof Playable playable) {
            JButton btnPlay = new JButton("Play");

            btnPlay.addActionListener(e -> {
                JDialog dialog = new JDialog();
                dialog.setTitle("Playing: " + media.getTitle());
                dialog.setSize(300, 200);
                String output;
                try {
                    output = playable.Play().replace("\n", "<br>");
                } catch (PlayerException ex) {
                    output = "<span style='color:red'>" + ex.getMessage() + "</span>";
                }

                JLabel lbl = new JLabel(
                    "<html><body style='text-align:center'>" +
                    output +
                    "</body></html>",
                    JLabel.CENTER
                );
                dialog.add(lbl);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            });

            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
