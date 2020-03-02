package dptec.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dptec.model.DependenteModel;

import javax.swing.JOptionPane;

public class DependenteDao {

    public List<DependenteModel> getListaDependenteNovo(DependenteModel d) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" d.cd_Dependente ");
            strQuery += (" ,d.cd_Matricula ");
            strQuery += (" ,d.nm_Dependente ");
            strQuery += (" ,d.ds_Sexo ");
            strQuery += (" ,d.ds_Parentesco ");
            strQuery += (" ,d.ds_Nacionalidade ");
            strQuery += (" ,convert(varchar(20),d.dt_Nascimento, 103) as dt_Nascimento ");
            strQuery += (" ,d.ds_NecesEspecial ");
            strQuery += (" ,d.nm_Mae ");
            strQuery += (" ,d.no_CPF ");
            strQuery += (" ,d.no_RG ");
            strQuery += (" ,d.ds_OrgExp ");
            strQuery += (" ,convert(varchar(20),d.dt_ExpRG, 103) as dt_ExpRG ");
            strQuery += (" ,d.cd_Status ");
            strQuery += (" ,s.ds_Status");
            strQuery += (" from Dependente d ");
            strQuery += (" inner join Status s on s.cd_Status = d.cd_Status");
            strQuery += (" where d.cd_Matricula = " + d.getMatricula());
            strQuery += (" and d.no_CPF = '" + d.getCpfDep() + "'");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery();

            List<DependenteModel> listaDeDependente = new ArrayList<DependenteModel>();

            while (resultado.next()) {
                DependenteModel dm = new DependenteModel();
                dm.setCdDependente(resultado.getInt("cd_Dependente"));
                dm.setMatricula(resultado.getInt("cd_Matricula"));
                dm.setNomeDep(resultado.getString("nm_Dependente"));
                dm.setSexo(resultado.getString("ds_Sexo"));
                dm.setParentesco(resultado.getString("ds_Parentesco"));
                dm.setNacionalidade(resultado.getString("ds_Nacionalidade"));
                dm.setDtNascimento(resultado.getString("dt_Nascimento"));
                dm.setNcEspecial(resultado.getString("ds_NecesEspecial"));
                dm.setNmMae(resultado.getString("nm_Mae"));
                dm.setCpfDep(resultado.getString("no_CPF"));
                dm.setRg(resultado.getString("no_RG"));
                dm.setOrgExp(resultado.getString("ds_OrgExp"));
                dm.setDtExp(resultado.getString("dt_ExpRG"));
                dm.setStatus(resultado.getInt("cd_Status"));
                dm.setDsstatus(resultado.getString("ds_Status"));
                listaDeDependente.add(dm);
            }
            resultado.close();
            comando.close();
            conn.connect().close();

            return listaDeDependente;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Dependente: " + e.getMessage());
            return null;
        }
    }

    public List<DependenteModel> getListaDependente(DependenteModel d) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = ("Select * from Dependente ");
            strQuery += (" where cd_Matricula = " + d.getMatricula());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery();

            List<DependenteModel> listaDeDependente = new ArrayList<DependenteModel>();

            while (resultado.next()) {
                DependenteModel dm = new DependenteModel();
                dm.setCdDependente(resultado.getInt("cd_Dependente"));
                dm.setMatricula(resultado.getInt("cd_Matricula"));
                dm.setNomeDep(resultado.getString("nm_Dependente"));
                dm.setSexo(resultado.getString("ds_Sexo"));
                dm.setParentesco(resultado.getString("ds_Parentesco"));
                dm.setNacionalidade(resultado.getString("ds_Nacionalidade"));
                dm.setDtNascimento(resultado.getString("dt_Nascimento"));
                dm.setNcEspecial(resultado.getString("ds_NecesEspecial"));
                dm.setNmMae(resultado.getString("nm_Mae"));
                dm.setCpfDep(resultado.getString("no_CPF"));
                dm.setRg(resultado.getString("no_RG"));
                dm.setOrgExp(resultado.getString("ds_OrgExp"));
                dm.setDtExp(resultado.getString("dt_ExpRG"));
                dm.setStatus(resultado.getInt("cd_Status"));
                listaDeDependente.add(dm);
            }
            resultado.close();
            comando.close();
            conn.connect().close();

            return listaDeDependente;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Dependente: " + e.getMessage());
            return null;
        }
    }

    public String InsertDependente(DependenteModel d) {
        BancoDadosDao conn = new BancoDadosDao();

        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_Dependente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            cstm.setInt(1, d.getCdDependente()); //vcdDependente
            cstm.setInt(2, d.getMatricula()); //vcdMatricula
            cstm.setString(3, d.getNomeDep());//vnmDependente
            cstm.setString(4, d.getSexo()); //vdsSexo
            cstm.setString(5, d.getParentesco()); //vdsParentesco
            cstm.setString(6, d.getNacionalidade()); //vdsNacionalidade
            cstm.setString(7, d.getDtNascimento()); //vdtNascimento
            cstm.setString(8, d.getNcEspecial());//vcdNecesEspecial
            cstm.setString(9, d.getNmMae());//vnmMae
            cstm.setString(10, d.getCpfDep());//vnoCPF
            cstm.setString(11, d.getRg());//vnoRG
            cstm.setString(12, d.getOrgExp());//vdsOrgExp
            cstm.setString(13, d.getDtExp());//vdtExpRG
            cstm.setInt(14, d.getStatus());//vcdStatus
            cstm.setInt(15, d.getCduser());//vcdUsuario
            cstm.setString(16, d.getOp());//vOp

            String msg = null;
            if (cstm.executeUpdate() > 0) {
                if (d.getOp().equals("I")) {
                    msg = "Dependente Cadastrado com Sucesso";
                } else if (d.getOp().equals("U")) {
                    msg = "Dependente Alterado Com Sucesso";
                } else {
                    msg = "Dependente Excluido com Sucesso";
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
