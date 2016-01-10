package ligapilkarska;

public class model {

    dao dao = null;

    model() {
        dao = new dao();
        
    }    
    public dao getdao(){
        return dao;
    } 
}
