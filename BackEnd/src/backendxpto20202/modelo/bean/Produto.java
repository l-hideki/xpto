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
public class Produto {

    private int id;
    private String cod;
    private String nome;
    private int valor;
    private int quant;

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id, int quant) {
        this.id = id;
        this.quant = quant;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(int id, String cod, String nome, int valor, int quant) {
        this.id = id;
        this.cod = cod;
        this.nome = nome;
        this.valor = valor;
        this.quant = quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Produtos{" + "id=" + id + ", cod=" + cod + ", nome=" + nome + ", valor=" + valor + ", quant=" + quant + '}';
    }
}
