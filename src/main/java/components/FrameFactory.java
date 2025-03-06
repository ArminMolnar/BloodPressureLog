package components;

import buttonController.ButtonEventHandler;
import controller.Controller;
import service.Calculator;

import javax.swing.*;
import java.awt.*;

public class FrameFactory {

    static ButtonFactory buttonFactory = new ButtonFactory();
    static TextFieldFactory textFieldFactory = new TextFieldFactory();
    static LabelFactory labelFactory = new LabelFactory();
    static Controller controller = new Controller();
    static Calculator calculator = new Calculator(labelFactory);


    public static void createMainFrame() {

        JFrame mainFrame = new JFrame();

        ButtonEventHandler buttonController = new ButtonEventHandler(mainFrame, buttonFactory, textFieldFactory, labelFactory, controller, calculator);

        buttonFactory.getTestConnectionButton().addActionListener(buttonController);
        buttonFactory.getOkButton().addActionListener(buttonController);
        buttonFactory.getAddRecordButton().addActionListener(buttonController);
        buttonFactory.getDisplayRecordButton().addActionListener(buttonController);
        buttonFactory.getDisplayAverageButton().addActionListener(buttonController);

        mainFrame.setTitle("Blood Pressure Log");
        mainFrame.setSize(500, 600);
        mainFrame.getContentPane().setBackground(Color.gray);
        mainFrame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(buttonFactory.getTestConnectionButton());
        mainFrame.add(textFieldFactory.getPasswordField());
        mainFrame.add(labelFactory.getPasswordLabel());
    }

}
