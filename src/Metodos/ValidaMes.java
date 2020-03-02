
package Metodos;

public class ValidaMes {
    
    public String MesNum(int mes){
        String smes = null;
        switch (mes){
            case 1:
                smes = "janeiro";
                break;
            case 2:
                smes = "Fevereiro";
                break;
            case 3:
                smes = "Março";
                break;
            case 4:
                smes = "Abril";
                break;
            case 5: 
                smes = "Maio";
                break;
            case 6:
                smes = "Junho";
                break;
            case 7:
                smes = "Julho";
                break;
            case 8:
                smes = "Agosto";
                break;
            case 9:
                smes = "Setembro";
                break;
            case 10:
                smes = "Outubro";
                break;
            case 11:
                smes = "Novembro";
                break;
            case 12:
                smes = "Dezembro";
                break;
            default:
                smes = "Falha ao Carregar Mes";
        }
        return smes;        
    }
    
    public int MesString(String mes){
        int imes = 0;
        switch (mes){
            case "Janeiro":
                imes = 1;
                break;
            case "Fevereiro":
                imes = 2;
                break;
            case "Março":
                imes = 3;
                break;
            case "Abril":
                imes = 4;
                break;
            case "Maio":
                imes = 5;
                break;
            case "Junho":
                imes = 6;
                break;
            case "Julho":
                imes = 7;
                break;
            case "Agosto":
                imes = 8;
                break;
            case "Setembro":
                imes = 9;
                break;
            case "Outubro":
                imes = 10;
                break;
            case "Novembro":
                imes = 11;
                break;
            case "Dezembro":
                imes = 12;
                break;                       
            }
            
        return imes;
    }
}
