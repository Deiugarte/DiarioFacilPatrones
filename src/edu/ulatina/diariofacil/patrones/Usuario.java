package edu.ulatina.diariofacil.patrones;

public abstract class Usuario {
    private IComportamiento comportamiento;
    private String username;

    public Usuario(String username, IComportamiento comportamiento) {
        this.username = username;
        this.comportamiento = comportamiento;
    }
    
    public IComportamiento getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(IComportamiento comportamiento) {
        this.comportamiento = comportamiento;
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
