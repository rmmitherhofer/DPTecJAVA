package dptec.controller;

import Metodos.ValidaMes;
import dptec.dao.PagamentoDao;
import dptec.model.PagamentoModel;
import java.util.List;
import java.util.ArrayList;

public class FolhaPagamentoController {

    private String mes;
    private int ano;
    private int cdmatricula;
    private String status;
    private int cdpagamento;

    public FolhaPagamentoController(String mes, int ano, int cdmatricula, String status, int cdpagamento) {
        this.ano = ano;
        this.mes = mes;
        this.cdmatricula = cdmatricula;
        this.status = status;
        this.cdpagamento = cdpagamento;
    }

    public List<PagamentoModel> listaPagamento() {
        int nmes = 0;
        ValidaMes vm = new ValidaMes();
        nmes = vm.MesString(mes);

        PagamentoModel pm = new PagamentoModel();
        pm.setCdmatricula(cdmatricula);
        pm.setMes(nmes);
        pm.setAno(ano);
        pm.setDsstatus(status);
        PagamentoDao pd = new PagamentoDao();
        List<PagamentoModel> listaPagamentos = new ArrayList<PagamentoModel>();
        listaPagamentos = pd.getListaFechamentoFolha(pm);
        if (listaPagamentos.size() > 0) {
            return listaPagamentos;
        } else {
            return null;
        }
    }

    public String getFechaFolha() {
        String msg = null;
        PagamentoModel pm = new PagamentoModel();
        pm.setCdmatricula(cdmatricula);
        PagamentoDao pd = new PagamentoDao();
        msg = pd.fechaFolha(pm);
        if (msg != null) {
            return msg;
        } else {
            return null;
        }
    }

    public int quantPag() {
        int nmes = 0, quant;
        ValidaMes vm = new ValidaMes();
        nmes = vm.MesString(mes);

        PagamentoModel pm = new PagamentoModel();
        pm.setMes(nmes);
        pm.setAno(ano);
        pm.setDsstatus(status);
        PagamentoDao pd = new PagamentoDao();
        quant = pd.getQuantPagamento(pm);
        return quant;
    }
}
