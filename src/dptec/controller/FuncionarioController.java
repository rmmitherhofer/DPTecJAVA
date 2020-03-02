package dptec.controller;

import dptec.dao.BancoDao;
import dptec.view.CadFuncionarioView;
import dptec.view.MasterView;
import java.util.ArrayList;
import java.util.List;

import dptec.model.FuncionarioModel;
import dptec.model.EstadoCivilModel;
import dptec.model.CargoModel;
import dptec.model.DepartamentoModel;
import dptec.model.StatusModel;
import dptec.model.EnderecoModel;
import dptec.model.FinancasModel;
//import dptec.dao.BancoDadosDao;
import dptec.dao.CargoDao;
import dptec.dao.EstadoCivilDao;
import dptec.dao.StatusDao;
import dptec.dao.DepartamentoDao;
import dptec.dao.EnderecoDao;
import dptec.dao.FinancasDao;
//import dptec.dao.FuncionarioDao2;
import dptec.dao.FuncionarioDao3;
import dptec.model.BancoModel;
import dptec.model.EmpresaModel;
import dptec.model.UsuarioModel;
import dptec.dao.EmpresaDao;
import java.util.Date;
import javax.swing.JOptionPane;

public class FuncionarioController {

    String cdmatricula;
    String nmfuncionario;
    String notelefone;
    String notelcelular;
    String notelcomercial;
    String noramal;
    String dsemail;
    String dsemailcom;
    String nmpai;
    String nmmae;
    String dsnacionalidade;
    String dsnaturalidade;
    String dtnascimento;
    String dssexo;
    String dsestadocivil;
    String nmconjuge;
    String dsnecespecial;
    String noctps;
    String noseriectps;
    String sgufctps;
    String dtexpctps;
    String nopis;
    String norg;
    String dsorgexprg;
    String dtexperg;
    String nocpf;
    String notiteleitor;
    String nozona;
    String nosecao;
    String noreservista;
    String norareservista;
    String sgseriereservista;
    String dtadmissao;
    String dtdesligamento;
    String dscargo;
    String dsdepartamento;
    String tpcontrato;
    String nocep;
    String noendereco;
    String nmcomplemento;
    String status;
    String op;
    int cduser;
    String tpconta;
    String nmbanco;
    String noagencia;
    String noconta;
    String nodigito;
    String statusfin;
    String vlsalario;
    String nmempresa;

    public FuncionarioController(String cdmatricula, String nmfuncionario, String notelefone, String notelcelular, String notelcomercial, String noramal, String dsemail, String dsemailcom, String nmpai, String nmmae, String dsnacionalidade, String dsnaturalidade, String dtnascimento, String dssexo, String dsestadocivil, String nmconjuge, String dsnecespecial, String noctps, String noseriectps, String sgufctps, String dtexpctps, String nopis, String norg, String dsorgexprg, String dtexperg, String nocpf, String notiteleitor, String nozona, String nosecao, String noreservista, String norareservista, String sgseriereservista, String dtadmissao, String dtdesligamento, String dscargo, String dsdepartamento, String tpcontrato, String nocep, String noendereco, String nmcomplemento, String status, String op, int cduser, String tpconta, String nmbanco, String noagencia, String noconta, String nodigito, String statusfin, String vlsalario, String nmempresa) {
        this.cdmatricula = cdmatricula;
        this.nmfuncionario = nmfuncionario;
        this.notelefone = notelefone;
        this.notelcelular = notelcelular;
        this.notelcomercial = notelcomercial;
        this.noramal = noramal;
        this.dsemail = dsemail;
        this.dsemailcom = dsemailcom;
        this.nmpai = nmpai;
        this.nmmae = nmmae;
        this.dsnacionalidade = dsnacionalidade;
        this.dsnaturalidade = dsnaturalidade;
        this.dtnascimento = dtnascimento;
        this.dssexo = dssexo;
        this.dsestadocivil = dsestadocivil;
        this.nmconjuge = nmconjuge;
        this.dsnecespecial = dsnecespecial;
        this.noctps = noctps;
        this.noseriectps = noseriectps;
        this.sgufctps = sgufctps;
        this.dtexpctps = dtexpctps;
        this.nopis = nopis;
        this.norg = norg;
        this.dsorgexprg = dsorgexprg;
        this.dtexperg = dtexperg;
        this.nocpf = nocpf;
        this.notiteleitor = notiteleitor;
        this.nozona = nozona;
        this.nosecao = nosecao;
        this.noreservista = noreservista;
        this.norareservista = norareservista;
        this.sgseriereservista = sgseriereservista;
        this.dtadmissao = dtadmissao;
        this.dtdesligamento = dtdesligamento;
        this.dscargo = dscargo;
        this.dsdepartamento = dsdepartamento;
        this.tpcontrato = tpcontrato;
        this.nocep = nocep;
        this.noendereco = noendereco;
        this.nmcomplemento = nmcomplemento;
        this.status = status;
        this.op = op;
        this.cduser = cduser;
        this.tpconta = tpconta;
        this.nmbanco = nmbanco;
        this.noagencia = noagencia;
        this.noconta = noconta;
        this.nodigito = nodigito;
        this.statusfin = statusfin;
        this.vlsalario = vlsalario;
        this.nmempresa = nmempresa;
    }

    public String incluiNovoFuncionario() {
        FuncionarioModel fm = new FuncionarioModel();
        CadFuncionarioView fv = new CadFuncionarioView();
        String msg;
        if ("".equals(cduser)) {
            msg = "falha ao Carregar Codigo do Usuario Interno";
            fv.dispose();
            return msg;
        }
        fm.setCduser(cduser);
        //Falidação do formulario Identificação
        if ("".equals(cdmatricula)) {
            msg = "Identificação: Matricula Não Informada";
            fv.txtMatricula.requestFocus();
            return msg;
        }
        fm.setCdmatricula(Integer.parseInt(cdmatricula));

        if ("".equals(nmfuncionario)) {
            msg = "Identificação: Nome da Funcionário é um Campo Obrigatório";
            fv.txtNmFunc.requestFocus();
            return msg;
        }
        fm.setNmfuncionario(nmfuncionario);

        if ("Selecionar".equals(dssexo)) {
            msg = "Identificação: Sexo é um Campo Obrigatório";
            fv.cmbSexo.requestFocus();
            return msg;
        }
        fm.setDssexo(dssexo);

        if ("-  -".equals(dtnascimento)) {
            msg = "Identificação: Data de nascimento é um Campo Obrigatório";
            fv.mskDtNasc.requestFocus();
            return msg;
        }
        fm.setDtnascimento(dtnascimento);

        if ("".equals(dsnacionalidade)) {
            msg = "Identificação: Nascionalidade é um Campo Obrigatório";
            fv.txtNascionalidade.requestFocus();
            return msg;
        }
        fm.setDsnacionalidade(dsnacionalidade);

        if ("".equals(dsnaturalidade)) {
            msg = "Identificação: Naturalidade é um Campo Obrigatório";
            fv.txtNaturalidade.requestFocus();
            return msg;
        }
        fm.setDsnaturalidade(dsnaturalidade);

        //Realizar Consulta do Estado Civil
        if (!"Selecionar".equals(dsestadocivil)) {
            EstadoCivilModel em = new EstadoCivilModel();
            em.setDsestadocivil(dsestadocivil);

            EstadoCivilDao ed = new EstadoCivilDao();
            List<EstadoCivilModel> listaEstadoCivil = new ArrayList<EstadoCivilModel>();
            listaEstadoCivil = ed.getListaECivil(em);

            if (listaEstadoCivil.size() > 0) {
                for (EstadoCivilModel esLocal : listaEstadoCivil) {
                    fm.setCdestadocivil(esLocal.getCdestadocivil());
                }
            } else {
                msg = "Falha na importação do Estado Civil";
                return msg;
            }
        } else {
            msg = "Identificação: Selecione o Estado Civil";
            return msg;
        }

        if ("".equals(nmconjuge) && ("Casado".equals(dsestadocivil) || "Concubinato".equals(dsestadocivil))) {
            msg = "Identificação: Nome do Conjuge é um Campo Obrigatório";
            fv.txtNmConjuge.requestFocus();
            return msg;
        }
        fm.setNmconjuge(nmconjuge);

        if ("".equals(nmmae)) {
            msg = "Identificação: Nome da Mãe é um Campo Obrigatório";
            fv.txtNmMae.requestFocus();
            return msg;
        }
        fm.setNmmae(nmmae);
        fm.setNmpai(nmpai);

        if ("Selecionar".equals(dsnecespecial)) {
            msg = "Identificação: Informe se Funcionario Possui necessidades especiais";
            fv.cmbNecEspecial.requestFocus();
            return msg;
        }
        fm.setDsnecespecial(dsnecespecial);

        //validação do form Documentação
        if (".   .   -".equals(nocpf)) {
            msg = "Documentação: Numero do CPF é um Campo Obrigatório";
            fv.mskCPF.requestFocus();
            return msg;
        }
        fm.setNocpf(nocpf.replace(".", "").replace("-", "").trim());

        if ("".equals(norg)) {
            msg = "Documentação: Numero do RG é um Campo Obrigatório";
            fv.txtRG.requestFocus();
            return msg;
        }
        fm.setNorg(norg.replace(".","").replace("-","").trim());

        if ("Selecionar".equals(dsorgexprg)) {
            msg = "Documentação: Selecione o Orgão Expeditor do RG";
            fv.cmbOrgExp.requestFocus();
            return msg;
        }
        fm.setDsorgexprg(dsorgexprg);

        if ("-  -".equals(dtexperg)) {
            msg = "Documentação: Informe a Data de Expedição do RG";
            fv.mskDtExpedicaoRG.requestFocus();
            return msg;
        }
        fm.setDtexperg(dtexperg);

        if ("".equals(nopis)) {
            msg = "Documentação: Numero do PIS/PASEP é um Campo Obrigatório";
            fv.txtPISPASEP.requestFocus();
            return msg;
        }
        fm.setNopis(nopis);

        if ("".equals(noreservista) && "Masculino".equals(dssexo)) {
            msg = "Documentação: Numero da Reservista é um Campo Obrigatório";
            fv.txtNReservista.requestFocus();
            return msg;
        }
        fm.setNoreservista(Integer.parseInt(noreservista));

        if ("".equals(norareservista) && "Masculino".equals(dssexo)) {
            msg = "Documentação: Numero do RA da Reservista é um Campo Obrigatório";
            fv.txtRA.requestFocus();
            return msg;
        }
        fm.setNorareservista(norareservista);

        if ("".equals(sgseriereservista) && "Masculino".equals(dssexo)) {
            msg = "Documentação: A Série da Reservista é um Campo Obrigatório";
            fv.txtSerieReservista.requestFocus();
            return msg;
        }
        fm.setSgseriereservista(sgseriereservista);

        if ("".equals(notiteleitor)) {
            msg = "Documentação: Numero do Titulo de Eleitor é um Campo Obrigatório";
            fv.txtTitEleitoral.requestFocus();
            return msg;
        }
        fm.setNotiteleitor(notiteleitor);
        if ("".equals(nozona)) {
            msg = "Documentação: Numero da Zona Eleitoral é um Campo Obrigatório";
            fv.txtZonaEleitoral.requestFocus();
            return msg;
        }
        fm.setNozona(Integer.parseInt(nozona));
        if ("".equals(nosecao)) {
            msg = "Documentação: Numero da Seção Eleitoral é um Campo Obrigatório";
            fv.txtSecaoEleitoral.requestFocus();
            return msg;
        }
        fm.setNosecao(Integer.parseInt(nosecao));

        if ("".equals(noctps)) {
            msg = "Documentação: Numero da CTPS é um Campo Obrigatório";
            fv.txtNCTPS.requestFocus();
            return msg;
        }
        fm.setNoctps(Integer.parseInt(noctps));
        if ("".equals(noseriectps)) {
            msg = "Documentação: Numero de série da CTPS é um Campo Obrigatório";
            fv.txtSerieCTPS.requestFocus();
            return msg;
        }
        fm.setNoseriectps(Integer.parseInt(noctps));
        if ("Selecionar".equals(sgufctps)) {
            msg = "Documentação: Selecione a UF da CTPS";
            fv.cmbUFCTPS.requestFocus();
            return msg;
        }
        fm.setSgufctps(sgufctps);
        if ("-  -".equals(dtexpctps)) {
            msg = "Documentação: Informe a Data de Expedição da CTPS";
            fv.mskDtExpedicao.requestFocus();
            return msg;
        }
        fm.setDtexpctps(dtexpctps);

        //Validação do Form Remuneração
        //Armazena as informaçoes dos Dados Financeiros na Model para depois incluir ou alterar no Banco
        FinancasModel finm = new FinancasModel();
        finm.setMatricula(Integer.parseInt(cdmatricula));

        if ("Selecionar".equals(tpconta)) {
            msg = "Remuneração: Selecione o Tipo da Conta Bancaria";
            return msg;
        }
        finm.setTpconta(tpconta);

        if (!"Selecionar".equals(statusfin)) {
            StatusModel sm = new StatusModel();
            sm.setDsStatus(statusfin);
            StatusDao sd = new StatusDao();
            List<StatusModel> listaDeStatus = new ArrayList<StatusModel>();
            listaDeStatus = sd.getListaStatus(sm);

            if (listaDeStatus.size() > 0) {
                for (StatusModel ls : listaDeStatus) {
                    finm.setCdstatus(ls.getCdStatus());
                }
            } else {
                msg = "Falha na importação do Status Financeiro";
                return msg;
            }
        } else {
            msg = "Remuneração: Informe o Status do Financeiro";
            return msg;
        }

        if (!"Selecionar".equals(nmbanco)) {
            BancoModel bm = new BancoModel();
            bm.setNmbanco(nmbanco);
            BancoDao bd = new BancoDao();
            List<BancoModel> listaBanco = new ArrayList<BancoModel>();
            listaBanco = bd.getListaBanco(bm);
            if (listaBanco.size() > 0) {
                for (BancoModel lb : listaBanco) {
                    finm.setCdbanco(lb.getCdbanco());
                }
            } else {
                msg = "Falha na importação do Codigo do Banco";
                return msg;
            }
        } else {
            msg = "Remuneração: Selecione o Banco onde o Colaborador possue conta";
            return msg;
        }

        if ("".equals(noagencia)) {
            msg = "Remuneração: informe o Numero da Agencia Bancária.";
            return msg;
        }
        finm.setNoagencia(noagencia);
        if ("".equals(noconta)) {
            msg = "Remuneração: informe o Numero da Conta Bancária.";
            return msg;
        }
        finm.setNoconta(noconta);
        if ("".equals(nodigito)) {
            msg = "Remuneração: informe o Digito da Conta Bancária.";
            return msg;
        }
        finm.setNodigito(Integer.parseInt(nodigito));

        if ("".equals(vlsalario)) {
            msg = "Remuneração: informe o Salario do Funcionario.";
            return msg;
        }
        finm.setVlsalario(Float.parseFloat(vlsalario.replace(",", ".").trim()));
        finm.setOp(op);
        finm.setCduser(cduser);

        //Validação do Form Dados p/ Contato
        if (!"-".equals(nocep)) {
            EnderecoModel em = new EnderecoModel();
            em.setNocep(nocep.replace(".", "").replace("-", ""));

            EnderecoDao ed = new EnderecoDao();
            List<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
            listaEndereco = ed.getListaEndereco(em);

            if (listaEndereco.size() > 0) {
                for (EnderecoModel eLocal : listaEndereco) {
                    fm.setNocep(eLocal.getNocep());
                }
            } else {
                msg = "Enereço não Cadastrado";
                return msg;
            }
        } else {
            msg = "Contato: Informe o código do CEP";
            return msg;
        }
        fm.setNoendereco(noendereco);
        fm.setNmcomplemento(nmcomplemento);

        if (!"(  )    -".equals(notelefone)) {
            fm.setNotelefone(notelefone.replace("(", "").replace(")", "").replace("-", "").trim());
        } else {
            fm.setNotelefone(null);
        }
        if (!"(  )     -".equals(notelcelular)) {
            fm.setNotelcelular(notelcelular.replace("(", "").replace(")", "").replace("-", "").trim());
        } else {
            fm.setNotelcomercial(null);
        }
        if (!"(  )    -".equals(notelcomercial)) {
            fm.setNotelcomercial(notelcomercial.replace("(", "").replace(")", "").replace("-", "").trim());
        } else {
            fm.setNotelcomercial(null);
        }
        if (!"".equals(noramal)) {
            fm.setNoramal(Integer.parseInt(noramal));
        } else {
            fm.setNoramal(0);
        }
        fm.setDsemail(dsemail);
        fm.setDsemailcom(dsemail);

        //Validação Form Dados Contratuais
        if (!"Selecionar".equals(status)) {
            StatusModel sm = new StatusModel();
            sm.setDsStatus(status);

            StatusDao sd = new StatusDao();
            List<StatusModel> listaDeStatus = new ArrayList<StatusModel>();
            listaDeStatus = sd.getListaStatus(sm);

            if (listaDeStatus.size() > 0) {
                for (StatusModel sLocal : listaDeStatus) {
                    fm.setStatus(sLocal.getCdStatus());
                }
            } else {
                msg = "Falha na importação do Status do Funcionario";
                return msg;
            }
        } else {
            msg = "Dados Contratuais: Informe o Status do Funcionário";
            return msg;
        }

        if (!"Selecionar".equals(nmempresa)) {
            EmpresaModel em = new EmpresaModel();
            em.setNmrazaosocial(nmempresa);

            EmpresaDao ed = new EmpresaDao();
            List<EmpresaModel> listaEmpresa = new ArrayList<EmpresaModel>();
            listaEmpresa = ed.getListaEmpresa(em);

            if (listaEmpresa.size() > 0) {
                for (EmpresaModel le : listaEmpresa) {
                    fm.setCdempresa(le.getCdempresa());
                }
            } else {
                msg = "Falha na importação da empresa";
                return msg;
            }
        } else {
            msg = "Dados Contratuais: Selecione a Empresa";
            return msg;
        }

        //Realizar Consulta do Cargo
        if (!"Selecionar".equals(dsdepartamento)) {
            DepartamentoModel dm = new DepartamentoModel();
            dm.setDsdepartamento(dsdepartamento);

            DepartamentoDao dd = new DepartamentoDao();
            List<DepartamentoModel> listaDepartamento = new ArrayList<DepartamentoModel>();
            listaDepartamento = dd.getListaDep(dm);

            if (listaDepartamento.size() > 0) {
                for (DepartamentoModel depLocal : listaDepartamento) {
                    fm.setCddepartamento(depLocal.getCddepartamento());
                }
            } else {
                msg = "Falha na importação do Departamento";
                return msg;
            }
        } else {
            msg = "Dados Contratuais: Selecione o Departamento";
            return msg;
        }

        if (!"Selecionar".equals(dscargo)) {
            CargoModel cm = new CargoModel();
            cm.setDscargo(dscargo);
            CargoDao cd = new CargoDao();
            List<CargoModel> listaCargo = new ArrayList<CargoModel>();
            listaCargo = cd.getListaCargo(cm);

            if (listaCargo.size() > 0) {
                for (CargoModel cargoLocal : listaCargo) {
                    fm.setCdcargo(cargoLocal.getCdcargo());
                }
            } else {
                msg = "Falha na Importaçao do Cargo";
                return msg;
            }
        } else {
            msg = "Dados Contratuais: Selecione o Cargo";
            return msg;
        }

        if ("Selecionar".equals(tpcontrato)) {
            msg = "Selecione o tipo de Contrato";
            fv.cmbTipo.requestFocus();
            return msg;
        }
        fm.setTpcontrato(tpcontrato);

        if ("-  -".equals(dtadmissao)) {
            msg = "Dados Contratuais: A Data de Admissão é um Campo Obrigatório";
            fv.mskDtAdmissao.requestFocus();
            return msg;
        }
        fm.setDtadmissao(dtadmissao);

        if (!"-  -".equals(dtdesligamento)) {
            fm.setDtdesligamento(dtdesligamento);
        }
        fm.setDtdesligamento(null);

        //Valida o tipo de Operação
        if ("".equals(op)) {
            msg = "Falha na Operação Tente Novamente";
            return msg;
        }
        fm.setOp(op);

        FuncionarioDao3 fd = new FuncionarioDao3();
        List<FuncionarioModel> listaFuncionario = new ArrayList<FuncionarioModel>();
        listaFuncionario = fd.getListaFunc(fm);

        if (listaFuncionario.size() < 1 || "U".equals(op) || "D".equals(op)) {
            msg = fd.insertFuncionario(fm);
            FinancasDao find = new FinancasDao();
            find.insertFinancas(finm);

            return msg;
        } else {
            msg = "Funcionário já Cadastrado!";
            return msg;
        }
    }

    public List<FuncionarioModel> listFunc() {
        FuncionarioModel fm = new FuncionarioModel();
        if (cdmatricula.equals("")){
            cdmatricula = "0";
        }
        fm.setCdmatricula(Integer.parseInt(cdmatricula));
        fm.setNmfuncionario(nmfuncionario.trim());
        fm.setNocpf(nocpf.replace(".","").replace("-","").trim());
        fm.setNorg(norg.replace(".","").replace("-","").trim());
        fm.setNopis(nopis.replace(".","").replace("-","").trim());
        fm.setDsdepartamento(dsdepartamento);
        fm.setDscargo(dscargo);
        fm.setDsstatus(status);
        
        FuncionarioDao3 fd = new FuncionarioDao3();
        List<FuncionarioModel> groupFunc = new ArrayList<FuncionarioModel>();
        groupFunc = fd.getListaFunc(fm);
        return groupFunc;
    }
}
