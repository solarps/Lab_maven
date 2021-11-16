package Lab4;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactsGUI implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton button = new JButton("Back");
    public FactsGUI(Facts facts) {
        frame.setTitle("Facts");
        //headers for the table
        String[] columns = new String[] {"Id", "Fact"};

        //actual data for the table in a 2d array
        Object[][] tableData = new Object[facts.getData().size()][columns.length];

        for (int i = 0;i<tableData.length;i++){
            tableData[i][0] = facts.getData().get(i).getFactId();
            tableData[i][1] = facts.getData().get(i).getFact();
        }
        //create table with data
        JTable table = new JTable(tableData, columns);
        table.setDefaultEditor(Object.class, null);
        resizeColumnWidth(table);

        button.addActionListener(this);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(table));
        frame.add(button);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            frame.dispose();
            DBGUI.frame.setVisible(true);
        }
    }
}
