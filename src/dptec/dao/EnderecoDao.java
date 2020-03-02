package dptec.dao;

import dptec.model.EnderecoModel;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class EnderecoDao {
    public List<EnderecoModel> getListaEndereco(EnderecoModel le){
    try{
        BancoDadosDao conn = new BancoDadosDao();
        conn.connect();
        
        String strQuery;
        strQuery = ("Select ");
        strQuery += (" * ");
        strQuery += (" From Endereco ");
        strQuery += (" where 1=1 ");
        strQuery += (" and ic_Ativo = 1 ");
        
        if(!"".equals(le.getNlogradouro()) && le.getNlogradouro() != null){
        strQuery += (" and nm_Logradouro like '%" + le.getNlogradouro() + "%'");
        }
        if(!"".equals(le.getNbairro()) && le.getNbairro() != null){
        strQuery += (" and nm_Bairro like '%" + le.getNbairro() + "%'");
        }
        if(!"".equals(le.getNcidade()) && le.getNcidade() != null){
        strQuery += (" and nm_Cidade like '%" + le.getNcidade() + "%'");
        }
        if(!"Selecionar".equals(le.getSguf()) && le.getSguf() != null){
        strQuery += (" and sg_UF like '%" + le.getSguf() + "%'");
        }
        if(!"".equals(le.getNocep()) && le.getNocep() != null){
        strQuery += (" and no_CEP = " + le.getNocep());
        }
        
        
        
        PreparedStatement comando;
        comando = conn.connect().prepareStatement(strQuery);
        ResultSet result;
        result = comando.executeQuery();
        
        List<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
        
            while(result.next()){
                EnderecoModel em = new EnderecoModel();
                em.setNocep(result.getString("no_CEP"));
                em.setNlogradouro(result.getString("nm_Logradouro"));
                em.setNbairro(result.getString("nm_Bairro"));
                em.setNcidade(result.getString("nm_Cidade"));
                em.setSguf(result.getString("sg_UF"));
                em.setNmpais(result.getString("nm_Pais"));
                em.setIcativo(result.getInt("ic_Ativo"));
                     
                listaEndereco.add(em);
            }
            result.close();
            comando.close();
            conn.connect().close();
            
            return listaEndereco;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao carregar o Endereço: " + e.getMessage());
            return null;
        }
    }
        
    public boolean InsertEndereco(EnderecoModel em) {
        BancoDadosDao conn = new BancoDadosDao();

        try (CallableStatement cstm = conn.connect().prepareCall("{call sp_Endereco(?,?,?,?,?,?,?,?,?)}")) {
            cstm.setString(1, em.getNocep()); //vcdDependente   
            cstm.setString(2, em.getNlogradouro()); //vcdDependente 
            cstm.setString(3, em.getNbairro()); //vcdDependente 
            cstm.setString(4, em.getNcidade()); //vcdDependente 
            cstm.setString(5, em.getSguf());
            cstm.setString(6, em.getNmpais());
            cstm.setInt(7, em.getIcativo());
            cstm.setInt(8, 1);//vcdUsuario
            cstm.setString(9, "I");//vOp

            String msg;
            if (cstm.executeUpdate() > 0) {
                msg = "Endereco Cadastrado com Sucesso";
            }
            cstm.close();
            conn.connect().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            return false;
        }

    }     
}
