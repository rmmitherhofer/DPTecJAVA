
package Metodos;

import dptec.dao.PerfilDao;
import dptec.model.PerfilModel;
import java.util.ArrayList;
import java.util.List;

import dptec.view.MasterView;


public class Config {
    public List<PerfilModel> validaPerfil(int user){ 
        PerfilModel pm = new PerfilModel();
        pm.setCdusuario(user);
        List<PerfilModel> gropuPerfil = new ArrayList<PerfilModel>();
        PerfilDao pd = new PerfilDao();
        gropuPerfil = pd.groupPerfil(pm);
        return gropuPerfil;  
    }       
}
