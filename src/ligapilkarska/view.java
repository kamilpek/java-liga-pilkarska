package ligapilkarska;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class view extends JFrame {

    private final model liga_model;
    private java.util.ArrayList<String> lista = new ArrayList<>();

    view(model model) {
        liga_model = model;
        TextArea_Select();                
    }
    
    public static JButton getprzycisk_pokaztabele() {
        return przycisk_pokaztabele;
    }
    
    public static JButton getprzycisk_2kolejka() {
        return przycisk_2kolejka;
    }
    
    public static JButton getprzycisk_test() {
        return przycisk_test;
    }
    
    public static JComboBox getlista_selectkolejki() {
        return lista_selectkolejki;
    }

    private int szerokosc = 800;
    private int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    private JFrame okno;
    private JPanel panel;
    private JLabel gornynapis;
    public static JButton przycisk_pokaztabele = new JButton("Pokaż Tabelę");
    public static JButton przycisk_2kolejka = new JButton("2. Kolejka");
    public static JButton przycisk_test = new JButton("Przycisk testowy");
    public static JTextArea select = new JTextArea(8, 60);
    public static JComboBox lista_selectkolejki = new JComboBox();
        

    public void TextArea_Select() {
        okno = new JFrame(tytul);
        okno.setSize(szerokosc, wysokosc);
        okno.setLayout(new GridLayout(4, 1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gornynapis = new JLabel("test", JLabel.CENTER);
        JScrollPane ScrollPane = new JScrollPane(select);
        przycisk_pokaztabele.setActionCommand("pokaztabele");
        przycisk_2kolejka.setActionCommand("2-kolejka");
        przycisk_test.setActionCommand("test");
        
        lista_selectkolejki.setBounds(80, 40, 170, 20);
        lista_selectkolejki.addItem("Wybierz kolejkę.");
        lista_selectkolejki.addItem("1. kolejka.");
        lista_selectkolejki.addItem("2. kolejka.");
        lista_selectkolejki.addItem("3. kolejka.");
        lista_selectkolejki.addItem("4. kolejka.");
        lista_selectkolejki.addItem("5. kolejka.");
        lista_selectkolejki.addItem("6. kolejka.");
        lista_selectkolejki.addItem("7. kolejka.");
        lista_selectkolejki.addItem("8. kolejka.");
        lista_selectkolejki.addItem("9. kolejka.");
        lista_selectkolejki.addItem("10. kolejka.");
        lista_selectkolejki.addItem("11. kolejka.");
        lista_selectkolejki.addItem("12. kolejka.");
        lista_selectkolejki.addItem("13. kolejka.");
        lista_selectkolejki.addItem("14. kolejka.");
        lista_selectkolejki.addItem("15. kolejka.");
        lista_selectkolejki.addItem("16. kolejka.");
        lista_selectkolejki.addItem("17. kolejka.");
        lista_selectkolejki.addItem("18. kolejka.");
        lista_selectkolejki.addItem("19. kolejka.");
        lista_selectkolejki.addItem("20. kolejka.");
        lista_selectkolejki.addItem("21. kolejka.");
        lista_selectkolejki.addItem("22. kolejka.");
        lista_selectkolejki.addItem("23. kolejka.");
        lista_selectkolejki.addItem("24. kolejka.");
        lista_selectkolejki.addItem("25. kolejka.");
        lista_selectkolejki.addItem("26. kolejka.");
        lista_selectkolejki.addItem("27. kolejka.");
        lista_selectkolejki.addItem("28. kolejka.");
        lista_selectkolejki.addItem("29. kolejka.");
        lista_selectkolejki.addItem("30. kolejka.");
        
        

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        okno.add(panel);
        okno.add(gornynapis);
        panel.add(lista_selectkolejki);
        panel.add(przycisk_pokaztabele);
//        panel.add(przycisk_1kolejka);
//        panel.add(przycisk_2kolejka);
//        panel.add(przycisk_test);        
        panel.add(select);
        panel.add(ScrollPane);
        okno.setVisible(true);
    }    
}
