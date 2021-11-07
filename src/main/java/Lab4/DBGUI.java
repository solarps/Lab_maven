package Lab4;

import javax.swing.*;

public class DBGUI extends JFrame {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    public DBGUI(APIData data){
        frame.setTitle("DB");
        //headers for the table
        String[] columns = new String[] {"Id", "Name", "ImageLink"};

        //actual data for the table in a 2d array
        Object[][] tableData = new Object[data.getData().size()][3];

        for (int i = 0;i<tableData.length;i++){
            tableData[i][0] = data.getData().get(i).getAnimeId();
            tableData[i][1] = data.getData().get(i).getAnimeName();
            tableData[i][2] = data.getData().get(i).getAnimeImg();
        }
        //create table with data
        JTable table = new JTable(tableData, columns);
        table.setDefaultEditor(Object.class, null);        //add the table to the frame
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*label.setText(data.getData().toString());
        frame.add(label);*/
    }
}
