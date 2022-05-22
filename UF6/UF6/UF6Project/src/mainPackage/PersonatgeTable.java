
package mainPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonatgeTable extends ORMTable{
    
    public PersonatgeTable(){
        super("Personatge");
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
        
        PersonatgeEntity pE = (PersonatgeEntity) o;
        
        String sqlCommand = "INSERT INTO PERSONATGE (jugatPer, nom, raza, classe) VALUES (" + pE.getJugatPer() + ", '" + pE.getNom() + "', '" 
                + pE.getRaza().desc + "', '" + pE.getClasse().desc + "')";
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        
        return numFilesAfectades;
    }

    @Override
    public ArrayList<PersonatgeEntity> GetAll() throws NullConnectionException, SQLException {
        
        ArrayList<PersonatgeEntity> resultList = new ArrayList<PersonatgeEntity>();
        
        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM PERSONATGE");
        
        while(resultat.next()){
            PersonatgeEntity p = new PersonatgeEntity(
                    
                    resultat.getInt("id"),
                    resultat.getInt("jugatPer"),
                    resultat.getString("nom"),
                    resultat.getString("raza"),
                    resultat.getString("classe"),
                    
                    resultat.getInt("forsa"),
                    resultat.getInt("destresa"),
                    resultat.getInt("constitucio"),
                    resultat.getInt("inteligencia"),
                    resultat.getInt("sabiduria"),
                    resultat.getInt("carisma"),
                    
                    resultat.getInt("pg")
            );
            resultList.add(p);
        }
        
        resultat.close();
        consulta.close();
        
        return resultList;
    }    
}
