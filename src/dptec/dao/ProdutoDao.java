package dptec.dao;

import dptec.model.ProdutoModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDao {

    public List<ProdutoModel> listProduto(ProdutoModel lpm) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" p.cd_Produto ");
            strQuery += (" ,p.ds_produto ");
            strQuery += (" ,p.vl_Produto ");
            strQuery += (" ,p.pc_Produto ");
            strQuery += (" ,p.cd_Categoria ");
            strQuery += (" ,p.ic_Ativo ");
            strQuery += (" ,c.ds_Categoria ");
            strQuery += (" from Produto p ");
            strQuery += (" inner join Categoria c on c.cd_Categoria = p.cd_Categoria ");
            strQuery += (" Where  1 = 1 ");

            if (!"".equals(lpm.getCdproduto()) && lpm.getCdproduto() != 0) {
                strQuery += (" and  p.cd_Produto = " + lpm.getCdproduto());
            }
            if (!"".equals(lpm.getDsproduto()) && lpm.getDsproduto() != null) {
                strQuery += (" and p.ds_produto like '%" + lpm.getDsproduto() + "%'");
            }
            if (!"Selecionar".equals(lpm.getDscategoria()) && lpm.getDscategoria() != null) {
                strQuery += (" and c.ds_Categoria = '" + lpm.getDscategoria() + "'");
            }
            /*if (!"Selecionar".equals(lpm.getIcativo()) && lpm.getIcativo() != 0 )) {
                strQuery += (" and p.ic_Ativo = " + lpm.getIcativo());
            } else{*/
                strQuery += (" and p.ic_Ativo = 1 ");
            //}            

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<ProdutoModel> listProduto = new ArrayList<ProdutoModel>();
            while (result.next()) {
                ProdutoModel pm = new ProdutoModel();
                pm.setCdproduto(result.getInt("cd_Produto"));
                pm.setDsproduto(result.getString("ds_produto"));
                pm.setVlproduto(result.getFloat("vl_Produto"));
                pm.setPcproduto(result.getFloat("pc_Produto"));
                pm.setCdcategoria(result.getInt("cd_Categoria"));
                pm.setIcativo(result.getInt("ic_Ativo"));
                pm.setDscategoria(result.getString("ds_Categoria"));
                listProduto.add(pm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listProduto;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Produto: " + e.getMessage());
            return null;
        }
    }

    public String dmlProduto(ProdutoModel p) {
        BancoDadosDao conn = new BancoDadosDao();

        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_Produto(?,?,?,?,?,?,?,?)}")) {
            cstm.setInt(1, p.getCdproduto());
            cstm.setString(2, p.getDsproduto());
            cstm.setFloat(3, p.getVlproduto());
            cstm.setFloat(4, p.getPcproduto());
            cstm.setInt(5, p.getCdcategoria());
            cstm.setInt(6, p.getIcativo());
            cstm.setInt(7, p.getCduser());
            cstm.setString(8, p.getOp());

            String msg = null;
            if (cstm.executeUpdate() > 0) {
                if (p.getOp().equals("I")) {
                    msg = "Produto Cadastrado com Sucesso";
                } else if (p.getOp().equals("U")) {
                    msg = "Produto Alterado Com Sucesso";
                } else {
                    msg = "Produto Excluido com Sucesso";
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
