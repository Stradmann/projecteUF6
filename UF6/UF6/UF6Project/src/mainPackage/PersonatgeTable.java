
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
        int bonusCons = (pE.getConstitucio() - 10)/2;
        int pG = 0;
        switch(pE.getClasse().desc){
            case "Guerrer":
                pG = 10 + bonusCons;
                break;
            case "Mag":
                pG = 4 + bonusCons;
                break;
            case "Murri":
                pG = 6 + bonusCons;
                break;
        }
        String sqlCommand = "INSERT INTO PERSONATGE (jugatPer, nom, raza, classe, forsa, destresa, constitucio, inteligencia, sabiduria, carisma, pg) VALUES (" + pE.getJugatPer() + ", '" + pE.getNom() + "', '" 
                + pE.getRaza().desc + "', '" + pE.getClasse().desc + "',"
                + "" + pE.getForsa() + ", " + pE.getDestresa() + ", " + pE.getConstitucio() + ", " + pE.getInteligencia() + ", "
                + pE.getSabiduria() + ", " + pE.getCarisma() + ", " + pG + ")";
        
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

    @Override
    public int update(ORMEntity aux, ORMEntity o) throws NullConnectionException, SQLException {
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
        PersonatgeEntity auxPE = (PersonatgeEntity) aux;
        
        String sqlCommand = "UPDATE PERSONATGE SET nom = '" + auxPE.getNom() + "', raza = '" + auxPE.getRaza().desc + "', classe = '" + auxPE.getClasse().desc
                + "', forsa = " + auxPE.getForsa() + ", destresa = " + auxPE.getDestresa() + ", constitucio = " + auxPE.getConstitucio()
                + ", inteligencia = " + auxPE.getInteligencia() + ", sabiduria = " + auxPE.getSabiduria() + ", carisma = " + auxPE.getCarisma()
                + ", pg = " + auxPE.getPg() + " WHERE id = " + pE.getId() ;
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        return numFilesAfectades;
    }

    @Override
    public int delete(ORMEntity o) throws NullConnectionException, SQLException {
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
        
        String sqlCommand = "DELETE FROM PERSONATGE WHERE id = " + pE.getId() ;
        
        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();
        
        getBDConnection().getConnection().commit();
        return numFilesAfectades;
    }   
}
