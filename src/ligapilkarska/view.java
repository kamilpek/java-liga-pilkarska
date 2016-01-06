package ligapilkarska;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class view extends JFrame {

    private final model liga_model;
    private java.util.ArrayList<String> lista = new ArrayList<>();

    view(model model) {
        liga_model = model;
        makeGUI();                
    }
    
    public static JButton getprzycisk_oglowne_select(){
        return przycisk_oglowne_select;
    }
        
    public static JButton getprzycisk_pokaztabele() {
        return przycisk_pokaztabele;
    }
    
    public static JComboBox getlista_selectkolejki() {
        return lista_selectkolejki;
    }

    private int szerokosc = 800;
    private int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    private JFrame okno_glowne;
    public JFrame okno_select;
    private JFrame okno_insert;
    private JFrame okno_update;
    private JFrame okno_delete;
    
    private JPanel panel = new JPanel();
    private JLabel gornynapis;
    public static JButton przycisk_pokaztabele = new JButton("Pokaż Tabelę");
    public static JButton przycisk_2kolejka = new JButton("2. Kolejka");
    public static JButton przycisk_test = new JButton("Przycisk testowy");
    public static JTextArea select = new JTextArea(16, 60);
    public static JScrollPane ScrollPane = new JScrollPane(select);
    public static JComboBox lista_selectkolejki = new JComboBox();
    
    public static JButton przycisk_oglowne_insert = new JButton("[C] Tryb INSERT");
    public static JButton przycisk_oglowne_select = new JButton("[R] Tryb SELECT");    
    public static JButton przycisk_oglowne_update = new JButton("[U] Tryb UPDATE");
    public static JButton przycisk_oglowne_delete = new JButton("[D] Tryb DELETE");
        

    public void makeGUI() {
        
        okno_glowne = new JFrame("Liga Piłarska - Witamy w programie!");
        okno_glowne.setSize(szerokosc, wysokosc);
        okno_glowne.setLayout(new GridLayout(0,1));
        okno_glowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_select = new JFrame("Liga Piłarska - wyswietlanie zawartosci Bazy Danych.");
        okno_select.setSize(szerokosc, wysokosc);
        okno_select.setLayout(new GridLayout(2, 1));
        okno_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_insert = new JFrame("Liga Piłarska - wstawianie danych do Bazy Danych.");
        okno_insert.setSize(szerokosc, wysokosc);
        okno_insert.setLayout(new GridLayout(3, 1));
        okno_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_update = new JFrame("Liga Piłarska - aktualizowanie wybranej zawartości w Bazie Danych.");
        okno_update.setSize(szerokosc, wysokosc);
        okno_update.setLayout(new GridLayout(3, 1));
        okno_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_delete = new JFrame("Liga Piłarska - usuwanie wybranej zawartości w Bazie Danych.");
        okno_delete.setSize(szerokosc, wysokosc);
        okno_delete.setLayout(new GridLayout(3, 1));
        okno_delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setLayout(new FlowLayout());

        gornynapis = new JLabel("test", JLabel.CENTER);        
        przycisk_pokaztabele.setActionCommand("pokaztabele");
        przycisk_2kolejka.setActionCommand("2-kolejka");
        przycisk_test.setActionCommand("test");
        
        przycisk_oglowne_insert.setActionCommand("okno_insert");
        przycisk_oglowne_select.setActionCommand("okno_select");        
        przycisk_oglowne_update.setActionCommand("okno_update");
        przycisk_oglowne_delete.setActionCommand("okno_delete");
        
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
        
        okno_glowne.add(przycisk_oglowne_insert);
        okno_glowne.add(przycisk_oglowne_select);        
        okno_glowne.add(przycisk_oglowne_update);
        okno_glowne.add(przycisk_oglowne_delete);
        okno_glowne.setVisible(true);
        
        okno_select.add(panel);
        panel.add(przycisk_pokaztabele);
        panel.add(lista_selectkolejki);
        panel.add(select);
        panel.add(ScrollPane);        
        
        
//        okno.add(gornynapis);
        

//        panel.add(przycisk_1kolejka);
//        panel.add(przycisk_2kolejka);
//        panel.add(przycisk_test);        
        
        
    }    
}
