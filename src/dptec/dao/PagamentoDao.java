package dptec.dao;

import dptec.model.DetalPagamentoModel;
import dptec.model.FolhaPontoModel;
import dptec.model.PagamentoModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagamentoDao {

    public List<PagamentoModel> getListaPagamento(PagamentoModel lp) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;

            if (lp.getDscategoria() == null) {
                strQuery = (" select ");
                strQuery += (" * ");
                strQuery += (" from vwPagamento ");
                strQuery += (" Where ");
                strQuery += (" month(dt_Referencia) = " + lp.getMes());
                strQuery += (" and Year(dt_Referencia) = " + lp.getAno());
                strQuery += (" and cd_matricula = " + lp.getCdmatricula());
            } else {
                strQuery = (" select ");
                strQuery += (" * ");
                strQuery += (" from vwPagamento ");
                strQuery += (" Where ");
                strQuery += (" month(dt_Referencia) = " + lp.getMes());
                strQuery += (" and Year(dt_Referencia) = " + lp.getAno());
                strQuery += (" and cd_matricula = " + lp.getCdmatricula());
                strQuery += (" and ds_Categoria = '" + lp.getDscategoria() + "'");
            }
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            while (result.next()) {
                PagamentoModel pm = new PagamentoModel();
                pm.setCdpagamento(result.getInt("cd_Pagamento"));
                pm.setCdempresa(result.getInt("cd_Empresa"));
                pm.setNmrazaosocial(result.getString("nm_Razao_Social"));
                pm.setNocnpj(result.getString("no_CNPJ"));
                pm.setCdmatricula(result.getInt("cd_Matricula"));
                pm.setNmfuncionario(result.getString("nm_Funcionario"));
                pm.setDscargo(result.getString("ds_Cargo"));
                pm.setCddepartamento(result.getInt("cd_Departamento"));
                pm.setDsdepartamento(result.getString("ds_Departamento"));
                pm.setCdccusto(result.getString("cd_CCusto"));
                pm.setCdbanco(result.getInt("cd_Banco"));
                pm.setNmbanco(result.getString("nm_Banco"));
                pm.setNoagencia(result.getInt("no_Agencia"));
                pm.setNoconta(result.getString("no_Conta"));
                pm.setNodigito(result.getInt("no_Digito"));
                pm.setVlsalario(result.getFloat("vl_Salario"));
                pm.setCdfinancas(result.getInt("cd_Financas"));
                pm.setDscategoria(result.getString("ds_Categoria"));
                pm.setDtreferencia(result.getString("dt_Referencia"));
                pm.setDscompetencia(result.getString("ds_Competencia"));
                pm.setDtpagamento(result.getString("dt_Pagamento"));
                pm.setVltotalvencido(result.getFloat("vl_TotalVencidos"));
                pm.setVldesconto(result.getFloat("vl_Descontos"));
                pm.setVlliquido(result.getFloat("vl_Liquidos"));
                listaPagamento.add(pm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaPagamento;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Lista de Pagamentos: " + e.getMessage());
            return null;
        }
    }

    public List<DetalPagamentoModel> getDetalPagamento(DetalPagamentoModel ldp) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" select ");
            strQuery += (" dp.cd_Produto ");
            strQuery += (" ,p.ds_produto ");
            strQuery += (" ,dp.qt_Quantidade ");
            strQuery += (" ,dp.vl_Vencimentos ");
            strQuery += (" ,dp.vl_Descontos ");
            strQuery += (" from DetalhePagamento dp ");
            strQuery += (" inner join Pagamento pg on pg.cd_Pagamento = dp.cd_Pagamento ");
            strQuery += (" inner join Produto p on p.cd_Produto = dp.cd_Produto ");
            strQuery += (" where ");
            strQuery += (" dp.cd_Pagamento = " + ldp.getCdpagamento());
            strQuery += (" and month(pg.dt_Referencia) = " + ldp.getMes());
            strQuery += (" and Year(pg.dt_Referencia) = " + ldp.getAno());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<DetalPagamentoModel> listaDetalhe = new ArrayList<DetalPagamentoModel>();
            while (result.next()) {
                DetalPagamentoModel dpm = new DetalPagamentoModel();
                dpm.setCdproduto(result.getInt("cd_Produto"));
                dpm.setDsproduto(result.getString("ds_produto"));
                dpm.setQuantidade(result.getFloat("qt_Quantidade"));
                dpm.setVlvencimento(result.getFloat("vl_Vencimentos"));
                dpm.setVldesconto(result.getFloat("vl_Descontos"));
                listaDetalhe.add(dpm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaDetalhe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Lista de detalhes do Pagamentos: " + e.getMessage());
            return null;
        }
    }

    public List<PagamentoModel> getListaFechamentoFolha(PagamentoModel ff) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" select ");
            strQuery += (" * ");
            strQuery += (" from vwFolhaPagamento ");
            strQuery += (" Where ");
            strQuery += (" ds_Status_func = '" + ff.getDsstatus() + "'");
            strQuery += (" and cd_Status_Ponto = 9 ");
            strQuery += (" and month(dt_PeriodoFim) = " + ff.getMes() + " -1");
            strQuery += (" and Year(dt_PeriodoFim) = " + ff.getAno());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<PagamentoModel> listaPagamento = new ArrayList<PagamentoModel>();
            while (result.next()) {
                PagamentoModel pm = new PagamentoModel();
                pm.setCdpagamento(result.getInt("cd_Pagamento"));
                pm.setCdmatricula(result.getInt("cd_Matricula"));
                pm.setNmfuncionario(result.getString("nm_Funcionario"));
                pm.setDscargo(result.getString("ds_Cargo"));
                pm.setDscategoria(result.getString("ds_Categoria"));
                pm.setDsdepartamento(result.getString("ds_Departamento"));
                pm.setDtreferencia(result.getString("dt_referencia"));
                pm.setStatuspag(result.getString("Status_Pagamento"));
                pm.setDsstatus(result.getString("ds_Status_func"));
                pm.setDtpagamento(result.getString("dt_Pagamento"));
                pm.setVltotalvencido(result.getFloat("vl_TotalVencidos"));
                pm.setVldesconto(result.getFloat("vl_Descontos"));
                pm.setVlliquido(result.getFloat("vl_Liquidos"));
                listaPagamento.add(pm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaPagamento;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Lista de Fechamento de Folha: " + e.getMessage());
            return null;
        }
    }

    public String fechaFolha(PagamentoModel lpm) {
        BancoDadosDao conn = new BancoDadosDao();
        try {
            ResultSet rs;
            String msg = null;
            CallableStatement cs = (CallableStatement) conn.connect().prepareCall("{call sp_CalculaFolha(?)}");
            cs.setInt(1, lpm.getCdmatricula());
            rs = cs.executeQuery();
            while (rs.next()) {
                msg = (rs.getString("msg"));
            }
            cs.close();
            conn.connect().close();
            return msg;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao Fechar Folha " + e.getMessage());
            return null;
        }
    }

    public int getQuantPagamento(PagamentoModel lpm) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = (" Select ");
            strquery += (" count(*) as Quantidade ");
            strquery += (" from vwFolhaPagamento ");
            strquery += (" Where ");
            strquery += (" cd_Status_Ponto = 9 ");
            strquery += (" and month(dt_PeriodoFim) = " + lpm.getMes() + " -1");
            strquery += (" and Year(dt_PeriodoFim) = " + lpm.getAno());
            //strquery += (" and ds_Categoria = 'Mensal'");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();

            int quant = 0;
            while (result.next()) {
                quant = (result.getInt("Quantidade"));
            }
            result.close();
            comando.close();
            conn.connect().close();
            return quant;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Quantidade de Registros do Pagamento: " + e.getMessage());
            return 0;
        }
    }

}
