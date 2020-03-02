package dptec.controller;

import dptec.model.DependenteModel;
import dptec.dao.DependenteDao;
import dptec.dao.StatusDao;
import dptec.model.StatusModel;
import java.util.ArrayList;
import java.util.List;

public class DependenteController {

    String matricula;
    String nomedep;
    String parentesco;
    String sexo;
    String nacionaliade;
    String dtnascimento;
    String ncespecial;
    String nomemae;
    String cpfdep;
    String rg;
    String orgexp;
    String dtexprg;
    String status;
    int cduser;
    String op;

    public DependenteController(String matricula, String nomedep, String parentesco, String sexo, String nacionaliade, String dtnascimento, String ncespecial, String nomemae, String cpfdep, String rg, String orgexp, String dtexprg, String status, int cduser, String op) {
        this.matricula = matricula;
        this.nomedep = nomedep;
        this.parentesco = parentesco;
        this.sexo = sexo;
        this.nacionaliade = nacionaliade;
        this.dtnascimento = dtnascimento;
        this.ncespecial = ncespecial;
        this.nomemae = nomemae;
        this.cpfdep = cpfdep;
        this.rg = rg;
        this.orgexp = orgexp;
        this.dtexprg = dtexprg;
        this.status = status;
        this.cduser = cduser;
        this.op = op;
    }

    public String incluiNovoDependente() {

        DependenteModel dm = new DependenteModel();
        String msg = null;

        if ("".equals(matricula)) {
            msg = "Falha ao Importar Matricula";
            return msg;
        }
        dm.setMatricula(Integer.parseInt(matricula.trim()));

        if ("".equals(nomedep)) {
            msg = "O Nome é um campo obrigatório";
            return msg;
        }
        dm.setNomeDep(nomedep.trim());

        if ("Selecionar".equals(parentesco)) {
            msg = "Selecione o grau de Parentesco";
            return msg;
        }
        dm.setParentesco(parentesco);

        if ("Selecionar".equals(sexo)) {
            msg = "Selecione o Sexo";
            return msg;
        }
        dm.setSexo(sexo);

        if ("".equals(nacionaliade)) {
            msg = "Informe a Nacionalidade";
            return msg;
        }
        dm.setNacionalidade(nacionaliade.trim());

        if ("-  -".equals(dtnascimento)) {
            msg = "Informe a Data de Nascimento";
            return msg;
        }
        dm.setDtNascimento(dtnascimento.replace("/", "-").trim());

        if ("Selecionar".equals(ncespecial)) {
            msg = "Informe se Dependente possui Necessidades Especiais";
            return msg;
        }
        dm.setNcEspecial(ncespecial);

        if ("".equals(nomemae)) {
            msg = "Informe o Nome da Mãe do Dependente";
            return msg;
        }
        dm.setNmMae(nomemae.trim());

        if (".   .   -".equals(cpfdep)) {
            msg = "O CPF é um dado Obrigatório";
            return msg;
        }
        dm.setCpfDep(cpfdep.replace(".", "").replace("-", "").trim());

        if ("".equals(rg)) {
            msg = "O RG é um dado Obrigatório";
            return msg;
        }
        dm.setRg(rg.replace(".", "").replace("-", "").trim());

        if ("Selecionar".equals(orgexp)) {
            msg = "Selecione o Orgão Expeditor";
            return msg;
        }
        dm.setOrgExp(orgexp);

        if ("-  -".equals(dtexprg)) {
            msg = "Informe a Data de Expedição";
            return msg;
        }
        dm.setDtExp(dtexprg.replace("/", "-").trim());

        if (!"Selecionar".equals(status)) {
            StatusModel sm = new StatusModel();
            sm.setDsStatus(status);

            StatusDao sd = new StatusDao();
            List<StatusModel> listaDeStatus = new ArrayList<StatusModel>();
            listaDeStatus = sd.getListaStatus(sm);

            if (listaDeStatus.size() > 0) {
                for (StatusModel sLocal : listaDeStatus) {
                    dm.setStatus(sLocal.getCdStatus());
                }
            } else {
                msg = "Falha na importação do Status";
                return msg;
            }
        } else {
            msg = "Informe o Status do Dependente";
            return msg;
        }

        if ("".equals(cduser)) {
            msg = "Falha ao Importar Usuario";
            return msg;
        }
        dm.setCduser(cduser);

        if ("".equals(op)) {
            msg = "Falha ao Importar Operação";
            return msg;
        }
        dm.setOp(op);

        DependenteDao dd = new DependenteDao();
        List<DependenteModel> listaDeDependente = new ArrayList<DependenteModel>();
        listaDeDependente = dd.getListaDependenteNovo(dm);

        if (listaDeDependente.size() < 1) {
            if (op.equals("I")) {
                msg = dd.InsertDependente(dm);
            }
        } else if (op.equals("U")) {
            msg = dd.InsertDependente(dm);
        } else {
            msg = "Dependente Ja Cadastrado";
        }

        return msg;
    }

    public List<DependenteModel> listaDependente() {
        DependenteModel dm = new DependenteModel();
        dm.setMatricula(Integer.parseInt(matricula));
        DependenteDao dd = new DependenteDao();
        List<DependenteModel> groupDep = new ArrayList<DependenteModel>();
        groupDep = dd.getListaDependente(dm);
        if (groupDep.size() > 0) {
            return groupDep;
        } else {
            return null;
        }
    }

    public List<DependenteModel> loadDependente() {
        DependenteModel dm = new DependenteModel();
        dm.setMatricula(Integer.parseInt(matricula.trim()));
        dm.setCpfDep(cpfdep.replace(".", "").replace("-", "").trim());
        DependenteDao dd = new DependenteDao();
        List<DependenteModel> groupDep = new ArrayList<DependenteModel>();
        groupDep = dd.getListaDependenteNovo(dm);
        if (groupDep.size() > 0) {
            return groupDep;
        } else {
            return null;
        }
    }
}
