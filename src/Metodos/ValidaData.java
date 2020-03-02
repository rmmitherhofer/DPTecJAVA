package Metodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ValidaData {

    public int valiaData(String date) {
        String d = date;
        Date msg = null;
        int v = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setLenient (false);
        try {
            msg = format.parse(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"Data inválida. Tente novamente!", "AVISO", JOptionPane.WARNING_MESSAGE);
            v = 1;
        }
        return v;
    }

}
