package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    protected JPanel customFieldsPanel = new JPanel();

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        setTitle("Add Item to Store");
        setSize(400, 400);
        setLayout(new BorderLayout());

        add(createMainForm(), BorderLayout.CENTER);
        add(createAddButton(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createMainForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);


        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);


        panel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        panel.add(tfCost);


        panel.add(new JLabel("Additional Fields:"));
        panel.add(customFieldsPanel);
        customFieldsPanel.setLayout(new BoxLayout(customFieldsPanel, BoxLayout.Y_AXIS));

        return panel;
    }

    private JButton createAddButton() {
        JButton btn = new JButton("Add");
        btn.addActionListener(e -> addItemToStore());
        return btn;
    }

    protected abstract void addItemToStore();
}
