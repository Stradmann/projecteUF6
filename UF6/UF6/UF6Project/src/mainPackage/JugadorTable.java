
package mainPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadorTable extends ORMTable{
    
    public JugadorTable(){
        super("Jugador");
    }

    @Override
    public int Insert(ORMEntity o) throws NullConnectionException, SQLException {
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        
        JugadorEntity jE = (JugadorEntity) o;
        
        String sqlCommand = "INSERT INTO JUGADOR (nom, arbitre) VALUES ('" + jE.getNom() + "', " + jE.isArbitre() + ")";
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        
        return numFilesAfectades;
    }

    @Override
    public ArrayList<JugadorEntity> GetAll() throws NullConnectionException, SQLException {
        
        ArrayList<JugadorEntity> resultList = new ArrayList<JugadorEntity>();
        
        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM JUGADOR");
        
        while(resultat.next()){
            JugadorEntity j = new JugadorEntity(
                    resultat.getInt("id"),
                    resultat.getString("nom"),
                    resultat.getBoolean("arbitre")
            );
            resultList.add(j);
        }
        
        resultat.close();
        consulta.close();
        
        return resultList;
    }
    
    public int update(String nom, boolean arbitre, ORMEntity o)throws NullConnectionException, SQLException{
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        
        JugadorEntity jE = (JugadorEntity) o;
        
        String sqlCommand = "UPDATE JUGADOR SET nom = '" + nom + "', arbitre = " + arbitre + " WHERE id = " + jE.getId() ;
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        return numFilesAfectades;
    } 
    
    public int delete(ORMEntity o)throws NullConnectionException, SQLException{
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        
        JugadorEntity jE = (JugadorEntity) o;
        
        String sqlCommand = "DELETE FROM JUGADOR WHERE id = " + jE.getId() ;
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        return numFilesAfectades;
    }   
}
