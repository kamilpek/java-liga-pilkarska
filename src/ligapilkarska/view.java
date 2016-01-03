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
//        lista = model.select();

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

    public void glowneOkno() {
        okno = new JFrame(tytul);
        okno.setSize(szerokosc, wysokosc);
        okno.setLayout(new GridLayout(3, 1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gornynapis = new JLabel("test", JLabel.CENTER);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(przycisk_uruchom);
        okno.add(panel);
//        okno.add(gornynapis);
    }
    
    public static JButton getprzycisk_uruchom() {
        return przycisk_uruchom;
    }

    void wynikselect(ArrayList wynik) {
        gornynapis.setText("Control in action: JTextArea");

        ArrayList<String> lista = new ArrayList<>();
        lista = wynik;

        String listawyniku = "";
        for (String s : lista) {
            listawyniku += s; }

        final JTextArea select = new JTextArea(listawyniku, 8, 60);
        JScrollPane pasek = new JScrollPane(select);

//        JButton przycisk_uruchom = new JButton("Uruchom");

        panel.add(select);
        panel.add(pasek);
        
        okno.setVisible(true);
    }

    

}
