package dptec.dao;

import dptec.model.DependenteModel;
import dptec.model.FolhaPontoModel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author renat
 */
public class FolhaPontoDao {
    
    public String GeraPonto(FolhaPontoModel dpd){
    BancoDadosDao conn = new BancoDadosDao();    
  
    try{          
        ResultSet rs;
        String msg = null;    
        CallableStatement cs = (CallableStatement) conn.connect().prepareCall("{call sp_GerarPonto(?)}");        
        cs.setInt(1, dpd.getCdmatricula());
        rs = cs.executeQuery();
        while(rs.next()){
            msg = rs.getString("msg");
        }          
            
            cs.close();
            conn.connect().close();            
            return msg;  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERRO: " + e.getMessage());
            return null;
        }
    }
    
    public List<FolhaPontoModel> listRelatorioPonto(FolhaPontoModel ldpd){
        BancoDadosDao conn = new BancoDadosDao();
        try{
            ResultSet rs;              
            CallableStatement cs = (CallableStatement) conn.connect().prepareCall("{call sp_CalculoPonto(?,?,?,?,?)}");        
            cs.setString(1, ldpd.getMes());
            cs.setInt(2, ldpd.getAno());
            cs.setInt(3, ldpd.getCdmatricula());
            cs.setInt(4, ldpd.getCdponto());
            cs.setString(5, ldpd.getOperacao());
            
            
            rs = cs.executeQuery();
            List<FolhaPontoModel> listaRelatorioPonto= new ArrayList<FolhaPontoModel>();            
            while(rs.next()){
                FolhaPontoModel fpm = new FolhaPontoModel();
                fpm.setData(rs.getString("dt_Data"));
                fpm.setDia(rs.getString("Dia"));
                fpm.setHoraentradaref(rs.getString("Horario_Entrada"));
                fpm.setHoraalmocoref(rs.getString("Horario_Almoco"));
                fpm.setHoraretornoalmocoref(rs.getString("Horario_Retorno_Almoco"));
                fpm.setHorasaida(rs.getString("Horario_Saida"));
                fpm.setMarcentrada(rs.getString("Marcacoes_Realizadas_Entrada"));
                fpm.setMarcalmoco(rs.getString("Marcacoes_Realizadas_Almoco"));
                fpm.setMarcretornalmoco(rs.getString("Marcacoes_Realizadas_RetornoAlmoco"));
                fpm.setMarcsaida(rs.getString("Marcacoes_Realizadas_Saida"));
                fpm.setHrtrabalhada(rs.getString("HoraTrabalhada"));
                fpm.setHrttalmoco(rs.getString("HoraAlmoco"));
                fpm.setHradicional(rs.getString("HoraAdicional"));
                listaRelatorioPonto.add(fpm);
            }          

                cs.close();
                conn.connect().close();            
                return listaRelatorioPonto;  
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERRO: " + e.getMessage());
                return null;
        }  
    }
    
    public List<FolhaPontoModel> getListaPonto(FolhaPontoModel lfpm){    
    try{   
        BancoDadosDao conn = new BancoDadosDao();    
        conn.connect();
        
        String strquery;
        strquery = ("Select ");
        strquery += (" * ");
        strquery += (" from vwPonto ");
        
        if (lfpm.getCdmatricula() == 0){        
            strquery += (" Where ds_Mes = " + lfpm.getMes()+ "");
            strquery += (" and Year(dt_PeriodoInicio) = " + lfpm.getAno()+ "");
            strquery += (" and ds_Status = '" + lfpm.getDsstatus()+ "'");
        }else{        
            strquery += (" Where cd_Matricula = " + lfpm.getCdmatricula());
            strquery += (" and ds_Mes = " + lfpm.getMes()+ "");
            strquery += (" and Year(dt_PeriodoInicio) = " + lfpm.getAno()+ "");
        }
        PreparedStatement comando;
        comando = conn.connect().prepareStatement(strquery);
        ResultSet result;
        result = comando.executeQuery();
        
        List<FolhaPontoModel> listaPonto = new ArrayList<FolhaPontoModel>();
        while(result.next()){
            FolhaPontoModel fpm = new FolhaPontoModel();
            fpm.setCdponto (result.getInt("cd_Ponto"));
            fpm.setCdmatricula(result.getInt("cd_Matricula"));
            fpm.setNmfuncionario(result.getString("nm_Funcionario"));
            fpm.setDscargo(result.getString("ds_Cargo"));
            fpm.setDsdepartamento(result.getString("ds_Departamento"));
            fpm.setDsmes(result.getString("ds_Mes"));
            fpm.setDscompetencia(result.getString("ds_Competencia"));
            fpm.setCdstatus(result.getInt("cd_Status"));           
            fpm.setHrsaldoref(result.getString("hr_Saldo_Referencia"));
            fpm.setHrsaldo(result.getString("hr_Saldo"));
            fpm.setDsstatus(result.getString("ds_Status"));
            fpm.setDtperiodoinicio(result.getString("dt_PeriodoInicio"));
            fpm.setDtperiodofim(result.getString("dt_PeriodoFim")); 
            listaPonto.add(fpm);
        }    
                            
                           
            result.close();
            comando.close();
            conn.connect().close();
            return listaPonto;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao carregar a Lista de Ponto: " + e.getMessage());
            return null;
        }        
    }   
    
    public int getQuantPonto(FolhaPontoModel lfpm){    
        try{   
            BancoDadosDao conn = new BancoDadosDao();    
            conn.connect();

            String strquery;
            strquery = ("Select ");
            strquery += (" count(*) as Quantidade");
            strquery += (" from vwPonto ");   
            strquery += (" Where ds_Mes = " + lfpm.getMes()+ "");
            strquery += (" and Year(dt_PeriodoInicio) = " + lfpm.getAno()+ "");
            strquery += (" and ds_Status = '" + lfpm.getDsstatus()+ "'");

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strquery);
            ResultSet result;
            result = comando.executeQuery();
            
            int quant = 0;
            while(result.next()){
                quant = (result.getInt("Quantidade"));
            } 
            result.close();
            comando.close();
            conn.connect().close();
            return quant;
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"ERRO ao carregar Quantidade de Registros do Ponto: " + e.getMessage());
                return 0;
        }        
    }
    
    public String fechaPonto(FolhaPontoModel ldpd){
        BancoDadosDao conn = new BancoDadosDao();
        try{
            ResultSet rs;
            String msg = null;    
            CallableStatement cs = (CallableStatement) conn.connect().prepareCall("{call sp_CalculoPonto(?,?,?,?,?)}");        
            cs.setString(1, ldpd.getMes());
            cs.setInt(2, ldpd.getAno());
            cs.setInt(3, ldpd.getCdmatricula());
            cs.setInt(4, ldpd.getCdponto());
            cs.setString(5, ldpd.getOperacao());

            rs = cs.executeQuery();                   
            while(rs.next()){            
                msg = (rs.getString("msg"));
            }
            cs.close();
            conn.connect().close();            
            return msg; 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO ao Fechar Ponto " + e.getMessage());
            return null;
        }
    }
}
