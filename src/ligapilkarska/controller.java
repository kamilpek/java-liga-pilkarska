package ligapilkarska;

import java.awt.event.*;

public class controller {

    private final model liga_model;
    private final view liga_view;
    private model liga_model_listener;
    private view liga_view_listener;    
    
    String lista_kolejki_polecenie = null;
    String lista_pozostale_polecenie = null;
    String delete_lista_tabele = null;
    String update_lista_klub_kolumny = null;
    String update_lista_sedzia_kolumny = null;
    String update_lista_trener_kolumny = null;
    String update_lista_stadion_kolumny = null;

    controller(model model, view view){
        liga_model = model;
        liga_view = view;        
        
        view.getprzycisk_pokaztabele().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_select_powrot().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_selectkolejki().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_selectpozostale().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_oglowne_select().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_delete().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_update().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_insert().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_wylacz().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_insert_powrot().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_insert_sedzia_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_insert_trener_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_insert_stadion_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_update_powrot().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_update_klub_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_update_sedzia_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_update_trener_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_update_stadion_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_update_klub_kolumny().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_update_sedzia_kolumny().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_update_trener_kolumny().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_update_stadion_kolumny().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_delete_powrot().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_delete_wykonaj().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_delete_dropbazy().addActionListener(new Nasluchiwacz(liga_model, liga_view));
    }

    private class Nasluchiwacz implements ActionListener {
        
        Nasluchiwacz(model model, view view){
            liga_model_listener = model;
            liga_view_listener = view;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            lista_kolejki_polecenie = view.getlista_selectkolejki().getSelectedItem().toString();
            lista_pozostale_polecenie =  view.getlista_selectpozostale().getSelectedItem().toString();
            delete_lista_tabele = view.getlista_delete_tabele().getSelectedItem().toString();
            update_lista_klub_kolumny = view.getlista_update_klub_kolumny().getSelectedItem().toString();
            update_lista_sedzia_kolumny = view.getlista_update_sedzia_kolumny().getSelectedItem().toString();
            update_lista_trener_kolumny = view.getlista_update_trener_kolumny().getSelectedItem().toString();
            update_lista_stadion_kolumny = view.getlista_update_stadion_kolumny().getSelectedItem().toString();
            
            String command = e.getActionCommand();          
            
            switch(command){
                case "okno_glowne" : {
                    liga_view_listener.okno_select.setVisible(false);
                    liga_view_listener.okno_insert.setVisible(false);
                    liga_view_listener.okno_update.setVisible(false);
                    liga_view_listener.okno_delete.setVisible(false);
                    liga_view_listener.okno_glowne.setVisible(true);
                } break;                
                case "okno_select" : {
                    liga_view_listener.okno_glowne.setVisible(false);
                    liga_view_listener.okno_select.setVisible(true);                    
                } break;
                case "okno_insert" : {
                    liga_view_listener.okno_glowne.setVisible(false);
                    liga_view_listener.okno_insert.setVisible(true);                    
                } break;
                case "okno_update" : {
                    liga_view_listener.okno_glowne.setVisible(false);
                    liga_view_listener.okno_update.setVisible(true);                    
                } break;
                case "okno_delete" : {
                    liga_view_listener.okno_glowne.setVisible(false);
                    liga_view_listener.okno_delete.setVisible(true);                    
                } break;
                case "pokaztabele" : {
                    String lista_pokaztabele = liga_model_listener.select_pokaztabele();
                    view.poletekstowe_select_wynik.setText(null);
                    view.poletekstowe_select_wynik.setText(lista_pokaztabele);
                } break;
                case "insert_sedzia_wykonaj" : {
                    String sedzia_imie = view.pole_insert_sedzia_imie.getText();
                    String sedzia_nazwisko = view.pole_insert_sedzia_nazwisko.getText();
                    String sedzia_region = view.pole_insert_sedzia_region.getText();
                    String sedzia_licencja = view.pole_insert_sedzia_licencja.getText();
                    liga_model_listener.insert_sedzia(sedzia_imie, sedzia_nazwisko, sedzia_region, sedzia_licencja);
                } break;
                case "insert_trener_wykonaj" : {
                    String trener_imie = view.pole_insert_trener_imie.getText();
                    String trener_nazwisko = view.pole_insert_trener_nazwisko.getText();
                    String trenr_licencja = view.pole_insert_trener_licencja.getText();
                    liga_model_listener.insert_trener(trener_imie, trener_nazwisko, trenr_licencja);
                } break;
                case "insert_stadion_wykonaj" : {
                    String stadion_miasto = view.pole_insert_stadion_miasto.getText();
                    String stadion_ulica = view.pole_insert_stadion_ulica.getText();
                    String stadion_numer = view.pole_insert_stadion_numer.getText();
                    String stadion_pojemnosc = view.pole_insert_stadion_pojemnosc.getText();
                    liga_model_listener.insert_stadion(stadion_miasto, stadion_ulica, stadion_numer, stadion_pojemnosc);
                } break;
                case "update_klub_wykonaj" : {
                    String klub_rekord = view.pole_update_klub_rekord.getText();
                    String klub_tresc = view.pole_update_klub_tresc.getText();
                    liga_model_listener.update_klub(update_lista_klub_kolumny, klub_rekord, klub_tresc);
                } break;
                case "update_sedzia_wykonaj" : {
                    String sedzia_rekord = view.pole_update_sedzia_rekord.getText();
                    String sedzia_tresc = view.pole_update_sedzia_tresc.getText();
                    liga_model_listener.update_sedzia(update_lista_sedzia_kolumny, sedzia_rekord, sedzia_tresc);
                } break;
                case "update_trener_wykonaj" : {
                    String trener_rekord = view.pole_update_trener_rekord.getText();
                    String trener_tresc = view.pole_update_trener_tresc.getText();
                    liga_model_listener.update_trener(update_lista_trener_kolumny, trener_rekord, trener_tresc);
                } break;
                case "update_stadion_wykonaj" : {
                    String stadion_rekord = view.pole_update_stadion_rekord.getText();
                    String stadion_tresc = view.pole_update_stadion_tresc.getText();
                    liga_model_listener.update_stadion(update_lista_stadion_kolumny, stadion_rekord, stadion_tresc);
                } break;
                case "delete_wykonaj" : {
                    String delete_rekord = view.pole_delete_rekord.getText();
                    liga_model_listener.delete_wykonaj(delete_lista_tabele, delete_rekord);
                } break;
                case "delete_dropbaza" : {
                    liga_model_listener.delete_dropbaza();
                } break;
                case "wylacz_program" : {
                    System.out.println("Wyłączono.");
                    liga_model_listener.wylacz_program();
                } break;
            }
                        
            switch(lista_kolejki_polecenie){
                case "1. kolejka.": {
                    String lista_1kolejka = liga_model_listener.select_zlozeniekolejki(1);
                    view.poletekstowe_select_wynik.setText(lista_1kolejka);
                } break;
                case "2. kolejka.": {
                    String lista_2kolejka = liga_model_listener.select_zlozeniekolejki(2);
                    view.poletekstowe_select_wynik.setText(lista_2kolejka);
                } break;
                case "3. kolejka.": { 
                    String lista_3kolejka = liga_model_listener.select_zlozeniekolejki(3);
                    view.poletekstowe_select_wynik.setText(lista_3kolejka);
                } break;
                case "4. kolejka.": { 
                    String lista_4kolejka = liga_model_listener.select_zlozeniekolejki(4);
                    view.poletekstowe_select_wynik.setText(lista_4kolejka);
                } break;
                case "5. kolejka.": {
                    String lista_5kolejka = liga_model_listener.select_zlozeniekolejki(5);
                    view.poletekstowe_select_wynik.setText(lista_5kolejka);
                } break;
                case "6. kolejka.": {
                    String lista_6kolejka = liga_model_listener.select_zlozeniekolejki(6);
                    view.poletekstowe_select_wynik.setText(lista_6kolejka);
                } break;
                case "7. kolejka.": {
                    String lista_7kolejka = liga_model_listener.select_zlozeniekolejki(7);
                    view.poletekstowe_select_wynik.setText(lista_7kolejka);
                } break;
                case "8. kolejka.": {
                    String lista_8kolejka = liga_model_listener.select_zlozeniekolejki(8);
                    view.poletekstowe_select_wynik.setText(lista_8kolejka);
                } break;
                case "9. kolejka.": {
                    String lista_9kolejka = liga_model_listener.select_zlozeniekolejki(9);
                    view.poletekstowe_select_wynik.setText(lista_9kolejka);
                } break;
                case "10. kolejka.": {
                    String lista_10kolejka = liga_model_listener.select_zlozeniekolejki(10);
                    view.poletekstowe_select_wynik.setText(lista_10kolejka);
                } break;
                case "11. kolejka.": {
                    String lista_11kolejka = liga_model_listener.select_zlozeniekolejki(11);
                    view.poletekstowe_select_wynik.setText(lista_11kolejka);
                } break;
                case "12. kolejka.": {
                    String lista_12kolejka = liga_model_listener.select_zlozeniekolejki(12);
                    view.poletekstowe_select_wynik.setText(lista_12kolejka);
                } break;
                case "13. kolejka.": {
                    String lista_13kolejka = liga_model_listener.select_zlozeniekolejki(13);
                    view.poletekstowe_select_wynik.setText(lista_13kolejka);
                } break;
                case "14. kolejka.": {
                    String lista_14kolejka = liga_model_listener.select_zlozeniekolejki(14);
                    view.poletekstowe_select_wynik.setText(lista_14kolejka);
                } break;
                case "15. kolejka.": {
                    String lista_15kolejka = liga_model_listener.select_zlozeniekolejki(15);
                    view.poletekstowe_select_wynik.setText(lista_15kolejka);
                } break;
                case "16. kolejka.": {
                    String lista_16kolejka = liga_model_listener.select_zlozeniekolejki(16);
                    view.poletekstowe_select_wynik.setText(lista_16kolejka);
                } break;
                case "17. kolejka.": {
                    String lista_17kolejka = liga_model_listener.select_zlozeniekolejki(17);
                    view.poletekstowe_select_wynik.setText(lista_17kolejka);
                } break;
                case "18. kolejka.": {
                    String lista_18kolejka = liga_model_listener.select_zlozeniekolejki(18);
                    view.poletekstowe_select_wynik.setText(lista_18kolejka);
                } break;
                case "19. kolejka.": {
                    String lista_19kolejka = liga_model_listener.select_zlozeniekolejki(19);
                    view.poletekstowe_select_wynik.setText(lista_19kolejka);
                } break;
                case "20. kolejka.": {
                    String lista_20kolejka = liga_model_listener.select_zlozeniekolejki(20);
                    view.poletekstowe_select_wynik.setText(lista_20kolejka);
                } break;
                case "21. kolejka.": {
                    String lista_21kolejka = liga_model_listener.select_zlozeniekolejki(21);
                    view.poletekstowe_select_wynik.setText(lista_21kolejka);
                } break;
                case "22. kolejka.": {
                    String lista_22kolejka = liga_model_listener.select_zlozeniekolejki(22);
                    view.poletekstowe_select_wynik.setText(lista_22kolejka);
                } break;
                case "23. kolejka.": {
                    String lista_23kolejka = liga_model_listener.select_zlozeniekolejki(23);
                    view.poletekstowe_select_wynik.setText(lista_23kolejka);
                } break;
                case "24. kolejka.": {
                    String lista_24kolejka = liga_model_listener.select_zlozeniekolejki(24);
                    view.poletekstowe_select_wynik.setText(lista_24kolejka);
                } break;
                case "25. kolejka.": {
                    String lista_25kolejka = liga_model_listener.select_zlozeniekolejki(25);
                    view.poletekstowe_select_wynik.setText(lista_25kolejka);
                } break;
                case "26. kolejka.": {
                    String lista_26kolejka = liga_model_listener.select_zlozeniekolejki(26);
                    view.poletekstowe_select_wynik.setText(lista_26kolejka);
                } break;
                case "27. kolejka.": {
                    String lista_27kolejka = liga_model_listener.select_zlozeniekolejki(27);
                    view.poletekstowe_select_wynik.setText(lista_27kolejka);
                } break;
                case "28. kolejka.": {
                    String lista_28kolejka = liga_model_listener.select_zlozeniekolejki(28);
                    view.poletekstowe_select_wynik.setText(lista_28kolejka);
                } break;
                case "29. kolejka.": {
                    String lista_29kolejka = liga_model_listener.select_zlozeniekolejki(29);
                    view.poletekstowe_select_wynik.setText(lista_29kolejka);
                } break;
                case "30. kolejka.": {
                    String lista_30kolejka = liga_model_listener.select_zlozeniekolejki(30);
                    view.poletekstowe_select_wynik.setText(lista_30kolejka);
                } break;                   
            }
            switch (lista_pozostale_polecenie){
                case "Kluby" : {
                    String lista_pozostale_kluby = liga_model_listener.select_pozostale_kluby();                    
                    view.poletekstowe_select_wynik.setText(lista_pozostale_kluby);                   
                } break;
                case "Sędziowie" : {
                    String lista_pozostale_sedziowie = liga_model_listener.select_pozostale_sedziowie();
                    view.poletekstowe_select_wynik.setText(lista_pozostale_sedziowie);                    
                } break;
                case "Trenerzy" : {
                    String lista_pozostale_trenerzy = liga_model_listener.select_pozostale_trenerzy();
                    view.poletekstowe_select_wynik.setText(lista_pozostale_trenerzy);                    
                } break;
                case "Stadiony" : {
                    String lista_pozostale_stadiony = liga_model_listener.select_pozostale_stadiony();
                    view.poletekstowe_select_wynik.setText(lista_pozostale_stadiony);
                } break;
            }
        }
    }
}