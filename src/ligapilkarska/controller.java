package ligapilkarska;

import java.awt.event.*;
import java.util.ArrayList;

public class controller {

    private final model liga_model;
    private final view liga_view;
    private final dao dao_baza;
    private model liga_model_listener;
    private view liga_view_listener; 
    private dao liga_dao_listener;
    
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
        dao_baza = liga_model.getdao();
        
        view.getprzycisk_pokaztabele().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_select_powrot().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_selectkolejki().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_selectpozostale().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_oglowne_select().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_delete().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_update().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_insert().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getprzycisk_oglowne_wylacz().addActionListener(new Nasluchiwacz(dao_baza, liga_view));
        
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
        
        Nasluchiwacz(dao dao_baza, view view){
            liga_dao_listener = dao_baza;
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
                case "pokaztabele": {
                    ArrayList<String> lista_pokaztabele = liga_dao_listener.select_pokaztabele();
                    view.poletekstowe_select_wynik.setText(null);
                    String listawyniku = "";
                    for (String s : lista_pokaztabele) {
                        listawyniku += s; }
                    view.poletekstowe_select_wynik.setText(listawyniku);
                }
                break;
                case "insert_sedzia_wykonaj" : {
                    String sedzia_imie = view.pole_insert_sedzia_imie.getText();
                    String sedzia_nazwisko = view.pole_insert_sedzia_nazwisko.getText();
                    String sedzia_region = view.pole_insert_sedzia_region.getText();
                    String sedzia_licencja = view.pole_insert_sedzia_licencja.getText();
                    liga_dao_listener.insert_sedzia(sedzia_imie, sedzia_nazwisko, sedzia_region, sedzia_licencja);
                } break;
                case "insert_trener_wykonaj" : {
                    String trener_imie = view.pole_insert_trener_imie.getText();
                    String trener_nazwisko = view.pole_insert_trener_nazwisko.getText();
                    String trenr_licencja = view.pole_insert_trener_licencja.getText();
                    liga_dao_listener.insert_trener(trener_imie, trener_nazwisko, trenr_licencja);
                } break;
                case "insert_stadion_wykonaj" : {
                    String stadion_miasto = view.pole_insert_stadion_miasto.getText();
                    String stadion_ulica = view.pole_insert_stadion_ulica.getText();
                    String stadion_numer = view.pole_insert_stadion_numer.getText();
                    String stadion_pojemnosc = view.pole_insert_stadion_pojemnosc.getText();
                    liga_dao_listener.insert_stadion(stadion_miasto, stadion_ulica, stadion_numer, stadion_pojemnosc);
                } break;
                case "update_klub_wykonaj" : {
                    String klub_rekord = view.pole_update_klub_rekord.getText();
                    String klub_tresc = view.pole_update_klub_tresc.getText();
                    liga_dao_listener.update_klub(update_lista_klub_kolumny, klub_rekord, klub_tresc);
                } break;
                case "update_sedzia_wykonaj" : {
                    String sedzia_rekord = view.pole_update_sedzia_rekord.getText();
                    String sedzia_tresc = view.pole_update_sedzia_tresc.getText();
                    liga_dao_listener.update_sedzia(update_lista_sedzia_kolumny, sedzia_rekord, sedzia_tresc);
                } break;
                case "update_trener_wykonaj" : {
                    String trener_rekord = view.pole_update_trener_rekord.getText();
                    String trener_tresc = view.pole_update_trener_tresc.getText();
                    liga_dao_listener.update_trener(update_lista_trener_kolumny, trener_rekord, trener_tresc);
                } break;
                case "update_stadion_wykonaj" : {
                    String stadion_rekord = view.pole_update_stadion_rekord.getText();
                    String stadion_tresc = view.pole_update_stadion_tresc.getText();
                    liga_dao_listener.update_stadion(update_lista_stadion_kolumny, stadion_rekord, stadion_tresc);
                } break;
                case "delete_wykonaj" : {
                    String delete_rekord = view.pole_delete_rekord.getText();
                    liga_dao_listener.delete_wykonaj(delete_lista_tabele, delete_rekord);
                } break;
                case "delete_dropbaza" : {
                    liga_dao_listener.delete_dropbaza();
                } break;
                case "wylacz_program" : {
                    System.out.println("Wyłączono.");
                    liga_dao_listener.wylacz_program();
                } break;
            }
                        
            select_kolejka_wyswietl select_kolejka = null;
            String kolejka_data = null;
            
            switch(lista_kolejki_polecenie){
                case "1. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/08/10' AND '2013/08/11';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "2. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/08/14' AND '2013/08/15';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "3. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/08/17' AND '2013/08/18';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "4. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/08/24' AND '2013/08/25';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "5. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/08/30' AND '2013/09/01';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "6. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/09/06' AND '2013/09/07';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "7. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/09/14' AND '2013/09/15';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "8. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/09/21' AND '2013/09/22';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "9. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/09/28' AND '2013/09/29';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "10. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/10/05' AND '2013/10/06';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "11. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/10/12' AND '2013/10/13';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "12. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/10/18' AND '2013/10/19';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "13. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/10/26' AND '2013/10/27';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "14. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/11/02' AND '2013/11/03';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "15. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/11/09' AND '2013/11/10';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "16. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/11/16' AND '2013/11/17';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "17. kolejka.": kolejka_data = "WHERE data BETWEEN '2013/11/23' AND '2013/11/24';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "18. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/03/15' AND '2014/03/16';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "19. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/03/22' AND '2014/03/23';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "20. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/03/29' AND '2014/03/30';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "21. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/04/05' AND '2014/04/06';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "22. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/04/12' AND '2014/04/13';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "23. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/04/18' AND '2014/04/19';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "24. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/04/26' AND '2014/04/27';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "25. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/05/03' AND '2014/05/04';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "26. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/05/10' AND '2014/05/11';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "27. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/05/17' AND '2014/05/18';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "28. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/05/24' AND '2014/05/25';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "29. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/05/31' AND '2014/06/01';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;
                case "30. kolejka.": kolejka_data = "WHERE data BETWEEN '2014/06/06' AND '2014/06/07';"; select_kolejka = new select_kolejka_wyswietl(kolejka_data); break;                   
            }
            
            if (lista_kolejki_polecenie != null) {           
            }
            
            ArrayList<String> select_lista_pozostale = null;
            select_pozostale_wyswietl select = null;
            
            switch (lista_pozostale_polecenie){
                case "Kluby" : select_lista_pozostale = liga_dao_listener.select_pozostale_kluby(); select = new select_pozostale_wyswietl(select_lista_pozostale); break;
                case "Sędziowie" : select_lista_pozostale = liga_dao_listener.select_pozostale_sedziowie(); select = new select_pozostale_wyswietl(select_lista_pozostale); break;
                case "Trenerzy" : select_lista_pozostale = liga_dao_listener.select_pozostale_trenerzy(); select = new select_pozostale_wyswietl(select_lista_pozostale); break;
                case "Stadiony" : select_lista_pozostale = liga_dao_listener.select_pozostale_stadiony(); select = new select_pozostale_wyswietl(select_lista_pozostale); break; }                    
            }
        }
    
    public class select_pozostale_wyswietl {

        select_pozostale_wyswietl(ArrayList<String> lista) {
            ArrayList<String> select_lista_pozostale = lista;
            String lista_wysw = "";
            for (String s : select_lista_pozostale) {
                lista_wysw += s;
            }
            view.poletekstowe_select_wynik.setText(lista_wysw);
        }
    }
    
    public class select_kolejka_wyswietl {

        select_kolejka_wyswietl(String tabela) {
            String kolejka_data = tabela;            
            ArrayList<String> lista_kolejka = liga_dao_listener.select_zlozeniekolejki(kolejka_data);
            view.poletekstowe_select_wynik.setText(null);
            String listawyniku = "";
            for (String s : lista_kolejka) {
                listawyniku += s;
            }
            view.poletekstowe_select_wynik.setText(listawyniku);
        }
    }
}
