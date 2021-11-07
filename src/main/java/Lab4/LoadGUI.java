package Lab4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Random;

public class LoadGUI extends JFrame implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton button = new JButton("Load data");
    static Random random = new Random();

    public LoadGUI() {
        button.setBounds(100, 160, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        frame.add(button);
        frame.setTitle("Load");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            frame.dispose();
            //JOptionPane.showMessageDialog(null,"Loading data...");
            Thread downloadThread = new DownloadThread();
            downloadThread.start();
            try {
                downloadThread.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            APIData data = DownloadThread.data;
            /*System.out.println(data);
            System.out.println("Sorted by name:");
            data.getData().sort(Comparator.comparing(Anime::getAnimeName));
            System.out.println(data);
            int i = random.nextInt(data.getData().size());
            String Anime_name = data.getData().get(i).getAnimeName();
            APIGetter apiGetter = new APIGetter();
            APIGetter.url = "https://anime-facts-rest-api.herokuapp.com/api/v1/" + Anime_name;
            apiGetter.run();
            Facts facts = (Facts) apiGetter.JsonParse(Facts.class);
            System.out.println("Anime: " + Anime_name);
            System.out.println(facts);*/
            DBGUI dbgui = new DBGUI(data);
        }
    }
}