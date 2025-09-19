
package model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String username;
    private String senha;
  
    public Usuario(){
    }
    
    public Usuario(Integer id, String username, String senha){
        this.id = id;
        this.username = username;
        this.senha = senha;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    } 
}
