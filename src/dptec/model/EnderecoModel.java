/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dptec.model;

public class EnderecoModel {
    
    private String nocep;   
    private String nlogradouro;
    private String nbairro;
    private String ncidade;
    private String sguf;
    private String nmpais;
    private int icativo;

    public String getNocep() {
        return nocep;
    }

    public void setNocep(String nocep) {
        this.nocep = nocep;
    }

    public String getNlogradouro() {
        return nlogradouro;
    }

    public void setNlogradouro(String nlogradouro) {
        this.nlogradouro = nlogradouro;
    }

    public String getNbairro() {
        return nbairro;
    }

    public void setNbairro(String nbairro) {
        this.nbairro = nbairro;
    }

    public String getNcidade() {
        return ncidade;
    }

    public void setNcidade(String ncidade) {
        this.ncidade = ncidade;
    }

    public String getSguf() {
        return sguf;
    }

    public void setSguf(String sguf) {
        this.sguf = sguf;
    }

    public String getNmpais() {
        return nmpais;
    }

    public void setNmpais(String nmpais) {
        this.nmpais = nmpais;
    }

    public int getIcativo() {
        return icativo;
    }

    public void setIcativo(int icativo) {
        this.icativo = icativo;
    }

  
}