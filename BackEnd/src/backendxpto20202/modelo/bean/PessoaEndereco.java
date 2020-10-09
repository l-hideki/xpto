/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.bean;

/**
 *
 * @author Hideki
 * 
 */



public class PessoaEndereco {

    private int id;
    private int idE;
    private int idP;
    private String obs;
    private Endereco end;
    private Pessoa pes;

    public PessoaEndereco(int id) {
        this.id = id;
    }

    public PessoaEndereco(String obs) {
        this.obs = obs;
    }

    
    public PessoaEndereco(int id, int idE, int idP, String obs) {
        this.id = id;
        this.idE = idE;
        this.idP = idP;
        this.obs = obs;
    }

    public PessoaEndereco(int id, int idE, int idP, String obs, Endereco end, Pessoa pes) {
        this.id = id;
        this.idE = idE;
        this.idP = idP;
        this.obs = obs;
        this.end = end;
        this.pes = pes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }

    public int getId() {
        return id;
    }

    public int getIdE() {
        return idE;
    }

    public int getIdP() {
        return idP;
    }

    public String getObs() {
        return obs;
    }

    public Endereco getEnd() {
        return end;
    }

    public Pessoa getPes() {
        return pes;
    }

}
