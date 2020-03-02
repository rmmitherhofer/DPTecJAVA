package dptec.controller;

import dptec.dao.CategoriaDao;
import dptec.dao.ProdutoDao;
import dptec.model.CategoriaModel;
import dptec.model.ProdutoModel;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private int cdproduto;
    private String dsproduto;
    private String dsstatus;
    private String dscategoria;
    private float vlproduto;
    private float pcproduto;
    private int cduser;
    private String op;

    public ProdutoController(int cdproduto, String dsproduto, String dsstatus, String dscategoria, float vlproduto, float pcproduto, int cduser, String op) {
        this.cdproduto = cdproduto;
        this.dsstatus = dsstatus;
        this.dsproduto = dsproduto;
        this.dscategoria = dscategoria;
        this.vlproduto = vlproduto;
        this.pcproduto = pcproduto;
        this.cduser = cduser;
        this.op = op;
    }

    public List<ProdutoModel> listProduto() {
        ProdutoModel pm = new ProdutoModel();
        pm.setCdproduto(cdproduto);
        pm.setDsproduto(dsproduto);
        pm.setDscategoria(dscategoria);
        if (dsstatus.equals("Ativo")) {
            pm.setIcativo(1);
        } else {
            pm.setIcativo(0);
        }
        List<ProdutoModel> gProd = new ArrayList<ProdutoModel>();
        ProdutoDao pd = new ProdutoDao();
        gProd = pd.listProduto(pm);
        return gProd;
    }

    public String dmlProduto() {
        String msg = null;
        ProdutoModel pm = new ProdutoModel();
        pm.setCdproduto(cdproduto);
        pm.setDsproduto(dsproduto);
        if (!"Selecionar".equals(dscategoria)){
            CategoriaModel cm = new CategoriaModel();
            cm.setDscategoria(dscategoria);
            CategoriaDao cd = new CategoriaDao();
            List<CategoriaModel> listCategoria = new ArrayList<CategoriaModel>();
            listCategoria = cd.getListCategoria(cm);
            if (listCategoria.size() > 0){
            for (CategoriaModel gCat : listCategoria){
                pm.setCdcategoria(gCat.getCdcategoria());
            }
            }else{
                msg = "Falha ao Importar Codigo da Categoria";
                return msg;
            }
        }else{
            msg = "Selecione a Categoria";
            return msg;
        }
        
        if (dsstatus.equals("Ativo")) {
            pm.setIcativo(1);
        } else {
            pm.setIcativo(0);
        }
        pm.setVlproduto(vlproduto);
        pm.setPcproduto(pcproduto / 100);
        pm.setOp(op);
        pm.setCduser(cduser);
        ProdutoDao pd = new ProdutoDao();
        msg = pd.dmlProduto(pm);
        return msg;
    }

}
