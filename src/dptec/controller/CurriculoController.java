package dptec.controller;

import dptec.dao.CategoriaDao;
import dptec.dao.CurriculoDao;
import dptec.dao.StatusDao;
import dptec.model.CategoriaModel;
import dptec.model.CurriculoModel;
import dptec.model.StatusModel;
import java.util.ArrayList;
import java.util.List;

public class CurriculoController {

    private int cdcurricular;
    private int cdmatricula;
    private String dscategoria;
    private String nmlocal;
    private String dscurricular;
    private String dtinicio;
    private String dtconclusao;
    private String dsstatus;
    private String op;
    private int cduser;

    public CurriculoController(int cdcurricular, int cdmatricula, String dscategoria, String nmlocal, String dscurricular, String dtinicio, String dtconclusao, String dsstatus, String op, int cduser) {
        this.cdcurricular = cdcurricular;
        this.cdmatricula = cdmatricula;
        this.dscategoria = dscategoria;
        this.dscurricular = dscurricular;
        this.dsstatus = dsstatus;
        this.dtconclusao = dtconclusao;
        this.dtinicio = dtinicio;
        this.nmlocal = nmlocal;
        this.op = op;
        this.cduser = cduser;
    }

    public String dmlCurriculo() {
        String msg = null;
        CurriculoModel cm = new CurriculoModel();
        if ("".equals(cduser)) {
            msg = "Falha ao Carregar Usuario";
            return msg;
        }
        cm.setCduser(cduser);

        if (!"I".equals(op) && !"U".equals(op) && !"D".equals(op) && !"B".equals(op)) {
            msg = "Falha na Operação";
            return msg;
        }
        cm.setOp(op);

        //Importar Código da Categoria
        if (!"Selecionar".equals(dscategoria)) {
            CategoriaModel catm = new CategoriaModel();
            catm.setDscategoria(dscategoria);
            CategoriaDao cd = new CategoriaDao();
            List<CategoriaModel> listCat = new ArrayList<CategoriaModel>();
            listCat = cd.getListCategoria(catm);
            if (listCat.size() > 0) {
                for (CategoriaModel lc : listCat) {
                    cm.setCdcategoria(lc.getCdcategoria());
                }
            } else {
                msg = "Falha na importação da Categoria";
                return msg;
            }
        } else {
            msg = "Selecione a Categoria";
            return msg;
        }

        //Importar o código do Status
        if (!"Selecionar".equals(dsstatus)) {
            StatusModel sm = new StatusModel();
            sm.setDsStatus(dsstatus);
            StatusDao sd = new StatusDao();
            List<StatusModel> listStatus = new ArrayList<StatusModel>();
            listStatus = sd.getListaStatus(sm);
            if (listStatus.size() > 0) {
                for (StatusModel ls : listStatus) {
                    cm.setCdstatus(ls.getCdStatus());
                }
            } else {
                msg = "Falha na importação do Status";
                return msg;
            }
        } else {
            msg = "Selecione o Status";
            return msg;
        }

        if ("".equals(cdmatricula)) {
            msg = "Falha ao carregar a Matricula do Funcionario, Entre em contato com Sistemas";
            return msg;
        }
        cm.setCdmatricula(cdmatricula);
        if ("".equals(nmlocal)) {
            msg = "Informe a Instituição";
            return msg;
        }
        cm.setNmlocal(nmlocal);

        if ("".equals(dscurricular)) {
            msg = "Informe a Descrição Curricular";
            return msg;
        }
        cm.setDscurricular(dscurricular);

        if ("-  -".equals(dtinicio)) {
            msg = "Informe a Data de Inicio";
            return msg;
        }
        cm.setDtinicio(dtinicio.replace("/", "-"));

        if ("Concluido".equals(dsstatus) && "-  -".equals(dtconclusao)) {
            msg = "Informe a Data de conclusão";
            return msg;
        } else if (!"-  -".equals(dtconclusao) && !"Concluido".equals(dsstatus)) {
            msg = "ATENÇÂO! não é possivel Cadastrar dado Curricular com data de Conclusão e o Status diferente de Concluido";
            return msg;
        } else if ("-  -".equals(dtconclusao)) {
            cm.setDtconclusao(null);
        } else {
            cm.setDtconclusao(dtconclusao.replace("/", "-"));
        }
        //só é usado para alterações ou exclusão
        cm.setCdcurricular(cdcurricular);
        CurriculoDao cd = new CurriculoDao();
        msg = cd.dmlCurriculo(cm);
        return msg;
    }

    public List<CurriculoModel> listCurriculo() {
        CurriculoModel cm = new CurriculoModel();
        cm.setCdmatricula(cdmatricula);
        List<CurriculoModel> groupCur = new ArrayList<CurriculoModel>();
        CurriculoDao cd = new CurriculoDao();
        groupCur = cd.getListCurriculoEscolar(cm);
        return groupCur;
    }
}
