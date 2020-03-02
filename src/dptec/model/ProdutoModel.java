
package dptec.model;

public class ProdutoModel {
    private int cdproduto;
    private String dsproduto;
    private float vlproduto;
    private float pcproduto;
    private int cdcategoria;
    private int icativo;
    private String dscategoria;
    private int cduser;
    private String op;

    public int getCduser() {
        return cduser;
    }

    public void setCduser(int cduser) {
        this.cduser = cduser;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getDscategoria() {
        return dscategoria;
    }

    public void setDscategoria(String dscategoria) {
        this.dscategoria = dscategoria;
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

    public float getVlproduto() {
        return vlproduto;
    }

    public void setVlproduto(float vlproduto) {
        this.vlproduto = vlproduto;
    }

    public float getPcproduto() {
        return pcproduto;
    }

    public void setPcproduto(float pcproduto) {
        this.pcproduto = pcproduto;
    }

    public int getCdcategoria() {
        return cdcategoria;
    }

    public void setCdcategoria(int cdcategoria) {
        this.cdcategoria = cdcategoria;
    }

    public int getIcativo() {
        return icativo;
    }

    public void setIcativo(int icativo) {
        this.icativo = icativo;
    }
    
}
