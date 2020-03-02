
package dptec.model;

public class PerfilModel {
    private int cdperfil;
    private String tpperfil;
    private String dsliberacao;
    private String dssistema;
    private int icativo;
    private int cdusuario;
    private int cdmatricula;
    private String dslogin;
    private String nmusuario; 

    public int getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(int cdusuario) {
        this.cdusuario = cdusuario;
    }

    public int getCdmatricula() {
        return cdmatricula;
    }

    public void setCdmatricula(int cdmatricula) {
        this.cdmatricula = cdmatricula;
    }

    public String getDslogin() {
        return dslogin;
    }

    public void setDslogin(String dslogin) {
        this.dslogin = dslogin;
    }

    public String getNmusuario() {
        return nmusuario;
    }

    public void setNmusuario(String nmusuario) {
        this.nmusuario = nmusuario;
    }

    public int getCdperfil() {
        return cdperfil;
    }

    public void setCdperfil(int cdperfil) {
        this.cdperfil = cdperfil;
    }

    public String getTpperfil() {
        return tpperfil;
    }

    public void setTpperfil(String tpperfil) {
        this.tpperfil = tpperfil;
    }

    public String getDsliberacao() {
        return dsliberacao;
    }

    public void setDsliberacao(String dsliberacao) {
        this.dsliberacao = dsliberacao;
    }

    public String getDssistema() {
        return dssistema;
    }

    public void setDssistema(String dssistema) {
        this.dssistema = dssistema;
    }

    public int getIcativo() {
        return icativo;
    }

    public void setIcativo(int icativo) {
        this.icativo = icativo;
    }
    
}
