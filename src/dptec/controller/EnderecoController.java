
package dptec.controller;

import dptec.model.EnderecoModel;

import dptec.dao.EnderecoDao;

import java.util.ArrayList;
import java.util.List;

import dptec.view.CadFuncionarioView;

import javax.swing.JOptionPane;

public class EnderecoController {
    String nocep;
    String nmlogradouro;
    String nmbairro;
    String nmcidade;
    String sguf;
    String nmpais;
    int icativo;

    public EnderecoController (String nocep, String nmlogradouro, String nmbairro, String nmcidade, String sguf, String nmpais){
        this.nocep = nocep;
        this.nmlogradouro = nmlogradouro;
        this.nmbairro = nmbairro;
        this.nmcidade = nmcidade;
        this.sguf = sguf;
        this.nmpais = nmpais;        
    }
    
    public List<EnderecoModel> buscaEndereco(){
        String msg;
        EnderecoModel em = new EnderecoModel();
        em.setNlogradouro(nmlogradouro);
        em.setNbairro(nmbairro);
        em.setNcidade(nmcidade);        
        em.setSguf(sguf);
        em.setNocep(nocep);
        EnderecoDao ed = new EnderecoDao();
        List<EnderecoModel> listEndereco = new ArrayList<EnderecoModel>();
        listEndereco = ed.getListaEndereco(em);
        if(listEndereco.size() > 0){
            return listEndereco;
        }else{
            return null;
        }        
    }
    
    public String incluiNovoEndereco(){
        String msg;
        EnderecoModel em = new EnderecoModel();
        CadFuncionarioView cadfunc = new CadFuncionarioView();
        em.setNocep(nocep);
        if(!"".equals(nocep)){
            EnderecoDao ed = new EnderecoDao();
            List<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
            listaEndereco = ed.getListaEndereco(em);            
            if(listaEndereco.size() < 1){                
                int opcao;
                Object[] options = {"Cadastrar", "Cancelar"};
                opcao = JOptionPane.showOptionDialog(null,"Endereço Não Cadastrado Deseja Cadastrar?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (opcao == 0){
                        if ("".equals(nmlogradouro)){
                            msg = "informe o Logradouro";
                            cadfunc.txtEndereco.requestFocus();                            
                        }else if ("".equals(nmbairro)){
                            msg = "informe o Bairro";
                            cadfunc.txtBairro.requestFocus(); 
                        }else if ("".equals(nmcidade)){
                            msg = "informe a Cidade";
                            cadfunc.txtCidade.requestFocus(); 
                        }else if ("Selecionar".equals(sguf)){
                            msg = "Selecione o Estado";
                            cadfunc.cmbUFEnd.requestFocus(); 
                        }else if ("".equals(nmpais)){
                            msg = "Infome o Pais de Origem";
                            cadfunc.txtPais.requestFocus();
                        }else{
                            em.setNlogradouro(nmlogradouro);                                   
                            em.setNbairro(nmbairro);
                            em.setNcidade(nmcidade);
                            em.setSguf(sguf);
                            em.setNmpais(nmpais);
                            icativo = 1;
                            em.setIcativo(icativo);
                            if (ed.InsertEndereco(em) == true){
                                msg = "Endereco Cadastrado com sucesso";
                            }else{
                                msg = "Falha no Cadastro";
                            }
                        }
                }else{
                    msg = "Cadastro Cancelado";                    
                }
            }else{
                msg = "Endereco Ja Cadastrado";
            }
        }else{
            msg = "Informe o cóigo do CEP";
        }
    return msg;
    }
}
