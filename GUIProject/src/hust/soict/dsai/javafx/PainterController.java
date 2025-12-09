package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawPane;  // The white drawing area

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private ToggleGroup toolGroup;

    private static final double PEN_SIZE = 4;
    private static final double ERASER_SIZE = 20;

    // ------------------------------
    // Mouse Drag Handler
    // ------------------------------
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {

        double x = event.getX();
        double y = event.getY();

        Circle dot;

        if (penButton.isSelected()) {
            dot = new Circle(x, y, PEN_SIZE, Color.BLACK);
        } 
        else if (eraserButton.isSelected()) {
            dot = new Circle(x, y, ERASER_SIZE, Color.WHITE);  // Eraser draws white
        } 
        else {
            return;  // No tool selected
        }

        drawPane.getChildren().add(dot);
    }

    // ------------------------------
    // Clear Button
    // ------------------------------
    @FXML
    private void clearButtonPressed() {
        drawPane.getChildren().clear();
    }
}
