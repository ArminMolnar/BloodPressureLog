package buttonController;

import components.ButtonFactory;
import components.LabelFactory;
import components.PasswordFieldFactory;
import components.TextFieldFactory;

import javax.swing.*;

public class ButtonManager {

    JFrame frame;
    private final ButtonFactory buttonFactory;
    private final TextFieldFactory textFieldFactory;
    private final LabelFactory labelFactory;
    private final PasswordFieldFactory passwordFieldFactory;


    public ButtonManager(JFrame frame, ButtonFactory buttonFactory, TextFieldFactory textFieldFactory, LabelFactory labelFactory, PasswordFieldFactory passwordFieldFactory) {
        this.frame = frame;
        this.buttonFactory = buttonFactory;
        this.textFieldFactory = textFieldFactory;
        this.labelFactory = labelFactory;
        this.passwordFieldFactory = passwordFieldFactory;
    }

    public void addButtons() {
        frame.add(buttonFactory.getAddRecordButton());
        frame.add(buttonFactory.getDisplayRecordButton());
        frame.add(buttonFactory.getDisplayAverageButton());

        frame.add(textFieldFactory.getSystolicField());
        frame.add(textFieldFactory.getDiastolicField());
        frame.add(textFieldFactory.getPulseField());

        frame.add(labelFactory.getSystolicLabel());
        frame.add(labelFactory.getDiastolicLabel());
        frame.add(labelFactory.getPulseLabel());
        frame.add(buttonFactory.getReturnButton());
    }

    public void addAverageData() {
        frame.add(labelFactory.getAverageLabel());
        frame.add(labelFactory.getAvgResultLabel());
    }

    public void clearTextField() {
        passwordFieldFactory.getPasswordField().setText("");
        textFieldFactory.getSystolicField().setText("");
        textFieldFactory.getDiastolicField().setText("");
        textFieldFactory.getPulseField().setText("");
    }

    public void refreshFrame() {
        frame.revalidate();
        frame.repaint();
    }

    public void setupUserSelection() {
        frame.getContentPane().removeAll();
        frame.add(textFieldFactory.getNameTextField());
        frame.add(buttonFactory.getOkButton());
        frame.add(labelFactory.getNameLabel());
        refreshFrame();
    }


}
