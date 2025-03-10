package buttonController;

import components.ButtonFactory;
import components.LabelFactory;
import components.TextFieldFactory;

import javax.swing.*;

public class ButtonManager {

    JFrame frame;
    private final ButtonFactory buttonFactory;
    private final TextFieldFactory textFieldFactory;
    private final LabelFactory labelFactory;

    public ButtonManager(JFrame frame, ButtonFactory buttonFactory, TextFieldFactory textFieldFactory, LabelFactory labelFactory) {
        this.frame = frame;
        this.buttonFactory = buttonFactory;
        this.textFieldFactory = textFieldFactory;
        this.labelFactory = labelFactory;
    }

    public void addButtons() {
        frame.add(buttonFactory.getAddRecordButton());
        frame.add(buttonFactory.getDisplayRecordButton());
        frame.add(buttonFactory.getDisplayAverageButton());

        frame.add(textFieldFactory.getSystolicField());
        frame.add(textFieldFactory.getDiastolicField());
        frame.add(textFieldFactory.getPulseField());
        frame.add(textFieldFactory.getPulsePressureField());

        frame.add(labelFactory.getSystolicLabel());
        frame.add(labelFactory.getDiastolicLabel());
        frame.add(labelFactory.getPulseLabel());
        frame.add(labelFactory.getPulsePressureLabel());

    }
}
