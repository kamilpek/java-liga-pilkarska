package ligapilkarska;

import java.awt.event.*;
import java.util.*;

public class controller {

    private ActionListener akcja;
    private model liga_model;
    private view liga_view;
    private java.util.ArrayList<String> lista = new ArrayList<>();

    controller(model model, view view) {
//        System.out.println("To jest kontroler.");
        liga_model = model;
        liga_view = view;

        lista = model.select();

        view.getprzycisk_uruchom().addActionListener(new NasluchiwaczPrzyciskow());
    }

    class MultiplyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

    class ClearListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

    private class NasluchiwaczPrzyciskow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Uruchom")) {

                String listawyniku = "";
                for (String s : lista) {
                    listawyniku += s;
                }
                view.select.append(listawyniku);
                System.out.println(listawyniku);
                System.out.println("Dodano wynik selecta do pola JTextArea.");
            }
        }
    }

}
