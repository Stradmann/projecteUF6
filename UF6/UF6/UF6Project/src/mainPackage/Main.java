package mainPackage;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    static final String USER = "a21yenwuwzha_user";
    static final String PWD = "A21yenwuwzha";
    static final String URL = "labs.inspedralbes.cat";
    static final String PORT = "3306";
    static final String BD_NAME = "a21yenwuwzha_projecteUF6";

    public static void main(String[] args){
        
        try {
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            
            JugadorTable jt = new JugadorTable();
            PersonatgeTable pt = new PersonatgeTable();
            jt.setConnection(bdCon);
            pt.setConnection(bdCon);
            
            //JugadorEntity je = new JugadorEntity("Yennifer", true);
            PersonatgeEntity pe = new PersonatgeEntity(3, "Cazleb", "Nan", "Mag", 10, 12, 8, 18, 15, 16, 3);
            
            //jt.Insert(je);
            pt.Insert(pe);
            bdCon.confirmarCanvis();
            bdCon.closeConnection();
            
        } catch (ClassNotFoundException ce) {
            System.out.println("Error al carregar driver");
        } catch (SQLException se) {
            System.out.println("Excepcio: ");
            System.out.println();
            System.out.println("El getSQLState es: " + se.getSQLState());
            System.out.println();
            System.out.println("El getMessage es: " + se.getMessage());
        } catch (NullConnectionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
