package components;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {

    private final JButton testConnectionButton;
    private final JButton addRecordButton;
    private final JButton displayRecordButton;
    private final JButton displayAverageButton;
    private final JButton OkButton;
    private static ButtonFactory instance;

    private ButtonFactory() {
        this.testConnectionButton = ButtonFactory.createButton("Test connection", 80, 150, 300, 30);
        this.addRecordButton = ButtonFactory.createButton("Add record", 80, 160, 300, 30);
        this.displayRecordButton = ButtonFactory.createButton("Display record", 80, 220, 300, 30);
        this.displayAverageButton = ButtonFactory.createButton("Display average", 80, 280, 300, 30);
        this.OkButton = ButtonFactory.createButton("OK", 80, 150, 300, 30);

    }

    private static JButton createButton(String text, int x, int y, int width, int height) {

        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Times New Roman", Font.BOLD, 17));
        return button;
    }


    public JButton getTestConnectionButton() {
        return testConnectionButton;
    }

    public JButton getDisplayAverageButton() {
        return displayAverageButton;
    }

    public JButton getDisplayRecordButton() {
        return displayRecordButton;
    }

    public JButton getAddRecordButton() {
        return addRecordButton;
    }

    public JButton getOkButton() {
        return OkButton;
    }

    public static ButtonFactory getInstance() {
        if (instance == null) {
            instance = new ButtonFactory();
        }
        return instance;
    }

}
