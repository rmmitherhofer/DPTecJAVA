
package dptec.dao;

import dptec.model.EmpresaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaDao {
    public List<EmpresaModel> getListaEmpresaAtivo(){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Empresa ");
            strQuery += (" Where cd_Status = 1 ");
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();
            
            List<EmpresaModel> listaEmpresa = new ArrayList<EmpresaModel>();
            while(result.next()){
                EmpresaModel em = new EmpresaModel();
                em.setCdempresa(result.getInt("cd_Empresa"));
                em.setNmfantasia(result.getString("nm_Fantasia"));
                em.setNmrazaosocial(result.getString("nm_Razao_Social"));
                em.setNocnpj(result.getString("no_CNPJ"));
                em.setNoinscestadual(result.getString("no_Insc_Estadual"));
                em.setNmsegmento(result.getString("nm_Segmento"));
                em.setTsabertura(result.getString("ts_Abertura"));
                em.setTsfechamento(result.getString("ts_Fechamento"));
                em.setCdstatus(result.getInt("cd_Status"));
                em.setNmsite(result.getString("nm_Site"));
                em.setCdcategoria(result.getInt("cd_Categoria"));
                em.setNocep(result.getString("no_CEP"));
                em.setNoendereco(result.getString("no_Endereco"));
                em.setNmcomplemento(result.getString("nm_Complemento"));
                em.setNotelefonesac(result.getString("no_Telefone_SAC"));
                em.setNotelefoneouvidoria(result.getString("no_Telefone_Ouvidoria"));
                em.setNmpaisorigem(result.getString("nm_Pais_Origem"));     
                listaEmpresa.add(em);
            }
         result.close();
         comando.close();
         conn.connect().close();
         return listaEmpresa;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao Listar Empresas: " + e.getMessage());
            return null;
        }  
    }
    
    public List<EmpresaModel> getListaEmpresa(EmpresaModel lem){
        try{
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();
            
            String strQuery;
            strQuery = (" Select * from Empresa ");
            strQuery += (" Where nm_Razao_Social = '" + lem.getNmrazaosocial() + "'");
            strQuery += (" or cd_Empresa = " + lem.getCdempresa());
            
            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();
            
            List<EmpresaModel> listaEmpresa = new ArrayList<EmpresaModel>();
            while(result.next()){
                EmpresaModel em = new EmpresaModel();
                em.setCdempresa(result.getInt("cd_Empresa"));
                em.setNmfantasia(result.getString("nm_Fantasia"));
                em.setNmrazaosocial(result.getString("nm_Razao_Social"));
                em.setNocnpj(result.getString("no_CNPJ"));
                em.setNoinscestadual(result.getString("no_Insc_Estadual"));
                em.setNmsegmento(result.getString("nm_Segmento"));
                em.setTsabertura(result.getString("ts_Abertura"));
                em.setTsfechamento(result.getString("ts_Fechamento"));
                em.setCdstatus(result.getInt("cd_Status"));
                em.setNmsite(result.getString("nm_Site"));
                em.setCdcategoria(result.getInt("cd_Categoria"));
                em.setNocep(result.getString("no_CEP"));
                em.setNoendereco(result.getString("no_Endereco"));
                em.setNmcomplemento(result.getString("nm_Complemento"));
                em.setNotelefonesac(result.getString("no_Telefone_SAC"));
                em.setNotelefoneouvidoria(result.getString("no_Telefone_Ouvidoria"));
                em.setNmpaisorigem(result.getString("nm_Pais_Origem"));     
                listaEmpresa.add(em);
            }
         result.close();
         comando.close();
         conn.connect().close();
         return listaEmpresa;      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO ao Listar Empresas: " + e.getMessage());
            return null;
        }  
    }
}
