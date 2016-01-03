package ligapilkarska;

import java.awt.event.*;

public class controller {

    private ActionListener akcja;
    private model liga_model;
    private view liga_view;

    controller(model model, view view) {
//        System.out.println("To jest kontroler.");
        liga_model = model;
        liga_view = view;
        
        view.getprzycisk_uruchom().addActionListener(new NasluchiwaczPrzyciskow());
    }

    public void uruchom() {
        akcja = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                model.uruchom();
                System.out.println("test");
            }
        };
        view.getprzycisk_uruchom().addActionListener(akcja);
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
                System.out.println("teest!!");
            }
        }
    }

}
