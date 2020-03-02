package dptec.dao;

import dptec.model.FuncionarioModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDao3 {

    public List<FuncionarioModel> getListaFunc(FuncionarioModel lf) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = ("Select");
            strquery += (" * ");
            strquery += (" From vwConsultaFuncionario ");
            strquery += (" Where 1=1 ");
            if (!"".equals(lf.getNocpf()) && lf.getNocpf() != null) {
                strquery += (" and Func_no_CPF = " + lf.getNocpf() + "");
            }
            if (!"".equals(lf.getCdmatricula()) && lf.getCdmatricula() != 0) {
                strquery += (" and Func_cd_Matricula = " + lf.getCdmatricula() + "");
            }
            if (!"".equals(lf.getNmfuncionario()) && lf.getNmfuncionario() != null) {
                strquery += (" and Func_nm_Funcionario like '%" + lf.getNmfuncionario() + "%'");
            }
            if (!"".equals(lf.getNorg()) && lf.getNorg() != null) {
                strquery += (" and Func_no_RG = '" + lf.getNorg() + "'");
            }
            if (!"".equals(lf.getNopis()) && lf.getNopis() != null) {
                strquery += (" and Func_no_PIS = '" + lf.getNopis() + "'");
            }
            if (!"Selecionar".equals(lf.getDsdepartamento()) && lf.getDsdepartamento() != null) {
                strquery += (" and Dep_DS_DEPARTAMENTO = '" + lf.getDsdepartamento() + "'");
            }
            if (!"Selecionar".equals(lf.getDscargo()) && lf.getDscargo() != null) {
                strquery += (" and Carg_DS_CARGO = '" + lf.getDscargo() + "'");
            }
            if (!"Selecionar".equals(lf.getDsstatus()) && lf.getDsstatus() != null) {
                strquery += (" and Stat_DS_STATUS = '" + lf.getDsstatus() + "'");
            }

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();

            List<FuncionarioModel> listaFuncionario = new ArrayList<FuncionarioModel>();
            while (result.next()) {
                FuncionarioModel fm = new FuncionarioModel();
                fm.setCdmatricula(result.getInt("Func_cd_Matricula"));
                fm.setNmfuncionario(result.getString("Func_nm_Funcionario"));
                fm.setNotelefone(result.getString("Func_cno_Telefone"));
                fm.setNotelcelular(result.getString("Func_no_TelCelular")); //OverFlow Numerico
                fm.setNotelcomercial(result.getString("Func_no_TelComercial"));
                fm.setNoramal(result.getInt("Func_no_Ramal"));
                fm.setDsemail(result.getString("Func_ds_email"));
                fm.setDsemailcom(result.getString("Func_ds_emailCom")); //Coluna Invalida
                fm.setNmmae(result.getString("Func_nm_Mae"));
                fm.setNmpai(result.getString("Func_nm_Pai"));
                fm.setDsnacionalidade(result.getString("Func_ds_Nacionalidade"));
                fm.setDsnaturalidade(result.getString("Func_ds_Naturalidade"));
                fm.setDtnascimento(result.getString("Func_dt_Nascimento"));
                fm.setDssexo(result.getString("Func_ds_Sexo"));
                fm.setCdestadocivil(result.getInt("Func_cd_EstadoCivil"));
                fm.setDsestadocivil(result.getString("EstCivil_DS_ESTADOCIVIL"));//EstCivil_DS_ESTADOCIVIL
                fm.setNmconjuge(result.getString("Func_nm_Conjuge"));
                fm.setDsnecespecial(result.getString("Func_ds_NecesEspecial"));//Coluna Invalida
                fm.setNoctps(result.getInt("Func_no_CTPS"));
                fm.setNoseriectps(result.getInt("Func_no_Serie"));
                fm.setSgufctps(result.getString("Func_sg_UF_CTPS"));
                fm.setDtexpctps(result.getString("Func_dt_Expedicao"));
                fm.setNopis(result.getString("Func_no_PIS")); //OverFlow Numerico
                fm.setNorg(result.getString("Func_no_RG"));
                fm.setDsorgexprg(result.getString("Func_ds_OrgExp")); //Coluna Invalida
                fm.setDtexperg(result.getString("Func_dt_Expedicao_RG"));
                fm.setNocpf(result.getString("Func_no_CPF")); //OverFlow Numerico
                fm.setNotiteleitor(result.getString("Func_no_Tit_Eleitor")); //OverFlow Numerico
                fm.setNozona(result.getInt("Func_no_Zona"));
                fm.setNosecao(result.getInt("Func_no_Secao"));
                fm.setNoreservista(result.getInt("Func_no_Reservista")); //OverFlow Numerico
                fm.setNorareservista(result.getString("Func_no_RA_Reservista")); //OverFlow Numerico
                fm.setSgseriereservista(result.getString("Func_sg_Serie_Reservista"));
                fm.setDtadmissao(result.getString("Func_ts_Admissao"));
                fm.setDtdesligamento(result.getString("Func_ts_Desligamento"));
                fm.setCdcargo(result.getInt("Func_cd_Cargo"));
                fm.setDscargo(result.getString("Carg_DS_CARGO"));//Carg_DS_CARGO
                fm.setCddepartamento(result.getInt("Func_cd_Departamento"));
                fm.setDsdepartamento(result.getString("Dep_DS_DEPARTAMENTO"));//Dep_DS_DEPARTAMENTO
                fm.setCentrocusto(result.getString("Dep_CD_CCUSTO"));//Dep_CD_CCUSTO
                fm.setNmgestor(result.getString("Gest_NM_FUNCIONARIO"));//Dep_CD_MATRICULA
                fm.setDscargogestor(result.getString("Carg_Gestor"));                    //Dep_GestDS_DEPARTAMENTO
                fm.setTpcontrato(result.getString("Func_tp_Contrato")); // Coluna Invalida
                fm.setNocep(result.getString("Func_no_CEP"));
                fm.setNmlogradouro(result.getString("End_NM_LOGRADOURO"));//End_NM_LOGRADOURO
                fm.setNoendereco(result.getString("Func_no_Endereco"));
                fm.setNmcomplemento(result.getString("Func_nm_Complemento"));
                fm.setNmbairro(result.getString("End_NM_BAIRRO"));//End_NM_BAIRRO
                fm.setNmcidade(result.getString("End_NM_CIDADE"));//End_NM_CIDADE
                fm.setSgufendereco(result.getString("End_SG_UF"));//End_SG_UF
                fm.setNmpais(result.getString("End_NM_PAIS"));//End_NM_PAIS
                fm.setStatus(result.getInt("Func_cd_Status"));
                fm.setDsstatus(result.getString("Stat_DS_STATUS"));//Stat_DS_STATUS
                fm.setNmempresa(result.getString("emp_Empresa"));//Stat_DS_STATUS

                listaFuncionario.add(fm);
            }

            result.close();
            comando.close();
            conn.connect().close();
            return listaFuncionario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Funcionario: " + e.getMessage());
            return null;
        }
    }

    public List<FuncionarioModel> loadMatricFun(FuncionarioModel lf) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = ("Select");
            strquery += (" Func_cd_Matricula ");
            strquery += (" ,Func_nm_Funcionario ");
            strquery += (" ,Func_no_CPF ");
            strquery += (" From vwConsultaFuncionario ");
            strquery += (" Where  ");
            strquery += (" Func_cd_Matricula = " + lf.getCdmatricula());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();

            List<FuncionarioModel> listaFuncionario = new ArrayList<FuncionarioModel>();
            while (result.next()) {
                FuncionarioModel fm = new FuncionarioModel();
                fm.setCdmatricula(result.getInt("Func_cd_Matricula"));
                fm.setNmfuncionario(result.getString("Func_nm_Funcionario"));
                fm.setNocpf(result.getString("Func_no_CPF"));
                listaFuncionario.add(fm);
            }

            result.close();
            comando.close();
            conn.connect().close();
            return listaFuncionario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Matricula: " + e.getMessage());
            return null;
        }
    }

    public int loadMatricula() {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = ("Select");
            strquery += (" max(cd_matricula) + 1 as cd_Matricula ");
            strquery += (" From Funcionario ");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();
            int cdmatricula = 0;
            while (result.next()) {
                cdmatricula = (result.getInt("cd_Matricula"));
            }

            result.close();
            comando.close();
            conn.connect().close();
            return cdmatricula;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Nova Matricula: " + e.getMessage());
            return 0;
        }
    }

    public String insertFuncionario(FuncionarioModel f) {
        BancoDadosDao conn = new BancoDadosDao();
        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_Funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            cstm.setInt(1, f.getCdmatricula());
            cstm.setString(2, f.getNmfuncionario());
            cstm.setString(3, f.getNotelefone());
            cstm.setString(4, f.getNotelcelular());
            cstm.setString(5, f.getNotelcomercial());
            cstm.setInt(6, f.getNoramal());
            cstm.setString(7, f.getDsemail());
            cstm.setString(8, f.getDsemailcom());
            cstm.setString(9, f.getNmmae());
            cstm.setString(10, f.getNmpai());
            cstm.setString(11, f.getDsnacionalidade());
            cstm.setString(12, f.getDsnaturalidade());
            cstm.setString(13, f.getDtnascimento());
            cstm.setString(14, f.getDssexo());
            cstm.setInt(15, f.getCdestadocivil());
            cstm.setString(16, f.getNmconjuge());
            cstm.setString(17, f.getDsnecespecial());
            cstm.setInt(18, f.getNoctps());
            cstm.setInt(19, f.getNoseriectps());
            cstm.setString(20, f.getSgufctps());
            cstm.setString(21, f.getDtexpctps());
            cstm.setString(22, f.getNopis());
            cstm.setString(23, f.getNorg());
            cstm.setString(24, f.getDsorgexprg());
            cstm.setString(25, f.getDtexperg());
            cstm.setString(26, f.getNocpf());
            cstm.setString(27, f.getNotiteleitor());
            cstm.setInt(28, f.getNozona());
            cstm.setInt(29, f.getNosecao());
            cstm.setInt(30, f.getNoreservista());
            cstm.setString(31, f.getNorareservista());
            cstm.setString(32, f.getSgseriereservista());
            cstm.setString(33, f.getDtadmissao());
            cstm.setString(34, f.getDtdesligamento());
            cstm.setInt(35, f.getCdcargo());
            cstm.setInt(36, f.getCddepartamento());
            cstm.setString(37, f.getTpcontrato());
            cstm.setString(38, f.getNocep());
            cstm.setString(39, f.getNoendereco());
            cstm.setString(40, f.getNmcomplemento());
            cstm.setInt(41, f.getStatus());
            cstm.setString(42, f.getOp()); //Operacao
            cstm.setInt(43, f.getCduser()); //Usuario 
            cstm.setInt(44, f.getCdempresa());

            String msg = null;
            if (cstm.executeUpdate() > 0) {
                if (f.getOp().equals("I")) {
                    msg = "Funcionario Cadastrado com Sucesso";
                } else if (f.getOp().equals("U")) {
                    msg = "Funcionario Alterado Com Sucesso";
                } else {
                    msg = "Funcionario Excluido com Sucesso";
                }
            }
            cstm.close();
            conn.connect().close();
            return msg;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            return null;
        }
    }
}
