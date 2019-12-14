
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JFrame;

public class BeanDiversos {

    // Variaveis publicas
    public Connection con = null;
    public PreparedStatement sttm, sttm2, sttm3;
    public Statement stmt = null;
    // Variavies privadas
    private Vector rst = new Vector();

    // Metodo que retorna a data do servidor
    public String DataSistema() {
        Date dt = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return data.format(dt);
    }

    // Metodo que retorna a hora do servidor
    public String HoraSistema() {
        Calendar data = Calendar.getInstance();
        return (data.getTime().toString().substring(11, 19));
    }

    // Metodo de conexao com o banco de dados
    public void Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_biblioteca", "root", "");
            con.setAutoCommit(false);
            stmt = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Metodo que checa se o campos é nulo e retorna a uma String no formato correto
    public String RetString(String campo, String tipo) {
        String resultDados = "";
        if ((campo == null) || (tipo.trim().equals("D"))) {
            if (tipo.trim().equals("D")) {
                if (campo == null) {
                    resultDados = "";
                } else {
                    resultDados = campo.substring(8, 10) + "/" + campo.substring(5, 7) + "/" + campo.substring(0, 4);
                }
            } else if (tipo.trim().equals("N")) {
                if (campo == null) {
                    resultDados = "0";
                }
            } else {
                resultDados = "";
            }
        } else {
            resultDados = campo;
        }
        return resultDados;
    }
    // Metodo que checa o campo e retorna a uma String no formato correto
    public String ConvData(String campo) {
        String resultDados = "";

        if (campo.trim().length() == 0) {
            resultDados = "null";
        } else {
            resultDados = campo.substring(6) + "-" + campo.substring(3, 5) + "-" + campo.substring(0, 2);
        }
        return resultDados;
    }

    public void passaCamposComEnter(JFrame frame) {
        // Colocando enter para pular de campo  
        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }
}
