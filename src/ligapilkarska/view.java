package ligapilkarska;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class view extends JFrame {

    private final model liga_model;
    private java.util.ArrayList<String> lista = new ArrayList<>();

    view(model model) {
        liga_model = model;
        glowneOkno();
    }

    private int szerokosc = 800;
    private int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    private JFrame okno;
    private JPanel panel;
    private JLabel gornynapis;
    public static JButton przycisk_uruchom = new JButton("1. Kolejka");
    public static JTextArea select = new JTextArea(8, 60);

    public void glowneOkno() {
        okno = new JFrame(tytul);
        okno.setSize(szerokosc, wysokosc);
        okno.setLayout(new GridLayout(3, 1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gornynapis = new JLabel("test", JLabel.CENTER);
        JScrollPane ScrollPane = new JScrollPane(select);
        przycisk_uruchom.setActionCommand("1-kolejka");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        okno.add(panel);
        okno.add(gornynapis);
        panel.add(przycisk_uruchom);
        panel.add(select);
        panel.add(ScrollPane);
        okno.setVisible(true);
    }    

    public static JButton getprzycisk_uruchom() {
        return przycisk_uruchom;
    }

}
