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
        TextArea_Select();                
    }
    
    public static JButton getprzycisk_1kolejka() {
        return przycisk_1kolejka;
    }
    
    public static JButton getprzycisk_2kolejka() {
        return przycisk_2kolejka;
    }

    private int szerokosc = 800;
    private int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    private JFrame okno;
    private JPanel panel;
    private JLabel gornynapis;
    public static JButton przycisk_1kolejka = new JButton("1. Kolejka");
    public static JButton przycisk_2kolejka = new JButton("2. Kolejka");
    public static JTextArea select = new JTextArea(8, 60);

    public void TextArea_Select() {
        okno = new JFrame(tytul);
        okno.setSize(szerokosc, wysokosc);
        okno.setLayout(new GridLayout(4, 1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gornynapis = new JLabel("test", JLabel.CENTER);
        JScrollPane ScrollPane = new JScrollPane(select);
        przycisk_1kolejka.setActionCommand("1-kolejka");
        przycisk_2kolejka.setActionCommand("2-kolejka");

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        okno.add(panel);
        okno.add(gornynapis);
        panel.add(przycisk_1kolejka);
        panel.add(przycisk_2kolejka);
        panel.add(select);
        panel.add(ScrollPane);
        okno.setVisible(true);
    }    
}
