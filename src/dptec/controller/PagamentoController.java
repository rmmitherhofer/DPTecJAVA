package dptec.controller;

import dptec.dao.PagamentoDao;
import dptec.model.PagamentoModel;
import dptec.model.DetalPagamentoModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PagamentoController {
    private int cdmatricula;
    private int ano;
    private String mes;
    
    public PagamentoController (int cdmatricula, int ano, String mes){
        this.cdmatricula = cdmatricula;
        this.ano = ano;
        this.mes = mes;              
    }
    
    public List<PagamentoModel> getlistaPagamento(int cdmatricula, int ano, String mes, String categ){        
        int nmes = 0; 
        switch (mes){
            case "janeiro":
                nmes = 1;
                break;
            case "Fevereiro":
                nmes = 2;
                break;
            case "Março":
                nmes = 3;
                break;
            case "Abril":
                nmes = 4;
                break;
            case "Maio":
                nmes = 5;
                break;
            case "Junho":
                nmes = 6;
                break;
            case "Julho":
                nmes = 7;
                break;
            case "Agosto":
                nmes = 8;
                break;
            case "Setembro":
                nmes = 9;
                break;
            case "Outubro":
                nmes = 10;
                break;
            case "Novembro":
                nmes = 11;
                break;
            case "Dezembro":
                nmes = 12;
                break;           
            }
        if (categ == null){
            PagamentoModel pm = new PagamentoModel();
            pm.setCdmatricula(cdmatricula);
            pm.setAno(ano);
            pm.setMes(nmes);
            PagamentoDao pd = new PagamentoDao();
            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            listaPagamento = pd.getListaPagamento(pm);
            if (listaPagamento.size() > 0 ){
                return listaPagamento;
            }else{
                return null;
            }
        }else{
            PagamentoModel pm = new PagamentoModel();
            pm.setCdmatricula(cdmatricula);
            pm.setAno(ano);
            pm.setMes(nmes);
            pm.setDscategoria(categ);
            PagamentoDao pd = new PagamentoDao();
            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            listaPagamento = pd.getListaPagamento(pm);
            if (listaPagamento.size() > 0 ){
                return listaPagamento;
            }else{
                return null;
            }
        }
    }
    
    public List<DetalPagamentoModel> getDetalPagamento(int cdpagamento, int ano, String mes){        
        int nmes = 0; 
        String msg = null;
        switch (mes){
            case "janeiro":
                nmes = 1;
                break;
            case "Fevereiro":
                nmes = 2;
                break;
            case "Março":
                nmes = 3;
                break;
            case "Abril":
                nmes = 4;
                break;
            case "Maio":
                nmes = 5;
                break;
            case "Junho":
                nmes = 6;
                break;
            case "Julho":
                nmes = 7;
                break;
            case "Agosto":
                nmes = 8;
                break;
            case "Setembro":
                nmes = 9;
                break;
            case "Outubro":
                nmes = 10;
                break;
            case "Novembro":
                nmes = 11;
                break;
            case "Dezembro":
                nmes = 12;
                break;           
            }
        DetalPagamentoModel dpm = new DetalPagamentoModel();
        dpm.setCdpagamento(cdpagamento);
        dpm.setAno(ano);
        dpm.setMes(nmes);
        PagamentoDao pd = new PagamentoDao();
        List<DetalPagamentoModel> listaDPagamento = new ArrayList<DetalPagamentoModel>();
        listaDPagamento = pd.getDetalPagamento(dpm);
        if (listaDPagamento.size() > 0 ){
            return listaDPagamento;
        }else{
            return null;
        }
    }
}
