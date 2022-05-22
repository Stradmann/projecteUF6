
package mainPackage;


public class PersonatgeEntity extends ORMEntity{
    
    //Atributs
    private int id;
    private int jugatPer;
    private String nom;
    private Raza raza;
    private Classe classe;
    
    private int forsa;
    private int destresa;
    private int constitucio;
    private int inteligencia;
    private int sabiduria;
    private int carisma;
    
    private int pg;
    
    private BDConnection c;
    
    public PersonatgeEntity(int jugatPer, String nom, String raza, String classe, 
            int forsa, int destresa, int constitucio, int inteligencia, int sabiduria, int carisma, int pg){
        
        this.jugatPer = jugatPer;
        this.nom = nom;
        switch(raza){
            case "Huma":
                this.raza= Raza.HUMANO;
                break;
            case "Elf":
                this.raza= Raza.ELFO;
                break;
            case "Mitja":
                this.raza= Raza.MEDIANO;
                break;
            case "Nan":
                this.raza= Raza.ENANO;
                break;
            case "Gnomo":
                this.raza= Raza.GNOMO;
                break;
        }

        switch(classe){
            case "Guerrer":
                this.classe= Classe.GUERRERO;
                break;
            case "Mag":
                this.classe= Classe.MAGO;
                break;
            case "Murri":
                this.classe= Classe.PICARO;
                break;
        }
        
        this.forsa = forsa;
        this.destresa = destresa;
        this.constitucio = constitucio;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
        
        this.pg = pg;
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
     * @return the jugatPer
     */
    public int getJugatPer() {
        return jugatPer;
    }

    /**
     * @param jugatPer the jugatPer to set
     */
    public void setJugatPer(int jugatPer) {
        this.jugatPer = jugatPer;
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
     * @return the raza
     */
    public Raza getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    /**
     * @return the classe
     */
    public Classe getClasse() {
        return classe;
    }

    /**
     * @param classe the classe to set
     */
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**
     * @return the forsa
     */
    public int getForsa() {
        return forsa;
    }

    /**
     * @param forsa the forsa to set
     */
    public void setForsa(int forsa) {
        this.forsa = forsa;
    }

    /**
     * @return the destresa
     */
    public int getDestresa() {
        return destresa;
    }

    /**
     * @param destresa the destresa to set
     */
    public void setDestresa(int destresa) {
        this.destresa = destresa;
    }

    /**
     * @return the constitucio
     */
    public int getConstitucio() {
        return constitucio;
    }

    /**
     * @param constitucio the constitucio to set
     */
    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    /**
     * @return the inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * @param inteligencia the inteligencia to set
     */
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * @return the sabiduria
     */
    public int getSabiduria() {
        return sabiduria;
    }

    /**
     * @param sabiduria the sabiduria to set
     */
    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    /**
     * @return the carisma
     */
    public int getCarisma() {
        return carisma;
    }

    /**
     * @param carisma the carisma to set
     */
    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    /**
     * @return the pg
     */
    public int getPg() {
        return pg;
    }

    /**
     * @param pg the pg to set
     */
    public void setPg(int pg) {
        this.pg = pg;
    }

    /**
     * @param c the c to set
     */
    public void setC(BDConnection c) {
        this.c = c;
    }
}
