package components;

import buttonController.ButtonEventHandler;
import controller.Controller;
import service.Calculator;

import javax.swing.*;
import java.awt.*;

public class FrameFactory {

    private static final ButtonFactory buttonFactory = ButtonFactory.getInstance();
    private static final TextFieldFactory textFieldFactory = TextFieldFactory.getInstance();
    private static final LabelFactory labelFactory = LabelFactory.getInstance();
    private static final Controller controller = Controller.getInstance();
    private static final PasswordFieldFactory passwordFieldFactory = PasswordFieldFactory.getInstance();
    private static final Calculator calculator = new Calculator(labelFactory);


    public void createMainFrame() {

        JFrame mainFrame = new JFrame();
        ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/TokyoGhoul.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setSize(500, 550);


        ButtonEventHandler buttonController = new ButtonEventHandler(mainFrame, buttonFactory, textFieldFactory, labelFactory, controller, calculator, passwordFieldFactory);

        buttonFactory.getTestConnectionButton().addActionListener(buttonController);
        buttonFactory.getOkButton().addActionListener(buttonController);
        buttonFactory.getAddRecordButton().addActionListener(buttonController);
        buttonFactory.getDisplayRecordButton().addActionListener(buttonController);
        buttonFactory.getDisplayAverageButton().addActionListener(buttonController);

        mainFrame.setTitle("Blood Pressure Log");
        mainFrame.setSize(500, 550);

        mainFrame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
        mainFrame.setLayout(null);
        mainFrame.setContentPane(backgroundLabel);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(buttonFactory.getTestConnectionButton());
        mainFrame.add(labelFactory.getPasswordLabel());
        mainFrame.add(passwordFieldFactory.getPasswordField());


    }

}
