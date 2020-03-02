package dptec.dao;

import dptec.model.CurriculoModel;
import dptec.model.FuncionarioModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CurriculoDao {

    public List<CurriculoModel> getListCurriculoEscolar(CurriculoModel lce) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" DC.cd_Curricular ");
            strQuery += (" ,DC.cd_Matricula ");
            strQuery += (" ,F.nm_Funcionario ");
            strQuery += (" ,DC.cd_categoria ");
            strQuery += (" ,C.ds_categoria ");
            strQuery += (" ,DC.nm_Local ");
            strQuery += (" ,DC.ds_Curricular ");
            strQuery += (" ,convert(varchar(20), DC.dt_Inicio, 103) as dt_Inicio ");
            strQuery += (" ,convert(varchar(20), DC.dt_Conclusao, 103) as dt_Conclusao ");
            strQuery += (" ,DC.cd_Status ");
            strQuery += (" ,S.ds_Status ");
            strQuery += (" from DadosCurricular DC");
            strQuery += (" INNER JOIN Funcionario F on F.cd_Matricula = DC.cd_Matricula ");
            strQuery += (" INNER JOIN Categoria C on C.cd_Categoria = DC.cd_Categoria ");
            strQuery += (" INNER JOIN Status S on S.cd_Status = DC.cd_Status ");
            strQuery += (" Where DC.cd_Matricula = " + lce.getCdmatricula() + "");
            strQuery += (" or DC.cd_Curricular = " + lce.getCdcurricular() + "");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<CurriculoModel> listaCurriculo = new ArrayList<CurriculoModel>();
            while (result.next()) {
                CurriculoModel cm = new CurriculoModel();
                cm.setCdcurricular(result.getInt("cd_Curricular"));
                cm.setCdmatricula(result.getInt("cd_Matricula"));
                cm.setNmfuncionario(result.getString("nm_Funcionario"));
                cm.setCdcategoria(result.getInt("cd_categoria"));
                cm.setDscategoria(result.getString("ds_Categoria"));
                cm.setNmlocal(result.getString("nm_Local"));
                cm.setDscurricular(result.getString("ds_Curricular"));
                cm.setDtinicio(result.getString("dt_Inicio"));
                cm.setDtconclusao(result.getString("dt_Conclusao"));
                cm.setCdstatus(result.getInt("cd_Status"));
                cm.setDsstatus(result.getString("ds_Status"));
                listaCurriculo.add(cm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaCurriculo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Curriculo" + e.getMessage());
            return null;
        }
    }

    public String dmlCurriculo(CurriculoModel c) {
        BancoDadosDao conn = new BancoDadosDao();
        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_Curriculo(?,?,?,?,?,?,?,?,?,?)}")) {
            cstm.setInt(1, c.getCdcurricular());
            cstm.setInt(2, c.getCdmatricula());
            cstm.setInt(3, c.getCdcategoria());
            cstm.setString(4, c.getNmlocal());
            cstm.setString(5, c.getDscurricular());
            cstm.setString(6, c.getDtinicio());
            cstm.setString(7, c.getDtconclusao());
            cstm.setInt(8, c.getCdstatus());
            cstm.setString(9, c.getOp());
            cstm.setInt(10, c.getCduser());
            String msg = null;
            if (cstm.executeUpdate() > 0) {
                if (c.getOp().equals("I")) {
                    msg = "Curriculo Cadastrado com Sucesso";
                } else if (c.getOp().equals("U")) {
                    msg = "Curriculo Alterado Com Sucesso";
                } else {
                    msg = "Curriculo Excluido com Sucesso";
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
