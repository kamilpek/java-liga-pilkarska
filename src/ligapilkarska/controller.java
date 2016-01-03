package ligapilkarska;

import java.awt.event.*;
import javax.swing.JButton;

public class controller {

    private ActionListener akcja;
    private model liga_model;
    private view liga_view;

    controller(model model, view view) {
//        System.out.println("To jest kontroler.");
        liga_model = model;
        liga_view = view;
    }

    public void uruchom() {
        akcja = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String tekst = model.uruchom();
                System.out.println("tekst");
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

}
