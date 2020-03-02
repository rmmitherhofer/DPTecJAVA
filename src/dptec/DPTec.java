package dptec;
//Renato Matos dos Santos Mitherhofer
//916203549

import dptec.view.LoginView;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DPTec {

    public static void main(String[] args) {
        try {
            LoginView lg = new LoginView();
            lg.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }

}
