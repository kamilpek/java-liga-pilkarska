package ligapilkarska;

import java.sql.*;
import java.util.*;

public class model {

    Connection conn = null;
    Statement stat = null;
    String url = null;
    String user = null;
    String pass = null;
    dao dao = null;

    model() {
        dao = new dao();
        
    }    
    public dao getdao(){
        return dao;
    } 
}
