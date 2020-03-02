package dptec.controller;

import java.util.List;
import dptec.model.CestaProdModel;
import dptec.dao.CestaProdutoDao;
import java.util.ArrayList;

public class CestaProdController {

    private int cdmatricula;
    private int cddependente;
    private int cdprod;
    private String op;
    private int cduser;
    private String tp;

    public CestaProdController(int cdmatricula, int cddepentente, int cdprod, String op, int cduser, String tp) {
        this.cdmatricula = cdmatricula;
        this.cddependente = cddepentente;
        this.cdprod = cdprod;
        this.op = op;
        this.cduser = cduser;
        this.tp = tp;
    }

    public List<CestaProdModel> groupProduto() {
        CestaProdModel cpm = new CestaProdModel();
        if (tp.equals("F")) {
            cpm.setCdmatricula(cdmatricula);
        } else if (tp.equals("D")) {
            cpm.setCddependente(cddependente);
        }
        CestaProdutoDao cpd = new CestaProdutoDao();
        if (tp.equals("F")) {
            List<CestaProdModel> listCestaFunc = new ArrayList<CestaProdModel>();
            listCestaFunc = cpd.listCestaProdFunc(cpm);
            return listCestaFunc;
        } else if (tp.equals("D")) {
            List<CestaProdModel> listCestaDep = new ArrayList<CestaProdModel>();
            listCestaDep = cpd.listCestaProdDep(cpm);
            return listCestaDep;
        } else {
            return null;
        }
    }

    public String dmlProd() {
        CestaProdModel cpm = new CestaProdModel();
        cpm.setCdproduto(cdprod);
        cpm.setCdmatricula(cdmatricula);
        cpm.setOp(op);
        cpm.setTp(tp);
        cpm.setCduser(cduser);
        cpm.setCddependente(cddependente);
        CestaProdutoDao cpd = new CestaProdutoDao();
        String msg = cpd.dmlProdCestaProd(cpm);
        return msg;
    }
}
