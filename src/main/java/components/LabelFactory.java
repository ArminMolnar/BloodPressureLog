package components;

import javax.swing.*;
import java.awt.*;

public class LabelFactory {

    private final JLabel nameLabel;
    private final JLabel passwordLabel;
    private final JLabel averageLabel;
    private final JLabel systolicLabel;
    private final JLabel diastolicLabel;
    private final JLabel pulseLabel;
    private final JLabel pulsePressureLabel;

    public LabelFactory() {
        this.nameLabel = createLabel("Name:", 180, 75, 200, 30);
        this.passwordLabel = createLabel("Password:", 180, 75, 200, 30);
        this.averageLabel = createLabel("Average:", 50, 320, 600, 30);
        this.systolicLabel = createLabel("Systolic:", 50, 75, 200, 30);
        this.diastolicLabel = createLabel("Diastolic:", 160, 75, 200, 30);
        this.pulseLabel = createLabel("Pulse:", 275, 75, 200, 30);
        this.pulsePressureLabel = createLabel("Pulse Pressure:", 365, 75, 200, 30);
    }

    public static JLabel createLabel(String text, int x, int y, int width, int height) {

        JLabel label = new JLabel(text);
        label.setText(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        return label;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getAverageLabel() {
        return averageLabel;
    }

    public JLabel getSystolicLabel() {
        return systolicLabel;
    }

    public JLabel getDiastolicLabel() {
        return diastolicLabel;
    }

    public JLabel getPulseLabel() {
        return pulseLabel;
    }

    public JLabel getPulsePressureLabel() {
        return pulsePressureLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
}
