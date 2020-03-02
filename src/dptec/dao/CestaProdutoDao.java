package dptec.dao;

import dptec.model.CargoModel;
import dptec.model.ProdutoModel;
import dptec.model.CestaProdModel;
import dptec.model.EnderecoModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CestaProdutoDao {

    public List<CestaProdModel> listCestaProdFunc(CestaProdModel lcpm) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" cpf.cd_CestaProduto ");
            strQuery += (" ,cpf.cd_Produto ");
            strQuery += (" ,cpf.cd_Matricula ");
            strQuery += (" ,cpf.dt_Inclusao ");
            strQuery += (" ,cpf.ic_Ativo ");
            strQuery += (" ,p.ds_produto ");
            strQuery += (" ,c.ds_Categoria ");
            strQuery += (" From CestaProdutoFuncionario cpf ");
            strQuery += (" inner join Produto p on p.cd_Produto = cpf.cd_Produto and cpf.ic_Ativo = 1 ");
            strQuery += (" inner join Categoria c on c.cd_Categoria = p.cd_Categoria ");
            strQuery += (" where cpf.cd_Matricula = " + lcpm.getCdmatricula());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<CestaProdModel> listCestaFunc = new ArrayList<CestaProdModel>();
            while (result.next()) {
                CestaProdModel cpm = new CestaProdModel();
                cpm.setCdcestaprod(result.getInt("cd_CestaProduto"));
                cpm.setCdproduto(result.getInt("cd_Produto"));
                cpm.setCdmatricula(result.getInt("cd_Matricula"));
                cpm.setDtinclusao(result.getString("dt_Inclusao"));
                cpm.setIcativo(result.getInt("ic_Ativo"));
                cpm.setDsproduto(result.getString("ds_produto"));
                cpm.setDscategoria(result.getString("ds_Categoria"));
                listCestaFunc.add(cpm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listCestaFunc;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Cesta de Produtos do Funcionario: " + e.getMessage());
            return null;
        }
    }

    public List<CestaProdModel> listCestaProdDep(CestaProdModel lcpm) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" cpd.cd_CestaBeneficio ");
            strQuery += (" ,cpd.cd_Produto ");
            strQuery += (" ,cpd.cd_Dependente ");
            strQuery += (" ,cpd.dt_Inclusao ");
            strQuery += (" ,cpd.ic_Ativo ");
            strQuery += (" ,p.ds_produto ");
            strQuery += (" ,c.ds_Categoria ");
            strQuery += (" From CestaProdutoDependente cpd ");
            strQuery += (" inner join Produto p on p.cd_Produto = cpd.cd_Produto and cpd.ic_Ativo = 1 ");
            strQuery += (" inner join Categoria c on c.cd_Categoria = p.cd_Categoria ");
            strQuery += (" where cpd.cd_Dependente = " + lcpm.getCddependente());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<CestaProdModel> listCestaFunc = new ArrayList<CestaProdModel>();
            while (result.next()) {
                CestaProdModel cpm = new CestaProdModel();
                cpm.setCdcestaprod(result.getInt("cd_CestaBeneficio"));
                cpm.setCdproduto(result.getInt("cd_Produto"));
                cpm.setCdmatricula(result.getInt("cd_Dependente"));
                cpm.setDtinclusao(result.getString("dt_Inclusao"));
                cpm.setIcativo(result.getInt("ic_Ativo"));
                cpm.setDsproduto(result.getString("ds_produto"));
                cpm.setDscategoria(result.getString("ds_Categoria"));
                listCestaFunc.add(cpm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listCestaFunc;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Cesta de Produtos do Dependente: " + e.getMessage());
            return null;
        }
    }

    public String dmlProdCestaProd(CestaProdModel cpm) {
        BancoDadosDao conn = new BancoDadosDao();
        
        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_CestaProduto(?,?,?,?,?,?)}")) {
            cstm.setInt(1, cpm.getCdproduto());
            cstm.setInt(2, cpm.getCdmatricula());
            cstm.setInt(3, cpm.getCddependente());
            cstm.setString(4, cpm.getTp());
            cstm.setInt(5, cpm.getCduser());
            cstm.setString(6, cpm.getOp());

            String msg = null;
            if (cstm.executeUpdate() > 0) {
                msg = "Produto Vinculao com Sucesso";
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
