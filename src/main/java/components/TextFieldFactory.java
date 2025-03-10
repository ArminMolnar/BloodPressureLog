package components;

import javax.swing.*;

public class TextFieldFactory {


    private final JTextField nameTextField;
    private final JTextField systolicField;
    private final JTextField diastolicField;
    private final JTextField pulseField;
    private final JTextField pulsePressureField;
    private static TextFieldFactory instance;

    public TextFieldFactory() {
        this.nameTextField = createTextField(170, 100, 100, 30);
        this.systolicField = createTextField(50, 100, 50, 30);
        this.diastolicField = createTextField(160, 100, 50, 30);
        this.pulseField = createTextField(270, 100, 50, 30);
        this.pulsePressureField = createTextField(380, 100, 50, 30);
    }

    private static JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);

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
