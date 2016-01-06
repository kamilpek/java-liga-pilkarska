package ligapilkarska;

import java.awt.event.*;

public class controller {

    private final model liga_model;
    private final view liga_view;
    private model liga_model_listener;
    private view liga_view_listener;    
    
    String polecenie = null;

    controller(model model, view view){
        liga_model = model;
        liga_view = view;        
        
        view.getprzycisk_pokaztabele().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        view.getlista_selectkolejki().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
        view.getprzycisk_oglowne_select().addActionListener(new Nasluchiwacz(liga_model, liga_view));
        
    }

    private class Nasluchiwacz implements ActionListener {
        
        Nasluchiwacz(model model, view view){
            liga_model_listener = model;
            liga_view_listener = view;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            polecenie = view.getlista_selectkolejki().getSelectedItem().toString();
            
            String command = e.getActionCommand();
            if (command.equals("pokaztabele")) {
                String lista_pokaztabele = liga_model_listener.select_pokaztabele();
                liga_view_listener.select.setText(null);
                liga_view_listener.select.setText(lista_pokaztabele);
            }
            else if (command.equals("okno_select")){
                liga_view_listener.okno_select.setVisible(true);
                System.out.println("działa");
            }
                        
            switch(polecenie){
                case "1. kolejka.": {
                    String lista_1kolejka = liga_model_listener.select_zlozeniekolejki(1);
                    view.select.setText(lista_1kolejka);
                } break;
                case "2. kolejka.": {
                    String lista_2kolejka = liga_model_listener.select_zlozeniekolejki(2);
                    view.select.setText(lista_2kolejka);
                } break;
                case "3. kolejka.": { 
                    String lista_3kolejka = liga_model_listener.select_zlozeniekolejki(3);
                    view.select.setText(lista_3kolejka);
                } break;
                case "4. kolejka.": { 
                    String lista_4kolejka = liga_model_listener.select_zlozeniekolejki(4);
                    view.select.setText(lista_4kolejka);
                } break;
                case "5. kolejka.": {
                    String lista_5kolejka = liga_model_listener.select_zlozeniekolejki(5);
                    view.select.setText(lista_5kolejka);
                } break;
                case "6. kolejka.": {
                    String lista_6kolejka = liga_model_listener.select_zlozeniekolejki(6);
                    view.select.setText(lista_6kolejka);
                } break;
                case "7. kolejka.": {
                    String lista_7kolejka = liga_model_listener.select_zlozeniekolejki(7);
                    view.select.setText(lista_7kolejka);
                } break;
                case "8. kolejka.": {
                    String lista_8kolejka = liga_model_listener.select_zlozeniekolejki(8);
                    view.select.setText(lista_8kolejka);
                } break;
                case "9. kolejka.": {
                    String lista_9kolejka = liga_model_listener.select_zlozeniekolejki(9);
                    view.select.setText(lista_9kolejka);
                } break;
                case "10. kolejka.": {
                    String lista_10kolejka = liga_model_listener.select_zlozeniekolejki(10);
                    view.select.setText(lista_10kolejka);
                } break;
                case "11. kolejka.": {
                    String lista_11kolejka = liga_model_listener.select_zlozeniekolejki(11);
                    view.select.setText(lista_11kolejka);
                } break;
                case "12. kolejka.": {
                    String lista_12kolejka = liga_model_listener.select_zlozeniekolejki(12);
                    view.select.setText(lista_12kolejka);
                } break;
                case "13. kolejka.": {
                    String lista_13kolejka = liga_model_listener.select_zlozeniekolejki(13);
                    view.select.setText(lista_13kolejka);
                } break;
                case "14. kolejka.": {
                    String lista_14kolejka = liga_model_listener.select_zlozeniekolejki(14);
                    view.select.setText(lista_14kolejka);
                } break;
                case "15. kolejka.": {
                    String lista_15kolejka = liga_model_listener.select_zlozeniekolejki(15);
                    view.select.setText(lista_15kolejka);
                } break;
                case "16. kolejka.": {
                    String lista_16kolejka = liga_model_listener.select_zlozeniekolejki(16);
                    view.select.setText(lista_16kolejka);
                } break;
                case "17. kolejka.": {
                    String lista_17kolejka = liga_model_listener.select_zlozeniekolejki(17);
                    view.select.setText(lista_17kolejka);
                } break;
                case "18. kolejka.": {
                    String lista_18kolejka = liga_model_listener.select_zlozeniekolejki(18);
                    view.select.setText(lista_18kolejka);
                } break;
                case "19. kolejka.": {
                    String lista_19kolejka = liga_model_listener.select_zlozeniekolejki(19);
                    view.select.setText(lista_19kolejka);
                } break;
                case "20. kolejka.": {
                    String lista_20kolejka = liga_model_listener.select_zlozeniekolejki(20);
                    view.select.setText(lista_20kolejka);
                } break;
                case "21. kolejka.": {
                    String lista_21kolejka = liga_model_listener.select_zlozeniekolejki(21);
                    view.select.setText(lista_21kolejka);
                } break;
                case "22. kolejka.": {
                    String lista_22kolejka = liga_model_listener.select_zlozeniekolejki(22);
                    view.select.setText(lista_22kolejka);
                } break;
                case "23. kolejka.": {
                    String lista_23kolejka = liga_model_listener.select_zlozeniekolejki(23);
                    view.select.setText(lista_23kolejka);
                } break;
                case "24. kolejka.": {
                    String lista_24kolejka = liga_model_listener.select_zlozeniekolejki(24);
                    view.select.setText(lista_24kolejka);
                } break;
                case "25. kolejka.": {
                    String lista_25kolejka = liga_model_listener.select_zlozeniekolejki(25);
                    view.select.setText(lista_25kolejka);
                } break;
                case "26. kolejka.": {
                    String lista_26kolejka = liga_model_listener.select_zlozeniekolejki(26);
                    view.select.setText(lista_26kolejka);
                } break;
                case "27. kolejka.": {
                    String lista_27kolejka = liga_model_listener.select_zlozeniekolejki(27);
                    view.select.setText(lista_27kolejka);
                } break;
                case "28. kolejka.": {
                    String lista_28kolejka = liga_model_listener.select_zlozeniekolejki(28);
                    view.select.setText(lista_28kolejka);
                } break;
                case "29. kolejka.": {
                    String lista_29kolejka = liga_model_listener.select_zlozeniekolejki(29);
                    view.select.setText(lista_29kolejka);
                } break;
                case "30. kolejka.": {
                    String lista_30kolejka = liga_model_listener.select_zlozeniekolejki(30);
                    view.select.setText(lista_30kolejka);
                } break;                   
            }
        }
    }
}
