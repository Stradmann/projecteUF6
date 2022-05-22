
package mainPackage;

public class JugadorEntity extends ORMEntity{
    
    //Atributs
    private int id;
    private String nom;
    private boolean arbitre;
    
    private BDConnection c;
    
    public JugadorEntity(String nom, boolean arbitre){
        this.nom = nom;
        this.arbitre = arbitre;
    }
    
    public JugadorEntity(int id, String nom, boolean arbitre){
        this(nom, arbitre);
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the arbitre
     */
    public boolean isArbitre() {
        return arbitre;
    }

    /**
     * @param arbitre the arbitre to set
     */
    public void setArbitre(boolean arbitre) {
        this.arbitre = arbitre;
    }

    /**
     * @param c the c to set
     */
    public void setC(BDConnection c) {
        this.c = c;
    }
    
    @Override
    public String toString(){
        String res = "<div><p>ID: " + this.id + "</p>"
                + "<p>Nom: " + this.nom + "</p>";
        if (this.arbitre) {
            res += "<p>Arbitra: Si</p>";
        } else {
            res += "<p>Arbitra: No</p>";
        }
        res += "</div>";
        return res;
    }
}
