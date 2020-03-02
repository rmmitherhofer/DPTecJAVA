
package dptec.dao;

import dptec.model.CategoriaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDao {
    public List<CategoriaModel> getListCategoria(CategoriaModel cm){
        
    try{
        BancoDadosDao conn = new BancoDadosDao();
        conn.connect();
        
        String strQuery;
        strQuery = (" Select * from Categoria ");
        strQuery +=(" where ds_Categoria = '" + cm.getDscategoria() + "'"); 
        strQuery +=(" or cd_Categoria = " + cm.getCdcategoria()); 
        
        PreparedStatement comando = conn.connect().prepareStatement(strQuery);
        ResultSet result = comando.executeQuery();
        
        List<CategoriaModel> listaCat = new ArrayList<CategoriaModel>();        
            while(result.next()){
                CategoriaModel catm = new CategoriaModel();
                catm.setCdcategoria(result.getInt("cd_Categoria"));
                catm.setDscategoria(result.getString("ds_Categoria"));
                catm.setIcativo(result.getInt("ic_Ativo"));            
                listaCat.add(catm);
                
            }
            result.close();
            comando.close();
            conn.connect().close();
            
            return listaCat;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao Importar o Categoria: " + e.getMessage());
            return null;
        }
    }
}
