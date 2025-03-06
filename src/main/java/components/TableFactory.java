package components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableFactory extends JFrame {

    private final DefaultTableModel model;

    public TableFactory() {
        setTitle("Blood Pressure Data");
        setSize(800, 600);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"Name", "Systolic", "Diastolic", "Pulse", "PulsePressure", "Date"}, 0);

        JTable table = new JTable(model) {
        };

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
