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
    
    public ArrayList<String> select_11kolejka(){
        Select select_11kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/10/12' AND '2013/10/13';");
            select_11kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_11kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_12kolejka(){
        Select select_12kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/10/18' AND '2013/10/19';");
            select_12kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_12kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_13kolejka(){
        Select select_13kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/10/26' AND '2013/10/27';");
            select_13kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_13kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_14kolejka(){
        Select select_14kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/11/02' AND '2013/11/03';");
            select_14kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_14kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_15kolejka(){
        Select select_15kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/11/09' AND '2013/11/10';");
            select_15kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_15kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_16kolejka(){
        Select select_16kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/11/16' AND '2013/11/17';");
            select_16kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_16kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_17kolejka(){
        Select select_17kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2013/11/23' AND '2013/11/24';");
            select_17kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_17kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_18kolejka(){
        Select select_18kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/03/15' AND '2014/03/16';");
            select_18kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_18kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_19kolejka(){
        Select select_19kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/03/22' AND '2014/03/23';");
            select_19kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_19kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_20kolejka(){
        Select select_20kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/03/29' AND '2014/03/30';");
            select_20kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_20kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_21kolejka(){
        Select select_21kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/04/05' AND '2014/04/06';");
            select_21kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_21kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_22kolejka(){
        Select select_22kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/04/12' AND '2014/04/13';");
            select_22kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_22kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_23kolejka(){
        Select select_23kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/04/18' AND '2014/04/19';");
            select_23kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_23kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_24kolejka(){
        Select select_24kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/04/26' AND '2014/04/27';");
            select_24kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_24kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_25kolejka(){
        Select select_25kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/05/03' AND '2014/05/04';");
            select_25kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_25kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_26kolejka(){
        Select select_26kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/05/10' AND '2014/05/11';");
            select_26kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_26kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_27kolejka(){
        Select select_27kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/05/17' AND '2014/05/18';");
            select_27kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_27kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_28kolejka(){
        Select select_28kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/05/24' AND '2014/05/25';");
            select_28kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_28kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_29kolejka(){
        Select select_29kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/05/30' AND '2014/06/01';");
            select_29kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_29kolejka.wynik_kolejki;
    }
    
    public ArrayList<String> select_30kolejka(){
        Select select_30kolejka = null;
        try {
            ResultSet rs = stat.executeQuery("SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id WHERE data BETWEEN '2014/06/07' AND '2014/06/07';");
            select_30kolejka = new Select(stat, rs);
            
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }        
        return select_30kolejka.wynik_kolejki;
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
