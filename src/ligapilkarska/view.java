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
        lista = model.select();

        glowneOkno();
        wynikselect(lista);
    }

    private int szerokosc = 800;
    private int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    private JFrame okno;
    private JPanel panel;
    private JLabel gornynapis;
    private JLabel status;
    public static JButton przycisk_uruchom = new JButton("Uruchom");
    public static JTextArea select = new JTextArea(8, 60);

    public void glowneOkno() {
        okno = new JFrame(tytul);
        okno.setSize(szerokosc, wysokosc);
        okno.setLayout(new GridLayout(3, 1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gornynapis = new JLabel("test", JLabel.CENTER);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
//        panel.add(przycisk_uruchom);
        okno.add(panel);
        okno.add(gornynapis);
    }

    void wynikselect(ArrayList wynik) {

        JScrollPane pasek = new JScrollPane(select);

        przycisk_uruchom.setActionCommand("Uruchom");
        przycisk_uruchom.addActionListener(null);

        panel.add(przycisk_uruchom);
        panel.add(select);
        panel.add(pasek);

        okno.setVisible(true);
    }

    public static JButton getprzycisk_uruchom() {
        return przycisk_uruchom;
    }

}
