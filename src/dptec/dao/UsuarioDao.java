package dptec.dao;

import dptec.model.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao {
    public List<UsuarioModel> getListaUsuario(UsuarioModel lum){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Usuario ");
            strQuery += (" Where ds_Login = '" + lum.getDslogin()+ "'");
            strQuery += (" or cd_Usuario = " + lum.getCdusuario()+ "");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();
            
            List<UsuarioModel> listaUsuario = new ArrayList<UsuarioModel>();
            while(result.next()){
                UsuarioModel um = new UsuarioModel();
                um.setCdusuario(result.getInt("cd_Usuario"));
                um.setNmusuario(result.getString("nm_Usuario"));
                um.setDslogin(result.getString("ds_Login"));
                um.setDssenha(result.getString("ds_Senha"));
                um.setCdmatricula(result.getInt("cd_Matricula"));
                um.setIcativo(result.getInt("ic_ativo"));
                listaUsuario.add(um);
            }
         result.close();
         comando.close();
         conn.connect().close();
         return listaUsuario;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Usuario: " + e.getMessage());
            return null;
        }  
    }
}
