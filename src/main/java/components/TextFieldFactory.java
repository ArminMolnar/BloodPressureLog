package components;

import javax.swing.*;
import java.awt.*;

public class TextFieldFactory {


    private final JTextField nameTextField;
    private final JTextField systolicField;
    private final JTextField diastolicField;
    private final JTextField pulseField;
    private final JTextField pulsePressureField;
    private static TextFieldFactory instance;

    private TextFieldFactory() {
        this.nameTextField = createTextField(135, 100, 100, 30);
        this.systolicField = createTextField(50, 100, 50, 30);
        this.diastolicField = createTextField(130, 100, 50, 30);
        this.pulseField = createTextField(210, 100, 50, 30);
        this.pulsePressureField = createTextField(290, 100, 50, 30);
    }

    private static JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        return textField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getSystolicField() {
        return systolicField;
    }

    public JTextField getDiastolicField() {
        return diastolicField;
    }

    public JTextField getPulsePressureField() {
        return pulsePressureField;
    }

    public JTextField getPulseField() {
        return pulseField;
    }

    public static TextFieldFactory getInstance() {
        if (instance == null) {
            instance = new TextFieldFactory();
        }
        return instance;
    }
}
