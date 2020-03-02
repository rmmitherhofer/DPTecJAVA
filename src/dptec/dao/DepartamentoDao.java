
package dptec.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dptec.model.DepartamentoModel;

import javax.swing.JOptionPane;

public class DepartamentoDao {

    public List<DepartamentoModel> getListaDep (DepartamentoModel lp){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = (" Select * From Departamento ");
            strquery += (" Where cd_Departamento = " + lp.getCddepartamento() + "");
            strquery += (" or ds_Departamento = '" + lp.getDsdepartamento()+ "'");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();

            List<DepartamentoModel> listaDepartamento = new ArrayList<DepartamentoModel>();

            while(result.next()){
                DepartamentoModel dm = new DepartamentoModel();
                dm.setCddepartamento(result.getInt("cd_Departamento"));
                dm.setDsdepartamento(result.getString("ds_Departamento"));
                dm.setCdccusto(result.getString("cd_CCusto"));
                dm.setCdfuncionario(result.getInt("cd_Matricula"));
                listaDepartamento.add(dm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaDepartamento;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao carregar o Departamento: " +  e.getMessage());
            return null;
        }
    }
    
    public List<DepartamentoModel> getListaDepAtivo (){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strquery;
            strquery = (" Select * From Departamento ");
            strquery += (" Where ic_Ativo = 1");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();

            List<DepartamentoModel> listaDepartamento = new ArrayList<DepartamentoModel>();

            while(result.next()){
                DepartamentoModel dm = new DepartamentoModel();
                dm.setCddepartamento(result.getInt("cd_Departamento"));
                dm.setDsdepartamento(result.getString("ds_Departamento"));
                dm.setCdccusto(result.getString("cd_CCusto"));
                dm.setCdfuncionario(result.getInt("cd_Matricula"));
                listaDepartamento.add(dm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return listaDepartamento;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao carregar o Departamento: " +  e.getMessage());
            return null;
        }
    }
}
