package components;

import javax.swing.*;

public class TextFieldFactory {


    private final JTextField nameTextField;
    private final JTextField systolicField;
    private final JTextField diastolicField;
    private final JTextField pulseField;
    private final JTextField pulsePressureField;
    private final JTextField passwordField;

    public TextFieldFactory() {
        this.nameTextField = createTextField("Name", 170, 100, 100, 30);
        this.systolicField = createTextField("Systolic", 50, 100, 50, 30);
        this.diastolicField = createTextField("Diastolic", 160, 100, 50, 30);
        this.pulseField = createTextField("Pulse", 270, 100, 50, 30);
        this.pulsePressureField = createTextField("Pulse Pressure", 380, 100, 50, 30);
        this.passwordField = createTextField("Password", 170, 100, 100, 30);
    }

    public static JTextField createTextField(String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setToolTipText(text);
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

    public JTextField getPasswordField() {
        return passwordField;
    }
}
