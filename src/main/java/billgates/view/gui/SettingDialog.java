package billgates.view.gui;

import javax.swing.*;
import java.awt.*;

public class SettingDialog extends JDialog {
    private static final JComboBox<String> colorField = new JComboBox<>();
    private static final JComboBox<String> fontField = new JComboBox<>();
    private final static Color[] COLORS = new Color[]{ActionButton.DEFAULT_BACKGROUND_COLOR,
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.PINK,
            Color.WHITE};
    private final static String[] FONTS = new String[]{"Modern No. 20", "Times New Roman",
            "Helvetica", "Arial", "Impact", "Verdana", "Century", "Tahoma", "Copperplate"};
    private static int colorIndex;
    private static int fontIndex;
    private final JButton confirmButton = new JButton("Confirm");
    private final JButton cancelButton = new JButton("Cancel");
    private boolean confirmed = false;

    // Set up setting dialog to change background color and font style
    public SettingDialog(MainFrame owner) {
        super(owner);

        // Set the font
        this.setFont(new FontSettings(14));

        // Set the Main root panel and its layout
        JPanel root = new JPanel();
        this.setTitle("Setting");
        this.setModal(true);
        this.setSize(400, 200);
        this.setResizable(false);
        SwingUtil.centerInOwner(this, this.getOwner());
        this.setContentPane(root);

        //Set the sub-action root panel
        JPanel subAction = new JPanel();
        subAction.add(this.confirmButton);
        subAction.add(this.cancelButton);

        // Set the color-field and font-field
        JLabel backgroundButton = new JLabel("Background Color");
        colorField.addItem("Default");
        colorField.addItem("Red");
        colorField.addItem("Orange");
        colorField.addItem("Yellow");
        colorField.addItem("Green");
        colorField.addItem("Cyan");
        colorField.addItem("Blue");
        colorField.addItem("Pink");
        colorField.addItem("White");

        JLabel fontStyle = new JLabel("Font");
        fontField.addItem("Default");
        fontField.addItem("Times New Roman");
        fontField.addItem("Helvetica");
        fontField.addItem("Arial");
        fontField.addItem("Impact");
        fontField.addItem("Verdana");
        fontField.addItem("Century");
        fontField.addItem("Tahoma");
        fontField.addItem("Copperplate");

        //Set the color choose box panel
        JPanel colorChooseBox = new JPanel();
        colorChooseBox.add(backgroundButton);
        colorChooseBox.add(colorField);

        //Set the font choose box panel
        JPanel fontChooseBox = new JPanel();
        fontChooseBox.add(fontStyle);
        fontChooseBox.add(fontField);

        //Add the panels to root panel to set up our layout
        this.add(colorChooseBox, BorderLayout.CENTER);
        this.add(fontChooseBox, BorderLayout.CENTER);
        this.add(subAction, BorderLayout.SOUTH);

        // Case 1: Click cancelButton
        this.cancelButton.addActionListener(e -> setVisible(false));

        // Case 2: Choose different color and font
        this.confirmButton.addActionListener((e ->
        {
            colorIndex = colorField.getSelectedIndex();
            colorField.setSelectedIndex(colorIndex);

            fontIndex = fontField.getSelectedIndex();
            fontField.setSelectedIndex(fontIndex);

            this.confirmed = true;

            JOptionPane.showMessageDialog(this, "Page has been set!", "All Set",
                    JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
        }));
    }

    public static void setColorField(int index) {
        colorField.setSelectedIndex(index);
    }

    public static void setFontField(int index) {
        fontField.setSelectedIndex(index);
    }

    public int getMyColor() {
        return colorIndex;
    }

    public int getMyFont() {
        return fontIndex;
    }

    public boolean exec() {

        // Show the dialog
        this.setVisible(true);
        return confirmed;
    }
}