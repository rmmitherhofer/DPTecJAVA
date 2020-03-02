package dptec.dao;

import dptec.model.BancoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BancoDao {
    
    public List<BancoModel> getListaBancoAtivo(){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Banco ");
            strQuery += (" Where ic_ativo = 1 ");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();
            
            List<BancoModel> listaBanco = new ArrayList<BancoModel>();
            while(result.next()){
                BancoModel bm = new BancoModel();
                bm.setCdbanco(result.getInt("cd_Banco"));
                bm.setNmbanco(result.getString("nm_Banco"));
                bm.setSgbanco(result.getString("sg_Sigla"));
                bm.setDscompetencia(result.getString("ds_Competencia"));
                bm.setDswebsite(result.getString("ds_WebSite"));
                bm.setIcativo(result.getInt("ic_Ativo"));
                listaBanco.add(bm);
            }
         result.close();
         comando.close();
         conn.connect().close();
         return listaBanco;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao Listar Bancos: " + e.getMessage());
            return null;
        }  
    }
    
    public List<BancoModel> getListaBanco(BancoModel lbm){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Banco ");
            strQuery += (" Where nm_Banco = '" + lbm.getNmbanco() + "'");
            strQuery += (" or cd_Banco = " + lbm.getCdbanco());
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();
            
            List<BancoModel> listaBanco = new ArrayList<BancoModel>();
            while(result.next()){
                BancoModel bm = new BancoModel();
                bm.setCdbanco(result.getInt("cd_Banco"));
                bm.setNmbanco(result.getString("nm_Banco"));
                bm.setSgbanco(result.getString("sg_Sigla"));
                bm.setDscompetencia(result.getString("ds_Competencia"));
                bm.setDswebsite(result.getString("ds_WebSite"));
                bm.setIcativo(result.getInt("ic_Ativo"));
                listaBanco.add(bm);
            }
         result.close();
         comando.close();
         conn.connect().close();
         return listaBanco;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao carregar Banco: " + e.getMessage());
            return null;
        }  
    }
    
}
