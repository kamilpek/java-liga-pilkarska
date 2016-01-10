package ligapilkarska;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class view extends JFrame {

    private final model liga_model;
    private final java.util.ArrayList<String> lista = new ArrayList<>();

    view(model model) {
        liga_model = model;
        makeGUI();                
    }
    
    public static JButton getprzycisk_oglowne_select(){
        return przycisk_oglowne_select;
    }
    
    public static JButton getprzycisk_oglowne_insert(){
        return przycisk_oglowne_insert;
    }
    
    public static JButton getprzycisk_oglowne_update(){
        return przycisk_oglowne_update;
    }
    
    public static JButton getprzycisk_oglowne_delete(){
        return przycisk_oglowne_delete;
    }
    
    public static JButton getprzycisk_oglowne_wylacz(){
        return przycisk_oglowne_wylacz;
    }
        
    public static JButton getprzycisk_pokaztabele() {
        return przycisk_select_pokaztabele;
    }
    
    public static JComboBox getlista_selectkolejki() {
        return lista_selectkolejki;
    }
    
    public static JComboBox getlista_selectpozostale() {
        return lista_selectpozostale;
    }
    
    public static JButton getprzycisk_select_powrot(){
        return przycisk_powrot;
    }
    
    public static JButton getprzycisk_insert_powrot(){
        return przycisk_insert_powrot;
    }
    
    public static JButton getprzycisk_insert_sedzia_wykonaj(){
        return przycisk_insert_sedzia_wykonaj;
    }
    
    public static JButton getprzycisk_insert_trener_wykonaj(){
        return przycisk_insert_trener_wykonaj;
    }
    
    public static JButton getprzycisk_insert_stadion_wykonaj(){
        return przycisk_insert_stadion_wykonaj;
    }
    
    public static JButton getprzycisk_update_powrot(){
        return przycisk_update_powrot;
    }
    
    public static JComboBox getlista_update_klub_kolumny(){
        return lista_update_klub_kolumny;
    }
    
    public static JComboBox getlista_update_trener_kolumny(){
        return lista_update_trener_kolumny;
    }
    
    public static JComboBox getlista_update_sedzia_kolumny(){
        return lista_update_sedzia_kolumny;
    }
    
    public static JComboBox getlista_update_stadion_kolumny(){
        return lista_update_stadion_kolumny;
    }
    
    public static JButton getprzycisk_update_klub_wykonaj(){
        return przycisk_update_klub_wykonaj;
    }
    
    public static JButton getprzycisk_update_trener_wykonaj(){
        return przycisk_update_trener_wykonaj;
    }
    
    public static JButton getprzycisk_update_sedzia_wykonaj(){
        return przycisk_update_sedzia_wykonaj;
    }
    
    public static JButton getprzycisk_update_stadion_wykonaj(){
        return przycisk_update_stadion_wykonaj;
    }
    
    public static JButton getprzycisk_delete_powrot(){
        return przycisk_delete_powrot;
    }
    
    public static JComboBox getlista_delete_tabele(){
        return lista_delete_tabele;
    }
    
    public static JButton getprzycisk_delete_wykonaj(){
        return przycisk_delete_wykonaj;
    }
    
    public static JButton getprzycisk_delete_dropbazy(){
        return przycisk_delete_dropbazy;
    }

    private final int szerokosc = 800;
    private final int wysokosc = 600;
    private final String tytul = "Liga Piłkarska";

    public JFrame okno_glowne;
    public JFrame okno_select;
    public JFrame okno_insert;
    public JFrame okno_update;
    public JFrame okno_delete;
    
    private final JPanel panel_select = new JPanel();
    private final JPanel panel_select_pole = new JPanel();
    private final JPanel panel_insert_0 = new JPanel();
    private final JPanel panel_insert_sedzia = new JPanel();
    private final JPanel panel_insert_trener = new JPanel();
    private final JPanel panel_insert_stadion = new JPanel();
    private final JPanel panel_update_0 = new JPanel();  
    private final JPanel panel_update_sedzia = new JPanel();
    private final JPanel panel_update_trener = new JPanel();
    private final JPanel panel_update_stadion = new JPanel(); 
    private final JPanel panel_update_klub = new JPanel(); 
    private final JPanel panel_delete_0 = new JPanel();
    private final JPanel panel_delete_1 = new JPanel();
    private final JPanel panel_delete_2 = new JPanel();
    
    public static JButton przycisk_2kolejka = new JButton("2. Kolejka");
    public static JButton przycisk_test = new JButton("Przycisk testowy");    
    
    public static JButton przycisk_oglowne_insert = new JButton("[C] Tryb INSERT");
    public static JButton przycisk_oglowne_select = new JButton("[R] Tryb SELECT");    
    public static JButton przycisk_oglowne_update = new JButton("[U] Tryb UPDATE");
    public static JButton przycisk_oglowne_delete = new JButton("[D] Tryb DELETE");
    public static JButton przycisk_oglowne_wylacz = new JButton("Wyłącz program.");
    
    public static JButton przycisk_powrot = new JButton("Powrót do Menu.");
    public static JButton przycisk_select_pokaztabele = new JButton("Pokaż Tabelę");
    public static JTextArea poletekstowe_select_wynik = new JTextArea(16, 60);
    public static JScrollPane scrollpane_select_pola = null;
    public static JComboBox lista_selectkolejki = new JComboBox();
    public static JComboBox lista_selectpozostale = new JComboBox();
    
    public static JButton przycisk_insert_powrot = new JButton("Powrót do menu");    
    public static JLabel etykieta_insert_sedzia_info = new JLabel("Wstawianie do tabeli sędzia.");
    public static JTextField pole_insert_sedzia_imie = new JTextField("Podaj Imię", 8);
    public static JTextField pole_insert_sedzia_nazwisko = new JTextField("Podaj Nazwisko", 12);
    public static JTextField pole_insert_sedzia_region = new JTextField("Podaj Region", 8);
    public static JTextField pole_insert_sedzia_licencja = new JTextField("Podaj nr licencji", 8);
    public static JButton przycisk_insert_sedzia_wykonaj = new JButton("Wykonaj");
    public static JLabel etykieta_insert_trener_info = new JLabel("Wstawianie do tabeli trener.");
    public static JTextField pole_insert_trener_imie = new JTextField("Podaj Imię", 8);
    public static JTextField pole_insert_trener_nazwisko = new JTextField("Podaj Nazwisko", 12);   
    public static JTextField pole_insert_trener_licencja = new JTextField("Podaj nr licencji", 8);
    public static JButton przycisk_insert_trener_wykonaj = new JButton("Wykonaj");
    public static JLabel etykieta_insert_stadion_info = new JLabel("Wstawianie do tabeli stadion.");
    public static JTextField pole_insert_stadion_miasto = new JTextField("Podaj Miasto", 8);
    public static JTextField pole_insert_stadion_ulica = new JTextField("Podaj Ulicę", 12);   
    public static JTextField pole_insert_stadion_numer = new JTextField("Podaj nr", 8);
    public static JTextField pole_insert_stadion_pojemnosc = new JTextField("Podaj pojemnosć", 8);
    public static JButton przycisk_insert_stadion_wykonaj = new JButton("Wykonaj");
    
    public static JButton przycisk_update_powrot = new JButton("Powrót do menu");
    public static JLabel etykieta_update_klub_info = new JLabel("Zmiana w tabeli klub");
    public static JComboBox lista_update_klub_kolumny = new JComboBox();
    public static JTextField pole_update_klub_rekord = new JTextField("Numer rekordu", 10);
    public static JTextField pole_update_klub_tresc = new JTextField("Treść zmiany", 16);
    public static JButton przycisk_update_klub_wykonaj = new JButton("Wykonaj");
    public static JLabel etykieta_update_trener_info = new JLabel("Zmiana w tabeli trener");
    public static JComboBox lista_update_trener_kolumny = new JComboBox();
    public static JTextField pole_update_trener_rekord = new JTextField("Numer rekordu", 10);
    public static JTextField pole_update_trener_tresc = new JTextField("Treść zmiany", 16);
    public static JButton przycisk_update_trener_wykonaj = new JButton("Wykonaj");
    public static JLabel etykieta_update_sedzia_info = new JLabel("Zmiana w tabeli sedzia");
    public static JComboBox lista_update_sedzia_kolumny = new JComboBox();
    public static JButton przycisk_update_sedzia_wykonaj = new JButton("Wykonaj");
    public static JTextField pole_update_sedzia_rekord = new JTextField("Numer rekordu", 10);
    public static JTextField pole_update_sedzia_tresc = new JTextField("Treść zmiany", 16);
    public static JLabel etykieta_update_stadion_info = new JLabel("Zmiana w tabeli stadion");
    public static JComboBox lista_update_stadion_kolumny = new JComboBox();
    public static JTextField pole_update_stadion_rekord = new JTextField("Numer rekordu", 10);
    public static JTextField pole_update_stadion_tresc = new JTextField("Treść zmiany", 16);
    public static JButton przycisk_update_stadion_wykonaj = new JButton("Wykonaj");
    
    public static JButton przycisk_delete_powrot = new JButton("Powrot do menu");
    public static JComboBox lista_delete_tabele = new JComboBox();
    public static JTextField pole_delete_rekord = new JTextField("Numer Rekordu", 12);
    public static JButton przycisk_delete_wykonaj = new JButton("Wykonaj");
    public static JButton przycisk_delete_dropbazy = new JButton("Drop Bazy");
        

    public void makeGUI() {
        
        okno_glowne = new JFrame("Liga Piłarska - Witamy w programie!");
        okno_glowne.setSize(szerokosc, wysokosc);
        okno_glowne.setLayout(new GridLayout(0,1));
        okno_glowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_select = new JFrame("Liga Piłarska - wyswietlanie zawartosci Bazy Danych.");
        okno_select.setSize(szerokosc, wysokosc);
        okno_select.setLayout(new BorderLayout());
        okno_select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_insert = new JFrame("Liga Piłarska - wstawianie danych do Bazy Danych.");
        okno_insert.setSize(szerokosc, wysokosc);
        okno_insert.setLayout(new GridLayout(5, 1));
        okno_insert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_update = new JFrame("Liga Piłarska - aktualizowanie wybranej zawartości w Bazie Danych.");
        okno_update.setSize(szerokosc, wysokosc);
        okno_update.setLayout(new GridLayout(5, 1));
        okno_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        okno_delete = new JFrame("Liga Piłarska - usuwanie wybranej zawartości w Bazie Danych.");
        okno_delete.setSize(szerokosc, wysokosc);
        okno_delete.setLayout(new GridLayout(3, 1));
        okno_delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
       
        przycisk_oglowne_insert.setActionCommand("okno_insert");
        przycisk_oglowne_select.setActionCommand("okno_select");        
        przycisk_oglowne_update.setActionCommand("okno_update");
        przycisk_oglowne_delete.setActionCommand("okno_delete");
        przycisk_oglowne_wylacz.setActionCommand("wylacz_program");
        
        przycisk_insert_powrot.setActionCommand("okno_glowne");        
        przycisk_update_powrot.setActionCommand("okno_glowne");        
        przycisk_delete_powrot.setActionCommand("okno_glowne");
        
        panel_select.setLayout(new FlowLayout());       
        przycisk_select_pokaztabele.setActionCommand("pokaztabele");
        przycisk_powrot.setActionCommand("okno_glowne");
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
        
        lista_selectpozostale.addItem("Wybierz selecta.");
        lista_selectpozostale.addItem("Sędziowie");
        lista_selectpozostale.addItem("Kluby");
        lista_selectpozostale.addItem("Stadiony");
        lista_selectpozostale.addItem("Trenerzy");
        
        lista_update_klub_kolumny.addItem("Wybierz kolumnę.");
        lista_update_klub_kolumny.addItem("nazwa");
        lista_update_klub_kolumny.addItem("strona");
        lista_update_klub_kolumny.addItem("telefon");
        lista_update_klub_kolumny.addItem("miasto");
        lista_update_klub_kolumny.addItem("ulica");
        lista_update_klub_kolumny.addItem("numer");
        lista_update_klub_kolumny.addItem("barwy");
        
        lista_update_sedzia_kolumny.addItem("Wybierz kolumnę.");
        lista_update_sedzia_kolumny.addItem("imie");
        lista_update_sedzia_kolumny.addItem("nazwisko");
        lista_update_sedzia_kolumny.addItem("region");
        lista_update_sedzia_kolumny.addItem("licencja");
        
        lista_update_trener_kolumny.addItem("Wybierz kolumnę.");
        lista_update_trener_kolumny.addItem("imie");
        lista_update_trener_kolumny.addItem("nazwisko");
        lista_update_trener_kolumny.addItem("licencja");
        
        lista_update_stadion_kolumny.addItem("Wybierz kolumnę.");
        lista_update_stadion_kolumny.addItem("miasto");
        lista_update_stadion_kolumny.addItem("ulica");
        lista_update_stadion_kolumny.addItem("numer");
        lista_update_stadion_kolumny.addItem("pojemnosc");
        
        lista_delete_tabele.addItem("Wybierz tabelę.");
        lista_delete_tabele.addItem("klub");
        lista_delete_tabele.addItem("stadion");
        lista_delete_tabele.addItem("trener");
        lista_delete_tabele.addItem("sedzia");
        
        okno_glowne.add(przycisk_oglowne_insert);
        okno_glowne.add(przycisk_oglowne_select);        
        okno_glowne.add(przycisk_oglowne_update);
        okno_glowne.add(przycisk_oglowne_delete);
        okno_glowne.add(przycisk_oglowne_wylacz);
        okno_glowne.setVisible(true);
        
        okno_insert.add(panel_insert_0);
        panel_insert_0.add(przycisk_insert_powrot);
        panel_insert_sedzia.setLayout(new FlowLayout());
        okno_insert.add(panel_insert_sedzia);
        panel_insert_sedzia.add(etykieta_insert_sedzia_info);
        panel_insert_sedzia.add(pole_insert_sedzia_imie);
        panel_insert_sedzia.add(pole_insert_sedzia_nazwisko);
        panel_insert_sedzia.add(pole_insert_sedzia_region);
        panel_insert_sedzia.add(pole_insert_sedzia_licencja);
        przycisk_insert_sedzia_wykonaj.setActionCommand("insert_sedzia_wykonaj");
        panel_insert_sedzia.add(przycisk_insert_sedzia_wykonaj);        
        panel_insert_trener.setLayout(new FlowLayout());
        okno_insert.add(panel_insert_trener);
        panel_insert_trener.add(etykieta_insert_trener_info);
        panel_insert_trener.add(pole_insert_trener_imie);
        panel_insert_trener.add(pole_insert_trener_nazwisko);
        panel_insert_trener.add(pole_insert_trener_licencja);
        przycisk_insert_trener_wykonaj.setActionCommand("insert_trener_wykonaj");
        panel_insert_trener.add(przycisk_insert_trener_wykonaj);        
        panel_insert_stadion.setLayout(new FlowLayout());
        okno_insert.add(panel_insert_stadion);
        panel_insert_stadion.add(etykieta_insert_stadion_info);
        panel_insert_stadion.add(pole_insert_stadion_miasto);
        panel_insert_stadion.add(pole_insert_stadion_ulica);
        panel_insert_stadion.add(pole_insert_stadion_numer);
        panel_insert_stadion.add(pole_insert_stadion_pojemnosc);
        przycisk_insert_stadion_wykonaj.setActionCommand("insert_stadion_wykonaj");
        panel_insert_stadion.add(przycisk_insert_stadion_wykonaj);
        
        okno_select.add(panel_select, BorderLayout.PAGE_START);
        panel_select.add(przycisk_select_pokaztabele);
        panel_select.add(lista_selectkolejki);
        panel_select.add(lista_selectpozostale);
        panel_select.add(przycisk_powrot);
        okno_select.add(panel_select_pole);
        scrollpane_select_pola = new JScrollPane(poletekstowe_select_wynik);
        okno_select.add(panel_select_pole, BorderLayout.CENTER);
        panel_select_pole.add(poletekstowe_select_wynik);
        panel_select_pole.add(scrollpane_select_pola);
        
        panel_update_0.setLayout(new FlowLayout());
        okno_update.add(panel_update_0);
        panel_update_0.add(przycisk_update_powrot);
        okno_update.add(panel_update_klub);
        panel_update_klub.add(etykieta_update_klub_info);
        panel_update_klub.add(lista_update_klub_kolumny);
        panel_update_klub.add(pole_update_klub_rekord);
        panel_update_klub.add(pole_update_klub_tresc);
        przycisk_update_klub_wykonaj.setActionCommand("update_klub_wykonaj");
        panel_update_klub.add(przycisk_update_klub_wykonaj);
        okno_update.add(panel_update_stadion);
        panel_update_stadion.add(etykieta_update_stadion_info);
        panel_update_stadion.add(lista_update_stadion_kolumny);
        panel_update_stadion.add(pole_update_stadion_rekord);
        panel_update_stadion.add(pole_update_stadion_tresc);
        przycisk_update_stadion_wykonaj.setActionCommand("update_stadion_wykonaj");
        panel_update_stadion.add(przycisk_update_stadion_wykonaj);
        okno_update.add(panel_update_sedzia);
        panel_update_sedzia.add(etykieta_update_sedzia_info);
        panel_update_sedzia.add(lista_update_sedzia_kolumny);
        panel_update_sedzia.add(pole_update_sedzia_rekord);
        panel_update_sedzia.add(pole_update_sedzia_tresc);
        przycisk_update_sedzia_wykonaj.setActionCommand("update_sedzia_wykonaj");
        panel_update_sedzia.add(przycisk_update_sedzia_wykonaj);
        okno_update.add(panel_update_trener);
        panel_update_trener.add(etykieta_update_trener_info);
        panel_update_trener.add(lista_update_trener_kolumny);
        panel_update_trener.add(pole_update_trener_rekord);
        panel_update_trener.add(pole_update_trener_tresc);
        przycisk_update_trener_wykonaj.setActionCommand("update_trener_wykonaj");
        panel_update_trener.add(przycisk_update_trener_wykonaj);
        
        panel_delete_0.setLayout(new FlowLayout());
        okno_delete.add(panel_delete_0);
        panel_delete_0.add(przycisk_delete_powrot);
        okno_delete.add(panel_delete_1);
        panel_delete_1.add(lista_delete_tabele);
        panel_delete_1.add(pole_delete_rekord);
        przycisk_delete_wykonaj.setActionCommand("delete_wykonaj");
        panel_delete_1.add(przycisk_delete_wykonaj);
        panel_delete_2.setLayout(new FlowLayout());
        okno_delete.add(panel_delete_2);
        przycisk_delete_dropbazy.setActionCommand("delete_dropbaza");
        panel_delete_2.add(przycisk_delete_dropbazy);
    }    
}
