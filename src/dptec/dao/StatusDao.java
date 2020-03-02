
package dptec.dao;

import dptec.model.StatusModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StatusDao {
    public List<StatusModel> getListaStatus(StatusModel s){
        
    try{
        BancoDadosDao conn = new BancoDadosDao();
        conn.connect();
        
        String strQuery;
        strQuery = (" Select * from Status ");
        strQuery +=(" where ds_Status = '" + s.getDsStatus() + "'"); 
        strQuery +=(" or cd_Status = " + s.getCdStatus()+ ""); 
        
        PreparedStatement comando = conn.connect().prepareStatement(strQuery);
        ResultSet resultado = comando.executeQuery();
        
        List<StatusModel> listaStatus = new ArrayList<StatusModel>();        
            while(resultado.next()){
                StatusModel sm = new StatusModel();
                sm.setCdStatus(resultado.getInt("cd_Status"));
                sm.setDsStatus(resultado.getString("ds_Status"));
                sm.setIcAtivo(resultado.getInt("ic_Ativo"));            
                listaStatus.add(sm);
                
            }
            resultado.close();
            comando.close();
            conn.connect().close();
            
            return listaStatus;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao Importar o Status: " + e.getMessage());
            return null;
        }
    }
}
