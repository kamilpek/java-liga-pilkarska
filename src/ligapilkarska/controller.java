package ligapilkarska;

import java.awt.event.*;
import java.util.*;

public class controller {

    private ActionListener akcja;
    private model liga_model;
    private view liga_view;
    private java.util.ArrayList<String> lista = new ArrayList<>();

    controller(model model, view view){
        liga_model = model;
        liga_view = view;

        lista = model.select_30kolejka();
        view.getprzycisk_uruchom().addActionListener(new NasluchiwaczPrzyciskow());
    }

    private class NasluchiwaczPrzyciskow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("1-kolejka")) {

                String listawyniku = "";
                for (String s : lista) {
                    listawyniku += s;
                }
                view.select.append(listawyniku);
            }
        }
    }

}
