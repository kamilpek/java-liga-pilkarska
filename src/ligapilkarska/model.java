package ligapilkarska;

import java.io.*;
import java.sql.*;
import java.util.*;

public class model {

    Connection conn = null;
    Statement stat = null;
    String url = null;
    String user = null;
    String pass = null;

    model() {
        polaczenie();
    }

    model(String url, String user, String pass) {
        polaczenie(url, user, pass);
    }

    model(String user, String pass) {
        polaczenie(user, pass);
    }

    private Statement polaczenie() {
        url = "jdbc:postgresql://localhost/liga";
        user = "majster";
        pass = "System32";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            stat = conn.createStatement();
            System.out.println("Połączono z Bazą!!");
        } catch (SQLException e) {
            System.err.println("ERROR!!: " + e.getMessage());
            System.exit(0);
        }
        return this.stat;
    }

    private Statement polaczenie(String url, String user, String pass) {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("ERROR!!!: " + e.getMessage());
            System.exit(0);
        }
        return this.stat;
    }

    private Statement polaczenie(String user, String pass) {
        url = "jdbc:postgresql://localhost/liga";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("ERROR!!!!: " + e.getMessage());
            System.exit(0);
        }
        return this.stat;
    }

    ArrayList<String> select() {
        Select select = new Select(stat);
        return select.listawynikowa;
    }
    
    public static String uruchom(){
        String tekst = "test klasy controller";
//        System.out.println(tekst);
        return tekst;
    }
}

class Select {

    ArrayList<String> listawynikowa = new ArrayList<>();

    Select(Statement stat) {
        wynikselecta(stat);
    }

    private ArrayList<String> wynikselecta(Statement stat) {
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/10' AND '2013/08/11';");
            while (rs.next()) {
                String data = rs.getString("data");
                String godzina = rs.getString("godzina");
                String gospodarz = rs.getString(3);
                int punkty_gospodarz = rs.getInt(4);
                int punkty_gosc = rs.getInt(5);
                String gosc = rs.getString(6);

                String wynik = data + " " + godzina + " " + gospodarz + "\t " + punkty_gospodarz + " : " + punkty_gosc + "   " + gosc + "\n";
                listawynikowa.add(wynik);

//                System.out.println(stat);
//                System.out.println(data + " " + godzina + " " + gospodarz + "\t " + punkty_gospodarz + " " + punkty_gosc + "\t" + gosc);                
            }

        } catch (SQLException e) {
            System.err.println("ERROR!!: " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Rozmiar tablicy to: "+ listawynikowa.size());
        return listawynikowa;
    }
}
