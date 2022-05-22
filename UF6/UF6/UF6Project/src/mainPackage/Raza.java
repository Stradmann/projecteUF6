
package mainPackage;

public enum Raza{
    
    HUMANO("Huma"),
    ELFO ("Elf"),
    MEDIANO ("Mitja"),
    ENANO ("Nan"),
    GNOMO ("Gnomo");
    
    public String desc;
    
    Raza(String desc){
        this.desc = desc;
    }   
}

