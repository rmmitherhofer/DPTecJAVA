package dptec.dao;

import dptec.model.PerfilModel;
import dptec.model.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PerfilDao {

    public List<PerfilModel> groupPerfil(PerfilModel gpm) {
        try {
            BancoDadosDao conn = new BancoDadosDao();
            conn.connect();

            String strQuery;
            strQuery = (" Select ");
            strQuery += (" u.cd_Usuario ");
            strQuery += (" ,u.ds_Login ");
            strQuery += (" ,u.nm_Usuario ");
            strQuery += (" ,u.cd_Matricula ");
            strQuery += (" ,p.cd_Perfil ");
            strQuery += (" ,p.ds_Liberacao ");
            strQuery += (" ,p.ds_Sistema ");
            strQuery += (" ,p.ic_Ativo ");
            strQuery += (" ,p.tp_Perfil ");
            strQuery += (" from Usuario u ");
            strQuery += (" inner join PerfilUsuario pu on pu.cd_Usuario = u.cd_Usuario ");
            strQuery += (" inner join Perfil p on p.cd_Perfil = pu.cd_Perfil and p.ic_Ativo = 1");
            strQuery += (" left join Funcionario f on f.cd_Matricula = u.cd_Matricula ");
            strQuery += (" Where u.cd_Usuario = " + gpm.getCdusuario());

            PreparedStatement comando;
            comando = conn.connect().prepareStatement(strQuery);
            ResultSet result;
            result = comando.executeQuery();

            List<PerfilModel> lPerfil = new ArrayList<PerfilModel>();
            while (result.next()) {
                PerfilModel pm = new PerfilModel();
                pm.setCdusuario(result.getInt("cd_Usuario"));
                pm.setDslogin(result.getString("ds_Login"));
                pm.setNmusuario(result.getString("nm_Usuario"));
                pm.setCdmatricula(result.getInt("cd_Matricula"));
                pm.setCdperfil(result.getInt("cd_Perfil"));
                pm.setDsliberacao(result.getString("ds_Liberacao"));
                pm.setDssistema(result.getString("ds_Sistema"));
                pm.setTpperfil(result.getString("tp_Perfil"));
                lPerfil.add(pm);
            }
            result.close();
            comando.close();
            conn.connect().close();
            return lPerfil;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao carregar o Perfil: " + e.getMessage());
            return null;
        }
    }

}
