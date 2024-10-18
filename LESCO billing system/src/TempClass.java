import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TempClass {

    public static void createTableWithUpdateAndDeleteButtons(ArrayList<String[]> dataList) {
        // Create table model with columns
        String[] columns = {"ID", "Name", "Update", "Delete", "Save"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        // Add rows to the table from dataList
        for (String[] data : dataList) {
            tableModel.addRow(new Object[]{data[0], data[1], "Update", "Delete", "Save"});
        }

        JTable table = new JTable(tableModel);

        // Initially make the cells non-editable except for the "Update", "Delete", and "Save" columns
        table.setDefaultEditor(Object.class, null);  // Disable cell editing globally

        // Adding Update button functionality
        table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton updateButton = new JButton("Update");

                updateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Update clicked for row: " + row);

                        // Make row editable
                        table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
                        table.editCellAt(row, 1);  // Enable editing for the Name column (index 1)

                        // Show the Save button after enabling editing
                        tableModel.setValueAt("Save", row, 4);
                    }
                });
                return updateButton;
            }
        });

        // Adding Delete button functionality
        table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton deleteButton = new JButton("Delete");

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get the row where the button was clicked
                        int clickedRow = row;
                        System.out.println("Delete clicked for row: " + clickedRow);

                        // Remove the selected row from dataList and the table
                        dataList.remove(clickedRow);
                        tableModel.removeRow(clickedRow);
                    }
                });
                return deleteButton;
            }
        });

        // Adding Save button functionality
        table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton saveButton = new JButton("Save");

                saveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // After editing, save the data to dataList
                        String updatedId = tableModel.getValueAt(row, 0).toString();
                        String updatedName = tableModel.getValueAt(row, 1).toString();

                        dataList.get(row)[0] = updatedId;
                        dataList.get(row)[1] = updatedName;

                        System.out.println("Saved changes for row: " + row + " - ID: " + updatedId + ", Name: " + updatedName);

                        // Write updated dataList to a temporary file
                        writeDataListToTempFile(dataList);

                        // Make the row non-editable again after saving
                        table.setDefaultEditor(Object.class, null);
                    }
                });
                return saveButton;
            }
        });

        // Setup JFrame
        JFrame frame = new JFrame("Table with Editable Rows and Save Button");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    // Method to write the dataList to a temporary file
    private static void writeDataListToTempFile(ArrayList<String[]> dataList) {
        try {
            // Create a temporary file
            File tempFile = new File("dataListTemp.txt");

            // Write dataList to the file
            FileWriter writer = new FileWriter(tempFile,false);
            for (String[] data : dataList) {
                writer.write(data[0] + "," + data[1] + "\n");
            }

            // Close the writer
            writer.close();

            // Print the path of the temp file
            System.out.println("Data written to temp file: " + tempFile.getAbsolutePath());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String[]> dataList = new ArrayList<>();
        dataList.add(new String[]{"101", "John"});
        dataList.add(new String[]{"102", "Jane"});

        createTableWithUpdateAndDeleteButtons(dataList);
    }
}
