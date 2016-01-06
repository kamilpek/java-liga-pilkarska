package ligapilkarska;

import java.sql.*;
import java.util.*;

public class model {

    Connection conn = null;
    Statement stat = null;
    String url = null;
    String user = null;
    String pass = null;
    
    String prefix_selectkolejki_query = "SELECT DATA, godzina, k1.nazwa ||' '|| k1.miasto AS gospodarz, gosp_pkt AS punkty, gosc_pkt AS punkty, k2.nazwa ||' '|| k2.miasto AS gosc FROM klub k1 INNER JOIN mecz ON k1.id=mecz.gospodarz INNER JOIN klub k2 ON mecz.gosc=k2.id ";

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
    
    public String select_pokaztabele(){
        ArrayList<String> tabela_koniec = new ArrayList<>();
        ArrayList<String> tabela_gosp_nazwa = new ArrayList<>();
        ArrayList<String> tabela_gosc_nazwa = new ArrayList<>();
        ArrayList<Integer> tabela_gosp_pkt = new ArrayList<>();
        ArrayList<Integer> tabela_gosc_pkt = new ArrayList<>();
        ArrayList<String> tabela_klub_nazwa = new ArrayList<>();
        ArrayList<Integer> tabela_klub_pkt = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        String tabela_koncowa = null;
        String zaptyanie_pokaztabele = null;        
        String zapytanie_punktygospodarz = "SELECT nazwa, sum(gosp_pkt) as punkty FROM mecz, klub WHERE mecz.gospodarz = klub.id GROUP BY nazwa ORDER BY nazwa;";
        String zapytanie_punktygosc = "SELECT nazwa, sum(gosc_pkt) as punkty FROM mecz, klub WHERE mecz.gosc = klub.id GROUP BY nazwa ORDER BY nazwa;";
        String tabela_create = "CREATE TABLE tabela(id serial, nazwa varchar(16) not null, punkty int not null);";
        String tabela_drop = "DROP TABLE IF EXISTS tabela;";         
        
        try{
           ResultSet rs_punktygospodarz = stat.executeQuery(zapytanie_punktygospodarz);
           while(rs_punktygospodarz.next()){
               String nazwa_gosp = rs_punktygospodarz.getString("nazwa");
               tabela_gosp_nazwa.add(nazwa_gosp);
               int punkty_gosp = rs_punktygospodarz.getInt("punkty");
               tabela_gosp_pkt.add(punkty_gosp);
            }           
        } catch (SQLException e) {
            System.err.println("ERROR select_pokaztabele_punktygospodarz!!: "+ e.getMessage());
            System.exit(0);
        }
        
        try{
            ResultSet rs_punktygosc = stat.executeQuery(zapytanie_punktygosc);
            while(rs_punktygosc.next()){               
               String nazwa_gosc = rs_punktygosc.getString("nazwa");
               tabela_gosc_nazwa.add(nazwa_gosc);
               int punkty_gosc = rs_punktygosc.getInt("punkty");
               tabela_gosc_pkt.add(punkty_gosc);
            }                       
        } catch (SQLException e) {
            System.err.println("ERROR select_pokaztabele_punktygosc!!: "+ e.getMessage());
            System.exit(0);            
        }        
        
        for(int x = 0; x < 15; x++){            
            if(tabela_gosp_nazwa.get(i).equals(tabela_gosc_nazwa.get(i))){
                int punkty = tabela_gosp_pkt.get(i) + tabela_gosc_pkt.get(i);
                String klub = i + ". " + tabela_gosp_nazwa.get(i) + "\t" + punkty + "\n";
                tabela_klub_nazwa.add(tabela_gosp_nazwa.get(i));
                tabela_klub_pkt.add(punkty);
            }
            i++;
        }
        
        try{
            stat.execute(tabela_drop);
            stat.execute(tabela_create);
        } catch (SQLException e){
            System.err.println("ERROR select_pokaztabele_drop/creatae: "+ e.getMessage());
        }
        
        for(int x = 0; x < 15; x++){
            String nazwa = tabela_klub_nazwa.get(j);
            int punkty = tabela_klub_pkt.get(j);
            
            String tabela_insert = "INSERT INTO tabela(nazwa, punkty) VALUES ('" + nazwa + "', " + punkty + ");";
            try{                
                stat.execute(tabela_insert);
            } catch (SQLException e) {
                System.err.println("ERROR select_pokaztabele_tabelapomocnicza: "+ e.getMessage());
            }
            j++;
        }
        
        try{
            ResultSet rs_tabela = stat.executeQuery("SELECT nazwa, punkty FROM tabela ORDER BY punkty DESC;");
            while(rs_tabela.next()){
                k++;
                String tabela_nazwa = rs_tabela.getString("nazwa");
                int tabela_punkty = rs_tabela.getInt("punkty");
                String rekord = k + ". " + tabela_nazwa + "\t\t" + tabela_punkty + "\n";
                tabela_koniec.add(rekord);               
            }
        } catch (SQLException e) {
            System.err.println("ERROR select_pokaztabele_selecttabela"+ e.getMessage());
        }
        
        tabela_koncowa = "";        
        for (String s : tabela_koniec) {
            tabela_koncowa += s;
        }        
        
        return tabela_koncowa;
    }
    
    public String select_zlozeniekolejki(int numer_kolejki){
        
        String kolejka_data = null;
        
        switch (numer_kolejki){
            case 1: kolejka_data = "WHERE data BETWEEN '2013/08/10' AND '2013/08/11';"; break;
            case 2: kolejka_data = "WHERE data BETWEEN '2013/08/14' AND '2013/08/15';"; break;
            case 3: kolejka_data = "WHERE data BETWEEN '2013/08/17' AND '2013/08/18';"; break;
            case 4: kolejka_data = "WHERE data BETWEEN '2013/08/24' AND '2013/08/25';"; break;
            case 5: kolejka_data = "WHERE data BETWEEN '2013/08/30' AND '2013/09/01';"; break;
            case 6: kolejka_data = "WHERE data BETWEEN '2013/09/06' AND '2013/09/07';"; break;
            case 7: kolejka_data = "WHERE data BETWEEN '2013/09/14' AND '2013/09/15';"; break;
            case 8: kolejka_data = "WHERE data BETWEEN '2013/09/21' AND '2013/09/22';"; break;
            case 9: kolejka_data = "WHERE data BETWEEN '2013/09/28' AND '2013/09/29';"; break;
            case 10: kolejka_data = "WHERE data BETWEEN '2013/10/05' AND '2013/10/06';"; break;
            case 11: kolejka_data = "WHERE data BETWEEN '2013/10/12' AND '2013/10/13';"; break;
            case 12: kolejka_data = "WHERE data BETWEEN '2013/10/18' AND '2013/10/19';"; break;
            case 13: kolejka_data = "WHERE data BETWEEN '2013/10/26' AND '2013/10/27';"; break;
            case 14: kolejka_data = "WHERE data BETWEEN '2013/11/02' AND '2013/11/03';"; break;
            case 15: kolejka_data = "WHERE data BETWEEN '2013/11/09' AND '2013/11/10';"; break;
            case 16: kolejka_data = "WHERE data BETWEEN '2013/11/16' AND '2013/11/17';"; break;
            case 17: kolejka_data = "WHERE data BETWEEN '2013/11/23' AND '2013/11/24';"; break;
            case 18: kolejka_data = "WHERE data BETWEEN '2014/03/15' AND '2014/03/16';"; break;
            case 19: kolejka_data = "WHERE data BETWEEN '2014/03/22' AND '2014/03/23';"; break;
            case 20: kolejka_data = "WHERE data BETWEEN '2014/03/29' AND '2014/03/30';"; break;
            case 21: kolejka_data = "WHERE data BETWEEN '2014/04/05' AND '2014/04/06';"; break;
            case 22: kolejka_data = "WHERE data BETWEEN '2014/04/12' AND '2014/04/13';"; break;
            case 23: kolejka_data = "WHERE data BETWEEN '2014/04/18' AND '2014/04/19';"; break;
            case 24: kolejka_data = "WHERE data BETWEEN '2014/04/26' AND '2014/04/27';"; break;
            case 25: kolejka_data = "WHERE data BETWEEN '2014/05/03' AND '2014/05/04';"; break;
            case 26: kolejka_data = "WHERE data BETWEEN '2014/05/10' AND '2014/05/11';"; break;
            case 27: kolejka_data = "WHERE data BETWEEN '2014/05/17' AND '2014/05/18';"; break;
            case 28: kolejka_data = "WHERE data BETWEEN '2014/05/24' AND '2014/05/25';"; break;
            case 29: kolejka_data = "WHERE data BETWEEN '2014/05/31' AND '2014/06/01';"; break;
            case 30: kolejka_data = "WHERE data BETWEEN '2014/06/06' AND '2014/06/07';"; break;
        }
        
        String select_kolejka = prefix_selectkolejki_query + kolejka_data;
                
        Select select_zlozeniekolejki = null;
        try{
            ResultSet rs = stat.executeQuery(select_kolejka);
            select_zlozeniekolejki = new Select(stat, rs);
        } catch (SQLException e) {
            System.err.println("ERROR!!: "+ e.getMessage());
            System.exit(0);
        }
        return select_zlozeniekolejki.listawyniku;
//        return null;
    }
    
}

class Select {

    ArrayList<String> wynik_kolejki = new ArrayList<>();
    String listawyniku = null;

    Select(Statement stat, ResultSet rs) {
        select_kolejki(stat, rs);
    }

    private String select_kolejki (Statement stat, ResultSet rs) {
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
        
        listawyniku = "";
        for (String s : wynik_kolejki) {
            listawyniku += s;
        }
        
        return listawyniku;
    }
}
