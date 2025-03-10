package components;

import javax.swing.*;
import java.awt.*;

public class PasswordFieldFactory {

    private final JPasswordField passwordField;
    private static PasswordFieldFactory instance;

    public PasswordFieldFactory() {
        this.passwordField = createPasswordField(170, 100, 100, 30);
    }

    private static JPasswordField createPasswordField(int x, int y, int width, int height) {

        JPasswordField field = new JPasswordField();
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Times New Roman", Font.BOLD, 14));
        return field;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public static PasswordFieldFactory getInstance() {
        if (instance == null) {
            return new PasswordFieldFactory();
        }
        return instance;
    }
}
