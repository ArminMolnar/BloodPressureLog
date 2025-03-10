package buttonController;

import components.ButtonFactory;
import components.LabelFactory;
import components.TextFieldFactory;
import connection.DatabaseConnection;
import controller.Controller;
import service.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ButtonEventHandler implements ActionListener {
    JFrame frame;
    private final ButtonFactory buttonFactory;
    private final TextFieldFactory textFieldFactory;
    private final LabelFactory labelFactory;
    private final Controller controller;
    private final Calculator calculator;
    private final ButtonManager buttonManager;


    public ButtonEventHandler(JFrame frame, ButtonFactory buttonFactory, TextFieldFactory textFieldFactory, LabelFactory labelFactory, Controller controller, Calculator calculator) {
        this.frame = frame;
        this.buttonFactory = buttonFactory;
        this.textFieldFactory = textFieldFactory;
        this.labelFactory = labelFactory;
        this.controller = controller;
        this.calculator = calculator;
        this.buttonManager = new ButtonManager(frame, buttonFactory, textFieldFactory, labelFactory);
    }

    private void handleTestConnection() {
        String password = textFieldFactory.getPasswordField().getText();
        if (DatabaseConnection.testConnection(password)) {
            DatabaseConnection.setPassword(password);
            JOptionPane.showMessageDialog(frame, "Connected to the database");

            setupFunctionFrame();

        } else {
            JOptionPane.showMessageDialog(frame, "Connection failed");
        }
    }


    private void handleAddRecord() throws SQLException {
        String name = storeName();

        String systolicValue = textFieldFactory.getSystolicField().getText();
        int systolic = Integer.parseInt(systolicValue);

        String diastolicValue = String.valueOf(textFieldFactory.getDiastolicField().getText());
        int diastolic = Integer.parseInt(diastolicValue);

        String pulseValue = String.valueOf(textFieldFactory.getPulseField().getText());
        int pulse = Integer.parseInt(pulseValue);

        String pulsePressureValue = String.valueOf(textFieldFactory.getPulsePressureField().getText());
        int pulsePressure = Integer.parseInt(pulsePressureValue);

        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());

        controller.addRecord(name, String.valueOf(systolic), String.valueOf(diastolic), String.valueOf(pulse), String.valueOf(pulsePressure), sqlTimestamp);
        JOptionPane.showMessageDialog(frame, "Record added");
        clearTextField();

    }

    private void handleOkButton() {
        storeName();
        frame.remove(textFieldFactory.getNameTextField());
        frame.remove(buttonFactory.getOkButton());
        frame.remove(labelFactory.getNameLabel());
        frame.remove(textFieldFactory.getPasswordField());
        buttonManager.addButtons();
        refreshFrame();

    }

    private void handleDisplayRecordButton() throws SQLException {
        if (controller.checkIfPersonExists(textFieldFactory)) {
            controller.displayRecord(textFieldFactory);
        } else {
            JOptionPane.showMessageDialog(frame, "No data for this person yet." + '\n' + "Enter blood pressure values first");
        }

    }

    private void handleAverageRecordButton() throws SQLException {
        frame.add(labelFactory.getAverageLabel());
        frame.add(labelFactory.getAvgResultLabel());
        calculator.calculateAverage(textFieldFactory);
        refreshFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            handleAction(e.getSource());
        } catch (SQLException ex) {
            handleSQLException(ex);
        }
    }

    private void handleAction(Object source) throws SQLException {
        if (source == buttonFactory.getTestConnectionButton()) {
            handleTestConnection();
        } else if (source == buttonFactory.getOkButton()) {
            handleOkButton();
        } else if (source == buttonFactory.getAddRecordButton()) {
            handleAddRecord();
        } else if (source == buttonFactory.getDisplayRecordButton()) {
            handleDisplayRecordButton();
        } else if (source == buttonFactory.getDisplayAverageButton()) {
            handleAverageRecordButton();
        }
    }

    private void handleSQLException(SQLException ex) {
        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
    }

    private void clearTextField() {
        textFieldFactory.getPasswordField().setText("");
        textFieldFactory.getSystolicField().setText("");
        textFieldFactory.getDiastolicField().setText("");
        textFieldFactory.getPulseField().setText("");
        textFieldFactory.getPulsePressureField().setText("");
    }

    private String storeName() {
        return textFieldFactory.getNameTextField().getText();
    }

    private void refreshFrame() {
        frame.revalidate();
        frame.repaint();
    }

    private void setupFunctionFrame() {
        frame.add(textFieldFactory.getNameTextField());
        frame.add(buttonFactory.getOkButton());
        frame.add(labelFactory.getNameLabel());
        refreshFrame();
        frame.remove(textFieldFactory.getPasswordField());
        frame.remove(labelFactory.getPasswordLabel());
        frame.remove(buttonFactory.getTestConnectionButton());
        clearTextField();
    }

}
