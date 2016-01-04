package ligapilkarska;

import java.awt.event.*;
import java.util.*;

public class controller {

    private model liga_model;
    private view liga_view;
    private java.util.ArrayList<String> lista_1kolejka = new ArrayList<>();
    private java.util.ArrayList<String> lista_2kolejka = new ArrayList<>();

    controller(model model, view view){
        liga_model = model;
        liga_view = view;

        lista_1kolejka = model.select_1kolejka();
        lista_2kolejka = model.select_2kolejka();
        view.getprzycisk_1kolejka().addActionListener(new NasluchiwaczPrzyciskow());
        view.getprzycisk_2kolejka().addActionListener(new NasluchiwaczPrzyciskow());
    }

    private class NasluchiwaczPrzyciskow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("1-kolejka")) {
                String listawyniku = "";
                for (String s : lista_1kolejka) {
                    listawyniku += s;
                }
                view.select.setText(listawyniku);
            }
            else if (command.equals("2-kolejka")) {
                String listawyniku = "";
                for (String s : lista_2kolejka) {
                    listawyniku += s;
                }                
                view.select.setText(listawyniku);
            }
        }
    }
}
