package dptec.view;

import Metodos.Config;
import Metodos.ValidaData;
import Metodos.TrataCaracteres;

import dptec.controller.FuncionarioController;
import dptec.controller.EnderecoController;
import dptec.controller.DependenteController;
import dptec.controller.CestaProdController;
import dptec.controller.CurriculoController;

import dptec.dao.BancoDao;
import dptec.dao.CargoDao;
import dptec.dao.DepartamentoDao;
import dptec.dao.DependenteDao;
import dptec.dao.EnderecoDao;
import dptec.dao.EstadoCivilDao;
import dptec.dao.FinancasDao;
import dptec.dao.FuncionarioDao3;
import dptec.dao.EmpresaDao;
import dptec.dao.ProdutoDao;

import dptec.model.BancoModel;
import dptec.model.CargoModel;
import dptec.model.DepartamentoModel;
import dptec.model.EnderecoModel;
import dptec.model.EstadoCivilModel;
import dptec.model.FuncionarioModel;
import dptec.model.CurriculoModel;
import dptec.model.DependenteModel;
import dptec.model.FinancasModel;
import dptec.model.EmpresaModel;
import dptec.model.CestaProdModel;
import dptec.model.ProdutoModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadFuncionarioView extends javax.swing.JFrame {

    boolean formOpen = false;
    private int cduser;
    private int cddependente;
    private String op = "I";
    private int cdcur = 0;

    Date data = new Date();
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
    String getdate = dataFormatada.format(data);

    public CadFuncionarioView() {
        initComponents();
        setLocationRelativeTo(null);
        txtAgencia.setDocument(new TrataCaracteres(16, "[aA-zZ]"));
        txtBairro.setDocument(new TrataCaracteres(90, "aA0-zZ9"));
        txtCCusto.setDocument(new TrataCaracteres(8, "aA0-zZ9"));
        txtCargoGestor.setDocument(new TrataCaracteres(60, "aA0-zZ9"));
        txtCidade.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtComplemento.setDocument(new TrataCaracteres(60, "aA0-zZ9"));
        txtEmail.setDocument(new TrataCaracteres(100, "aA0-zZ9"));
        txtEmailCom.setDocument(new TrataCaracteres(100, "aA0-zZ9"));
        txtEndereco.setDocument(new TrataCaracteres(100, "aA0-zZ9"));
        txtMatricula.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtNCTPS.setDocument(new TrataCaracteres(8, "[aA-zZ]"));
        txtNReservista.setDocument(new TrataCaracteres(6, "[aA-zZ]"));
        txtNascionalidade.setDocument(new TrataCaracteres(40, "[0-9]"));
        txtNaturalidade.setDocument(new TrataCaracteres(50, "[0-9]"));
        txtNmConjuge.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNmFunc.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNmGestor.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNmMae.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNmPai.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNoConta.setDocument(new TrataCaracteres(18, "[aA-zZ]"));
        txtNumero.setDocument(new TrataCaracteres(6, "aA0-zZ9"));
        txtPISPASEP.setDocument(new TrataCaracteres(13, "[aA-zZ]"));
        txtPais.setDocument(new TrataCaracteres(60, "[0-9]"));
        txtRA.setDocument(new TrataCaracteres(12, "[aA-zZ]"));
        txtRG.setDocument(new TrataCaracteres(11, "aA0-zZ9"));
        txtSalario.setDocument(new TrataCaracteres(10, "[aA-zZ]"));
        txtSecaoEleitoral.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtSerieCTPS.setDocument(new TrataCaracteres(8, "[aA-zZ]"));
        txtSerieReservista.setDocument(new TrataCaracteres(1, "[0-9]"));
        txtTitEleitoral.setDocument(new TrataCaracteres(15, "[aA-zZ]"));
        txtZonaEleitoral.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtDigito.setDocument(new TrataCaracteres(1, "[aA-zZ]"));

        //Formulario Dependente
        txtNmTit.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtMatriculaDep.setDocument(new TrataCaracteres(10, "[aA-zZ]"));
        txtNmDep.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtNacionalidadeDep.setDocument(new TrataCaracteres(40, "[0-9]"));;
        txtNmMaeDep.setDocument(new TrataCaracteres(80, "[0-9]"));;
        txtRGDep.setDocument(new TrataCaracteres(11, "aA0-zZ9"));;

        //Form Busca Endereco
        txtLogradouroBusca.setDocument(new TrataCaracteres(100, "aA0-zZ9"));
        txtBairroBusca.setDocument(new TrataCaracteres(90, "aA0-zZ9"));
        txtCidadeBusca.setDocument(new TrataCaracteres(80, "[0-9]"));

        //Form Dados Curricular
        txtMatriculaCur.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtNmFuncionarioCur.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtLocalCur.setDocument(new TrataCaracteres(90, "aA0-zZ9"));
        txtaDescricaoCur.setDocument(new TrataCaracteres(1000, "aA0-zZ9"));

        //Form Consulta Func
        txtMatriculaBFunc.setDocument(new TrataCaracteres(4, "[aA-zZ]"));
        txtNomeBFunc.setDocument(new TrataCaracteres(80, "[0-9]"));
        txtRGBFunc.setDocument(new TrataCaracteres(11, "aA0-zZ9"));
        txtPISBFunc.setDocument(new TrataCaracteres(13, "[aA-zZ]"));
    }

    public void Load(int cduser) {
        try {
            formOpen = true;
            btnAddDep.setEnabled(false);
            btnIncluiEscolaridade.setEnabled(false);
            btnIncluiProfiss.setEnabled(false);
            btnIncluiCurso.setEnabled(false);
            btnEditProd.setEnabled(false);
            tpFuncionario.remove(pnlBuscaEnd);
            tpFuncionario.remove(pnlCadCuricular);
            tpFuncionario.remove(pnlCadDependente);
            tpFuncionario.remove(pnlConsultaFunc);
            tpFuncionario.remove(pnlEditBenef);
            op = "I";
            loadOp(op);

            this.cduser = cduser;
            FuncionarioDao3 fd = new FuncionarioDao3();
            txtMatricula.setText(String.valueOf(fd.loadMatricula()));

            EstadoCivilDao ecd = new EstadoCivilDao();
            List<EstadoCivilModel> listaECivil = new ArrayList<EstadoCivilModel>();
            listaECivil = ecd.getListaECivilAtivo();
            for (EstadoCivilModel lec : listaECivil) {
                cmbEstCivil.addItem(lec.getDsestadocivil());
            }

            DepartamentoDao dd = new DepartamentoDao();
            List<DepartamentoModel> listaDepartamento = new ArrayList<DepartamentoModel>();
            listaDepartamento = dd.getListaDepAtivo();
            for (DepartamentoModel ld : listaDepartamento) {
                cmbDepartamento.addItem(ld.getDsdepartamento());
                cmbDepartamentoBFunc.addItem(ld.getDsdepartamento());
            }

            CargoDao cd = new CargoDao();
            List<CargoModel> listaCargo = new ArrayList<CargoModel>();
            listaCargo = cd.getListaCargoAtivo();
            for (CargoModel lc : listaCargo) {
                cmbCargo.addItem(lc.getDscargo());
                cmbCargoBFunc.addItem(lc.getDscargo());
            }

            BancoDao bd = new BancoDao();
            List<BancoModel> listaBanco = new ArrayList<BancoModel>();
            listaBanco = bd.getListaBancoAtivo();
            for (BancoModel lb : listaBanco) {
                cmbNmBanco.addItem(lb.getNmbanco());
            }

            EmpresaDao ed = new EmpresaDao();
            List<EmpresaModel> listaEmpresa = new ArrayList<EmpresaModel>();
            listaEmpresa = ed.getListaEmpresaAtivo();
            for (EmpresaModel le : listaEmpresa) {
                cmbEmpresa.addItem(le.getNmrazaosocial());
            }

            mskDtAdmissao.setText(getdate);

            loadProdutoFun();
            loadProdutoDep();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    private void loadProdutoFun() {
        try {
            DefaultTableModel dtmProd = (DefaultTableModel) tblBenDispo.getModel();
            dtmProd.setNumRows(0);
            ProdutoDao pd = new ProdutoDao();
            ProdutoModel pm = new ProdutoModel();
            List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
            listaProduto = pd.listProduto(pm);
            try {
                for (ProdutoModel gProd : listaProduto) {
                    if (gProd.getCdcategoria() != 2) {
                        dtmProd.addRow(new Object[]{
                            gProd.getCdproduto(),
                            gProd.getDsproduto(),
                            gProd.getDscategoria()
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getStackTrace());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    private void loadProdutoDep() {
        try {
            DefaultTableModel dtmProdDep = (DefaultTableModel) tblBenDispoDep.getModel();
            dtmProdDep.setNumRows(0);
            ProdutoDao pd = new ProdutoDao();
            ProdutoModel pm = new ProdutoModel();
            List<ProdutoModel> listaProduto = new ArrayList<ProdutoModel>();
            listaProduto = pd.listProduto(pm);
            try {
                for (ProdutoModel gProd : listaProduto) {
                    if (gProd.getCdcategoria() == 2) {
                        dtmProdDep.addRow(new Object[]{
                            gProd.getCdproduto(),
                            gProd.getDsproduto(),
                            gProd.getDscategoria()
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getStackTrace());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    public void Empty() {
        DefaultTableModel dtmEscolaridade = (DefaultTableModel) tblEscolaridade.getModel();
        dtmEscolaridade.setNumRows(0);
        DefaultTableModel dtmDProfiss = (DefaultTableModel) tblDadoProf.getModel();
        dtmDProfiss.setNumRows(0);
        DefaultTableModel dtmCurso = (DefaultTableModel) tblCursos.getModel();
        dtmCurso.setNumRows(0);
        DefaultTableModel dtmDep = (DefaultTableModel) tblDependente.getModel();
        dtmDep.setNumRows(0);
        txtAgencia.setText("");
        txtBairro.setText("");
        txtCCusto.setText("");
        txtCargoGestor.setText("");
        txtCidade.setText("");
        txtComplemento.setText("");
        txtEmail.setText("");
        txtEmailCom.setText("");
        txtEndereco.setText("");
        txtNCTPS.setText("");
        txtNReservista.setText("");
        txtNascionalidade.setText("");
        txtNaturalidade.setText("");
        txtNmConjuge.setText("");
        txtNmFunc.setText("");
        txtNmGestor.setText("");
        txtNmMae.setText("");
        txtNmPai.setText("");
        txtNoConta.setText("");
        txtNumero.setText("");
        txtPISPASEP.setText("");
        txtPais.setText("");
        txtRA.setText("");
        txtRG.setText("");
        txtSalario.setText("");
        txtSecaoEleitoral.setText("");
        txtSerieCTPS.setText("");
        txtSerieReservista.setText("");
        txtTitEleitoral.setText("");
        txtZonaEleitoral.setText("");
        txtDigito.setText("");
        mskCEP.setText("");
        mskCPF.setText("");
        mskDtAdmissao.setText("");
        mskDtDesligamento.setText("");
        mskDtExpedicao.setText("");
        mskDtExpedicaoRG.setText("");
        mskDtNasc.setText("");
        mskRamal.setText("");
        mskTelCel.setText("");
        mskTelCom.setText("");
        mskTelRes.setText("");
        cmbCargo.setSelectedItem("Selecionar");
        cmbEstCivil.setSelectedItem("Selecionar");
        cmbNecEspecial.setSelectedItem("Selecionar");
        cmbNmBanco.setSelectedItem("Selecionar");
        cmbOrgExp.setSelectedItem("Selecionar");
        cmbSexo.setSelectedItem("Selecionar");
        cmbStatus.setSelectedItem("Selecionar");
        cmbTipo.setSelectedItem("Selecionar");
        cmbTpConta.setSelectedItem("Selecionar");
        cmbUFCTPS.setSelectedItem("Selecionar");
        cmbUFEnd.setSelectedItem("Selecionar");
        cmbStatusFinancas.setSelectedItem("Selecionar");
    }

    private void loadBen() {
        loadProdutoFun();
        CestaProdController cpc = new CestaProdController(
                Integer.parseInt(txtMatricula.getText()),
                0,
                0,
                "B",
                cduser,
                "F"
        );
        DefaultTableModel dtmbenfuncativo = (DefaultTableModel) tblProdAtivoFunc.getModel();
        dtmbenfuncativo.setNumRows(0);
        DefaultTableModel dtmbenfuncinc = (DefaultTableModel) tblBenFunc.getModel();
        dtmbenfuncinc.setNumRows(0);
        DefaultTableModel dtmbenDisp = (DefaultTableModel) tblBenDispo.getModel();
        List<CestaProdModel> gCesta = new ArrayList<CestaProdModel>();
        try {
            gCesta = cpc.groupProduto();

            if (gCesta != null) {
                for (CestaProdModel cpmmodel : gCesta) {
                    dtmbenfuncativo.addRow(new Object[]{
                        cpmmodel.getCdproduto(),
                        cpmmodel.getDsproduto(),
                        cpmmodel.getDscategoria()

                    });
                    dtmbenfuncinc.addRow(new Object[]{
                        cpmmodel.getCdproduto(),
                        cpmmodel.getDsproduto(),
                        cpmmodel.getDscategoria()
                    });

                    int i = 0;
                    int l = tblBenDispo.getRowCount();
                    for (i = 0; i <= l; i++) {
                        int cdprodutodispo = Integer.parseInt(tblBenDispo.getValueAt(i, 0).toString());
                        if (cdprodutodispo == cpmmodel.getCdproduto()) {
                            dtmbenDisp.removeRow(i);
                            break;
                        }
                    }

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    private void loadBenDep() {
        loadProdutoDep();
        CestaProdController cpc = new CestaProdController(
                0,
                cddependente,
                0,
                "B",
                cduser,
                "D"
        );
        DefaultTableModel dtmbenDepativo = (DefaultTableModel) tblProdAtivoDep.getModel();
        dtmbenDepativo.setNumRows(0);
        DefaultTableModel dtmbenDepInc = (DefaultTableModel) tblBenDep.getModel();
        dtmbenDepInc.setNumRows(0);
        DefaultTableModel dtmbenDispDep = (DefaultTableModel) tblBenDispoDep.getModel();
        List<CestaProdModel> gCesta = new ArrayList<CestaProdModel>();
        try {
            gCesta = cpc.groupProduto();

            if (gCesta != null) {
                for (CestaProdModel cpmmodel : gCesta) {
                    dtmbenDepativo.addRow(new Object[]{
                        cpmmodel.getCdproduto(),
                        cpmmodel.getDsproduto(),
                        cpmmodel.getDscategoria()

                    });
                    dtmbenDepInc.addRow(new Object[]{
                        cpmmodel.getCdproduto(),
                        cpmmodel.getDsproduto(),
                        cpmmodel.getDscategoria()
                    });

                    int i = 0;
                    int l = tblBenDispoDep.getRowCount();
                    for (i = 0; i <= l; i++) {
                        int cdprodutodispo = Integer.parseInt(tblBenDispoDep.getValueAt(i, 0).toString());
                        if (cdprodutodispo == cpmmodel.getCdproduto()) {
                            dtmbenDispDep.removeRow(i);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }

    private void EmptyEnd() {
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);
        mskCEPBusca.setText("");
        txtLogradouroBusca.setText("");
        txtBairroBusca.setText("");
        txtCidadeBusca.setText("");
        cmbUFBusca.setSelectedItem("Selecionar");
    }

    private void emptyBuscaFun() {
        txtMatriculaBFunc.setText("");
        txtNomeBFunc.setText("");
        txtRGBFunc.setText("");
        txtPISBFunc.setText("");
        mskCPFBFunc.setText("");
        cmbDepartamentoBFunc.setSelectedItem("Selecionar");
        cmbCargoBFunc.setSelectedItem("Selecionar");
        cmbStatusBFunc.setSelectedItem("Selecionar");
        DefaultTableModel dtmFunc = (DefaultTableModel) tblFuncionario.getModel();
        dtmFunc.setNumRows(0);
    }

    private void emptyCur() {
        cmbCategoriaCur.setSelectedItem("Selecionar");
        cmbStatusCur.setSelectedItem("Selecionar");
        txtLocalCur.setText("");
        txtaDescricaoCur.setText("");
        mskDtInicioCur.setText("");
        mskDtTerminoCur.setText("");
    }

    private void emptyDep() {
        txtNmDep.setText("");
        cmbParentescoDep.setSelectedItem("Selecionar");
        cmbSexoDep.setSelectedItem("Selecionar");
        txtNacionalidadeDep.setText("");
        mskDtNascDep.setText("");
        cmbNecEspDep.setSelectedItem("Selecionar");
        txtNmMaeDep.setText("");
        mskCPFDep.setText("");
        txtRGDep.setText("");
        cmbOrgExpDep.setSelectedItem("Selecionar");
        mskDtExpedicaoRGDep.setText("");
        cmbStatusDep.setSelectedItem("Selecionar");
    }

    private void loadEnd(EnderecoModel em) {
        mskCEP.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cmbUFEnd.setSelectedItem(em.getSguf());
        txtPais.setText("");
        mskCEP.setText(em.getNocep());
        txtEndereco.setText(em.getNlogradouro());
        txtBairro.setText(em.getNbairro());
        txtCidade.setText(em.getNcidade());
        cmbUFEnd.setSelectedItem(em.getSguf());
        txtPais.setText(em.getNmpais());
        revalidate();
    }

    private void loadOp(String op) {
        if (op.equals("I")) {
            btnSalvar.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnBuscar.setEnabled(true);
            btnImprimir.setEnabled(false);
        } else if (op.equals("U")) {
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnImprimir.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpFuncionario = new javax.swing.JTabbedPane();
        pnlFuncIdentif = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblNmFunc = new javax.swing.JLabel();
        txtNmFunc = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lbldtNasc = new javax.swing.JLabel();
        lblNascionalidade = new javax.swing.JLabel();
        lblNaturalidade = new javax.swing.JLabel();
        lblStCivil = new javax.swing.JLabel();
        lblNmConjuge = new javax.swing.JLabel();
        lblNmMae = new javax.swing.JLabel();
        lblNmPai = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        mskDtNasc = new javax.swing.JFormattedTextField();
        txtNascionalidade = new javax.swing.JTextField();
        cmbEstCivil = new javax.swing.JComboBox<>();
        txtNmConjuge = new javax.swing.JTextField();
        txtNmMae = new javax.swing.JTextField();
        txtNmPai = new javax.swing.JTextField();
        txtNaturalidade = new javax.swing.JTextField();
        pnlImagem = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cmbNecEspecial = new javax.swing.JComboBox<>();
        pnlConsultaFunc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnPesquisarBFunc = new javax.swing.JButton();
        btnVoltarBFunc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMatriculaBFunc = new javax.swing.JTextField();
        lblMatricula1 = new javax.swing.JLabel();
        lblPIS = new javax.swing.JLabel();
        txtNomeBFunc = new javax.swing.JTextField();
        lblDepartamento1 = new javax.swing.JLabel();
        txtRGBFunc = new javax.swing.JTextField();
        lblCargo1 = new javax.swing.JLabel();
        txtPISBFunc = new javax.swing.JTextField();
        lblStatus1 = new javax.swing.JLabel();
        mskCPFBFunc = new javax.swing.JFormattedTextField();
        cmbDepartamentoBFunc = new javax.swing.JComboBox<>();
        cmbCargoBFunc = new javax.swing.JComboBox<>();
        cmbStatusBFunc = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        lblCPF1 = new javax.swing.JLabel();
        lblRG1 = new javax.swing.JLabel();
        pnlDocumentacao = new javax.swing.JPanel();
        lblRG = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblNCTPS = new javax.swing.JLabel();
        lblSerieCTPS = new javax.swing.JLabel();
        lblUFCTPS = new javax.swing.JLabel();
        lblOrgExp = new javax.swing.JLabel();
        lblPISPASEP = new javax.swing.JLabel();
        lblTitEleitor = new javax.swing.JLabel();
        lblSerieTitulo = new javax.swing.JLabel();
        lblSecaoTitulo = new javax.swing.JLabel();
        lblDtExpedicaoCTPS = new javax.swing.JLabel();
        lblNReservista = new javax.swing.JLabel();
        lblSReservista = new javax.swing.JLabel();
        mskCPF = new javax.swing.JFormattedTextField();
        txtRG = new javax.swing.JTextField();
        txtPISPASEP = new javax.swing.JTextField();
        txtNReservista = new javax.swing.JTextField();
        txtSerieReservista = new javax.swing.JTextField();
        txtTitEleitoral = new javax.swing.JTextField();
        txtZonaEleitoral = new javax.swing.JTextField();
        txtSecaoEleitoral = new javax.swing.JTextField();
        txtNCTPS = new javax.swing.JTextField();
        txtSerieCTPS = new javax.swing.JTextField();
        mskDtExpedicao = new javax.swing.JFormattedTextField();
        cmbUFCTPS = new javax.swing.JComboBox<>();
        cmbOrgExp = new javax.swing.JComboBox<>();
        mskDtExpedicaoRG = new javax.swing.JFormattedTextField();
        lblDtExpedicaoRG = new javax.swing.JLabel();
        txtRA = new javax.swing.JTextField();
        lblRA = new javax.swing.JLabel();
        pnlContabil = new javax.swing.JPanel();
        lblSalario = new javax.swing.JLabel();
        lblNmBanco = new javax.swing.JLabel();
        lblAgencia = new javax.swing.JLabel();
        lblNoConta = new javax.swing.JLabel();
        lblTpConta = new javax.swing.JLabel();
        cmbTpConta = new javax.swing.JComboBox<>();
        cmbNmBanco = new javax.swing.JComboBox<>();
        txtAgencia = new javax.swing.JTextField();
        txtNoConta = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtDigito = new javax.swing.JTextField();
        cmbStatusFinancas = new javax.swing.JComboBox<>();
        lblStatusFinanca = new javax.swing.JLabel();
        pnlDContato = new javax.swing.JPanel();
        mskTelRes = new javax.swing.JFormattedTextField();
        mskTelCel = new javax.swing.JFormattedTextField();
        mskTelCom = new javax.swing.JFormattedTextField();
        lblTelRes = new javax.swing.JLabel();
        lblTelCel = new javax.swing.JLabel();
        lblTelCom = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblUFEnd = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        mskCEP = new javax.swing.JFormattedTextField();
        cmbUFEnd = new javax.swing.JComboBox<>();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        btnBuscaCEP = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailCom = new javax.swing.JLabel();
        txtEmailCom = new javax.swing.JTextField();
        mskRamal = new javax.swing.JFormattedTextField();
        lblRamal = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        lblPais = new javax.swing.JLabel();
        pnlBuscaEnd = new javax.swing.JPanel();
        txtLogradouroBusca = new javax.swing.JTextField();
        txtBairroBusca = new javax.swing.JTextField();
        txtCidadeBusca = new javax.swing.JTextField();
        cmbUFBusca = new javax.swing.JComboBox<>();
        lblCEP = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        lblBairro1 = new javax.swing.JLabel();
        lblCidade1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEndereco = new javax.swing.JTable();
        lblUF = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        mskCEPBusca = new javax.swing.JFormattedTextField();
        pnlDCurricular = new javax.swing.JPanel();
        lblEscolaridade = new javax.swing.JLabel();
        lblDadosProf = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        dgvDadosProf = new javax.swing.JScrollPane();
        tblDadoProf = new javax.swing.JTable();
        dgvEscolaridade = new javax.swing.JScrollPane();
        tblEscolaridade = new javax.swing.JTable();
        dgvCursos = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnIncluiEscolaridade = new javax.swing.JButton();
        btnIncluiCurso = new javax.swing.JButton();
        btnIncluiProfiss = new javax.swing.JButton();
        pnlCadCuricular = new javax.swing.JPanel();
        mskDtInicioCur = new javax.swing.JFormattedTextField();
        lblMatricula3 = new javax.swing.JLabel();
        mskDtTerminoCur = new javax.swing.JFormattedTextField();
        lblNmFuncionario = new javax.swing.JLabel();
        cmbCategoriaCur = new javax.swing.JComboBox<>();
        lblDsCurricular = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaDescricaoCur = new javax.swing.JTextArea();
        lblLocal = new javax.swing.JLabel();
        lbldtInicio = new javax.swing.JLabel();
        lblStatus3 = new javax.swing.JLabel();
        lblDtFim = new javax.swing.JLabel();
        cmbStatusCur = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        btnCadastraCur = new javax.swing.JButton();
        txtMatriculaCur = new javax.swing.JTextField();
        btnVoltarCur = new javax.swing.JButton();
        txtNmFuncionarioCur = new javax.swing.JTextField();
        btnAlterarCur = new javax.swing.JButton();
        txtLocalCur = new javax.swing.JTextField();
        lbldscTela = new javax.swing.JLabel();
        pnlContratual = new javax.swing.JPanel();
        lblDtAdmissao = new javax.swing.JLabel();
        lblDtDesligamento = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblCCusto = new javax.swing.JLabel();
        lblNmGestor = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        txtCCusto = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        txtNmGestor = new javax.swing.JTextField();
        txtCargoGestor = new javax.swing.JTextField();
        lblCargoGestor = new javax.swing.JLabel();
        mskDtAdmissao = new javax.swing.JFormattedTextField();
        mskDtDesligamento = new javax.swing.JFormattedTextField();
        cmbDepartamento = new javax.swing.JComboBox<>();
        cmbCargo = new javax.swing.JComboBox<>();
        cmbEmpresa = new javax.swing.JComboBox<>();
        lblEmpresa = new javax.swing.JLabel();
        pnlDependente = new javax.swing.JPanel();
        dgvDep = new javax.swing.JScrollPane();
        tblDependente = new javax.swing.JTable();
        btnAddDep = new javax.swing.JButton();
        lblDependente = new javax.swing.JLabel();
        pnlCadDependente = new javax.swing.JPanel();
        tpDependente = new javax.swing.JTabbedPane();
        pnlDependeteView = new javax.swing.JPanel();
        lblCPFTit = new javax.swing.JLabel();
        mskCPFDep = new javax.swing.JFormattedTextField();
        lblDtExpedicaoRG1 = new javax.swing.JLabel();
        lblMatricula2 = new javax.swing.JLabel();
        mskDtExpedicaoRGDep = new javax.swing.JFormattedTextField();
        lblDadosTitular = new javax.swing.JLabel();
        txtRGDep = new javax.swing.JTextField();
        lblDadosDep = new javax.swing.JLabel();
        lblNmMaeDep = new javax.swing.JLabel();
        cmbSexoDep = new javax.swing.JComboBox<>();
        lblNacionalidade = new javax.swing.JLabel();
        lblNmDep = new javax.swing.JLabel();
        cmbOrgExpDep = new javax.swing.JComboBox<>();
        txtNacionalidadeDep = new javax.swing.JTextField();
        lblParentesco = new javax.swing.JLabel();
        lblOrgExp1 = new javax.swing.JLabel();
        mskDtNascDep = new javax.swing.JFormattedTextField();
        lblDtNasc = new javax.swing.JLabel();
        lblStatusDep = new javax.swing.JLabel();
        txtNmMaeDep = new javax.swing.JTextField();
        txtMatriculaDep = new javax.swing.JTextField();
        lblCPFDep = new javax.swing.JLabel();
        cmbStatusDep = new javax.swing.JComboBox<>();
        cmbNecEspDep = new javax.swing.JComboBox<>();
        txtNmTit = new javax.swing.JTextField();
        lblRG2 = new javax.swing.JLabel();
        mskCPFTit = new javax.swing.JFormattedTextField();
        lblNecEsp = new javax.swing.JLabel();
        txtNmDep = new javax.swing.JTextField();
        lblSexo1 = new javax.swing.JLabel();
        cmbParentescoDep = new javax.swing.JComboBox<>();
        lblNmTit = new javax.swing.JLabel();
        btnSalvarDep = new javax.swing.JButton();
        btnAlterarDep = new javax.swing.JButton();
        btnCancelarDep = new javax.swing.JButton();
        pnlBeneficioDep = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProdAtivoDep = new javax.swing.JTable();
        btnEditProdDep = new javax.swing.JButton();
        pnlEditBeneficioDep = new javax.swing.JPanel();
        lblProdDispoDep = new javax.swing.JLabel();
        lblProdDep = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblBenDep = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblBenDispoDep = new javax.swing.JTable();
        btnAddProdDep = new javax.swing.JButton();
        btnRemoveProdDep = new javax.swing.JButton();
        btnVoltarDep = new javax.swing.JButton();
        pnlBeneficios = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblProdAtivoFunc = new javax.swing.JTable();
        btnEditProd = new javax.swing.JButton();
        pnlEditBenef = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBenDispo = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBenFunc = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        lblProdDispo = new javax.swing.JLabel();
        lblProdFunc = new javax.swing.JLabel();
        btnVoltarBen = new javax.swing.JButton();
        pnlAcoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Funcionário");
        setLocation(new java.awt.Point(200, 50));
        setResizable(false);

        lblMatricula.setText("Matrícula");

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        lblNmFunc.setText("Nome Completo");

        lblSexo.setText("Sexo");

        lbldtNasc.setText("Data Nascimento");

        lblNascionalidade.setText("Nacionalidade");

        lblNaturalidade.setText("Naturalidade");

        lblStCivil.setText("Estado Civil");

        lblNmConjuge.setText("Nome Cônjuge");

        lblNmMae.setText("Nome da Mãe");

        lblNmPai.setText("Nome do Pai");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Feminino", "Masculino" }));
        cmbSexo.setActionCommand("CboxFuncSexo");

        try {
            mskDtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtNascFocusLost(evt);
            }
        });
        mskDtNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtNascActionPerformed(evt);
            }
        });
        mskDtNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mskDtNascKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mskDtNascKeyTyped(evt);
            }
        });

        cmbEstCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        cmbEstCivil.setActionCommand("CboxFuncSexo");

        javax.swing.GroupLayout pnlImagemLayout = new javax.swing.GroupLayout(pnlImagem);
        pnlImagem.setLayout(pnlImagemLayout);
        pnlImagemLayout.setHorizontalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        pnlImagemLayout.setVerticalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        jLabel13.setText("Necessidades Especiais?");

        cmbNecEspecial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Nenhuma", "Autismo", "Doença Crônica", "Perda Auditiva e Surdez", "Deficiência Intelectual", "Deficiência de Aprendizado", "Perda de Memória", "Deficiência Mental", "Deficiência Física", "Distúrbios da Fala e da Linguagem", "Perda de Visão e Cegueira" }));

        javax.swing.GroupLayout pnlFuncIdentifLayout = new javax.swing.GroupLayout(pnlFuncIdentif);
        pnlFuncIdentif.setLayout(pnlFuncIdentifLayout);
        pnlFuncIdentifLayout.setHorizontalGroup(
            pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                        .addComponent(lblSexo)
                                        .addGap(241, 241, 241)
                                        .addComponent(lblNascionalidade))
                                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbldtNasc)
                                                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(mskDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNmConjuge))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNaturalidade)
                                                    .addComponent(txtNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lblNmFunc)
                                            .addComponent(txtNmFunc)
                                            .addComponent(txtNmConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatricula)
                                    .addComponent(cmbEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                        .addComponent(txtNmMae, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNmPai, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                                        .addComponent(lblNmMae)
                                        .addGap(198, 198, 198)
                                        .addComponent(lblNmPai))
                                    .addComponent(lblStCivil))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93))
                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(cmbNecEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlFuncIdentifLayout.setVerticalGroup(
            pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula)
                    .addComponent(lblNmFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncIdentifLayout.createSequentialGroup()
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSexo)
                            .addComponent(lbldtNasc)
                            .addComponent(lblNascionalidade)
                            .addComponent(lblNaturalidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStCivil)
                            .addComponent(lblNmConjuge))
                        .addGap(5, 5, 5)
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNmMae)
                            .addComponent(lblNmPai)))
                    .addComponent(pnlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNmMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNmPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNecEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Identificação", pnlFuncIdentif);

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "CPF", "Cargo", "Departamento", "Status", "Data Admissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFuncionario);

        btnPesquisarBFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Buscar.png"))); // NOI18N
        btnPesquisarBFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarBFuncActionPerformed(evt);
            }
        });

        btnVoltarBFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltarBFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarBFuncActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Consultar Funcionarios");

        lblMatricula1.setText("Matricula");

        lblPIS.setText("PIS/PASEP");

        lblDepartamento1.setText("Departamento");

        lblCargo1.setText("Cargo");

        lblStatus1.setText("Status");

        try {
            mskCPFBFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cmbDepartamentoBFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        cmbCargoBFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        cmbStatusBFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Inativo", "Afastado", "Férias", "Desligado" }));

        lblNome.setText("Nome");

        lblCPF1.setText("CPF");

        lblRG1.setText("RG");

        javax.swing.GroupLayout pnlConsultaFuncLayout = new javax.swing.GroupLayout(pnlConsultaFunc);
        pnlConsultaFunc.setLayout(pnlConsultaFuncLayout);
        pnlConsultaFuncLayout.setHorizontalGroup(
            pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mskCPFBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRG1)
                            .addComponent(txtRGBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPIS)
                            .addComponent(txtPISBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                                        .addComponent(lblDepartamento1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbDepartamentoBFunc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCargo1)
                                    .addComponent(cmbCargoBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus1)
                                    .addComponent(cmbStatusBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                                        .addComponent(txtMatriculaBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultaFuncLayout.createSequentialGroup()
                                        .addComponent(lblMatricula1)
                                        .addGap(43, 43, 43)))
                                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(txtNomeBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)
                        .addComponent(btnPesquisarBFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltarBFunc)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlConsultaFuncLayout.setVerticalGroup(
            pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultaFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula1)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatriculaBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF1)
                    .addComponent(lblRG1)
                    .addComponent(lblPIS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConsultaFuncLayout.createSequentialGroup()
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mskCPFBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRGBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPISBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDepartamento1)
                            .addComponent(lblCargo1)
                            .addComponent(lblStatus1))
                        .addGap(4, 4, 4)
                        .addGroup(pnlConsultaFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbDepartamentoBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCargoBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatusBFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPesquisarBFunc)
                    .addComponent(btnVoltarBFunc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpFuncionario.addTab("Consulta Funcionario", pnlConsultaFunc);

        lblRG.setText("RG");

        lblCPF.setText("CPF");

        lblNCTPS.setText("CTPS");

        lblSerieCTPS.setText("Série");

        lblUFCTPS.setText("UF");

        lblOrgExp.setText("Org. Exp");

        lblPISPASEP.setText("PIS/PASEP");

        lblTitEleitor.setText("Titulo Eleitoral");

        lblSerieTitulo.setText("Zona");

        lblSecaoTitulo.setText("Seção");

        lblDtExpedicaoCTPS.setText("Data Expedição");

        lblNReservista.setText("Nº. Reservista");

        lblSReservista.setText("Série");

        try {
            mskCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskCPFActionPerformed(evt);
            }
        });

        try {
            mskDtExpedicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtExpedicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtExpedicaoFocusLost(evt);
            }
        });
        mskDtExpedicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtExpedicaoActionPerformed(evt);
            }
        });

        cmbUFCTPS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        cmbOrgExp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "SSP", "PM", "PC", "CNT ", "DIC", "CTPS", "FGTS", "IFP", "IPF", "IML ", "MTE", "MMA ", "MAE", "MEX", "POF", "POM", "SES", "SJS ", "SJTS", "ZZZ" }));

        try {
            mskDtExpedicaoRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtExpedicaoRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtExpedicaoRGFocusLost(evt);
            }
        });
        mskDtExpedicaoRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtExpedicaoRGActionPerformed(evt);
            }
        });

        lblDtExpedicaoRG.setText("Data Expedição");

        lblRA.setText("RA");

        javax.swing.GroupLayout pnlDocumentacaoLayout = new javax.swing.GroupLayout(pnlDocumentacao);
        pnlDocumentacao.setLayout(pnlDocumentacaoLayout);
        pnlDocumentacaoLayout.setHorizontalGroup(
            pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitEleitoral)
                            .addComponent(lblTitEleitor)
                            .addComponent(lblNCTPS)
                            .addComponent(txtNCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSerieTitulo)
                                    .addComponent(txtZonaEleitoral, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDocumentacaoLayout.createSequentialGroup()
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSerieCTPS)
                                    .addComponent(txtSerieCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbUFCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUFCTPS))
                                .addGap(18, 18, 18)))
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDtExpedicaoCTPS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSecaoEleitoral, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSecaoTitulo)
                            .addComponent(mskDtExpedicao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCPF)
                    .addComponent(mskCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRG)
                            .addComponent(txtPISPASEP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPISPASEP))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNReservista, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNReservista))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                                        .addComponent(txtRA)
                                        .addGap(6, 6, 6))
                                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                                        .addComponent(lblRA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrgExp)
                                    .addComponent(cmbOrgExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(164, 164, 164)))
                        .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDtExpedicaoRG)
                            .addComponent(lblSReservista)
                            .addComponent(txtSerieReservista, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskDtExpedicaoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(370, Short.MAX_VALUE))
        );
        pnlDocumentacaoLayout.setVerticalGroup(
            pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mskCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                        .addComponent(lblRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                        .addComponent(lblOrgExp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrgExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDocumentacaoLayout.createSequentialGroup()
                        .addComponent(lblDtExpedicaoRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mskDtExpedicaoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPISPASEP)
                    .addComponent(lblNReservista)
                    .addComponent(lblSReservista)
                    .addComponent(lblRA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPISPASEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNReservista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerieReservista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitEleitor)
                    .addComponent(lblSerieTitulo)
                    .addComponent(lblSecaoTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitEleitoral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtZonaEleitoral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecaoEleitoral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNCTPS)
                    .addComponent(lblSerieCTPS)
                    .addComponent(lblDtExpedicaoCTPS)
                    .addComponent(lblUFCTPS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDocumentacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerieCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mskDtExpedicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUFCTPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Documentação", pnlDocumentacao);

        lblSalario.setText("Salário (R$)");

        lblNmBanco.setText("Banco");

        lblAgencia.setText("Agencia");

        lblNoConta.setText("Numero da Conta");

        lblTpConta.setText("Conta");

        cmbTpConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Conta Corrente", "Conta Poupança", "Conta Salário" }));

        cmbNmBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        cmbStatusFinancas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Inativo", "Afastado", "Férias", "Desligado" }));

        lblStatusFinanca.setText("Status");

        javax.swing.GroupLayout pnlContabilLayout = new javax.swing.GroupLayout(pnlContabil);
        pnlContabil.setLayout(pnlContabilLayout);
        pnlContabilLayout.setHorizontalGroup(
            pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContabilLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNmBanco)
                    .addComponent(lblSalario)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContabilLayout.createSequentialGroup()
                        .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgencia)
                            .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoConta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDigito, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbNmBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlContabilLayout.createSequentialGroup()
                            .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlContabilLayout.createSequentialGroup()
                                    .addComponent(cmbTpConta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContabilLayout.createSequentialGroup()
                                    .addComponent(lblTpConta)
                                    .addGap(196, 196, 196)))
                            .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStatusFinanca)
                                .addComponent(cmbStatusFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        pnlContabilLayout.setVerticalGroup(
            pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContabilLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTpConta)
                    .addComponent(lblStatusFinanca))
                .addGap(6, 6, 6)
                .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTpConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusFinancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblNmBanco)
                .addGap(6, 6, 6)
                .addComponent(cmbNmBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgencia)
                    .addComponent(lblNoConta))
                .addGap(6, 6, 6)
                .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDigito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );

        tpFuncionario.addTab("Remuneração", pnlContabil);

        try {
            mskTelRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            mskTelCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            mskTelCom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTelRes.setText("Tel. Residencial");

        lblTelCel.setText("Tel.Celular");

        lblTelCom.setText("Tel.Comercial");

        lblEndereco.setText("Endereço");

        lblNumero.setText("Número");

        lblBairro.setText("Bairro");

        lblComplemento.setText("Complemento");

        lblCidade.setText("Cidade");

        lblUFEnd.setText("UF");

        lblCep.setText("CEP");

        try {
            mskCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskCEPActionPerformed(evt);
            }
        });

        cmbUFEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        btnBuscaCEP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Buscar.png"))); // NOI18N
        btnBuscaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCEPActionPerformed(evt);
            }
        });

        lblEmail.setText("e-Mail");

        lblEmailCom.setText("e-Mail Comercial");

        try {
            mskRamal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblRamal.setText("Ramal");

        lblPais.setText("Pais");

        javax.swing.GroupLayout pnlDContatoLayout = new javax.swing.GroupLayout(pnlDContato);
        pnlDContato.setLayout(pnlDContatoLayout);
        pnlDContatoLayout.setHorizontalGroup(
            pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDContatoLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelRes)
                            .addComponent(mskTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDContatoLayout.createSequentialGroup()
                                .addComponent(mskTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mskTelCom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDContatoLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(lblTelCom))
                            .addComponent(lblTelCel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRamal)
                            .addComponent(mskRamal)))
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailCom)
                            .addComponent(txtEmailCom, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBairro))
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEndereco)
                            .addGroup(pnlDContatoLayout.createSequentialGroup()
                                .addComponent(lblComplemento)
                                .addGap(188, 188, 188)
                                .addComponent(lblBairro))
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(txtNumero)))
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUFEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUFEnd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPais)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCep)
                            .addComponent(mskCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        pnlDContatoLayout.setVerticalGroup(
            pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDContatoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDContatoLayout.createSequentialGroup()
                        .addComponent(lblCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mskCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscaCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento)
                    .addComponent(lblBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(lblUFEnd)
                    .addComponent(lblPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUFEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDContatoLayout.createSequentialGroup()
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelRes)
                            .addComponent(lblTelCel)
                            .addComponent(lblTelCom)
                            .addComponent(lblRamal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mskTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskTelCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDContatoLayout.createSequentialGroup()
                        .addComponent(lblEmailCom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Dados Para Contato", pnlDContato);

        txtLogradouroBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroBuscaActionPerformed(evt);
            }
        });

        txtBairroBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroBuscaActionPerformed(evt);
            }
        });

        txtCidadeBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeBuscaActionPerformed(evt);
            }
        });

        cmbUFBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmbUFBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUFBuscaActionPerformed(evt);
            }
        });

        lblCEP.setText("CEP");

        lblLogradouro.setText("Logradouro");

        lblBairro1.setText("Bairro");

        lblCidade1.setText("Cidade");

        tblEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEP", "Logradouro", "Bairro", "Cidade", "UF", "País"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEndereco);

        lblUF.setText("UF");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        try {
            mskCEPBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskCEPBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskCEPBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscaEndLayout = new javax.swing.GroupLayout(pnlBuscaEnd);
        pnlBuscaEnd.setLayout(pnlBuscaEndLayout);
        pnlBuscaEndLayout.setHorizontalGroup(
            pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogradouroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCEP)
                            .addComponent(mskCEPBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogradouro)
                            .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                                .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBairro1))
                                .addGap(6, 6, 6)
                                .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCidade1)
                                    .addComponent(txtCidadeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUF)
                                    .addComponent(cmbUFBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnlBuscaEndLayout.setVerticalGroup(
            pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCEP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mskCEPBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogradouro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogradouroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBuscaEndLayout.createSequentialGroup()
                        .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCidade1)
                                .addComponent(lblBairro1))
                            .addComponent(lblUF, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBuscaEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCidadeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUFBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        tpFuncionario.addTab("Buscar Endereço", pnlBuscaEnd);

        lblEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEscolaridade.setText("Escolaridade");

        lblDadosProf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDadosProf.setText("Dados Profissionais");

        lblCurso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCurso.setText("Cursos");

        tblDadoProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Local", "Descrição", "Data de Contratação", "Data de Desligamento", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDadoProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDadoProfMouseClicked(evt);
            }
        });
        dgvDadosProf.setViewportView(tblDadoProf);

        tblEscolaridade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Local", "Descrição", "Data de Inicio", "Data de Conclusão", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEscolaridade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEscolaridadeMouseClicked(evt);
            }
        });
        dgvEscolaridade.setViewportView(tblEscolaridade);

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Local", "Descrição", "Data de Inicio", "Data de Conclusão", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursosMouseClicked(evt);
            }
        });
        dgvCursos.setViewportView(tblCursos);

        btnIncluiEscolaridade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/add.png"))); // NOI18N
        btnIncluiEscolaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluiEscolaridadeActionPerformed(evt);
            }
        });

        btnIncluiCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/add.png"))); // NOI18N
        btnIncluiCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluiCursoActionPerformed(evt);
            }
        });

        btnIncluiProfiss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/add.png"))); // NOI18N
        btnIncluiProfiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluiProfissActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDCurricularLayout = new javax.swing.GroupLayout(pnlDCurricular);
        pnlDCurricular.setLayout(pnlDCurricularLayout);
        pnlDCurricularLayout.setHorizontalGroup(
            pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDCurricularLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dgvCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(dgvDadosProf, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(lblCurso)
                    .addComponent(lblEscolaridade)
                    .addComponent(lblDadosProf)
                    .addComponent(dgvEscolaridade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIncluiCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluiProfiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluiEscolaridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlDCurricularLayout.setVerticalGroup(
            pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDCurricularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEscolaridade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dgvEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluiEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lblDadosProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dgvDadosProf, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluiProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dgvCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluiCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Dados Curricular", pnlDCurricular);

        pnlCadCuricular.setToolTipText("");

        try {
            mskDtInicioCur.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtInicioCur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtInicioCurFocusLost(evt);
            }
        });
        mskDtInicioCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtInicioCurActionPerformed(evt);
            }
        });

        lblMatricula3.setText("Matricula");

        try {
            mskDtTerminoCur.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtTerminoCur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtTerminoCurFocusLost(evt);
            }
        });
        mskDtTerminoCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtTerminoCurActionPerformed(evt);
            }
        });

        lblNmFuncionario.setText("Funcionário");

        cmbCategoriaCur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Cursos", "Experiencia Profissional", "Formação Escolar" }));

        lblDsCurricular.setText("Descrição");

        txtaDescricaoCur.setColumns(20);
        txtaDescricaoCur.setRows(5);
        jScrollPane3.setViewportView(txtaDescricaoCur);

        lblLocal.setText("Instituição");

        lbldtInicio.setText("Data Inicio");

        lblStatus3.setText("Status");

        lblDtFim.setText("Data Termino");

        cmbStatusCur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Cursando", "Concluido", "Incompleto", "Ativo" }));

        lblCategoria.setText("Categoria");

        btnCadastraCur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Salvar.png"))); // NOI18N
        btnCadastraCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCurActionPerformed(evt);
            }
        });

        btnVoltarCur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltarCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCurActionPerformed(evt);
            }
        });

        btnAlterarCur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnAlterarCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCurActionPerformed(evt);
            }
        });

        lbldscTela.setText("Dados Curricular");

        javax.swing.GroupLayout pnlCadCuricularLayout = new javax.swing.GroupLayout(pnlCadCuricular);
        pnlCadCuricular.setLayout(pnlCadCuricularLayout);
        pnlCadCuricularLayout.setHorizontalGroup(
            pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadCuricularLayout.createSequentialGroup()
                        .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatricula3)
                            .addComponent(txtMatriculaCur, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocal))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                                .addComponent(lblNmFuncionario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNmFuncionarioCur)))
                    .addComponent(txtLocalCur)
                    .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                        .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                                .addComponent(btnCadastraCur, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarCur, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVoltarCur, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDsCurricular)
                            .addComponent(lbldscTela)
                            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addGap(141, 141, 141)
                                .addComponent(lblStatus3))
                            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                                .addComponent(cmbCategoriaCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(cmbStatusCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbldtInicio)
                                    .addComponent(mskDtInicioCur, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDtFim)
                                    .addComponent(mskDtTerminoCur, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(614, 614, 614)))
                .addGap(35, 35, 35))
        );
        pnlCadCuricularLayout.setVerticalGroup(
            pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldscTela)
                .addGap(18, 18, 18)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(lblStatus3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoriaCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                        .addComponent(lblMatricula3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatriculaCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCadCuricularLayout.createSequentialGroup()
                        .addComponent(lblNmFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNmFuncionarioCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLocal)
                .addGap(8, 8, 8)
                .addComponent(txtLocalCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDsCurricular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldtInicio)
                    .addComponent(lblDtFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mskDtInicioCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mskDtTerminoCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadCuricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastraCur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarCur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltarCur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        tpFuncionario.addTab("Cadastro Curricular", pnlCadCuricular);

        lblDtAdmissao.setText("Data Admissão");

        lblDtDesligamento.setText("Data Desligamento");

        lblDepartamento.setText("Departamento");

        lblCargo.setText("Cargo");

        lblCCusto.setText("Centro de Custo");

        lblNmGestor.setText("Gertor Imediato");

        lblStatus.setText("Status");

        lblTipo.setText("Tipo");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo", "Inativo", "Afastado", "Férias", "Desligado" }));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "CLT", "Terceiro", "PJ", "Parceiro" }));

        lblCargoGestor.setText("Cargo Gestor Imediato");

        try {
            mskDtAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtAdmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtAdmissaoFocusLost(evt);
            }
        });
        mskDtAdmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtAdmissaoActionPerformed(evt);
            }
        });

        try {
            mskDtDesligamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtDesligamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtDesligamentoFocusLost(evt);
            }
        });
        mskDtDesligamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtDesligamentoActionPerformed(evt);
            }
        });

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        cmbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        lblEmpresa.setText("Empresa");

        javax.swing.GroupLayout pnlContratualLayout = new javax.swing.GroupLayout(pnlContratual);
        pnlContratual.setLayout(pnlContratualLayout);
        pnlContratualLayout.setHorizontalGroup(
            pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContratualLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlContratualLayout.createSequentialGroup()
                        .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNmGestor)
                            .addComponent(mskDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNmGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mskDtDesligamento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDtDesligamento)
                            .addComponent(lblCargoGestor)
                            .addComponent(txtCargoGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContratualLayout.createSequentialGroup()
                        .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContratualLayout.createSequentialGroup()
                        .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDtAdmissao)
                            .addComponent(lblDepartamento)
                            .addComponent(lblStatus)
                            .addComponent(lblCargo)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlContratualLayout.createSequentialGroup()
                                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTipo)
                                    .addComponent(lblCCusto)
                                    .addComponent(lblEmpresa))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        pnlContratualLayout.setVerticalGroup(
            pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContratualLayout.createSequentialGroup()
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContratualLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblStatus)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContratualLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(lblCCusto))
                .addGap(7, 7, 7)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(lblTipo))
                .addGap(2, 2, 2)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNmGestor)
                    .addComponent(lblCargoGestor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNmGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargoGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtAdmissao)
                    .addComponent(lblDtDesligamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContratualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mskDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mskDtDesligamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Dados Contratuais", pnlContratual);

        tblDependente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "Parentesco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDependenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblDependenteMouseEntered(evt);
            }
        });
        dgvDep.setViewportView(tblDependente);

        btnAddDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Adduser.png"))); // NOI18N
        btnAddDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDepActionPerformed(evt);
            }
        });

        lblDependente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDependente.setText("Dependentes");

        javax.swing.GroupLayout pnlDependenteLayout = new javax.swing.GroupLayout(pnlDependente);
        pnlDependente.setLayout(pnlDependenteLayout);
        pnlDependenteLayout.setHorizontalGroup(
            pnlDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDependenteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDependenteLayout.createSequentialGroup()
                        .addComponent(dgvDep, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddDep, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                    .addComponent(lblDependente))
                .addContainerGap())
        );
        pnlDependenteLayout.setVerticalGroup(
            pnlDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDependenteLayout.createSequentialGroup()
                .addGroup(pnlDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDependenteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDependente))
                    .addGroup(pnlDependenteLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnlDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddDep)
                            .addComponent(dgvDep, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Dependente", pnlDependente);

        lblCPFTit.setText("CPF");

        try {
            mskCPFDep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskCPFDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskCPFDepActionPerformed(evt);
            }
        });

        lblDtExpedicaoRG1.setText("Data Expedição");

        lblMatricula2.setText("Matricula");

        try {
            mskDtExpedicaoRGDep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtExpedicaoRGDep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtExpedicaoRGDepFocusLost(evt);
            }
        });
        mskDtExpedicaoRGDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtExpedicaoRGDepActionPerformed(evt);
            }
        });

        lblDadosTitular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDadosTitular.setText("Dados do Titular");

        lblDadosDep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDadosDep.setText("Cadastro de Dependente");

        lblNmMaeDep.setText("Nome da Mãe");

        cmbSexoDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Feminino", "Masculino" }));
        cmbSexoDep.setActionCommand("CboxFuncSexo");

        lblNacionalidade.setText("Nacionalidade");
        lblNacionalidade.setToolTipText("");

        lblNmDep.setText("Nome");

        cmbOrgExpDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "SSP", "PM", "PC", "CNT ", "DIC", "CTPS", "FGTS", "IFP", "IPF", "IML ", "MTE", "MMA ", "MAE", "MEX", "POF", "POM", "SES", "SJS ", "SJTS", "ZZZ" }));

        lblParentesco.setText("Parentesco");

        lblOrgExp1.setText("Org. Exp");

        try {
            mskDtNascDep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskDtNascDep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mskDtNascDepFocusLost(evt);
            }
        });
        mskDtNascDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskDtNascDepActionPerformed(evt);
            }
        });

        lblDtNasc.setText("Data de Nascimento");

        lblStatusDep.setText("Status");

        lblCPFDep.setText("CPF");

        cmbStatusDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Ativo" }));
        cmbStatusDep.setActionCommand("CboxFuncSexo");

        cmbNecEspDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Nenhum", "Autismo", "Doença Crônica", "Perda Auditiva e Surdez", "Deficiência Intelectual", "Deficiência de Aprendizado", "Perda de Memória", "Deficiência Mental", "Deficiência Física", "Distúrbios da Fala e da Linguagem", "Perda de Visão e Cegueira" }));

        lblRG2.setText("RG");

        try {
            mskCPFTit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        mskCPFTit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mskCPFTitActionPerformed(evt);
            }
        });

        lblNecEsp.setText("Necessidades Especiais?");

        lblSexo1.setText("Sexo");

        cmbParentescoDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Filho(a)", "Conjugê", "Pai", "Mãe" }));

        lblNmTit.setText("Nome");

        btnSalvarDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Salvar.png"))); // NOI18N
        btnSalvarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDepActionPerformed(evt);
            }
        });

        btnAlterarDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnAlterarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDepActionPerformed(evt);
            }
        });

        btnCancelarDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnCancelarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDependeteViewLayout = new javax.swing.GroupLayout(pnlDependeteView);
        pnlDependeteView.setLayout(pnlDependeteViewLayout);
        pnlDependeteViewLayout.setHorizontalGroup(
            pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                        .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNmMaeDep)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDependeteViewLayout.createSequentialGroup()
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMatricula2)
                                    .addComponent(txtMatriculaDep, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                        .addComponent(lblNmTit)
                                        .addGap(422, 422, 422))
                                    .addComponent(txtNmTit)))
                            .addComponent(lblNmMaeDep, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDadosTitular, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mskCPFTit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCPFTit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatusDep)
                                    .addComponent(cmbStatusDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(285, 285, 285))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDependeteViewLayout.createSequentialGroup()
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                        .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                                .addComponent(lblCPFDep)
                                                .addGap(126, 126, 126)
                                                .addComponent(lblRG2))
                                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                                .addComponent(mskCPFDep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtRGDep, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbSexoDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblSexo1))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNacionalidade)
                                                    .addComponent(txtNacionalidadeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(mskDtNascDep, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDtNasc, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(lblDadosDep)
                                    .addComponent(lblNmDep)
                                    .addComponent(txtNmDep, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblParentesco)
                                    .addComponent(lblNecEsp)
                                    .addComponent(cmbParentescoDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbNecEspDep, 0, 233, Short.MAX_VALUE))))
                        .addContainerGap(251, Short.MAX_VALUE))
                    .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                        .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrgExp1)
                                    .addComponent(cmbOrgExpDep, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                                .addComponent(btnSalvarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDtExpedicaoRG1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mskDtExpedicaoRGDep, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(393, Short.MAX_VALUE))))
        );
        pnlDependeteViewLayout.setVerticalGroup(
            pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDependeteViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDadosTitular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFTit)
                    .addComponent(lblStatusDep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mskCPFTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatusDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula2)
                    .addComponent(lblNmTit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatriculaDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNmTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDadosDep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblParentesco)
                    .addComponent(lblNmDep))
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNmDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbParentescoDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo1)
                    .addComponent(lblNacionalidade)
                    .addComponent(lblDtNasc)
                    .addComponent(lblNecEsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSexoDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacionalidadeDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mskDtNascDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNecEspDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNmMaeDep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNmMaeDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFDep)
                    .addComponent(lblRG2)
                    .addComponent(lblOrgExp1)
                    .addComponent(lblDtExpedicaoRG1))
                .addGap(5, 5, 5)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mskCPFDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRGDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrgExpDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mskDtExpedicaoRGDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDependeteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCancelarDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarDep))
                    .addComponent(btnAlterarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        tpDependente.addTab("Dependente", pnlDependeteView);

        tblProdAtivoDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblProdAtivoDep);

        btnEditProdDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnEditProdDep.setText("Editar");
        btnEditProdDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProdDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBeneficioDepLayout = new javax.swing.GroupLayout(pnlBeneficioDep);
        pnlBeneficioDep.setLayout(pnlBeneficioDepLayout);
        pnlBeneficioDepLayout.setHorizontalGroup(
            pnlBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBeneficioDepLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditProdDep, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnlBeneficioDepLayout.setVerticalGroup(
            pnlBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBeneficioDepLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditProdDep, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        tpDependente.addTab("Beneficio", pnlBeneficioDep);

        lblProdDispoDep.setText("Produto Disponivel");

        lblProdDep.setText("Produto Parametrizado");

        tblBenDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblBenDep);

        tblBenDispoDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblBenDispoDep);

        btnAddProdDep.setText(">>");
        btnAddProdDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdDepActionPerformed(evt);
            }
        });

        btnRemoveProdDep.setText("<<");
        btnRemoveProdDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProdDepActionPerformed(evt);
            }
        });

        btnVoltarDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarDepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditBeneficioDepLayout = new javax.swing.GroupLayout(pnlEditBeneficioDep);
        pnlEditBeneficioDep.setLayout(pnlEditBeneficioDepLayout);
        pnlEditBeneficioDepLayout.setHorizontalGroup(
            pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                        .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddProdDep)
                                    .addComponent(btnRemoveProdDep)))
                            .addComponent(lblProdDispoDep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdDep)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnlEditBeneficioDepLayout.setVerticalGroup(
            pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdDep, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProdDispoDep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditBeneficioDepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEditBeneficioDepLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnAddProdDep)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveProdDep)))
                .addGap(18, 18, 18)
                .addComponent(btnVoltarDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        tpDependente.addTab("Parametrizar Beneficio Dependente", pnlEditBeneficioDep);

        javax.swing.GroupLayout pnlCadDependenteLayout = new javax.swing.GroupLayout(pnlCadDependente);
        pnlCadDependente.setLayout(pnlCadDependenteLayout);
        pnlCadDependenteLayout.setHorizontalGroup(
            pnlCadDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpDependente)
        );
        pnlCadDependenteLayout.setVerticalGroup(
            pnlCadDependenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpDependente, javax.swing.GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
        );

        tpFuncionario.addTab("Cadastro Dependente", pnlCadDependente);

        tblProdAtivoFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblProdAtivoFunc);

        btnEditProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnEditProd.setText("Editar");
        btnEditProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBeneficiosLayout = new javax.swing.GroupLayout(pnlBeneficios);
        pnlBeneficios.setLayout(pnlBeneficiosLayout);
        pnlBeneficiosLayout.setHorizontalGroup(
            pnlBeneficiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBeneficiosLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditProd, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnlBeneficiosLayout.setVerticalGroup(
            pnlBeneficiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBeneficiosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlBeneficiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditProd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        tpFuncionario.addTab("Beneficios", pnlBeneficios);

        tblBenDispo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblBenDispo);

        tblBenFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblBenFunc);

        btnAdd.setText(">>");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("<<");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        lblProdDispo.setText("Produto Disponivel");

        lblProdFunc.setText("Produto Parametrizado");

        btnVoltarBen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnVoltarBen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarBenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditBenefLayout = new javax.swing.GroupLayout(pnlEditBenef);
        pnlEditBenef.setLayout(pnlEditBenefLayout);
        pnlEditBenefLayout.setHorizontalGroup(
            pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditBenefLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltarBen, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEditBenefLayout.createSequentialGroup()
                        .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditBenefLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnRemove)))
                            .addComponent(lblProdDispo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdFunc)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        pnlEditBenefLayout.setVerticalGroup(
            pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditBenefLayout.createSequentialGroup()
                .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditBenefLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdFunc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProdDispo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditBenefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEditBenefLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)))
                .addGap(18, 18, 18)
                .addComponent(btnVoltarBen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        tpFuncionario.addTab("Editar Beneficios", pnlEditBenef);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/Imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dptec/imagens/voltar2.png"))); // NOI18N
        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAcoesLayout = new javax.swing.GroupLayout(pnlAcoes);
        pnlAcoes.setLayout(pnlAcoesLayout);
        pnlAcoesLayout.setHorizontalGroup(
            pnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlAcoesLayout.setVerticalGroup(
            pnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnExcluir)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpFuncionario)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpFuncionario)
                .addContainerGap())
        );

        tpFuncionario.getAccessibleContext().setAccessibleName("Dados Funcionario");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mskCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskCPFActionPerformed

    private void mskDtExpedicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtExpedicaoActionPerformed
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtNasc.getText());
        if (v == 1) {
            mskDtNasc.setText("");
            mskDtNasc.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtExpedicaoActionPerformed

    private void mskDtAdmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtAdmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtAdmissaoActionPerformed

    private void mskDtDesligamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtDesligamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtDesligamentoActionPerformed

    private void mskDtExpedicaoRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtExpedicaoRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtExpedicaoRGActionPerformed

    private void btnAddDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDepActionPerformed
        tpFuncionario.remove(pnlDependente);
        tpFuncionario.add(pnlCadDependente, "Cadastrar Dependente", 6);
        tpFuncionario.setSelectedIndex(6);
        tpDependente.setSelectedIndex(0);
        tpDependente.remove(pnlEditBeneficioDep);
        tpDependente.remove(pnlBeneficioDep);
        mskCPFTit.setEnabled(false);
        txtMatriculaDep.setEnabled(false);
        txtNmTit.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        mskCPFDep.setEnabled(true);
        btnSalvarDep.setEnabled(true);
        btnAlterarDep.setEnabled(false);
    }//GEN-LAST:event_btnAddDepActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        FuncionarioController fc = new FuncionarioController(
                txtMatricula.getText().trim(),
                txtNmFunc.getText().trim(),
                mskTelRes.getText().trim(),
                mskTelCel.getText().trim(),
                mskTelCom.getText().trim(),
                mskRamal.getText().trim(),
                txtEmail.getText().trim(),
                txtEmailCom.getText().trim(),
                txtNmPai.getText().trim(),
                txtNmMae.getText().trim(),
                txtNascionalidade.getText().trim(),
                txtNaturalidade.getText().trim(),
                mskDtNasc.getText().trim(),
                cmbSexo.getSelectedItem().toString().trim(),
                cmbEstCivil.getSelectedItem().toString().trim(),
                txtNmConjuge.getText().trim(),
                cmbNecEspecial.getSelectedItem().toString().trim(),
                txtNCTPS.getText().trim(),
                txtSerieCTPS.getText().trim(),
                cmbUFCTPS.getSelectedItem().toString().trim(),
                mskDtExpedicao.getText().trim(),
                txtPISPASEP.getText().trim(),
                txtRG.getText().trim(),
                cmbOrgExp.getSelectedItem().toString().trim(),
                mskDtExpedicaoRG.getText().trim(),
                mskCPF.getText().trim(),
                txtTitEleitoral.getText().trim(),
                txtZonaEleitoral.getText().trim(),
                txtSecaoEleitoral.getText().trim(),
                txtNReservista.getText().trim(),
                txtRA.getText().trim(),
                txtSerieReservista.getText().trim(),
                mskDtAdmissao.getText().trim(),
                mskDtDesligamento.getText().trim(),
                cmbCargo.getSelectedItem().toString(),
                cmbDepartamento.getSelectedItem().toString(),
                cmbTipo.getSelectedItem().toString().trim(),
                mskCEP.getText().trim(),
                txtNumero.getText().trim(),
                txtComplemento.getText().trim(),
                cmbStatus.getSelectedItem().toString().trim(),
                "I",
                cduser,
                cmbTpConta.getSelectedItem().toString().trim(),
                cmbNmBanco.getSelectedItem().toString().trim(),
                txtAgencia.getText().trim(),
                txtNoConta.getText().trim(),
                txtDigito.getText().trim(),
                cmbStatusFinancas.getSelectedItem().toString().trim(),
                txtSalario.getText().trim().replace(",", "."),
                cmbEmpresa.getSelectedItem().toString().trim()
        );
        JOptionPane.showMessageDialog(null, fc.incluiNovoFuncionario());
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void mskCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskCEPActionPerformed
        EnderecoModel em = new EnderecoModel();
        em.setNocep(mskCEP.getText().replace(".", "").replace("-", "").trim());
        EnderecoDao ed = new EnderecoDao();
        List<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
        listaEndereco = ed.getListaEndereco(em);
        if (listaEndereco.size() > 0) {
            for (EnderecoModel sLocal : listaEndereco) {
                try {
                    mskCEP.setText(sLocal.getNocep());
                    cmbUFEnd.setSelectedItem(sLocal.getSguf());
                    txtBairro.setText(sLocal.getNbairro());
                    txtCidade.setText(sLocal.getNcidade());
                    txtEndereco.setText(sLocal.getNlogradouro());
                    txtPais.setText(sLocal.getNmpais());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
                }
            }
        } else {
            EnderecoController ec = new EnderecoController(
                    mskCEP.getText().replace(".", "").replace("-", "").trim(),
                    txtEndereco.getText().trim(),
                    txtBairro.getText().trim(),
                    txtCidade.getText().trim(),
                    cmbUFEnd.getSelectedItem().toString().trim(),
                    txtPais.getText().trim()
            );
            JOptionPane.showMessageDialog(null, ec.incluiNovoEndereco());
        }
    }//GEN-LAST:event_mskCEPActionPerformed

    private void btnBuscaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCEPActionPerformed
        tpFuncionario.remove(pnlDContato);
        tpFuncionario.add(pnlBuscaEnd, "Busca Endereço", 3);
        tpFuncionario.setSelectedIndex(3);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);
    }//GEN-LAST:event_btnBuscaCEPActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        Empty();
        FuncionarioModel fm = new FuncionarioModel();
        fm.setCdmatricula(Integer.parseInt(txtMatricula.getText().replace(".", "").replace(",", "".replace("-", "")).trim()));
        FuncionarioDao3 fd = new FuncionarioDao3();
        List<FuncionarioModel> listaFuncionario = new ArrayList<FuncionarioModel>();
        listaFuncionario = fd.getListaFunc(fm);
        if (listaFuncionario.size() > 0) {
            op = "U";
            loadOp(op);
            for (FuncionarioModel fLocal : listaFuncionario) {
                txtMatricula.setText(String.valueOf(fLocal.getCdmatricula()));
                txtMatriculaDep.setText(String.valueOf(fLocal.getCdmatricula()));
                txtNmFunc.setText(fLocal.getNmfuncionario());
                txtNmTit.setText(fLocal.getNmfuncionario());
                mskTelRes.setText(String.valueOf(fLocal.getNotelefone()));
                mskTelCel.setText(String.valueOf(fLocal.getNotelcelular()));
                mskTelCom.setText(String.valueOf(fLocal.getNotelcomercial()));
                mskRamal.setText(String.valueOf(fLocal.getNoramal()));
                txtEmail.setText(fLocal.getDsemail());
                txtEmailCom.setText(fLocal.getDsemailcom());
                txtNmMae.setText(fLocal.getNmmae());
                txtNmPai.setText(fLocal.getNmpai());
                txtNascionalidade.setText(fLocal.getDsnacionalidade());
                txtNaturalidade.setText(fLocal.getDsnaturalidade());
                mskDtNasc.setText(fLocal.getDtnascimento().replace("/", "-"));
                cmbSexo.setSelectedItem(fLocal.getDssexo());
                cmbEstCivil.setSelectedItem(fLocal.getDsestadocivil());
                txtNmConjuge.setText(fLocal.getNmconjuge());
                cmbNecEspecial.setSelectedItem(fLocal.getDsnecespecial());
                txtNCTPS.setText(String.valueOf(fLocal.getNoctps()));
                txtSerieCTPS.setText(String.valueOf(fLocal.getNoseriectps()));
                cmbUFCTPS.setSelectedItem(fLocal.getSgufctps());
                mskDtExpedicao.setText(fLocal.getDtexpctps().replace("/", "-"));
                txtPISPASEP.setText(String.valueOf(fLocal.getNopis()));
                txtRG.setText(String.valueOf(fLocal.getNorg()));
                cmbOrgExp.setSelectedItem(fLocal.getDsorgexprg());
                mskDtExpedicaoRG.setText(fLocal.getDtexperg().replace("/", "-"));
                mskCPF.setText(fLocal.getNocpf());
                mskCPFTit.setText(fLocal.getNocpf());
                txtTitEleitoral.setText(fLocal.getNotiteleitor());
                txtZonaEleitoral.setText(String.valueOf(fLocal.getNozona()));
                txtSecaoEleitoral.setText(String.valueOf(fLocal.getNosecao()));
                txtNReservista.setText(String.valueOf(fLocal.getNoreservista()));
                txtRA.setText(String.valueOf(fLocal.getNorareservista()));
                txtSerieReservista.setText(fLocal.getSgseriereservista());
                mskDtAdmissao.setText(fLocal.getDtadmissao().replace("/", "-"));
                if (fLocal.getDtdesligamento() != null) {
                    mskDtDesligamento.setText(fLocal.getDtdesligamento().replace("/", "-"));

                    btnExcluir.setEnabled(false);
                    btnAlterar.setEnabled(false);
                    btnIncluiEscolaridade.setEnabled(false);
                    btnIncluiProfiss.setEnabled(false);
                    btnIncluiCurso.setEnabled(false);
                    btnAddDep.setEnabled(false);
                    btnEditProd.setEnabled(false);

                    tblDependente.setEnabled(false);
                    tblCursos.setEnabled(false);
                    tblDadoProf.setEnabled(false);
                    tblEscolaridade.setEnabled(false);

                    JOptionPane.showMessageDialog(null, "Funcionario não pode ser Editado, o mesmo foi desligado em " + fLocal.getDtdesligamento());
                } else {
                    btnExcluir.setEnabled(true);
                    btnAlterar.setEnabled(true);
                    btnIncluiEscolaridade.setEnabled(true);
                    btnIncluiProfiss.setEnabled(true);
                    btnIncluiCurso.setEnabled(true);
                    btnAddDep.setEnabled(true);
                    btnEditProd.setEnabled(true);

                    tblDependente.setEnabled(true);
                    tblCursos.setEnabled(true);
                    tblDadoProf.setEnabled(true);
                    tblEscolaridade.setEnabled(true);
                }
                cmbCargo.setSelectedItem(fLocal.getDscargo());
                cmbDepartamento.setSelectedItem(fLocal.getDsdepartamento());
                txtCCusto.setText(fLocal.getCentrocusto());
                txtCargoGestor.setText(fLocal.getDscargogestor());
                txtNmGestor.setText(fLocal.getNmgestor());
                cmbTipo.setSelectedItem(fLocal.getTpcontrato());
                mskCEP.setText(String.valueOf(fLocal.getNocep()));
                mskCEP.setText(fLocal.getNocep());
                cmbUFEnd.setSelectedItem(fLocal.getSgufendereco());
                txtBairro.setText(fLocal.getNmbairro());
                txtCidade.setText(fLocal.getNmcidade());
                txtEndereco.setText(fLocal.getNmlogradouro());
                txtPais.setText(fLocal.getNmpais());
                txtNumero.setText(fLocal.getNoendereco());
                txtComplemento.setText(fLocal.getNmcomplemento());
                cmbStatus.setSelectedItem(fLocal.getDsstatus());
                cmbEmpresa.setSelectedItem(fLocal.getNmempresa());

                //Preenche o form Curriculo
                txtMatriculaCur.setText(String.valueOf(fLocal.getCdmatricula()));
                txtNmFuncionarioCur.setText(fLocal.getNmfuncionario());

                CurriculoController cc = new CurriculoController(
                        0,// int cdcurricular;
                        Integer.parseInt(txtMatricula.getText().trim()),//int cdmatricula;
                        null,//String dscategoria;
                        null,//String nmlocal;
                        null,//String dscurricular;
                        null,//String dtinicio;
                        null,//String dtconclusao;
                        null,//String dsstatus;
                        "B",// String op;                
                        cduser// int cduser;
                );

                DefaultTableModel dtmEscolar = (DefaultTableModel) tblEscolaridade.getModel();
                DefaultTableModel dtmProfis = (DefaultTableModel) tblDadoProf.getModel();
                DefaultTableModel dtmCurso = (DefaultTableModel) tblCursos.getModel();
                List<CurriculoModel> groupCur = new ArrayList<CurriculoModel>();
                groupCur = cc.listCurriculo();

                if (groupCur.size() > 0) {
                    for (CurriculoModel cmeLocal : groupCur) {
                        if ("Formação Escolar".equals(cmeLocal.getDscategoria())) {
                            dtmEscolar.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                        if ("Experiencia Profissional".equals(cmeLocal.getDscategoria())) {
                            dtmProfis.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                        if ("Cursos".equals(cmeLocal.getDscategoria())) {
                            dtmCurso.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                    }
                }

                loadBen();

                DefaultTableModel dtmDependente = (DefaultTableModel) tblDependente.getModel();
                DependenteModel dpndm = new DependenteModel();
                dpndm.setMatricula(fLocal.getCdmatricula());
                DependenteDao dpntm = new DependenteDao();
                List<DependenteModel> listaDependente = new ArrayList<DependenteModel>();
                listaDependente = dpntm.getListaDependente(dpndm);
                if (listaDependente.size() > 0) {
                    for (DependenteModel dpdnt : listaDependente) {
                        dtmDependente.addRow(new Object[]{
                            dpdnt.getCdDependente(),
                            dpdnt.getNomeDep(),
                            dpdnt.getCpfDep(),
                            dpdnt.getParentesco(),});
                    }
                }
                FinancasModel fnm = new FinancasModel();
                fnm.setMatricula(fLocal.getCdmatricula());
                FinancasDao fnmd = new FinancasDao();
                List<FinancasModel> listaFinanca = new ArrayList<FinancasModel>();
                listaFinanca = fnmd.getListaFincanca(fnm);
                if (listaFinanca.size() > 0) {
                    for (FinancasModel fmdl : listaFinanca) {
                        cmbTpConta.setSelectedItem(fmdl.getTpconta());
                        cmbNmBanco.setSelectedItem(fmdl.getDsbanco());
                        txtAgencia.setText(fmdl.getNoagencia());
                        txtNoConta.setText(fmdl.getNoconta());
                        txtDigito.setText(String.valueOf(fmdl.getNodigito()));
                        txtSalario.setText(String.valueOf(fmdl.getVlsalario()).replace(".", ","));
                        cmbStatusFinancas.setSelectedItem(fmdl.getDsstatus());
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Matricula não Cadastrada!");
            Empty();
        }
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        if ("Selecionar".equals(cmbDepartamento.getSelectedItem())) {
            txtCCusto.setText("");
            txtNmGestor.setText("");
            txtCargoGestor.setText("");
        } else {
            DepartamentoModel dm = new DepartamentoModel();
            dm.setDsdepartamento(String.valueOf(cmbDepartamento.getSelectedItem()));
            DepartamentoDao dd = new DepartamentoDao();
            List<DepartamentoModel> listaDep = new ArrayList<DepartamentoModel>();
            listaDep = dd.getListaDep(dm);
            if (listaDep.size() > 0) {
                for (DepartamentoModel dLocal : listaDep) {
                    txtCCusto.setText(dLocal.getCdccusto());
                    FuncionarioModel fm2 = new FuncionarioModel();
                    fm2.setCdmatricula(dLocal.getCdfuncionario());
                    FuncionarioDao3 fd2 = new FuncionarioDao3();
                    List<FuncionarioModel> listaGestorIm = new ArrayList<FuncionarioModel>();
                    listaGestorIm = fd2.getListaFunc(fm2);
                    if (listaGestorIm.size() > 0) {
                        for (FuncionarioModel f2Local : listaGestorIm) {
                            txtNmGestor.setText(f2Local.getNmfuncionario());
                            txtCargoGestor.setText(f2Local.getDscargo());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        FuncionarioController fc = new FuncionarioController(
                txtMatricula.getText().trim(),//.cdmatricula = cdmatricula;
                txtNmFunc.getText().trim(),//.nmfuncionario = nmfuncionario;
                mskTelRes.getText().trim(),//.notelefone = notelefone;
                mskTelCel.getText().trim(),//.notelcelular = notelcelular;
                mskTelCom.getText().trim(),//.notelcomercial = notelcomercial;
                mskRamal.getText().trim(),//.noramal = noramal;
                txtEmail.getText().trim(),//.dsemail = dsemail;
                txtEmailCom.getText().trim(),//.nmpai = nmpai;
                txtNmPai.getText().trim(),//.nmmae = nmmae;
                txtNmMae.getText().trim(),//.nmmae = nmmae;
                txtNascionalidade.getText().trim(),//.dsnacionalidade = dsnacionalidade;
                txtNaturalidade.getText().trim(),//.dsnaturalidade = dsnaturalidade;
                mskDtNasc.getText().trim(),//.dtnascimento = dtnascimento;
                cmbSexo.getSelectedItem().toString().trim(),//.dssexo = dssexo;
                cmbEstCivil.getSelectedItem().toString().trim(),//.cdestadocivil = cdestadocivil;
                txtNmConjuge.getText().trim(),//.nmconjuge = nmconjuge;
                cmbNecEspecial.getSelectedItem().toString().trim(),//.dsnecespecial = dsnecespecial;
                txtNCTPS.getText().trim(),//.noctps = noctps;
                txtSerieCTPS.getText().trim(),//.noseriectps = noseriectps;
                cmbUFCTPS.getSelectedItem().toString().trim(),//.sgufctps = sgufctps;
                mskDtExpedicao.getText().trim(),//.dtexpctps = dtexpctps;
                txtPISPASEP.getText().trim(),//.nopis = nopis;
                txtRG.getText().trim(),//.norg = norg;
                cmbOrgExp.getSelectedItem().toString().trim(),//.dsorgexprg = dsorgexprg;
                mskDtExpedicaoRG.getText().trim(),//.dtexpreg = dtexpreg;
                mskCPF.getText().trim(),//.nocpf = nocpf;
                txtTitEleitoral.getText().trim(),//.notiteleitor = notiteleitor;
                txtZonaEleitoral.getText().trim(),//.nozona = nozona;
                txtSecaoEleitoral.getText().trim(),//.nosecao = nosecao;
                txtNReservista.getText().trim(),//.noreservista = noreservista;
                txtRA.getText().trim(),//.norareservista = norareservista;
                txtSerieReservista.getText().trim(),//.sgseriereservista = sgseriereservista;
                mskDtAdmissao.getText().trim(),//.dtadmissao = dtadmissao;
                mskDtDesligamento.getText().trim(),//.dtdesligamento = dtdesligamento;
                cmbCargo.getSelectedItem().toString(),//.cdcargo = cdcargo;
                cmbDepartamento.getSelectedItem().toString(),//.cddepartamento = cddepartamento;
                cmbTipo.getSelectedItem().toString().trim(),//.tpcontrato = tpcontrato;
                mskCEP.getText().trim(),//.nocep = nocep;
                txtNumero.getText().trim(),//.noendereco = noendereco;
                txtComplemento.getText().trim(),//.nmcomplemento = nmcomplemento;
                cmbStatus.getSelectedItem().toString().trim(),//.status =  status;
                "U",
                cduser,
                cmbTpConta.getSelectedItem().toString().trim(), //String tpconta;
                cmbNmBanco.getSelectedItem().toString().trim(), //String nmbanco;
                txtAgencia.getText().trim(), //String noagencia;
                txtNoConta.getText().trim(), //String noconta;
                txtDigito.getText().trim(), //int nodigito;
                cmbStatusFinancas.getSelectedItem().toString().trim(), //String statusfin;
                txtSalario.getText().trim().replace(",", "."),//float vlsalario;
                cmbEmpresa.getSelectedItem().toString().trim() // String nmempresa;
        );
        JOptionPane.showMessageDialog(null, fc.incluiNovoFuncionario());
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        FuncionarioController fc = new FuncionarioController(
                txtMatricula.getText().trim(),//.cdmatricula = cdmatricula;
                txtNmFunc.getText().trim(),//.nmfuncionario = nmfuncionario;
                mskTelRes.getText().trim(),//.notelefone = notelefone;
                mskTelCel.getText().trim(),//.notelcelular = notelcelular;
                mskTelCom.getText().trim(),//.notelcomercial = notelcomercial;
                mskRamal.getText().trim(),//.noramal = noramal;
                txtEmail.getText().trim(),//.dsemail = dsemail;
                txtEmailCom.getText().trim(),//.nmpai = nmpai;
                txtNmPai.getText().trim(),//.nmmae = nmmae;
                txtNmMae.getText().trim(),//.nmmae = nmmae;
                txtNascionalidade.getText().trim(),//.dsnacionalidade = dsnacionalidade;
                txtNaturalidade.getText().trim(),//.dsnaturalidade = dsnaturalidade;
                mskDtNasc.getText().trim(),//.dtnascimento = dtnascimento;
                cmbSexo.getSelectedItem().toString().trim(),//.dssexo = dssexo;
                cmbEstCivil.getSelectedItem().toString().trim(),//.cdestadocivil = cdestadocivil;
                txtNmConjuge.getText().trim(),//.nmconjuge = nmconjuge;
                cmbNecEspecial.getSelectedItem().toString().trim(),//.dsnecespecial = dsnecespecial;
                txtNCTPS.getText().trim(),//.noctps = noctps;
                txtSerieCTPS.getText().trim(),//.noseriectps = noseriectps;
                cmbUFCTPS.getSelectedItem().toString().trim(),//.sgufctps = sgufctps;
                mskDtExpedicao.getText().trim(),//.dtexpctps = dtexpctps;
                txtPISPASEP.getText().trim(),//.nopis = nopis;
                txtRG.getText().trim(),//.norg = norg;
                cmbOrgExp.getSelectedItem().toString().trim(),//.dsorgexprg = dsorgexprg;
                mskDtExpedicaoRG.getText().trim(),//.dtexpreg = dtexpreg;
                mskCPF.getText().trim(),//.nocpf = nocpf;
                txtTitEleitoral.getText().trim(),//.notiteleitor = notiteleitor;
                txtZonaEleitoral.getText().trim(),//.nozona = nozona;
                txtSecaoEleitoral.getText().trim(),//.nosecao = nosecao;
                txtNReservista.getText().trim(),//.noreservista = noreservista;
                txtRA.getText().trim(),//.norareservista = norareservista;
                txtSerieReservista.getText().trim(),//.sgseriereservista = sgseriereservista;
                mskDtAdmissao.getText().trim(),//.dtadmissao = dtadmissao;
                mskDtDesligamento.getText().trim(),//.dtdesligamento = dtdesligamento;
                cmbCargo.getSelectedItem().toString(),//.cdcargo = cdcargo;
                cmbDepartamento.getSelectedItem().toString(),//.cddepartamento = cddepartamento;
                cmbTipo.getSelectedItem().toString().trim(),//.tpcontrato = tpcontrato;
                mskCEP.getText().trim(),//.nocep = nocep;
                txtNumero.getText().trim(),//.noendereco = noendereco;
                txtComplemento.getText().trim(),//.nmcomplemento = nmcomplemento;
                cmbStatus.getSelectedItem().toString().trim(),//.status =  status;
                "D",
                cduser,
                cmbTpConta.getSelectedItem().toString().trim(), //String tpconta;
                cmbNmBanco.getSelectedItem().toString().trim(), //String nmbanco;
                txtAgencia.getText().trim(), //String noagencia;
                txtNoConta.getText().trim(), //String noconta;
                txtDigito.getText().trim(), //int nodigito;
                cmbStatusFinancas.getSelectedItem().toString().trim(), //String statusfin;
                txtSalario.getText().trim().replace(",", "."),//float vlsalario;
                cmbEmpresa.getSelectedItem().toString().trim() // String nmempresa;
        );
        JOptionPane.showMessageDialog(null, fc.incluiNovoFuncionario());
        mskDtDesligamento.setText(getdate);
        cmbStatus.setSelectedItem("Desligado");
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnIncluiEscolaridade.setEnabled(false);
        btnIncluiProfiss.setEnabled(false);
        btnIncluiCurso.setEnabled(false);
        btnAddDep.setEnabled(false);

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        tpFuncionario.remove(pnlFuncIdentif);
        tpFuncionario.remove(pnlDocumentacao);
        tpFuncionario.remove(pnlContabil);
        tpFuncionario.remove(pnlDContato);
        tpFuncionario.remove(pnlDCurricular);
        tpFuncionario.remove(pnlContratual);
        tpFuncionario.remove(pnlDependente);
        tpFuncionario.remove(pnlBeneficios);
        tpFuncionario.remove(pnlEditBenef);
        
        tpFuncionario.add(pnlConsultaFunc, "Busca Funcionario", 0);
        tpFuncionario.setSelectedIndex(0);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnIncluiEscolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluiEscolaridadeActionPerformed
        tpFuncionario.remove(pnlDCurricular);
        tpFuncionario.add(pnlCadCuricular, "Cadastrar Escolaridade", 4);
        tpFuncionario.setSelectedIndex(4);
        cmbCategoriaCur.setSelectedItem("Formação Escolar");
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnAlterarCur.setEnabled(false);
        cmbCategoriaCur.setEnabled(false);
        txtMatriculaCur.setEnabled(false);
        txtNmFuncionarioCur.setEnabled(false);
        btnCadastraCur.setEnabled(true);
    }//GEN-LAST:event_btnIncluiEscolaridadeActionPerformed

    private void btnIncluiProfissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluiProfissActionPerformed
        tpFuncionario.remove(pnlDCurricular);
        tpFuncionario.add(pnlCadCuricular, "Cadastrar Dados Profissional", 4);
        tpFuncionario.setSelectedIndex(4);
        cmbCategoriaCur.setSelectedItem("Experiencia Profissional");
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnAlterarCur.setEnabled(false);
        cmbCategoriaCur.setEnabled(false);
        txtMatriculaCur.setEnabled(false);
        txtNmFuncionarioCur.setEnabled(false);
        btnCadastraCur.setEnabled(true);
    }//GEN-LAST:event_btnIncluiProfissActionPerformed

    private void btnIncluiCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluiCursoActionPerformed
        tpFuncionario.remove(pnlDCurricular);
        tpFuncionario.add(pnlCadCuricular, "Cadastrar Cursos", 4);
        tpFuncionario.setSelectedIndex(4);
        cmbCategoriaCur.setSelectedItem("Cursos");
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnAlterarCur.setEnabled(false);
        cmbCategoriaCur.setEnabled(false);
        txtMatriculaCur.setEnabled(false);
        txtNmFuncionarioCur.setEnabled(false);
        btnCadastraCur.setEnabled(true);
    }//GEN-LAST:event_btnIncluiCursoActionPerformed

    private void txtLogradouroBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroBuscaActionPerformed
        EnderecoController ec = new EnderecoController(
                mskCEPBusca.getText().replace(".", "").replace("-", "").trim(),
                txtLogradouroBusca.getText().trim(),
                txtBairroBusca.getText().trim(),
                txtCidadeBusca.getText().trim(),
                cmbUFBusca.getSelectedItem().toString().trim(),
                null
        );
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);

        List<EnderecoModel> groupEnd = new ArrayList<EnderecoModel>();
        groupEnd = ec.buscaEndereco();
        try {
            for (EnderecoModel gend : groupEnd) {
                dtmEndereco.addRow(new Object[]{
                    gend.getNocep(),
                    gend.getNlogradouro(),
                    gend.getNbairro(),
                    gend.getNcidade(),
                    gend.getSguf(),
                    gend.getNmpais()
                });
            }
        } catch (Exception e) {
            int opcao;
            Object[] options = {"Sim", "Não"};
            opcao = JOptionPane.showOptionDialog(null, "Endereço não Localizado! Realizar Nova Consulta?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                EmptyEnd();
                mskCEP.setFocusable(true);
            } else {
                tpFuncionario.remove(pnlBuscaEnd);
                tpFuncionario.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_txtLogradouroBuscaActionPerformed

    private void txtBairroBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroBuscaActionPerformed
        EnderecoController ec = new EnderecoController(
                mskCEPBusca.getText().replace(".", "").replace("-", "").trim(),
                txtLogradouroBusca.getText().trim(),
                txtBairroBusca.getText().trim(),
                txtCidadeBusca.getText().trim(),
                cmbUFBusca.getSelectedItem().toString().trim(),
                null
        );
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);

        List<EnderecoModel> groupEnd = new ArrayList<EnderecoModel>();
        groupEnd = ec.buscaEndereco();
        try {
            for (EnderecoModel gend : groupEnd) {
                dtmEndereco.addRow(new Object[]{
                    gend.getNocep(),
                    gend.getNlogradouro(),
                    gend.getNbairro(),
                    gend.getNcidade(),
                    gend.getSguf(),
                    gend.getNmpais()
                });
            }
        } catch (Exception e) {
            int opcao;
            Object[] options = {"Sim", "Não"};
            opcao = JOptionPane.showOptionDialog(null, "Endereço não Localizado! Realizar Nova Consulta?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                EmptyEnd();
                mskCEP.setFocusable(true);
            } else {
                tpFuncionario.remove(pnlBuscaEnd);
                tpFuncionario.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_txtBairroBuscaActionPerformed

    private void txtCidadeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeBuscaActionPerformed
        EnderecoController ec = new EnderecoController(
                mskCEPBusca.getText().replace(".", "").replace("-", "").trim(),
                txtLogradouroBusca.getText().trim(),
                txtBairroBusca.getText().trim(),
                txtCidadeBusca.getText().trim(),
                cmbUFBusca.getSelectedItem().toString().trim(),
                null
        );
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);

        List<EnderecoModel> groupEnd = new ArrayList<EnderecoModel>();
        groupEnd = ec.buscaEndereco();
        try {
            for (EnderecoModel gend : groupEnd) {
                dtmEndereco.addRow(new Object[]{
                    gend.getNocep(),
                    gend.getNlogradouro(),
                    gend.getNbairro(),
                    gend.getNcidade(),
                    gend.getSguf(),
                    gend.getNmpais()
                });
            }
        } catch (Exception e) {
            int opcao;
            Object[] options = {"Sim", "Não"};
            opcao = JOptionPane.showOptionDialog(null, "Endereço não Localizado! Realizar Nova Consulta?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                EmptyEnd();
                mskCEP.setFocusable(true);
            } else {
                tpFuncionario.remove(pnlBuscaEnd);
                tpFuncionario.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_txtCidadeBuscaActionPerformed

    private void cmbUFBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUFBuscaActionPerformed
        if (!cmbUFBusca.getSelectedItem().equals("Selecionar")) {
            EnderecoController ec = new EnderecoController(
                    mskCEPBusca.getText().replace(".", "").replace("-", "").trim(),
                    txtLogradouroBusca.getText().trim(),
                    txtBairroBusca.getText().trim(),
                    txtCidadeBusca.getText().trim(),
                    cmbUFBusca.getSelectedItem().toString().trim(),
                    null
            );
            DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
            dtmEndereco.setNumRows(0);

            List<EnderecoModel> groupEnd = new ArrayList<EnderecoModel>();
            groupEnd = ec.buscaEndereco();
            try {
                for (EnderecoModel gend : groupEnd) {
                    dtmEndereco.addRow(new Object[]{
                        gend.getNocep(),
                        gend.getNlogradouro(),
                        gend.getNbairro(),
                        gend.getNcidade(),
                        gend.getSguf(),
                        gend.getNmpais()
                    });
                }
            } catch (Exception e) {
                int opcao;
                Object[] options = {"Sim", "Não"};
                opcao = JOptionPane.showOptionDialog(null, "Endereço não Localizado! Realizar Nova Consulta?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (opcao == 0) {
                    EmptyEnd();
                    mskCEP.setFocusable(true);
                } else {
                    tpFuncionario.remove(pnlBuscaEnd);
                    tpFuncionario.setSelectedIndex(3);
                }
            }
        }
    }//GEN-LAST:event_cmbUFBuscaActionPerformed

    private void tblEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnderecoMouseClicked
        int i = tblEndereco.getSelectedRow();
        EnderecoModel em = new EnderecoModel();
        em.setNocep(tblEndereco.getValueAt(i, 0).toString());
        em.setNlogradouro(tblEndereco.getValueAt(i, 1).toString());
        em.setNbairro(tblEndereco.getValueAt(i, 2).toString());
        em.setNcidade(tblEndereco.getValueAt(i, 3).toString());
        em.setSguf(tblEndereco.getValueAt(i, 4).toString());
        em.setNmpais(tblEndereco.getValueAt(i, 5).toString());

        loadEnd(em);
        tpFuncionario.remove(pnlBuscaEnd);
        tpFuncionario.add(pnlDContato, "Contato", 3);
        tpFuncionario.setSelectedIndex(3);
        loadOp(op);
        EmptyEnd();
    }//GEN-LAST:event_tblEnderecoMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        tpFuncionario.remove(pnlBuscaEnd);
        tpFuncionario.add(pnlDContato, "Contato", 3);
        tpFuncionario.setSelectedIndex(3);
        loadOp(op);
        EmptyEnd();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void mskCEPBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskCEPBuscaActionPerformed
        EnderecoController ec = new EnderecoController(
                mskCEPBusca.getText().replace(".", "").replace("-", "").trim(),
                txtLogradouroBusca.getText().trim(),
                txtBairroBusca.getText().trim(),
                txtCidadeBusca.getText().trim(),
                cmbUFBusca.getSelectedItem().toString().trim(),
                null
        );
        DefaultTableModel dtmEndereco = (DefaultTableModel) tblEndereco.getModel();
        dtmEndereco.setNumRows(0);

        List<EnderecoModel> groupEnd = new ArrayList<EnderecoModel>();
        groupEnd = ec.buscaEndereco();
        try {
            for (EnderecoModel gend : groupEnd) {
                dtmEndereco.addRow(new Object[]{
                    gend.getNocep(),
                    gend.getNlogradouro(),
                    gend.getNbairro(),
                    gend.getNcidade(),
                    gend.getSguf(),
                    gend.getNmpais()
                });
            }
        } catch (Exception e) {
            int opcao;
            Object[] options = {"Sim", "Não"};
            opcao = JOptionPane.showOptionDialog(null, "Endereço não Localizado! Realizar Nova Consulta?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                EmptyEnd();
                mskCEP.setFocusable(true);
            } else {
                tpFuncionario.remove(pnlBuscaEnd);
                tpFuncionario.setSelectedIndex(3);
            }
        }
    }//GEN-LAST:event_mskCEPBuscaActionPerformed

    private void btnVoltarBFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarBFuncActionPerformed
        tpFuncionario.remove(pnlConsultaFunc);
        tpFuncionario.add(pnlFuncIdentif, "Identificação", 0);
        tpFuncionario.add(pnlDocumentacao, "Documentação", 1);
        tpFuncionario.add(pnlContabil, "Remuneração", 2);
        tpFuncionario.add(pnlDContato, "Contato", 3);
        tpFuncionario.add(pnlDCurricular, "Dado Curricular", 4);
        tpFuncionario.add(pnlContratual, "Dados Contratual", 5);
        tpFuncionario.add(pnlDependente, "Dependente", 6);
        tpFuncionario.add(pnlBeneficios, "Beneficio", 7);
        tpFuncionario.setSelectedIndex(0);
        loadOp(op);
        emptyBuscaFun();
    }//GEN-LAST:event_btnVoltarBFuncActionPerformed

    private void btnSalvarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDepActionPerformed
        try {
            DependenteController dc = new DependenteController(txtMatricula.getText(),
                    txtNmDep.getText().trim(),
                    cmbParentescoDep.getSelectedItem().toString().trim(),
                    cmbSexoDep.getSelectedItem().toString().trim(),
                    txtNacionalidadeDep.getText().trim(),
                    mskDtNascDep.getText().trim(),
                    cmbNecEspDep.getSelectedItem().toString().trim(),
                    txtNmMaeDep.getText().trim(),
                    mskCPFDep.getText().trim(),
                    txtRGDep.getText().trim(),
                    cmbOrgExpDep.getSelectedItem().toString().trim(),
                    mskDtExpedicaoRGDep.getText().trim(),
                    cmbStatusDep.getSelectedItem().toString().trim(),
                    cduser,
                    "I"
            );

            String msg = null;
            msg = dc.incluiNovoDependente();
            JOptionPane.showMessageDialog(null, msg);
            if (msg.equals("Dependente Cadastrado com Sucesso")) {
                DefaultTableModel dtmDependente = (DefaultTableModel) tblDependente.getModel();
                dtmDependente.setNumRows(0);
                List<DependenteModel> listaDependente = new ArrayList<DependenteModel>();
                listaDependente = dc.listaDependente();
                if (listaDependente.size() > 0) {
                    for (DependenteModel dpdnt : listaDependente) {
                        dtmDependente.addRow(new Object[]{
                            dpdnt.getCdDependente(),
                            dpdnt.getNomeDep(),
                            dpdnt.getCpfDep(),
                            dpdnt.getParentesco(),});
                    }
                }
                tpFuncionario.remove(pnlCadDependente);
                tpFuncionario.add(pnlDependente, "Dependente", 6);
                tpFuncionario.setSelectedIndex(6);
                emptyDep();
                loadOp(op);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }//GEN-LAST:event_btnSalvarDepActionPerformed

    private void btnCancelarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDepActionPerformed
        tpFuncionario.remove(pnlCadDependente);
        tpFuncionario.add(pnlDependente, "Dependente", 6);
        tpFuncionario.setSelectedIndex(6);
        emptyDep();
        loadOp(op);
    }//GEN-LAST:event_btnCancelarDepActionPerformed

    private void mskCPFTitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskCPFTitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskCPFTitActionPerformed

    private void mskCPFDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskCPFDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskCPFDepActionPerformed

    private void mskDtExpedicaoRGDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtExpedicaoRGDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtExpedicaoRGDepActionPerformed

    private void mskDtNascDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtNascDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtNascDepActionPerformed

    private void btnVoltarCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCurActionPerformed
        tpFuncionario.remove(pnlCadCuricular);
        tpFuncionario.add(pnlDCurricular, "Dados Curricular", 4);
        tpFuncionario.setSelectedIndex(4);
        loadOp(op);
        emptyCur();
    }//GEN-LAST:event_btnVoltarCurActionPerformed

    private void tblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMouseClicked
        Empty();
        int i = tblFuncionario.getSelectedRow();
        txtMatricula.setText(tblFuncionario.getValueAt(i, 0).toString());

        FuncionarioModel fm = new FuncionarioModel();
        fm.setCdmatricula(Integer.parseInt(txtMatricula.getText().replace(".", "").replace(",", "".replace("-", "")).trim()));
        FuncionarioDao3 fd = new FuncionarioDao3();
        List<FuncionarioModel> listaFuncionario = new ArrayList<FuncionarioModel>();
        listaFuncionario = fd.getListaFunc(fm);
        if (listaFuncionario.size() > 0) {
            op = "U";
            loadOp(op);
            for (FuncionarioModel fLocal : listaFuncionario) {
                txtMatricula.setText(String.valueOf(fLocal.getCdmatricula()));
                txtMatriculaDep.setText(String.valueOf(fLocal.getCdmatricula()));
                txtNmFunc.setText(fLocal.getNmfuncionario());
                txtNmTit.setText(fLocal.getNmfuncionario());
                mskTelRes.setText(String.valueOf(fLocal.getNotelefone()));
                mskTelCel.setText(String.valueOf(fLocal.getNotelcelular()));
                mskTelCom.setText(String.valueOf(fLocal.getNotelcomercial()));
                mskRamal.setText(String.valueOf(fLocal.getNoramal()));
                txtEmail.setText(fLocal.getDsemail());
                txtEmailCom.setText(fLocal.getDsemailcom());
                txtNmMae.setText(fLocal.getNmmae());
                txtNmPai.setText(fLocal.getNmpai());
                txtNascionalidade.setText(fLocal.getDsnacionalidade());
                txtNaturalidade.setText(fLocal.getDsnaturalidade());
                mskDtNasc.setText(fLocal.getDtnascimento().replace("/", "-"));
                cmbSexo.setSelectedItem(fLocal.getDssexo());
                cmbEstCivil.setSelectedItem(fLocal.getDsestadocivil());
                txtNmConjuge.setText(fLocal.getNmconjuge());
                cmbNecEspecial.setSelectedItem(fLocal.getDsnecespecial());
                txtNCTPS.setText(String.valueOf(fLocal.getNoctps()));
                txtSerieCTPS.setText(String.valueOf(fLocal.getNoseriectps()));
                cmbUFCTPS.setSelectedItem(fLocal.getSgufctps());
                mskDtExpedicao.setText(fLocal.getDtexpctps().replace("/", "-"));
                txtPISPASEP.setText(String.valueOf(fLocal.getNopis()));
                txtRG.setText(String.valueOf(fLocal.getNorg()));
                cmbOrgExp.setSelectedItem(fLocal.getDsorgexprg());
                mskDtExpedicaoRG.setText(fLocal.getDtexperg().replace("/", "-"));
                mskCPF.setText(fLocal.getNocpf());
                mskCPFTit.setText(fLocal.getNocpf());
                txtTitEleitoral.setText(fLocal.getNotiteleitor());
                txtZonaEleitoral.setText(String.valueOf(fLocal.getNozona()));
                txtSecaoEleitoral.setText(String.valueOf(fLocal.getNosecao()));
                txtNReservista.setText(String.valueOf(fLocal.getNoreservista()));
                txtRA.setText(String.valueOf(fLocal.getNorareservista()));
                txtSerieReservista.setText(fLocal.getSgseriereservista());
                mskDtAdmissao.setText(fLocal.getDtadmissao().replace("/", "-"));
                if (fLocal.getDtdesligamento() != null) {
                    mskDtDesligamento.setText(fLocal.getDtdesligamento().replace("/", "-"));

                    btnExcluir.setEnabled(false);
                    btnAlterar.setEnabled(false);
                    btnIncluiEscolaridade.setEnabled(false);
                    btnIncluiProfiss.setEnabled(false);
                    btnIncluiCurso.setEnabled(false);
                    btnAddDep.setEnabled(false);
                    btnEditProd.setEnabled(false);

                    tblDependente.setEnabled(false);
                    tblCursos.setEnabled(false);
                    tblDadoProf.setEnabled(false);
                    tblEscolaridade.setEnabled(false);

                    JOptionPane.showMessageDialog(null, "Funcionario não pode ser Editado, o mesmo foi desligado em " + fLocal.getDtdesligamento());
                } else {
                    btnExcluir.setEnabled(true);
                    btnAlterar.setEnabled(true);
                    btnIncluiEscolaridade.setEnabled(true);
                    btnIncluiProfiss.setEnabled(true);
                    btnIncluiCurso.setEnabled(true);
                    btnAddDep.setEnabled(true);
                    btnEditProd.setEnabled(true);

                    tblDependente.setEnabled(true);
                    tblCursos.setEnabled(true);
                    tblDadoProf.setEnabled(true);
                    tblEscolaridade.setEnabled(true);
                }
                cmbCargo.setSelectedItem(fLocal.getDscargo());
                cmbDepartamento.setSelectedItem(fLocal.getDsdepartamento());
                txtCCusto.setText(fLocal.getCentrocusto());
                txtCargoGestor.setText(fLocal.getDscargogestor());
                txtNmGestor.setText(fLocal.getNmgestor());
                cmbTipo.setSelectedItem(fLocal.getTpcontrato());
                mskCEP.setText(String.valueOf(fLocal.getNocep()));
                mskCEP.setText(fLocal.getNocep());
                cmbUFEnd.setSelectedItem(fLocal.getSgufendereco());
                txtBairro.setText(fLocal.getNmbairro());
                txtCidade.setText(fLocal.getNmcidade());
                txtEndereco.setText(fLocal.getNmlogradouro());
                txtPais.setText(fLocal.getNmpais());
                txtNumero.setText(fLocal.getNoendereco());
                txtComplemento.setText(fLocal.getNmcomplemento());
                cmbStatus.setSelectedItem(fLocal.getDsstatus());
                cmbEmpresa.setSelectedItem(fLocal.getNmempresa());

                //Preenche o form Curriculo
                txtMatriculaCur.setText(String.valueOf(fLocal.getCdmatricula()));
                txtNmFuncionarioCur.setText(fLocal.getNmfuncionario());

                CurriculoController cc = new CurriculoController(
                        0,// int cdcurricular;
                        Integer.parseInt(txtMatricula.getText().trim()),//int cdmatricula;
                        null,//String dscategoria;
                        null,//String nmlocal;
                        null,//String dscurricular;
                        null,//String dtinicio;
                        null,//String dtconclusao;
                        null,//String dsstatus;
                        "B",// String op;                
                        cduser// int cduser;
                );

                DefaultTableModel dtmEscolar = (DefaultTableModel) tblEscolaridade.getModel();
                DefaultTableModel dtmProfis = (DefaultTableModel) tblDadoProf.getModel();
                DefaultTableModel dtmCurso = (DefaultTableModel) tblCursos.getModel();
                List<CurriculoModel> groupCur = new ArrayList<CurriculoModel>();
                groupCur = cc.listCurriculo();

                if (groupCur.size() > 0) {
                    for (CurriculoModel cmeLocal : groupCur) {
                        if ("Formação Escolar".equals(cmeLocal.getDscategoria())) {
                            dtmEscolar.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                        if ("Experiencia Profissional".equals(cmeLocal.getDscategoria())) {
                            dtmProfis.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                        if ("Cursos".equals(cmeLocal.getDscategoria())) {
                            dtmCurso.addRow(new Object[]{
                                cmeLocal.getCdcurricular(),
                                cmeLocal.getDscategoria(),
                                cmeLocal.getNmlocal(),
                                cmeLocal.getDscurricular(),
                                cmeLocal.getDtinicio(),
                                cmeLocal.getDtconclusao(),
                                cmeLocal.getDsstatus()});
                        }
                    }
                }

                loadBen();

                DefaultTableModel dtmDependente = (DefaultTableModel) tblDependente.getModel();
                DependenteModel dpndm = new DependenteModel();
                dpndm.setMatricula(fLocal.getCdmatricula());
                DependenteDao dpntm = new DependenteDao();
                List<DependenteModel> listaDependente = new ArrayList<DependenteModel>();
                listaDependente = dpntm.getListaDependente(dpndm);
                if (listaDependente.size() > 0) {
                    for (DependenteModel dpdnt : listaDependente) {
                        dtmDependente.addRow(new Object[]{
                            dpdnt.getCdDependente(),
                            dpdnt.getNomeDep(),
                            dpdnt.getCpfDep(),
                            dpdnt.getParentesco(),});
                    }
                }

                FinancasModel fnm = new FinancasModel();
                fnm.setMatricula(fLocal.getCdmatricula());
                FinancasDao fnmd = new FinancasDao();
                List<FinancasModel> listaFinanca = new ArrayList<FinancasModel>();
                listaFinanca = fnmd.getListaFincanca(fnm);
                if (listaFinanca.size() > 0) {
                    for (FinancasModel fmdl : listaFinanca) {
                        cmbTpConta.setSelectedItem(fmdl.getTpconta());
                        cmbNmBanco.setSelectedItem(fmdl.getDsbanco());
                        txtAgencia.setText(fmdl.getNoagencia());
                        txtNoConta.setText(fmdl.getNoconta());
                        txtDigito.setText(String.valueOf(fmdl.getNodigito()));
                        txtSalario.setText(String.valueOf(fmdl.getVlsalario()).replace(".", ","));
                        cmbStatusFinancas.setSelectedItem(fmdl.getDsstatus());
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Matricula não Cadastrada!");
            Empty();
        }
        tpFuncionario.remove(pnlConsultaFunc);
        tpFuncionario.remove(pnlConsultaFunc);
        tpFuncionario.add(pnlFuncIdentif, "Identificação", 0);
        tpFuncionario.add(pnlDocumentacao, "Documentação", 1);
        tpFuncionario.add(pnlContabil, "Remuneração", 2);
        tpFuncionario.add(pnlDContato, "Contato", 3);
        tpFuncionario.add(pnlDCurricular, "Dado Curricular", 4);
        tpFuncionario.add(pnlContratual, "Dados Contratual", 5);
        tpFuncionario.add(pnlDependente, "Dependente", 6);
        tpFuncionario.add(pnlBeneficios, "Beneficio", 7);
        tpFuncionario.setSelectedIndex(0);

        emptyBuscaFun();
    }//GEN-LAST:event_tblFuncionarioMouseClicked

    private void btnPesquisarBFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarBFuncActionPerformed
        FuncionarioController fc = new FuncionarioController(
                txtMatriculaBFunc.getText().trim(),
                txtNomeBFunc.getText().trim(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                txtPISBFunc.getText().trim(),
                txtRGBFunc.getText().trim(),
                null,
                null,
                mskCPFBFunc.getText().trim(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                cmbCargoBFunc.getSelectedItem().toString(),
                cmbDepartamentoBFunc.getSelectedItem().toString(),
                null,
                null,
                null,
                null,
                cmbStatusBFunc.getSelectedItem().toString(),
                "B",
                cduser,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        DefaultTableModel dtmFunc = (DefaultTableModel) tblFuncionario.getModel();
        dtmFunc.setNumRows(0);

        List<FuncionarioModel> listFunc = new ArrayList<FuncionarioModel>();
        listFunc = fc.listFunc();
        if (listFunc.size() > 0) {
            for (FuncionarioModel groupFunc : listFunc) {
                dtmFunc.addRow(new Object[]{
                    groupFunc.getCdmatricula(),
                    groupFunc.getNmfuncionario(),
                    groupFunc.getNocpf(),
                    groupFunc.getDscargo(),
                    groupFunc.getDsdepartamento(),
                    groupFunc.getDsstatus(),
                    groupFunc.getDtadmissao()
                });
            }
        }

    }//GEN-LAST:event_btnPesquisarBFuncActionPerformed

    private void btnCadastraCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraCurActionPerformed
        CurriculoController cc = new CurriculoController(
                0,// int cdcurricular;
                Integer.parseInt(txtMatriculaCur.getText().trim()),//int cdmatricula;
                cmbCategoriaCur.getSelectedItem().toString(),//String dscategoria;
                txtLocalCur.getText().trim(),//String nmlocal;
                txtaDescricaoCur.getText().trim(),//String dscurricular;
                mskDtInicioCur.getText().trim(),//String dtinicio;
                mskDtTerminoCur.getText().trim(),//String dtconclusao;
                cmbStatusCur.getSelectedItem().toString(),//String dsstatus;
                "I",// String op;                
                cduser// int cduser;
        );
        String msg = null;
        msg = cc.dmlCurriculo();
        JOptionPane.showMessageDialog(null, msg);
        if (msg.equals("Curriculo Cadastrado com Sucesso")) {
            DefaultTableModel dtmEscolar = (DefaultTableModel) tblEscolaridade.getModel();
            dtmEscolar.setNumRows(0);
            DefaultTableModel dtmProfis = (DefaultTableModel) tblDadoProf.getModel();
            dtmProfis.setNumRows(0);
            DefaultTableModel dtmCurso = (DefaultTableModel) tblCursos.getModel();
            dtmCurso.setNumRows(0);
            List<CurriculoModel> groupCur = new ArrayList<CurriculoModel>();
            groupCur = cc.listCurriculo();

            if (groupCur.size() > 0) {
                for (CurriculoModel cmeLocal : groupCur) {
                    if ("Formação Escolar".equals(cmeLocal.getDscategoria())) {
                        dtmEscolar.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                    if ("Experiencia Profissional".equals(cmeLocal.getDscategoria())) {
                        dtmProfis.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                    if ("Cursos".equals(cmeLocal.getDscategoria())) {
                        dtmCurso.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                }
            }
            tpFuncionario.remove(pnlCadCuricular);
            tpFuncionario.add(pnlDCurricular, "Dados Curricular", 4);
            tpFuncionario.setSelectedIndex(4);
            loadOp(op);
            emptyCur();
        }
    }//GEN-LAST:event_btnCadastraCurActionPerformed

    private void btnAlterarCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCurActionPerformed
        CurriculoController cc = new CurriculoController(
                cdcur,// int cdcurricular;
                Integer.parseInt(txtMatriculaCur.getText().trim()),//int cdmatricula;
                cmbCategoriaCur.getSelectedItem().toString(),//String dscategoria;
                txtLocalCur.getText().trim(),//String nmlocal;
                txtaDescricaoCur.getText().trim(),//String dscurricular;
                mskDtInicioCur.getText().trim(),//String dtinicio;
                mskDtTerminoCur.getText().trim(),//String dtconclusao;
                cmbStatusCur.getSelectedItem().toString(),//String dsstatus;
                "U",// String op;                
                cduser// int cduser;
        );
        String msg = null;
        msg = cc.dmlCurriculo();
        JOptionPane.showMessageDialog(null, msg);
        if (msg.equals("Curriculo Alterado Com Sucesso")) {
            DefaultTableModel dtmEscolar = (DefaultTableModel) tblEscolaridade.getModel();
            dtmEscolar.setNumRows(0);
            DefaultTableModel dtmProfis = (DefaultTableModel) tblDadoProf.getModel();
            dtmProfis.setNumRows(0);
            DefaultTableModel dtmCurso = (DefaultTableModel) tblCursos.getModel();
            dtmCurso.setNumRows(0);
            List<CurriculoModel> groupCur = new ArrayList<CurriculoModel>();
            groupCur = cc.listCurriculo();

            if (groupCur.size() > 0) {
                for (CurriculoModel cmeLocal : groupCur) {
                    if ("Formação Escolar".equals(cmeLocal.getDscategoria())) {
                        dtmEscolar.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                    if ("Experiencia Profissional".equals(cmeLocal.getDscategoria())) {
                        dtmProfis.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                    if ("Cursos".equals(cmeLocal.getDscategoria())) {
                        dtmCurso.addRow(new Object[]{
                            cmeLocal.getCdcurricular(),
                            cmeLocal.getDscategoria(),
                            cmeLocal.getNmlocal(),
                            cmeLocal.getDscurricular(),
                            cmeLocal.getDtinicio(),
                            cmeLocal.getDtconclusao(),
                            cmeLocal.getDsstatus()});
                    }
                }
            }

            tpFuncionario.remove(pnlCadCuricular);
            tpFuncionario.add(pnlDCurricular, "Dados Curricular", 4);
            tpFuncionario.setSelectedIndex(4);
            loadOp(op);
            emptyCur();
        }
    }//GEN-LAST:event_btnAlterarCurActionPerformed

    private void tblEscolaridadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEscolaridadeMouseClicked
        int i = tblEscolaridade.getSelectedRow();
        //Se i for < 0 é porque a tbl esta desabilitada significa que o funcionario nao esta ativo
        if (i >= 0) {
            cdcur = (Integer.parseInt(tblEscolaridade.getValueAt(i, 0).toString()));
            cmbCategoriaCur.setSelectedItem(tblEscolaridade.getValueAt(i, 1).toString());
            txtLocalCur.setText(tblEscolaridade.getValueAt(i, 2).toString());
            txtaDescricaoCur.setText(tblEscolaridade.getValueAt(i, 3).toString());
            try {
                mskDtInicioCur.setText(tblEscolaridade.getValueAt(i, 4).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtInicioCur.setText("");
            }
            try {
                mskDtTerminoCur.setText(tblEscolaridade.getValueAt(i, 5).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtTerminoCur.setText("");
            }
            cmbStatusCur.setSelectedItem(tblEscolaridade.getValueAt(i, 6).toString());

            tpFuncionario.remove(pnlDCurricular);
            tpFuncionario.add(pnlCadCuricular, "Escolaridade", 4);
            tpFuncionario.setSelectedIndex(4);
            cmbCategoriaCur.setSelectedItem("Formação Escolar");
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnImprimir.setEnabled(false);
            btnCadastraCur.setEnabled(false);
            cmbCategoriaCur.setEnabled(false);
            txtMatriculaCur.setEnabled(false);
            txtNmFuncionarioCur.setEnabled(false);

            btnAlterarCur.setEnabled(true);
            loadOp(op);
        } else {
            JOptionPane.showMessageDialog(null, "Não é Possivel alterar dado de ex-Funcionario");
        }
    }//GEN-LAST:event_tblEscolaridadeMouseClicked

    private void tblDadoProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDadoProfMouseClicked
        int i = tblDadoProf.getSelectedRow();
        //Se i for < 0 é porque a tbl esta desabilitada significa que o funcionario nao esta ativo
        if (i >= 0) {
            cdcur = (Integer.parseInt(tblDadoProf.getValueAt(i, 0).toString()));
            cmbCategoriaCur.setSelectedItem(tblDadoProf.getValueAt(i, 1).toString());
            txtLocalCur.setText(tblDadoProf.getValueAt(i, 2).toString());
            txtaDescricaoCur.setText(tblDadoProf.getValueAt(i, 3).toString());
            try {
                mskDtInicioCur.setText(tblDadoProf.getValueAt(i, 4).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtInicioCur.setText("");
            }
            try {
                mskDtTerminoCur.setText(tblDadoProf.getValueAt(i, 5).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtTerminoCur.setText("");
            }
            cmbStatusCur.setSelectedItem(tblDadoProf.getValueAt(i, 6).toString());

            tpFuncionario.remove(pnlDCurricular);
            tpFuncionario.add(pnlCadCuricular, "Dados Profissionais", 4);
            tpFuncionario.setSelectedIndex(4);
            cmbCategoriaCur.setSelectedItem("Experiencia Profissional");
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnImprimir.setEnabled(false);
            btnCadastraCur.setEnabled(false);
            cmbCategoriaCur.setEnabled(false);
            txtMatriculaCur.setEnabled(false);
            txtNmFuncionarioCur.setEnabled(false);

            btnAlterarCur.setEnabled(true);
            loadOp(op);
        } else {
            JOptionPane.showMessageDialog(null, "Não é Possivel alterar dado de ex-Funcionario");
        }
    }//GEN-LAST:event_tblDadoProfMouseClicked

    private void tblCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMouseClicked
        int i = tblCursos.getSelectedRow();
        //Se i for < 0 é porque a tbl esta desabilitada significa que o funcionario nao esta ativo
        if (i >= 0) {
            cdcur = (Integer.parseInt(tblCursos.getValueAt(i, 0).toString()));
            cmbCategoriaCur.setSelectedItem(tblCursos.getValueAt(i, 1).toString());
            txtLocalCur.setText(tblCursos.getValueAt(i, 2).toString());
            txtaDescricaoCur.setText(tblCursos.getValueAt(i, 3).toString());
            try {
                mskDtInicioCur.setText(tblCursos.getValueAt(i, 4).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtInicioCur.setText("");
            }
            try {
                mskDtTerminoCur.setText(tblCursos.getValueAt(i, 5).toString().replace("/", "-"));
            } catch (Exception e) {
                mskDtTerminoCur.setText("");
            }
            cmbStatusCur.setSelectedItem(tblCursos.getValueAt(i, 6).toString());

            tpFuncionario.remove(pnlDCurricular);
            tpFuncionario.add(pnlCadCuricular, "Cursos", 4);
            tpFuncionario.setSelectedIndex(4);
            cmbCategoriaCur.setSelectedItem("Cursos");
            btnSalvar.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnImprimir.setEnabled(false);
            btnCadastraCur.setEnabled(false);
            cmbCategoriaCur.setEnabled(false);
            txtMatriculaCur.setEnabled(false);
            txtNmFuncionarioCur.setEnabled(false);

            btnAlterarCur.setEnabled(true);
            loadOp(op);
        } else {
            JOptionPane.showMessageDialog(null, "Não é Possivel alterar dado de ex-Funcionario");
        }
    }//GEN-LAST:event_tblCursosMouseClicked

    private void tblDependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDependenteMouseClicked
        try {
            int i = tblDependente.getSelectedRow();
            this.cddependente = Integer.parseInt(tblDependente.getValueAt(i, 0).toString().trim());
            //Se i for < 0 é porque a tbl esta desabilitada significa que o funcionario nao esta ativo
            if (i >= 0) {
                DependenteController dc = new DependenteController(
                        txtMatricula.getText(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        tblDependente.getValueAt(i, 2).toString().trim(),
                        null,
                        null,
                        null,
                        null,
                        cduser,
                        "B"
                );
                List<DependenteModel> groupDep = new ArrayList<DependenteModel>();
                groupDep = dc.loadDependente();
                if (groupDep != null) {
                    for (DependenteModel gp : groupDep) {
                        cmbStatusDep.setSelectedItem(gp.getDsstatus());
                        txtNmDep.setText(gp.getNomeDep());
                        cmbParentescoDep.setSelectedItem(gp.getParentesco());
                        cmbSexoDep.setSelectedItem(gp.getSexo());
                        txtNacionalidadeDep.setText(gp.getNacionalidade());
                        mskDtNascDep.setText(gp.getDtNascimento().replace("/", "-"));
                        cmbNecEspDep.setSelectedItem(gp.getNcEspecial());
                        txtNmMaeDep.setText(gp.getNmMae());
                        mskCPFDep.setText(gp.getCpfDep());
                        txtRGDep.setText(gp.getRg());
                        cmbOrgExpDep.setSelectedItem(gp.getOrgExp());
                        mskDtExpedicaoRGDep.setText(gp.getDtExp().replace("/", "-"));
                    }
                    loadBenDep();
                    tpFuncionario.remove(pnlDependente);
                    tpFuncionario.add(pnlCadDependente, "Alterar Dependente", 6);
                    tpFuncionario.setSelectedIndex(6);
                    tpDependente.setSelectedIndex(0);
                    tpDependente.remove(pnlEditBeneficioDep);
                    tpFuncionario.remove(pnlDependente);
                    tpDependente.remove(pnlBeneficioDep);
                    tpDependente.add(pnlBeneficioDep, "Beneficio Dependente", 1);

                    tpDependente.setSelectedIndex(0);
                    mskCPFTit.setEnabled(false);
                    txtMatriculaDep.setEnabled(false);
                    txtNmTit.setEnabled(false);
                    btnSalvar.setEnabled(false);
                    btnAlterar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnBuscar.setEnabled(false);
                    btnImprimir.setEnabled(false);
                    btnSalvarDep.setEnabled(false);
                    btnAlterarDep.setEnabled(true);
                    mskCPFDep.setEnabled(false);
                    btnEditProdDep.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace());
        }
    }//GEN-LAST:event_tblDependenteMouseClicked

    private void btnAlterarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDepActionPerformed
        DependenteController dc = new DependenteController(txtMatricula.getText().trim(),
                txtNmDep.getText().trim(),
                cmbParentescoDep.getSelectedItem().toString().trim(),
                cmbSexoDep.getSelectedItem().toString().trim(),
                txtNacionalidadeDep.getText().trim(),
                mskDtNascDep.getText().trim(),
                cmbNecEspDep.getSelectedItem().toString().trim(),
                txtNmMaeDep.getText().trim(),
                mskCPFDep.getText().trim(),
                txtRGDep.getText().trim(),
                cmbOrgExpDep.getSelectedItem().toString().trim(),
                mskDtExpedicaoRGDep.getText().trim(),
                cmbStatusDep.getSelectedItem().toString().trim(),
                cduser,
                "U"
        );

        String msg = null;
        msg = dc.incluiNovoDependente();
        JOptionPane.showMessageDialog(null, msg);
        if (msg.equals("Dependente Alterado Com Sucesso")) {
            DefaultTableModel dtmDependente = (DefaultTableModel) tblDependente.getModel();
            dtmDependente.setNumRows(0);
            List<DependenteModel> listaDependente = new ArrayList<DependenteModel>();
            listaDependente = dc.listaDependente();
            if (listaDependente.size() > 0) {
                for (DependenteModel dpdnt : listaDependente) {
                    dtmDependente.addRow(new Object[]{
                        dpdnt.getCdDependente(),
                        dpdnt.getNomeDep(),
                        dpdnt.getCpfDep(),
                        dpdnt.getParentesco(),});
                }
            }
            tpFuncionario.remove(pnlCadDependente);
            tpFuncionario.add(pnlDependente, "Dependente", 6);
            tpFuncionario.setSelectedIndex(6);
            emptyDep();
            loadOp(op);
        }
    }//GEN-LAST:event_btnAlterarDepActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        JOptionPane.showMessageDialog(null, "Documento enviado para Impressão");
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void mskDtNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtNascActionPerformed

    }//GEN-LAST:event_mskDtNascActionPerformed

    private void mskDtNascKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mskDtNascKeyPressed

    }//GEN-LAST:event_mskDtNascKeyPressed

    private void mskDtNascKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mskDtNascKeyTyped

    }//GEN-LAST:event_mskDtNascKeyTyped

    private void mskDtNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtNascFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtNasc.getText());
        if (v == 1) {
            mskDtNasc.setText("");
            mskDtNasc.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtNascFocusLost

    private void mskDtInicioCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtInicioCurActionPerformed
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtNasc.getText());
        if (v == 1) {
            mskDtNasc.setText("");
            mskDtNasc.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtInicioCurActionPerformed

    private void mskDtTerminoCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mskDtTerminoCurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mskDtTerminoCurActionPerformed

    private void mskDtExpedicaoRGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtExpedicaoRGFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtExpedicaoRG.getText());
        if (v == 1) {
            mskDtExpedicaoRG.setText("");
            mskDtExpedicaoRG.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtExpedicaoRGFocusLost

    private void mskDtExpedicaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtExpedicaoFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtExpedicao.getText());
        if (v == 1) {
            mskDtExpedicao.setText("");
            mskDtExpedicao.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtExpedicaoFocusLost

    private void mskDtInicioCurFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtInicioCurFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtInicioCur.getText());
        if (v == 1) {
            mskDtInicioCur.setText("");
            mskDtInicioCur.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtInicioCurFocusLost

    private void mskDtTerminoCurFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtTerminoCurFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtTerminoCur.getText());
        if (v == 1) {
            mskDtTerminoCur.setText("");
            mskDtTerminoCur.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtTerminoCurFocusLost

    private void mskDtAdmissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtAdmissaoFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtAdmissao.getText());
        if (v == 1) {
            mskDtAdmissao.setText("");
            mskDtAdmissao.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtAdmissaoFocusLost

    private void mskDtDesligamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtDesligamentoFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtDesligamento.getText());
        if (v == 1) {
            mskDtDesligamento.setText("");
            mskDtDesligamento.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtDesligamentoFocusLost

    private void mskDtNascDepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtNascDepFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtNascDep.getText());
        if (v == 1) {
            mskDtNascDep.setText("");
            mskDtNascDep.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtNascDepFocusLost

    private void mskDtExpedicaoRGDepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mskDtExpedicaoRGDepFocusLost
        ValidaData vd = new ValidaData();
        int v = vd.valiaData(mskDtExpedicaoRGDep.getText());
        if (v == 1) {
            mskDtExpedicaoRGDep.setText("");
            mskDtExpedicaoRGDep.setFocusable(true);
        }
    }//GEN-LAST:event_mskDtExpedicaoRGDepFocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int x = 0;
        String msg = null;
        int i[] = tblBenDispo.getSelectedRows();
        int l = tblBenDispo.getSelectedRowCount();
        for (x = 0; x < l; x++) {
            if (i[x] > -1) {
                CestaProdController cpc = new CestaProdController(
                        Integer.parseInt(txtMatricula.getText().trim()),
                        0,
                        Integer.parseInt(tblBenDispo.getValueAt(i[x], 0).toString().trim()),
                        "I",
                        cduser,
                        "F"
                );
                msg = cpc.dmlProd();
            } else {
                JOptionPane.showMessageDialog(null, "Não é Possivel Editar Dado de Conta Inativa");
                break;
            }
        }
        if (msg != null) {
            loadBen();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int x = 0;
        String msg = null;
        int i[] = tblBenFunc.getSelectedRows();
        int l = tblBenFunc.getSelectedRowCount();
        for (x = 0; x < l; x++) {
            if (i[x] > -1) {
                CestaProdController cpc = new CestaProdController(
                        Integer.parseInt(txtMatricula.getText().trim()),
                        0,
                        Integer.parseInt(tblBenFunc.getValueAt(i[x], 0).toString().trim()),
                        "D",
                        cduser,
                        "F"
                );
                msg = cpc.dmlProd();
            } else {
                JOptionPane.showMessageDialog(null, "Não é Possivel Editar Dado de Conta Inativa");
                break;
            }
        }
        if (msg != null) {
            loadBen();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProdActionPerformed
        tpFuncionario.remove(pnlBeneficios);
        tpFuncionario.add(pnlEditBenef, "Parametrizar Produto", 7);
        tpFuncionario.setSelectedIndex(7);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnSalvarDep.setEnabled(true);
        btnAlterarDep.setEnabled(false);
    }//GEN-LAST:event_btnEditProdActionPerformed

    private void btnVoltarBenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarBenActionPerformed
        tpFuncionario.remove(pnlEditBenef);
        tpFuncionario.add(pnlBeneficios, "Beneficios", 7);
        tpFuncionario.setSelectedIndex(7);
        loadOp(op);
    }//GEN-LAST:event_btnVoltarBenActionPerformed

    private void btnEditProdDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProdDepActionPerformed
        tpDependente.remove(pnlBeneficioDep);
        tpDependente.add(pnlEditBeneficioDep, "Parametrizar Produto", 1);
        tpDependente.setSelectedIndex(1);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnImprimir.setEnabled(false);
        btnSalvarDep.setEnabled(true);
        btnAlterarDep.setEnabled(false);
    }//GEN-LAST:event_btnEditProdDepActionPerformed

    private void btnAddProdDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdDepActionPerformed
        int x = 0;
        String msg = null;
        int i[] = tblBenDispoDep.getSelectedRows();
        int l = tblBenDispoDep.getSelectedRowCount();

        for (x = 0; x < l; x++) {
            if (i[x] > -1) {
                CestaProdController cpc = new CestaProdController(
                        0,
                        cddependente,
                        Integer.parseInt(tblBenDispoDep.getValueAt(i[x], 0).toString().trim()),
                        "I",
                        cduser,
                        "D"
                );
                msg = cpc.dmlProd();
            } else {
                JOptionPane.showMessageDialog(null, "Não é Possivel Editar Dado de Conta Inativa");
                break;
            }
        }
        if (msg != null) {
            loadBenDep();
        }
    }//GEN-LAST:event_btnAddProdDepActionPerformed

    private void btnRemoveProdDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProdDepActionPerformed
        int x = 0;
        String msg = null;
        int i[] = tblBenDep.getSelectedRows();
        int l = tblBenDep.getSelectedRowCount();
        for (x = 0; x < l; x++) {
            if (i[x] > -1) {
                CestaProdController cpc = new CestaProdController(
                        0,
                        cddependente,
                        Integer.parseInt(tblBenDep.getValueAt(i[x], 0).toString().trim()),
                        "D",
                        cduser,
                        "D"
                );
                msg = cpc.dmlProd();
            } else {
                JOptionPane.showMessageDialog(null, "Não é Possivel Editar Dado de Conta Inativa");
                break;
            }
        }
        if (msg != null) {
            loadBenDep();
        }
    }//GEN-LAST:event_btnRemoveProdDepActionPerformed

    private void btnVoltarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarDepActionPerformed
        tpDependente.remove(pnlEditBeneficioDep);
        tpDependente.add(pnlBeneficioDep, "Beneficio", 1);
        tpDependente.setSelectedIndex(1);
        loadOp(op);
        btnSalvarDep.setEnabled(false);
        btnAlterarDep.setEnabled(true);
    }//GEN-LAST:event_btnVoltarDepActionPerformed

    private void tblDependenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDependenteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDependenteMouseEntered
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadFuncionarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    public javax.swing.JButton btnAddDep;
    private javax.swing.JButton btnAddProdDep;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarCur;
    private javax.swing.JButton btnAlterarDep;
    public javax.swing.JButton btnBuscaCEP;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastraCur;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarDep;
    private javax.swing.JButton btnEditProd;
    private javax.swing.JButton btnEditProdDep;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnIncluiCurso;
    private javax.swing.JButton btnIncluiEscolaridade;
    private javax.swing.JButton btnIncluiProfiss;
    private javax.swing.JButton btnPesquisarBFunc;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveProdDep;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarDep;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltarBFunc;
    private javax.swing.JButton btnVoltarBen;
    private javax.swing.JButton btnVoltarCur;
    private javax.swing.JButton btnVoltarDep;
    public javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbCargoBFunc;
    private javax.swing.JComboBox<String> cmbCategoriaCur;
    public javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbDepartamentoBFunc;
    public javax.swing.JComboBox<String> cmbEmpresa;
    public javax.swing.JComboBox<String> cmbEstCivil;
    public javax.swing.JComboBox<String> cmbNecEspDep;
    public javax.swing.JComboBox<String> cmbNecEspecial;
    public javax.swing.JComboBox<String> cmbNmBanco;
    public javax.swing.JComboBox<String> cmbOrgExp;
    public javax.swing.JComboBox<String> cmbOrgExpDep;
    public javax.swing.JComboBox<String> cmbParentescoDep;
    public javax.swing.JComboBox<String> cmbSexo;
    public javax.swing.JComboBox<String> cmbSexoDep;
    public javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatusBFunc;
    private javax.swing.JComboBox<String> cmbStatusCur;
    public javax.swing.JComboBox<String> cmbStatusDep;
    public javax.swing.JComboBox<String> cmbStatusFinancas;
    public javax.swing.JComboBox<String> cmbTipo;
    public javax.swing.JComboBox<String> cmbTpConta;
    private javax.swing.JComboBox<String> cmbUFBusca;
    public javax.swing.JComboBox<String> cmbUFCTPS;
    public javax.swing.JComboBox<String> cmbUFEnd;
    public javax.swing.JScrollPane dgvCursos;
    public javax.swing.JScrollPane dgvDadosProf;
    public javax.swing.JScrollPane dgvDep;
    public javax.swing.JScrollPane dgvEscolaridade;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JLabel lblAgencia;
    public javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblBairro1;
    public javax.swing.JLabel lblCCusto;
    private javax.swing.JLabel lblCEP;
    public javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPF1;
    private javax.swing.JLabel lblCPFDep;
    private javax.swing.JLabel lblCPFTit;
    public javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargo1;
    public javax.swing.JLabel lblCargoGestor;
    private javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblCep;
    public javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCidade1;
    public javax.swing.JLabel lblComplemento;
    public javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDadosDep;
    public javax.swing.JLabel lblDadosProf;
    private javax.swing.JLabel lblDadosTitular;
    public javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDepartamento1;
    public javax.swing.JLabel lblDependente;
    private javax.swing.JLabel lblDsCurricular;
    public javax.swing.JLabel lblDtAdmissao;
    public javax.swing.JLabel lblDtDesligamento;
    public javax.swing.JLabel lblDtExpedicaoCTPS;
    public javax.swing.JLabel lblDtExpedicaoRG;
    private javax.swing.JLabel lblDtExpedicaoRG1;
    private javax.swing.JLabel lblDtFim;
    private javax.swing.JLabel lblDtNasc;
    public javax.swing.JLabel lblEmail;
    public javax.swing.JLabel lblEmailCom;
    public javax.swing.JLabel lblEmpresa;
    public javax.swing.JLabel lblEndereco;
    public javax.swing.JLabel lblEscolaridade;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblLogradouro;
    public javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMatricula1;
    private javax.swing.JLabel lblMatricula2;
    private javax.swing.JLabel lblMatricula3;
    public javax.swing.JLabel lblNCTPS;
    public javax.swing.JLabel lblNReservista;
    private javax.swing.JLabel lblNacionalidade;
    public javax.swing.JLabel lblNascionalidade;
    public javax.swing.JLabel lblNaturalidade;
    private javax.swing.JLabel lblNecEsp;
    public javax.swing.JLabel lblNmBanco;
    public javax.swing.JLabel lblNmConjuge;
    private javax.swing.JLabel lblNmDep;
    public javax.swing.JLabel lblNmFunc;
    private javax.swing.JLabel lblNmFuncionario;
    public javax.swing.JLabel lblNmGestor;
    public javax.swing.JLabel lblNmMae;
    private javax.swing.JLabel lblNmMaeDep;
    public javax.swing.JLabel lblNmPai;
    private javax.swing.JLabel lblNmTit;
    public javax.swing.JLabel lblNoConta;
    private javax.swing.JLabel lblNome;
    public javax.swing.JLabel lblNumero;
    public javax.swing.JLabel lblOrgExp;
    private javax.swing.JLabel lblOrgExp1;
    private javax.swing.JLabel lblPIS;
    public javax.swing.JLabel lblPISPASEP;
    public javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblParentesco;
    private javax.swing.JLabel lblProdDep;
    private javax.swing.JLabel lblProdDispo;
    private javax.swing.JLabel lblProdDispoDep;
    private javax.swing.JLabel lblProdFunc;
    public javax.swing.JLabel lblRA;
    public javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblRG1;
    private javax.swing.JLabel lblRG2;
    public javax.swing.JLabel lblRamal;
    public javax.swing.JLabel lblSReservista;
    public javax.swing.JLabel lblSalario;
    public javax.swing.JLabel lblSecaoTitulo;
    public javax.swing.JLabel lblSerieCTPS;
    public javax.swing.JLabel lblSerieTitulo;
    public javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexo1;
    public javax.swing.JLabel lblStCivil;
    public javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus3;
    private javax.swing.JLabel lblStatusDep;
    public javax.swing.JLabel lblStatusFinanca;
    public javax.swing.JLabel lblTelCel;
    public javax.swing.JLabel lblTelCom;
    public javax.swing.JLabel lblTelRes;
    public javax.swing.JLabel lblTipo;
    public javax.swing.JLabel lblTitEleitor;
    public javax.swing.JLabel lblTpConta;
    private javax.swing.JLabel lblUF;
    public javax.swing.JLabel lblUFCTPS;
    public javax.swing.JLabel lblUFEnd;
    private javax.swing.JLabel lbldscTela;
    private javax.swing.JLabel lbldtInicio;
    public javax.swing.JLabel lbldtNasc;
    public javax.swing.JFormattedTextField mskCEP;
    private javax.swing.JFormattedTextField mskCEPBusca;
    public javax.swing.JFormattedTextField mskCPF;
    private javax.swing.JFormattedTextField mskCPFBFunc;
    public javax.swing.JFormattedTextField mskCPFDep;
    public javax.swing.JFormattedTextField mskCPFTit;
    public javax.swing.JFormattedTextField mskDtAdmissao;
    public javax.swing.JFormattedTextField mskDtDesligamento;
    public javax.swing.JFormattedTextField mskDtExpedicao;
    public javax.swing.JFormattedTextField mskDtExpedicaoRG;
    public javax.swing.JFormattedTextField mskDtExpedicaoRGDep;
    private javax.swing.JFormattedTextField mskDtInicioCur;
    public javax.swing.JFormattedTextField mskDtNasc;
    public javax.swing.JFormattedTextField mskDtNascDep;
    private javax.swing.JFormattedTextField mskDtTerminoCur;
    public javax.swing.JFormattedTextField mskRamal;
    public javax.swing.JFormattedTextField mskTelCel;
    public javax.swing.JFormattedTextField mskTelCom;
    public javax.swing.JFormattedTextField mskTelRes;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JPanel pnlBeneficioDep;
    private javax.swing.JPanel pnlBeneficios;
    private javax.swing.JPanel pnlBuscaEnd;
    private javax.swing.JPanel pnlCadCuricular;
    private javax.swing.JPanel pnlCadDependente;
    private javax.swing.JPanel pnlConsultaFunc;
    private javax.swing.JPanel pnlContabil;
    private javax.swing.JPanel pnlContratual;
    private javax.swing.JPanel pnlDContato;
    private javax.swing.JPanel pnlDCurricular;
    private javax.swing.JPanel pnlDependente;
    private javax.swing.JPanel pnlDependeteView;
    private javax.swing.JPanel pnlDocumentacao;
    private javax.swing.JPanel pnlEditBenef;
    private javax.swing.JPanel pnlEditBeneficioDep;
    private javax.swing.JPanel pnlFuncIdentif;
    public javax.swing.JPanel pnlImagem;
    private javax.swing.JTable tblBenDep;
    private javax.swing.JTable tblBenDispo;
    private javax.swing.JTable tblBenDispoDep;
    private javax.swing.JTable tblBenFunc;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblDadoProf;
    private javax.swing.JTable tblDependente;
    private javax.swing.JTable tblEndereco;
    private javax.swing.JTable tblEscolaridade;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTable tblProdAtivoDep;
    private javax.swing.JTable tblProdAtivoFunc;
    private javax.swing.JTabbedPane tpDependente;
    private javax.swing.JTabbedPane tpFuncionario;
    public javax.swing.JTextField txtAgencia;
    public javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairroBusca;
    public javax.swing.JTextField txtCCusto;
    public javax.swing.JTextField txtCargoGestor;
    public javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCidadeBusca;
    public javax.swing.JTextField txtComplemento;
    public javax.swing.JTextField txtDigito;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEmailCom;
    public javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLocalCur;
    private javax.swing.JTextField txtLogradouroBusca;
    public javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMatriculaBFunc;
    private javax.swing.JTextField txtMatriculaCur;
    public javax.swing.JTextField txtMatriculaDep;
    public javax.swing.JTextField txtNCTPS;
    public javax.swing.JTextField txtNReservista;
    public javax.swing.JTextField txtNacionalidadeDep;
    public javax.swing.JTextField txtNascionalidade;
    public javax.swing.JTextField txtNaturalidade;
    public javax.swing.JTextField txtNmConjuge;
    public javax.swing.JTextField txtNmDep;
    public javax.swing.JTextField txtNmFunc;
    private javax.swing.JTextField txtNmFuncionarioCur;
    public javax.swing.JTextField txtNmGestor;
    public javax.swing.JTextField txtNmMae;
    public javax.swing.JTextField txtNmMaeDep;
    public javax.swing.JTextField txtNmPai;
    public javax.swing.JTextField txtNmTit;
    public javax.swing.JTextField txtNoConta;
    private javax.swing.JTextField txtNomeBFunc;
    public javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPISBFunc;
    public javax.swing.JTextField txtPISPASEP;
    public javax.swing.JTextField txtPais;
    public javax.swing.JTextField txtRA;
    public javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtRGBFunc;
    public javax.swing.JTextField txtRGDep;
    public javax.swing.JTextField txtSalario;
    public javax.swing.JTextField txtSecaoEleitoral;
    public javax.swing.JTextField txtSerieCTPS;
    public javax.swing.JTextField txtSerieReservista;
    public javax.swing.JTextField txtTitEleitoral;
    public javax.swing.JTextField txtZonaEleitoral;
    private javax.swing.JTextArea txtaDescricaoCur;
    // End of variables declaration//GEN-END:variables
}
