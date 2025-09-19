
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Despesa implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private Double preco;
    private String status;
    private LocalDate dataVencimento;
    
    public Despesa(){
    }
    
    public Despesa(Integer id, String nome, Double preco, String status, LocalDate dataVencimento){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.dataVencimento = dataVencimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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
        final Despesa other = (Despesa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Despesas: " + "id = " + id + ", nome = " + nome + ", valor = " + preco + ", status = " + status + ", data de vencimento = " + dataVencimento + '}';
    }

    
}
