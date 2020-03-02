package dptec.controller;

import dptec.dao.UsuarioDao;
import dptec.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private String dslogin;
    private String dssenha;

    public UsuarioController(String dslogin, String dssenha) {
        this.dslogin = dslogin;
        this.dssenha = dssenha;
    }

    public String validaUser() {
        String msg = null;
        String senhaval = null;
        String userval = null;
        int icativo = 1;

        if ("".equals(dslogin)) {
            msg = "Informe o Login";
            return msg;
        } else if ("".equals(dssenha)) {
            msg = "Informe a Senha";
            return msg;
        } else {

            UsuarioModel um = new UsuarioModel();
            um.setDslogin(dslogin);
            um.setDssenha(dssenha);
            UsuarioDao ud = new UsuarioDao();
            List<UsuarioModel> listaUser = new ArrayList<UsuarioModel>();
            listaUser = ud.getListaUsuario(um);

            if (listaUser.size() > 0) {
                for (UsuarioModel uml : listaUser) {
                    senhaval = uml.getDssenha();
                    userval = uml.getDslogin();
                    icativo = uml.getIcativo();
                    msg = String.valueOf(uml.getCdusuario());
                }
                if (!senhaval.equals(dssenha)) {
                    msg = "Senha Inválida!";
                }
                if (icativo == 0) {
                    msg = "Conta Inativa, Contate o Administrador";
                }
            } else {
                msg = "Usuario não encontrado";
            }
            return msg;
        }
    }
}
