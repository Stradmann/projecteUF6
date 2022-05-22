
package mainPackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Controller {
    
    static final String USER = "a21yenwuwzha_user";
    static final String PWD = "A21yenwuwzha";
    static final String URL = "labs.inspedralbes.cat";
    static final String PORT = "3306";
    static final String BD_NAME = "a21yenwuwzha_projecteUF6";
    
    private static JugadorTable jt;
    private static PersonatgeTable pt;
    
    private static ArrayList<JugadorEntity> players = new ArrayList<JugadorEntity>();
    
    private static JFrame mainFrame;
    private static JFrame jugadorsMenu;
    private static JFrame personatgesMenu;
    
    public static void connect(){
        //CREATE CONECTION AND TABLES
         try {
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            
            setJt(new JugadorTable());
            setPt(new PersonatgeTable());
            getJt().setConnection(bdCon);
            getPt().setConnection(bdCon);
            
            //JugadorEntity je = new JugadorEntity("Yennifer", true);
            //PersonatgeEntity pe = new PersonatgeEntity(3, "Cazleb", "Nan", "Mag", 10, 12, 8, 18, 15, 16, 3);
            
            //jt.Insert(je);
            //pt.Insert(pe);
            //bdCon.confirmarCanvis();
            //bdCon.closeConnection();
            
        } catch (ClassNotFoundException ce) {
            System.out.println("Error al carregar driver");
        } catch (SQLException se) {
            System.out.println("Excepcio: ");
            System.out.println();
            System.out.println("El getSQLState es: " + se.getSQLState());
            System.out.println();
            System.out.println("El getMessage es: " + se.getMessage());
        }
    }

    /**
     * @return the jt
     */
    public static JugadorTable getJt() {
        return jt;
    }

    /**
     * @param aJt the jt to set
     */
    public static void setJt(JugadorTable aJt) {
        jt = aJt;
    }

    /**
     * @return the pt
     */
    public static PersonatgeTable getPt() {
        return pt;
    }

    /**
     * @param aPt the pt to set
     */
    public static void setPt(PersonatgeTable aPt) {
        pt = aPt;
    }

    /**
     * @return the players
     */
    public static ArrayList<JugadorEntity> getPlayers() {
        return players;
    }

    /**
     * @param aPlayers the players to set
     */
    public static void setPlayers() {
        try {
            players = jt.GetAll();
        } catch (NullConnectionException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @return the mainFrame
     */
    public static JFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * @param aMainFrame the mainFrame to set
     */
    public static void setMainFrame(JFrame aMainFrame) {
        mainFrame = aMainFrame;
    }

    /**
     * @return the jugadorsMenu
     */
    public static JFrame getJugadorsMenu() {
        return jugadorsMenu;
    }

    /**
     * @param aJugadorsMenu the jugadorsMenu to set
     */
    public static void setJugadorsMenu(JFrame aJugadorsMenu) {
        jugadorsMenu = aJugadorsMenu;
    }

    /**
     * @return the personatgesMenu
     */
    public static JFrame getPersonatgesMenu() {
        return personatgesMenu;
    }

    /**
     * @param aPersonatgesMenu the personatgesMenu to set
     */
    public static void setPersonatgesMenu(JFrame aPersonatgesMenu) {
        personatgesMenu = aPersonatgesMenu;
    }
    
    
    
    
}
