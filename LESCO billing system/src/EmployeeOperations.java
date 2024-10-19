import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeOperations {
    public MeterOperations mt=new MeterOperations(null);

<<<<<<< HEAD
    public static void showExpiringEmpCNIC(ArrayList<String> expiringCNICList) {
        JFrame frame = new JFrame("Expiring CNIC List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 700, 400);
=======
    void showExpiringEmpCNIC(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"CNIC","Allotment Date","Expiry Date"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b

        // Column headers for the table
        String[] columnNames = {"CNIC", "Allotment Date", "Expiry Date", "Update", "Save", "Delete"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[expiringCNICList.size()][columnNames.length];

        for (int i = 0; i < expiringCNICList.size(); i++) {
            String[] rowData = expiringCNICList.get(i).split(",");
            int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3); // Reserve 3 columns for buttons
            System.arraycopy(rowData, 0, data[i], 0, numberOfColumnsToCopy);
            data[i][3] = "Update";  // Update button
            data[i][4] = "Save";    // Save button
            data[i][5] = "Delete";  // Delete button
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(650, 300));
        table.setFillsViewportHeight(true);

        // Initially make the table cells non-editable
        table.setDefaultEditor(Object.class, null);

        // Add update button functionality
        table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton updateButton = new JButton("Update");

                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Update clicked for row: " + row);

                        // Enable editing for the entire row (CNIC, Allotment Date, Expiry Date)
                        for (int col = 0; col < 3; col++) {
                            table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                        }

                        // Show the Save button after enabling editing
                        tableModel.setValueAt("Save", row, 4);
                    }
                });
                return updateButton;
            }
        });

        // Add save button functionality
        table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton saveButton = new JButton("Save");

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Save the changes to the expiringCNICList
                        StringBuilder updatedRow = new StringBuilder();
                        for (int col = 0; col < 3; col++) {
                            updatedRow.append(tableModel.getValueAt(row, col).toString()).append(",");
                        }

                        // Update the corresponding row in the expiringCNICList
                        expiringCNICList.set(row, updatedRow.toString());

                        System.out.println("Saved changes for row: " + row);

                        // Write updated expiringCNICList to the file
                        writeExpiringCNICListToFile(expiringCNICList);

                        // Make the row non-editable again after saving
                        table.setDefaultEditor(Object.class, null);
                    }
                });
                return saveButton;
            }
        });

        // Add delete button functionality
        table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton deleteButton = new JButton("Delete");

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Delete clicked for row: " + row);

                        // Remove the row from expiringCNICList and the table
                        expiringCNICList.remove(row);
                        tableModel.removeRow(row);

                        // Write updated expiringCNICList to the file
                        writeExpiringCNICListToFile(expiringCNICList);
                    }
                });
                return deleteButton;
            }
        });

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

<<<<<<< HEAD
    // Helper method to write expiringCNICList to file
    public static void writeExpiringCNICListToFile(ArrayList<String> expiringCNICList) {
        String fileName = "TempExpiringCNICInfo.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : expiringCNICList) {
                writer.write(line);
                writer.newLine();  // Write each entry on a new line
            }
            System.out.println("Expiring CNIC data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void showAllBill(ArrayList<String> billDataList) {
        JFrame frame = new JFrame("All Bills");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 500, 700, 400);

        // Column headers for the table
        String[] columnNames = {"ID", "Month", "Regular Units", "Peak Units", "Entry Date", "Cost of Electricity", "Sales Tax", "Fixed Charge", "Total", "Due Date", "Status", "Update", "Save", "Delete"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[billDataList.size()][columnNames.length];

        for (int i = 0; i < billDataList.size(); i++) {
            String[] rowData = billDataList.get(i).split(",");
            int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3); // Reserve 3 columns for buttons
            System.arraycopy(rowData, 0, data[i], 0, numberOfColumnsToCopy);
            data[i][11] = "Update";  // Update button
            data[i][12] = "Save";    // Save button
            data[i][13] = "Delete";  // Delete button
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(650, 300));
        table.setFillsViewportHeight(true);

        // Initially make the table cells non-editable
        table.setDefaultEditor(Object.class, null);

        // Add update button functionality
        table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton updateButton = new JButton("Update");

                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Update clicked for row: " + row);

                        // Enable editing for the entire row (all bill columns except buttons)
                        for (int col = 0; col < 11; col++) {
                            table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                        }

                        // Show the Save button after enabling editing
                        tableModel.setValueAt("Save", row, 12);
                    }
                });
                return updateButton;
            }
        });

        // Add save button functionality
        table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton saveButton = new JButton("Save");

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Save the changes to the billDataList
                        StringBuilder updatedRow = new StringBuilder();
                        for (int col = 0; col < 11; col++) {
                            updatedRow.append(tableModel.getValueAt(row, col).toString()).append(",");
                        }

                        // Update the corresponding row in the billDataList
                        billDataList.set(row, updatedRow.toString());

                        System.out.println("Saved changes for row: " + row);

                        // Write updated billDataList to the file
                        writeBillDataToFile(billDataList);

                        // Make the row non-editable again after saving
                        table.setDefaultEditor(Object.class, null);
                    }
                });
                return saveButton;
            }
        });

        // Add delete button functionality
        table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton deleteButton = new JButton("Delete");

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Delete clicked for row: " + row);

                        // Remove the row from billDataList and the table
                        billDataList.remove(row);
                        tableModel.removeRow(row);

                        // Write updated billDataList to the file
                        writeBillDataToFile(billDataList);
                    }
                });
                return deleteButton;
            }
        });

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Helper method to write billDataList to file
    public static void writeBillDataToFile(ArrayList<String> billDataList) {
        String fileName = "Temp-AllBillData.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : billDataList) {
                writer.write(line);
                writer.newLine();  // Write each entry on a new line
            }
            System.out.println("Bill data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void showAllPaid(ArrayList<String> paidDataList) {
        JFrame frame = new JFrame("Paid Bills");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 700, 400);

        // Column headers for the table
        String[] columnNames = {"ID", "Month", "Regular Units", "Peak Units", "Entry Date", "Cost of Electricity", "Sales Tax", "Fixed Charge", "Total", "Due Date", "Status", "Update", "Save", "Delete"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[paidDataList.size()][columnNames.length];

        for (int i = 0; i < paidDataList.size(); i++) {
            String[] rowData = paidDataList.get(i).split(",");
            int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3); // Reserve 3 columns for buttons
            System.arraycopy(rowData, 0, data[i], 0, numberOfColumnsToCopy);
            data[i][11] = "Update";  // Update button
            data[i][12] = "Save";    // Save button
            data[i][13] = "Delete";  // Delete button
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(650, 300));
        table.setFillsViewportHeight(true);

        // Initially make the table cells non-editable
        table.setDefaultEditor(Object.class, null);

        // Add update button functionality
        table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton updateButton = new JButton("Update");

                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Update clicked for row: " + row);

                        // Enable editing for the entire row (all columns except buttons)
                        for (int col = 0; col < 11; col++) {
                            table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                        }

                        // Show the Save button after enabling editing
                        tableModel.setValueAt("Save", row, 12);
                    }
                });
                return updateButton;
            }
        });

        // Add save button functionality
        table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton saveButton = new JButton("Save");

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Save the changes to the paidDataList
                        StringBuilder updatedRow = new StringBuilder();
                        for (int col = 0; col < 11; col++) {
                            updatedRow.append(tableModel.getValueAt(row, col).toString()).append(",");
                        }

                        // Update the corresponding row in the paidDataList
                        paidDataList.set(row, updatedRow.toString());

                        System.out.println("Saved changes for row: " + row);

                        // Write updated paidDataList to the file
                        writeBillDataToFile(paidDataList, "PaidBillData.txt");

                        // Make the row non-editable again after saving
                        table.setDefaultEditor(Object.class, null);
                    }
                });
                return saveButton;
            }
        });

        // Add delete button functionality
        table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton deleteButton = new JButton("Delete");

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Delete clicked for row: " + row);

                        // Remove the row from paidDataList and the table
                        paidDataList.remove(row);
                        tableModel.removeRow(row);

                        // Write updated paidDataList to the file
                        writeBillDataToFile(paidDataList, "PaidBillData.txt");
                    }
                });
                return deleteButton;
            }
        });

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Helper method to write data to a file
    public static void writeBillDataToFile(ArrayList<String> dataList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : dataList) {
                writer.write(line);
                writer.newLine();  // Write each entry on a new line
            }
            System.out.println("Data written to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


        public static void showAllUnPaid(ArrayList<String> unpaidDataList) {
            JFrame frame = new JFrame("Unpaid Bills");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(600, 0, 700, 400);

            // Column headers for the table
            String[] columnNames = {"ID", "Month", "Regular Units", "Peak Units", "Entry Date", "Cost of Electricity", "Sales Tax", "Fixed Charge", "Total", "Due Date", "Status", "Update", "Save", "Delete"};

            // Convert ArrayList to 2D Object array for JTable
            String[][] data = new String[unpaidDataList.size()][columnNames.length];

            for (int i = 0; i < unpaidDataList.size(); i++) {
                String[] rowData = unpaidDataList.get(i).split(",");
                int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3); // Reserve 3 columns for buttons
                System.arraycopy(rowData, 0, data[i], 0, numberOfColumnsToCopy);
                data[i][11] = "Update";  // Update button
                data[i][12] = "Save";    // Save button
                data[i][13] = "Delete";  // Delete button
            }

            // Table model
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(tableModel);
            table.setPreferredScrollableViewportSize(new Dimension(650, 300));
            table.setFillsViewportHeight(true);

            // Initially make the table cells non-editable
            table.setDefaultEditor(Object.class, null);

            // Add update button functionality
            table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton updateButton = new JButton("Update");

                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Update clicked for row: " + row);

                            // Enable editing for the entire row (all columns except buttons)
                            for (int col = 0; col < 11; col++) {
                                table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                            }

                            // Show the Save button after enabling editing
                            tableModel.setValueAt("Save", row, 12);
                        }
                    });
                    return updateButton;
                }
            });

            // Add save button functionality
            table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton saveButton = new JButton("Save");

                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Save the changes to the unpaidDataList
                            StringBuilder updatedRow = new StringBuilder();
                            for (int col = 0; col < 11; col++) {
                                updatedRow.append(tableModel.getValueAt(row, col).toString()).append(",");
                            }

                            // Update the corresponding row in the unpaidDataList
                            unpaidDataList.set(row, updatedRow.toString());

                            System.out.println("Saved changes for row: " + row);

                            // Write updated unpaidDataList to the file
                            writeBillDataToFile(unpaidDataList, "UnpaidBillData.txt");

                            // Make the row non-editable again after saving
                            table.setDefaultEditor(Object.class, null);
                        }
                    });
                    return saveButton;
                }
            });

            // Add delete button functionality
            table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    JButton deleteButton = new JButton("Delete");

                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Delete clicked for row: " + row);

                            // Remove the row from unpaidDataList and the table
                            unpaidDataList.remove(row);
                            tableModel.removeRow(row);

                            // Write updated unpaidDataList to the file
                            writeBillDataToFile(unpaidDataList, "UnpaidBillData.txt");
                        }
                    });
                    return deleteButton;
                }
            });

            // Add the table to a scroll pane (so it is scrollable)
            JScrollPane scrollPane = new JScrollPane(table);

            // Add the scroll pane to the frame
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        }




    public void showAllEmployees(ArrayList<String> dataList) {
        JFrame frame = new JFrame("Employee Data Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Column headers for the table
        String[] columnNames = {"Name", "Password", "Update", "Save", "Delete"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][columnNames.length];
        for (int i = 0; i < dataList.size(); i++) {
            String[] rowData = dataList.get(i).split(",");
            int numberOfColumnsToCopy = Math.min(rowData.length, columnNames.length - 3); // Reserve 3 columns for buttons
            System.arraycopy(rowData, 0, data[i], 0, numberOfColumnsToCopy);
            data[i][2] = "Update";  // Update button
            data[i][3] = "Save";    // Save button
            data[i][4] = "Delete";  // Delete button
=======


    void showAllBill(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,500,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
<<<<<<< HEAD
        table.setPreferredScrollableViewportSize(new Dimension(550, 300));
        table.setFillsViewportHeight(true);

        // Initially make the table cells non-editable
        table.setDefaultEditor(Object.class, null);

        // Add update button functionality
        table.getColumn("Update").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton updateButton = new JButton("Update");

                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Update clicked for row: " + row);

                        // Enable editing for the row
                        for (int col = 0; col < 2; col++) {
                            table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new JTextField()));
                        }

                        // Show Save button after enabling editing
                        tableModel.setValueAt("Save", row, 3);
                    }
                });
                return updateButton;
            }
        });

        // Add save button functionality
        table.getColumn("Save").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton saveButton = new JButton("Save");

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Save the changes to the dataList
                        StringBuilder updatedRow = new StringBuilder();
                        for (int col = 0; col < 2; col++) {
                            updatedRow.append(tableModel.getValueAt(row, col).toString()).append(",");
                        }

                        // Update the corresponding row in the dataList
                        dataList.set(row, updatedRow.toString());

                        System.out.println("Saved changes for row: " + row);

                        // Write updated dataList to file
                        writeEmployeeDataToFile(dataList, "EmployeeData.txt");

                        // Make the row non-editable again after saving
                        table.setDefaultEditor(Object.class, null);
                    }
                });
                return saveButton;
            }
        });

        // Add delete button functionality
        table.getColumn("Delete").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton deleteButton = new JButton("Delete");

                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Delete clicked for row: " + row);

                        // Remove the row from dataList and the table
                        dataList.remove(row);
                        tableModel.removeRow(row);

                        // Write updated dataList to file
                        writeEmployeeDataToFile(dataList, "Temp-EmployeeData.txt");
                    }
                });
                return deleteButton;
            }
        });
=======
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    void showAllPaid(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500, 400);
       // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    void showAllUnPaid(ArrayList<String> dataList)
    {
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600,0,500, 400);
        // id + "," + currentMonthName + "," + currentReadingRegular + "," + currentReadingPeak + "," + readingEntryDate + "," + costOfElectricity + "," + salesTaxAmount + "," + fixedCharge + "," + totalBillingCharge + "," + dueDate + "," + billPaidStatus + "," + dueDate;// Write the line to the file
        // Column headers for the table
        String[] columnNames = {"ID", "Month","Regular Units","Peak Units","Entry Date","costOfElectricity","Sales Tax","fixed Charge","Total","Due Date","Status"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }


    void showALlEmployees(ArrayList<String> dataList)
    {
        // Frame for the table
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Column headers for the table
        String[] columnNames = {"Name", "Passwrod"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
<<<<<<< HEAD

    // Helper method to write data to a file
    public static void writeEmployeeDataToFile(ArrayList<String> dataList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : dataList) {
                writer.write(line);
                writer.newLine();  // Write each entry on a new line
            }
            System.out.println("Data written to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
//    void showExpiryDateTable( ArrayList<String> dataList)
//    {
//        // Frame for the table
//        JFrame frame = new JFrame("Data List Table");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);
//
//        // Column headers for the table
//        String[] columnNames = {"CNIC", "Start Date", "Expiry Date"};
//
//        // Convert ArrayList to 2D Object array for JTable
//        String[][] data = new String[dataList.size()][];
//        for (int i = 0; i < dataList.size(); i++) {
//            data[i] = dataList.get(i).split(",");
//        }
//
//        // Table model
//        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
//        JTable table = new JTable(tableModel);
//        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
//        table.setFillsViewportHeight(true);
//
//        // Add the table to a scroll pane (so it is scrollable)
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // Add the scroll pane to the frame
//        frame.add(scrollPane, BorderLayout.CENTER);
//        frame.setVisible(true);
//    }






=======
    void showExpiryDateTable( ArrayList<String> dataList)
    {
        // Frame for the table
        JFrame frame = new JFrame("Data List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Column headers for the table
        String[] columnNames = {"CNIC", "Start Date", "Expiry Date"};

        // Convert ArrayList to 2D Object array for JTable
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).split(",");
        }

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane (so it is scrollable)
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b

    public void addEmployee(String name,String password) throws FileNotFoundException {
        String employeeFile="EmployeesData.txt";
        System.out.println("Add New Employee");

        Scanner scanner = new Scanner(System.in);

        // Get employee name and password from user input
//        System.out.println("Enter Employee Name:");
//        String name = scanner.nextLine();
//
//        System.out.println("Enter Employee Password:");
//        String password = scanner.nextLine();

        // Construct the employee data in the required format (comma-separated)
        String employeeInfo = name + "," + password;

        // Read the existing file to check for duplicate name
        boolean isEmployeeExist = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] existingEmployeeData = line.split(",", 2);
                if (existingEmployeeData.length > 1 && existingEmployeeData[0].equals(name)) {
                    isEmployeeExist = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the employee file: " + e.getMessage());
        }

        // If the employee exists, ask the user if they still want to add

        // Add the new employee to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(employeeFile, true))) {
            writer.write(employeeInfo);
            writer.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to the employee file: " + e.getMessage());
        }
        ArrayList<String> dataList=new ArrayList<>();
        String line="";
        dataList=mt.readFile("EmployeesData.txt",dataList,line);
        System.out.println("Data in Employee File\n");
        for(String s:dataList)
        {
            System.out.println(s+"\n");
        }
<<<<<<< HEAD
        showAllEmployees(dataList);
=======
        showALlEmployees(dataList);
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b
    }

    public void updateExpiry(String cnic,String expiryDate)
    {

        System.out.println("WellCome to Update Expiry");

        String fileName="CustomerInfo.txt";
        String line="";
        String line1="";
        String customerCNIC="";
        ArrayList<String> dataList = new ArrayList<>();
       // String expiryDate="";


        Scanner scan = new Scanner(System.in);
       // System.out.println("Enter CNIC");
      //  String cnic = scan.nextLine();
        boolean isUserFound=false;

        File inputFile = new File(fileName);
       // File tempFile = new File("temp_" + fileName);
        //BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        )
        {


            while ((line1 = reader.readLine()) != null) {


                String[] userData = line1.split(",");
                customerCNIC = userData[1];

               // System.out.println("data\t"+customerCNIC+"\n");
                if (cnic.equals(customerCNIC)) {
                    isUserFound=true;
                    System.out.println("User Found\n");



                    try (
                            BufferedReader readerBill = new BufferedReader(new FileReader("NADRADB.txt"));

                    ) {


                        while ((line = readerBill.readLine()) != null) {

                          //  System.out.println("Line:"+line);
                            String[] dateData = line.split(",");
//                                System.out.println("Date Data is :\n");
//                                for(int i=0; i<dateData.length; i++) {
//                                    System.out.println("dateData["+i+"] : "+dateData[i]);
//                                }
                            customerCNIC=dateData[0];

                            if (cnic.equals(customerCNIC))
                            {

                                System.out.println("CNIC Found\n");
                               // expiryDate=dateData[2];
                                System.out.println("CNIC:"+customerCNIC+" UpdatedDate: "+expiryDate+"\n");

                              //  System.out.println("Expiry Date : "+expiryDate);
                                Scanner scanner1 = new Scanner(System.in);
//                                System.out.println("Enter updated Expiry Date(YYYY-MM-DD)\n");
//                                expiryDate=scanner1.nextLine();

                                dateData[dateData.length-1]= String.valueOf(expiryDate);
                              //  System.out.println("dateData["+dateData.length+"] : "+dateData[dateData.length-1]);
                                line = String.join(",", dateData);
                                System.out.println("Update Record:\n"+line);
                               // System.out.println("line:\t"+line);
                                dataList.add(line);
                            }
                            else
                            {
                               // System.out.println(line);
                                dataList.add(line);

                            }

                        }
<<<<<<< HEAD
                        showExpiringEmpCNIC(dataList);
=======
                        showExpiryDateTable(dataList);
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b
                       for(int i=0;i<dataList.size();i++)
                       {
                           System.out.println("DataList["+i+"] "+dataList.get(i));
                       }
                        mt.writeFile("NADRADB.txt", dataList);
//                        BufferedWriter writer1 = new BufferedWriter(new FileWriter("NADRADB.txt"));
//                        for (String s : dataList) {
//                            writer1.write(s+System.lineSeparator());
//                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }






//                    if(userData.length==9)
//                    {
//                        System.out.println("In famouse If User datta\n"+userData[userData.length-1]);
//                        meterCounter=1;
//                        line1=line1+","+meterCounter;
//                    }
//                    else {
//                        System.out.println("In famouse If User datta\n"+userData[userData.length-1]);
//
//                        meterCounter= Integer.parseInt(userData[userData.length-1]);
//                        meterCounter++;
//                        System.out.println("In famouse else\n"+meterCounter);
//                        userData[userData.length-1]= String.valueOf(meterCounter);
//                        line1 = String.join(",", userData);
//
//                    }
//                    System.out.println("Data in the list after modification");
//                    for (String data : dataList) {
//                        System.out.println(data);
//                    }
//
//                    writeFile(dataList);

//                    System.out.println("\n\nin if\n\n ");
//                   flag=true;
//
//                    System.out.println("Updated line is "+line1);
//                    //System.out.println("\nCounter:"+coutner+"dataList.size()"+dataList.size());
//                    if (coutner >= 0 && coutner < dataList.size()) {
//                        dataList.set(coutner, line1);
//                        System.out.println(coutner + "\n" + line1);
//                    } else {
//                        System.out.println("Index out of bounds: " + coutner);
//                    }
//                    break;
//                    dataList.set(coutner-1,line);
//
//                    System.out.println(coutner+"\n"+line);



                    //   writer.write(line + System.lineSeparator());

                }



            }
            if(isUserFound)
            {
                System.out.println("User found\n");

            }
            else
            {
                System.out.println("User not Found");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

}

    public void paidUnpaidreport() {
        System.out.println("Paid Unpaid Report");

        boolean status = false;
        String line;
        boolean userFound = false;
        ArrayList<String> unPaid=new ArrayList<>();
        ArrayList<String> paid=new ArrayList<>();
        ArrayList<String> totalBills=new ArrayList<>();


            try (
                    BufferedReader readerBill = new BufferedReader(new FileReader("BillingInfo.txt"));
                    Scanner scannerBill = new Scanner(System.in)
            ) {

                while ((line = readerBill.readLine()) != null) {
                    totalBills.add(line);


                    String[] dbData = line.split(",");
                    System.out.println("Data is :\n");
                    for(int i=0; i<dbData.length; i++) {
                        System.out.println("dbData["+i+"] : "+dbData[i]);
                    }
                    status=Boolean.parseBoolean(dbData[10]);
                    if (status) {
                        paid.add(line);
                    }
                    else if(status==false)
                    {
                        unPaid.add(line);
                    }
                    else
                    {
                        System.out.println("In else\n");
                    }


                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(totalBills.isEmpty())
            {
                System.out.println("No Bill");
            }
            else {
                System.out.println("Total Bills\n");
                for(int i=0;i<totalBills.size();i++)
                {
                    System.out.println(totalBills.get(i));
                }
                showAllBill(totalBills);
            }

            if(paid.isEmpty())
            {
                System.out.println("No paid Bill");
            }
            else {
                System.out.println("Paid\n");
                for(int i=0;i<paid.size();i++)
                {
                    System.out.println(paid.get(i));
                }
                showAllPaid(paid);

            }
            if(unPaid.isEmpty())
            {
                System.out.println("No unpaid Bill");
            }
            else {
                System.out.println("Unpaid Bill\n");
                for(int i=0;i<unPaid.size();i++)
                {
                    System.out.println(unPaid.get(i));
                }
                showAllUnPaid(unPaid);
            }

    }

    public void viewExpiringCNIC() throws ParseException {
        System.out.println("In view Expiring CNIC");


        String name = "";
        String password = "";
        String line;
        boolean userFound = false;
        String expiryDate="";
        String currDate = "";
        String datePlus30Days = "";
        Date d1 = null;
        Date d2 = null;
        Date d3 = null;
        boolean flage=false;
        ArrayList<String> datalist=new ArrayList<>();




        LocalDate currentDate = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        currDate = currentDate.toString();
        d1 = sdf.parse(currDate);


        LocalDate futureDate = currentDate.plusDays(30);
        datePlus30Days = futureDate.toString();
        d2 = sdf.parse(datePlus30Days);




                        try (
                                BufferedReader readerBill = new BufferedReader(new FileReader("NADRADB.txt"));
                        ) {

                            while ((line = readerBill.readLine()) != null) {

                                String[] dbData = line.split(",");
                                expiryDate=dbData[2];
                                d3=sdf.parse(expiryDate);
//
                                if (d2.compareTo(d3) > 0 && d1.compareTo(d3) < 0)
                                {
                                    flage=true;
                                   // System.out.println(sdf.format(d2) + " (d1 + 30 days) is after " + expiryDate);
                                    System.out.println(line);
                                    datalist.add(line);
                                }


                            }
                            if(flage==false)
                            {
                                System.out.println("No User Found\n");
                                JOptionPane.showMessageDialog(null,"No User Found");
                            }
                            else
                            {
                                showExpiringEmpCNIC(datalist);
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        userFound = true;
                    }
<<<<<<< HEAD

    public static void main(String[] args) throws ParseException {
        EmployeeOperations em=new EmployeeOperations();
       // em.showAllEmployees();
    }
=======
>>>>>>> 1e6e73842a9a5b62a4432e7fea8310d4a71d6b3b
}
