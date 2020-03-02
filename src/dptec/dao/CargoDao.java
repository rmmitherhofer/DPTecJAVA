
package dptec.dao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dptec.model.CargoModel;

import javax.swing.JOptionPane;

public class CargoDao {
    public List<CargoModel> getListaCargo (CargoModel lc){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Cargo ");
            strQuery += (" Where cd_cargo = " + lc.getCdcargo()+ "");
            strQuery += (" or ds_Cargo = '" + lc.getDscargo() + "'");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery();
            
            List<CargoModel> listaCargo = new ArrayList<CargoModel>();
            while(resultado.next()){
                CargoModel cm = new CargoModel();
                cm.setCdcargo(resultado.getInt("cd_Cargo"));
                cm.setDscargo(resultado.getString("ds_Cargo"));
                cm.setIcativo(resultado.getInt("ic_Ativo"));
                listaCargo.add(cm);
            }
         resultado.close();
         comando.close();
         conn.connect().close();
         return listaCargo;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Cargo: " + e.getMessage());
            return null;
        }  
    }
    
    public List<CargoModel> getListaCargoAtivo(){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Cargo ");
            strQuery += (" Where ic_ativo = 1 ");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery();
            
            List<CargoModel> listaCargo = new ArrayList<CargoModel>();
            while(resultado.next()){
                CargoModel cm = new CargoModel();
                cm.setCdcargo(resultado.getInt("cd_Cargo"));
                cm.setDscargo(resultado.getString("ds_Cargo"));
                cm.setIcativo(resultado.getInt("ic_Ativo"));
                listaCargo.add(cm);
            }
         resultado.close();
         comando.close();
         conn.connect().close();
         return listaCargo;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao Listar Cargos: " + e.getMessage());
            return null;
        }  
    }
}
