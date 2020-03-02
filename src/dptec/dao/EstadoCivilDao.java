package dptec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dptec.model.EstadoCivilModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;    

public class EstadoCivilDao {
    public List<EstadoCivilModel> getListaECivil (EstadoCivilModel ec){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery  = (" Select * from EstadoCivil ");
            strQuery += (" where ds_EstadoCivil = '" + ec.getDsestadocivil()+ "'");
            strQuery += (" or cd_EstadoCivil = '" + ec.getCdestadocivil()+ "'");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery(); 
            
            List<EstadoCivilModel> listaEstadoCivil = new ArrayList<EstadoCivilModel>();
            
            while (resultado.next()){
                EstadoCivilModel ecm = new EstadoCivilModel();
                ecm.setCdestadocivil(resultado.getInt("cd_EstadoCivil"));
                ecm.setDsestadocivil(resultado.getString("ds_EstadoCivil"));
                ecm.setIcativo(resultado.getInt("ic_Ativo"));
                listaEstadoCivil.add(ecm);
            }
            
            resultado.close();
            comando.close();
            conn.connect().close();
            
            return listaEstadoCivil;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao carregar Estado Civil: " + e.getMessage());
            return null;
        }
    }
    
    public List<EstadoCivilModel> getListaECivilAtivo (){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery  = (" Select * from EstadoCivil ");
            strQuery += (" where ic_Ativo = 1");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet resultado;
            resultado = comando.executeQuery(); 
            
            List<EstadoCivilModel> listaEstadoCivil = new ArrayList<EstadoCivilModel>();
            
            while (resultado.next()){
                EstadoCivilModel ecm = new EstadoCivilModel();
                ecm.setCdestadocivil(resultado.getInt("cd_EstadoCivil"));
                ecm.setDsestadocivil(resultado.getString("ds_EstadoCivil"));
                ecm.setIcativo(resultado.getInt("ic_Ativo"));
                listaEstadoCivil.add(ecm);
            }
            
            resultado.close();
            comando.close();
            conn.connect().close();
            
            return listaEstadoCivil;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao Listar Estado Civil: " + e.getMessage());
            return null;
        }
    }
}
