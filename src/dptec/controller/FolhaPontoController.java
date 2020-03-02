package dptec.controller;

import Metodos.ValidaMes;
import dptec.dao.FolhaPontoDao;
import dptec.model.FolhaPontoModel;
import dptec.view.FolhaPontoView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FolhaPontoController {

    private String mes;
    private int ano;
    private int cdmatricula;
    private String status;
    private int cdponto;

    public FolhaPontoController(String mes, int ano, int cdmatricula, String status, int cdponto) {
        this.mes = mes;
        this.ano = ano;
        this.cdmatricula = cdmatricula;
        this.status = status;
        this.cdponto = cdponto;
    }

    public String MarcaPonto() {
        String msg = null;
        FolhaPontoView fp = new FolhaPontoView();
        FolhaPontoModel fpm = new FolhaPontoModel();

        fpm.setCdmatricula(cdmatricula);

        FolhaPontoDao fpd = new FolhaPontoDao();
        msg = fpd.GeraPonto(fpm);
        return msg;
    }

    public List<FolhaPontoModel> getListPonto() {
        int nmes = 0;

        ValidaMes vm = new ValidaMes();
        nmes = vm.MesString(mes);

        FolhaPontoModel fpm = new FolhaPontoModel();
        fpm.setCdmatricula(cdmatricula);
        fpm.setMes(String.valueOf(nmes));
        fpm.setAno(ano);
        fpm.setDsstatus(status);
        FolhaPontoDao fpd = new FolhaPontoDao();
        List<FolhaPontoModel> listaPonto = new ArrayList<FolhaPontoModel>();
        listaPonto = fpd.getListaPonto(fpm);
        if (listaPonto.size() > 0) {
            return listaPonto;
        } else {
            return null;
        }
    }

    public List<FolhaPontoModel> getRelatorioPonto() {
        FolhaPontoModel fpm = new FolhaPontoModel();
        fpm.setMes(mes);
        fpm.setAno(ano);
        fpm.setCdmatricula(cdmatricula);
        FolhaPontoDao fpd = new FolhaPontoDao();
        List<FolhaPontoModel> listaPonto = new ArrayList<FolhaPontoModel>();
        listaPonto = fpd.listRelatorioPonto(fpm);
        if (listaPonto.size() > 0) {
            return listaPonto;
        } else {
            return null;
        }
    }

    public String getFechaPontoLote() {
        String msg = null;
        FolhaPontoModel fpm = new FolhaPontoModel();
        fpm.setMes(mes);
        fpm.setAno(ano);
        fpm.setCdponto(cdponto);
        fpm.setCdmatricula(cdmatricula);
        fpm.setOperacao("F");
        FolhaPontoDao fpd = new FolhaPontoDao();
        msg = fpd.fechaPonto(fpm);
        if (msg != null) {
            return msg;
        } else {
            return null;
        }
    }

    public int quantPonto() {
        int nmes = 0, quant;
        ValidaMes vm = new ValidaMes();
        nmes = vm.MesString(mes);

        FolhaPontoModel fpm = new FolhaPontoModel();
        fpm.setMes(String.valueOf(nmes));
        fpm.setAno(ano);
        fpm.setDsstatus(status);
        FolhaPontoDao fpd = new FolhaPontoDao();
        quant = fpd.getQuantPonto(fpm);
        if (quant > 0) {
            return quant;
        } else {
            return 0;
        }
    }

}
