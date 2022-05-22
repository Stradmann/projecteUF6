
package mainPackage;

public enum Raza{
    
    HUMANO("Huma"),
    ELFO ("Elf"),
    MEDIANO ("Mitja"),
    ENANO ("Nan"),
    GNOMO ("Gnomo");
    
    String desc;
    
    Raza(String desc){
        this.desc = desc;
    }   
}

