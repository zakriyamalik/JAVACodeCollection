import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Temp {


    public static void createAndShowTable(ArrayList<String> dataList) {
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





    public static void main(String[] args) {
        ArrayList<String> dataList = new ArrayList<>();
        // Sample data (in your case, you'll read this from a file)
        dataList.add("1234123412341,2024-9-6,2024-9-6");
        dataList.add("1234123412341,2024-9-6,1212-12-12");
        dataList.add("1234123412342,2024-9-6,2023-7-7");
        dataList.add("44444444444444,2024-9-1,2027-7-7");

        // Create and display the table with the data
        createAndShowTable(dataList);
    }
}
