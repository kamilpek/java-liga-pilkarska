package ligapilkarska;

import java.awt.event.*;

public class controller {

    private final model liga_model;
    private final view liga_view;
    
    private final String lista_1kolejka;
    private final String lista_2kolejka;
    private final String lista_3kolejka;
    private final String lista_4kolejka;
    private final String lista_5kolejka;
    private final String lista_6kolejka;
    private final String lista_7kolejka;
    private final String lista_8kolejka;
    private final String lista_9kolejka;
    private final String lista_10kolejka;
    private final String lista_11kolejka;
    private final String lista_12kolejka;
    private final String lista_13kolejka;
    private final String lista_14kolejka;
    private final String lista_15kolejka;
    private final String lista_16kolejka;
    private final String lista_17kolejka;
    private final String lista_18kolejka;
    private final String lista_19kolejka;
    private final String lista_20kolejka;
    private final String lista_21kolejka;
    private final String lista_22kolejka;
    private final String lista_23kolejka;
    private final String lista_24kolejka;
    private final String lista_25kolejka;
    private final String lista_26kolejka;
    private final String lista_27kolejka;
    private final String lista_28kolejka;
    private final String lista_29kolejka;
    private final String lista_30kolejka;
    private String lista_pokaztabele;
    
    String polecenie = null;

    controller(model model, view view){
        liga_model = model;
        liga_view = view;

        lista_1kolejka = model.select_zlozeniekolejki(1);
        lista_2kolejka = model.select_zlozeniekolejki(2);
        lista_3kolejka = model.select_zlozeniekolejki(3);
        lista_4kolejka = model.select_zlozeniekolejki(4);
        lista_5kolejka = model.select_zlozeniekolejki(5);
        lista_6kolejka = model.select_zlozeniekolejki(6);
        lista_7kolejka = model.select_zlozeniekolejki(7);
        lista_8kolejka = model.select_zlozeniekolejki(8);
        lista_9kolejka = model.select_zlozeniekolejki(9);
        lista_10kolejka = model.select_zlozeniekolejki(10);
        lista_11kolejka = model.select_zlozeniekolejki(11);
        lista_12kolejka = model.select_zlozeniekolejki(12);
        lista_13kolejka = model.select_zlozeniekolejki(13);
        lista_14kolejka = model.select_zlozeniekolejki(14);
        lista_15kolejka = model.select_zlozeniekolejki(15);
        lista_16kolejka = model.select_zlozeniekolejki(16);
        lista_17kolejka = model.select_zlozeniekolejki(17);
        lista_18kolejka = model.select_zlozeniekolejki(18);
        lista_19kolejka = model.select_zlozeniekolejki(19);
        lista_20kolejka = model.select_zlozeniekolejki(20);
        lista_21kolejka = model.select_zlozeniekolejki(21);
        lista_22kolejka = model.select_zlozeniekolejki(22);
        lista_23kolejka = model.select_zlozeniekolejki(23);
        lista_24kolejka = model.select_zlozeniekolejki(24);
        lista_25kolejka = model.select_zlozeniekolejki(25);
        lista_26kolejka = model.select_zlozeniekolejki(26);
        lista_27kolejka = model.select_zlozeniekolejki(27);
        lista_28kolejka = model.select_zlozeniekolejki(28);
        lista_29kolejka = model.select_zlozeniekolejki(29);
        lista_30kolejka = model.select_zlozeniekolejki(30);
        lista_pokaztabele = model.select_pokaztabele();
        
        view.getprzycisk_pokaztabele().addActionListener(new NasluchiwaczPrzyciskow());
        view.getprzycisk_2kolejka().addActionListener(new NasluchiwaczPrzyciskow());
        view.getlista_selectkolejki().addActionListener(new NasluchiwaczPrzyciskow());
        
    }

    private class NasluchiwaczPrzyciskow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            polecenie = view.getlista_selectkolejki().getSelectedItem().toString();
            
            String command = e.getActionCommand();
            if (command.equals("pokaztabele")) {
                view.select.setText(null);
                view.select.setText(lista_pokaztabele);
                System.out.println(lista_pokaztabele);
            }
                        
            switch(polecenie){
                case "1. kolejka.": view.select.setText(lista_1kolejka); break;
                case "2. kolejka.": view.select.setText(lista_2kolejka); break;
                case "3. kolejka.": view.select.setText(lista_3kolejka); break;
                case "4. kolejka.": view.select.setText(lista_4kolejka); break;
                case "5. kolejka.": view.select.setText(lista_5kolejka); break;
                case "6. kolejka.": view.select.setText(lista_6kolejka); break;
                case "7. kolejka.": view.select.setText(lista_7kolejka); break;
                case "8. kolejka.": view.select.setText(lista_8kolejka); break;
                case "9. kolejka.": view.select.setText(lista_9kolejka); break;
                case "10. kolejka.": view.select.setText(lista_10kolejka); break;
                case "11. kolejka.": view.select.setText(lista_11kolejka); break;
                case "12. kolejka.": view.select.setText(lista_12kolejka); break;
                case "13. kolejka.": view.select.setText(lista_13kolejka); break;
                case "14. kolejka.": view.select.setText(lista_14kolejka); break;
                case "15. kolejka.": view.select.setText(lista_15kolejka); break;
                case "16. kolejka.": view.select.setText(lista_16kolejka); break;
                case "17. kolejka.": view.select.setText(lista_17kolejka); break;
                case "18. kolejka.": view.select.setText(lista_18kolejka); break;
                case "19. kolejka.": view.select.setText(lista_19kolejka); break;
                case "20. kolejka.": view.select.setText(lista_20kolejka); break;
                case "21. kolejka.": view.select.setText(lista_21kolejka); break;
                case "22. kolejka.": view.select.setText(lista_22kolejka); break;
                case "23. kolejka.": view.select.setText(lista_23kolejka); break;
                case "24. kolejka.": view.select.setText(lista_24kolejka); break;
                case "25. kolejka.": view.select.setText(lista_25kolejka); break;
                case "26. kolejka.": view.select.setText(lista_26kolejka); break;
                case "27. kolejka.": view.select.setText(lista_27kolejka); break;
                case "28. kolejka.": view.select.setText(lista_28kolejka); break;
                case "29. kolejka.": view.select.setText(lista_29kolejka); break;
                case "30. kolejka.": view.select.setText(lista_30kolejka); break;                   
            }
        }
    }
}
