package ligapilkarska;

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

    public ArrayList<String> select_1kolejka(){
        Select select_1kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/10' AND '2013/08/11';");
            select_1kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_1kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_2kolejka(){
        Select select_2kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/14' AND '2013/08/15';");
            select_2kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_2kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_3kolejka(){
        Select select_3kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/17' AND '2013/08/18';");
            select_3kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_3kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_4kolejka(){
        Select select_4kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/24' AND '2013/08/25';");
            select_4kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_4kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_5kolejka(){
        Select select_5kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/08/30' AND '2013/09/01';");
            select_5kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_5kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_6kolejka(){
        Select select_6kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/09/06' AND '2013/09/07';");
            select_6kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_6kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_7kolejka(){
        Select select_7kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/09/14' AND '2013/09/15';");
            select_7kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_7kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_8kolejka(){
        Select select_8kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/09/21' AND '2013/09/22';");
            select_8kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_8kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_9kolejka(){
        Select select_9kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/09/28' AND '2013/09/29';");
            select_9kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_9kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_10kolejka(){
        Select select_10kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/10/05' AND '2013/10/06';");
            select_10kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_10kolejka.wynik_kolejki;
    }
    
}

class Select {

    ArrayList<String> wynik_kolejki = new ArrayList<>();
    ArrayList<String> wynik_2kolejka = new ArrayList<>();

    Select(Statement stat, ResultSet rs) {
        select_kolejki(stat, rs);
    }

    private ArrayList<String> select_kolejki (Statement stat, ResultSet rs) {
        try {
            while (rs.next()) {
                String data = rs.getString("data");
                String godzina = rs.getString("godzina");
                String gospodarz = rs.getString(3);
                int punkty_gospodarz = rs.getInt(4);
                int punkty_gosc = rs.getInt(5);
                String gosc = rs.getString(6);

                String wynik = data + " " + godzina + " " + gospodarz + "\t " + punkty_gospodarz + " : " + punkty_gosc + "   " + gosc + "\n";
                wynik_kolejki.add(wynik);               
            }
        } catch (SQLException e) {
            System.err.println("ERROR!!: " + e.getMessage());
            System.exit(0);
        }
        return wynik_kolejki;
    }
}
