package dptec.model;

public class StatusModel {
    private int cdstatus;
    private String dsstatus;
    private int icativo;
    
    
    public int getCdStatus(){
        return cdstatus;
    }
    public void setCdStatus(int cdstatus){
        this.cdstatus = cdstatus;
    }    

    public String getDsStatus(){
        return dsstatus;
    }
    public void setDsStatus(String dsstatus){
        this.dsstatus = dsstatus;
    }
    
    public int getIcAtivo(){
        return icativo;
    }
    public void setIcAtivo(int icativo){
        this.icativo = icativo;
    }  

    public void add(StatusModel sm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
