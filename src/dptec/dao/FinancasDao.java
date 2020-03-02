
package dptec.dao;

import dptec.model.FinancasModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FinancasDao {
    public List<FinancasModel> getListaFincanca(FinancasModel lf){        
    try{
        BancoDadosDao conn = new BancoDadosDao();
        conn.connect();
        
        String strQuery;
        strQuery = (" Select * from Financas f ");
        strQuery += (" Inner join Banco b on b.cd_Banco = f.cd_Banco ");
        strQuery += (" Inner join Status s on s.cd_Status = f.cd_Status");
        strQuery +=(" where f.cd_Matricula = '" + lf.getMatricula() + "'"); 
        
        PreparedStatement comando = conn.connect().prepareStatement(strQuery);
        ResultSet result = comando.executeQuery();
        
        List<FinancasModel> listaFinancas = new ArrayList<FinancasModel>();        
            while(result.next()){
                FinancasModel fm = new FinancasModel();
                fm.setMatricula(result.getInt("cd_Matricula"));
                fm.setTpconta(result.getString("tp_Conta"));
                fm.setDsbanco(result.getString("nm_Banco"));
                fm.setNoagencia(result.getString("no_Agencia")); 
                fm.setNoconta(result.getString("no_Conta"));   
                fm.setNodigito(result.getInt("no_Digito"));   
                fm.setCdfinancas(result.getInt("cd_Financas"));   
                fm.setCdstatus(result.getInt("cd_Status"));
                fm.setDsstatus(result.getString("ds_Status"));
                fm.setVlsalario(result.getFloat("vl_Salario"));
                listaFinancas.add(fm);
                
            }
            result.close();
            comando.close();
            conn.connect().close();
            
            return listaFinancas;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao Importar Financas: " + e.getMessage());
            return null;
        }
    }
    
    public String insertFinancas(FinancasModel fm){
        BancoDadosDao conn = new BancoDadosDao();
        try(CallableStatement cstm = conn.connect().prepareCall("{call sp_Financas(?,?,?,?,?,?,?,?,?,?,?)}")){
            cstm.setInt(1, fm.getCdfinancas());
            cstm.setString(2, fm.getTpconta());
            cstm.setInt(3, fm.getCdbanco());
            cstm.setString(4, fm.getNoagencia());
            cstm.setString(5, fm.getNoconta());
            cstm.setInt(6, fm.getNodigito());
            cstm.setInt(7, fm.getCdstatus());
            cstm.setInt(8, fm.getMatricula());
            cstm.setFloat(9, fm.getVlsalario()); 
            cstm.setString(10, fm.getOp()); //Operacao
            cstm.setInt(11, fm.getCduser()); //Usuario    
            
            String msg = null;
            if(cstm.executeUpdate() > 0 ){ 
                if (fm.getOp().equals("I")){
                    msg = "Dados Financeiros Cadastrado com Sucesso";
                }else if(fm.getOp().equals("U")){
                    msg = "Dados Financeiros Alterado Com Sucesso";
                }else{
                    msg = "Dados Financeiros Excluidos com Sucesso";
                }
                    
            }
            cstm.close();
            conn.connect().close(); 
            return msg;            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO: " + e.getMessage());
            return null;
        }
    } 
}
