package Lab4;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBGUI implements ActionListener {
    static JFrame frame = new JFrame();
    private final JComboBox comboBox;
    private final JButton button = new JButton("Facts");
    public DBGUI(APIData data){
        frame.setTitle("DB");
        //headers for the table
        String[] columns = new String[] {"Id", "Name", "ImageLink"};

        //actual data for the table in a 2d array
        Object[][] tableData = new Object[data.getData().size()][columns.length];

        for (int i = 0;i<tableData.length;i++){
            tableData[i][0] = data.getData().get(i).getAnimeId();
            tableData[i][1] = data.getData().get(i).getAnimeName();
            tableData[i][2] = data.getData().get(i).getAnimeImg();
        }
        //create table with data
        JTable table = new JTable(tableData, columns);
        table.setDefaultEditor(Object.class, null);
        String[] names = new String[data.getData().size()];
        for (int i = 0;i<names.length; i++){
            names[i] = data.getData().get(i).getAnimeName();
        }
        resizeColumnWidth(table);


        comboBox = new JComboBox(names);
        button.setBounds(100, 160, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(table));
        frame.add(comboBox);
        frame.add(button);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            String anime_name = String.valueOf(comboBox.getSelectedItem());
            frame.dispose();
            APIGetter apiGetter = new APIGetter();
            APIGetter.url = "https://anime-facts-rest-api.herokuapp.com/api/v1/" + anime_name;
            apiGetter.run();
            Facts facts = (Facts) apiGetter.JsonParse(Facts.class);

            FactsGUI factsGUI = new FactsGUI(facts);
        }
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 30; // Min width
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
}
