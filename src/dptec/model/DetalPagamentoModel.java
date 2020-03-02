
package dptec.model;

public class DetalPagamentoModel {
   private int cdproduto;
   private String dsproduto;
   private float quantidade;
   private float vlvencimento;
   private float vldesconto;
   private int cdpagamento;
   private int mes;
   private int ano;

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCdpagamento() {
        return cdpagamento;
    }

    public void setCdpagamento(int cdpagamento) {
        this.cdpagamento = cdpagamento;
    }
   
   
    public int getCdproduto() {
        return cdproduto;
    }

    public void setCdproduto(int cdproduto) {
        this.cdproduto = cdproduto;
    }

    public String getDsproduto() {
        return dsproduto;
    }

    public void setDsproduto(String dsproduto) {
        this.dsproduto = dsproduto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getVlvencimento() {
        return vlvencimento;
    }

    public void setVlvencimento(float vlvencimento) {
        this.vlvencimento = vlvencimento;
    }

    public float getVldesconto() {
        return vldesconto;
    }

    public void setVldesconto(float vldesconto) {
        this.vldesconto = vldesconto;
    }
}
