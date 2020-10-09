/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.bean;

/**
 *
 * @author Hideki
 */
public class Endereco {

    private int id;
    private String cep;
    private int numero;
    private String complemento;

    public Endereco(int id) {
        this.id = id;
    }

    public Endereco(String cep) {
        this.cep = cep;
    }

    public Endereco(int id, String cep, int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", cep=" + cep + ", numero=" + numero + ", complemento=" + complemento + '}';
    }

}
