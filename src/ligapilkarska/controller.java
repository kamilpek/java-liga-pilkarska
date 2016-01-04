package ligapilkarska;

import java.awt.event.*;
import java.util.*;

public class controller {

    private model liga_model;
    private view liga_view;
    private java.util.ArrayList<String> lista_1kolejka = new ArrayList<>();
    private java.util.ArrayList<String> lista_2kolejka = new ArrayList<>();
    private java.util.ArrayList<String> lista_3kolejka = new ArrayList<>();
    private java.util.ArrayList<String> lista_4kolejka = new ArrayList<>();
    String polecenie = null;

    controller(model model, view view){
        liga_model = model;
        liga_view = view;

        lista_1kolejka = model.select_1kolejka();
        lista_2kolejka = model.select_2kolejka();
        lista_3kolejka = model.select_3kolejka();
        lista_4kolejka = model.select_4kolejka();
        view.getprzycisk_1kolejka().addActionListener(new NasluchiwaczPrzyciskow());
        view.getprzycisk_2kolejka().addActionListener(new NasluchiwaczPrzyciskow());
        view.getlista_selectkolejki().addActionListener(new NasluchiwaczPrzyciskow());
        
    }

    private class NasluchiwaczPrzyciskow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            polecenie = view.getlista_selectkolejki().getSelectedItem().toString();
            
            String command = e.getActionCommand();
            if ((command.equals("1-kolejka"))||polecenie.equals("1. kolejka.")) {
                String listawyniku = "";
                for (String s : lista_1kolejka) {
                    listawyniku += s;
                }
                view.select.setText(listawyniku);
            }
            else if ((command.equals("2-kolejka")||(polecenie.equals("2. kolejka.")))) {
                String listawyniku = "";
                for (String s : lista_2kolejka) {
                    listawyniku += s;
                }                
                view.select.setText(listawyniku);
            }
            else if (polecenie.equals("3. kolejka.")) {
                String listawyniku = "";
                for (String s : lista_3kolejka) {
                    listawyniku += s;
                }                
                view.select.setText(listawyniku);                
            }
            else if (polecenie.equals("4. kolejka.")) {
                String listawyniku = "";
                for (String s : lista_4kolejka) {
                    listawyniku += s;
                }
                view.select.setText(listawyniku);
            }
        }
    }
}
