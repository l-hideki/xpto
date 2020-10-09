/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendxpto20202.modelo.bean;

/**
 *
 * @author ProfAlexandre
 */
public class UsuarioPessoa {

    private int id;
    private int idU;
    private int idP;
    private String obs;
    private Usuario usu;
    private Pessoa pes;

    public UsuarioPessoa(int id) {
        this.id = id;
    }

    public UsuarioPessoa(String obs) {
        this.obs = obs;
    }

    public UsuarioPessoa(int id, int idU, int idP, String obs) {
        this.id = id;
        this.idU = idU;
        this.idP = idP;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "UsuarioPessoa{" + "id="
                + id + ", idU="
                + idU + ", idP="
                + idP + ", obs="
                + obs + ", usu="
                + usu.getLogin() + ", pes="
                + pes.getNome() + "}";

    }
}
