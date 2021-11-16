package Lab4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadGUI extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton button = new JButton("Load data");

    public LoadGUI() {
        button.setBounds(100, 160, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);
        frame.add(button);
        frame.setTitle("Load");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            frame.dispose();
            Thread downloadThread = new DownloadThread();
            downloadThread.start();
            try {
                downloadThread.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            APIData data = DownloadThread.data;
            DBGUI dbgui = new DBGUI(data);
        }
    }
}