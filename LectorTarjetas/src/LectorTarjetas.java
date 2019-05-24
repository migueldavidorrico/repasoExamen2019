import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LectorTarjetas extends JDialog {
    String leido=null;

    public LectorTarjetas(JFrame miVentana) {
        super(miVentana);
        this.leido = "";
        setModal(true);
        setBounds(0,0,800,800);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel panel=new JPanel(new BorderLayout());
        JLabel mensaje=new JLabel("Pase la tarjeta por el lector");
        mensaje.setForeground(Color.BLUE);
        mensaje.setFont(new Font("Arial",Font.ITALIC,42));
        panel.add(mensaje);
        add(panel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                pulsacion(e);
            }
        })
        ;
    }

    private void pulsacion(KeyEvent e) {
        this.leido+=e.getKeyChar();
        if(this.leido.length()==10){
            this.setVisible(false);
        }
    }

    public void bloquea() {
        this.setVisible(true);
    }

    public String getLectura() {
        String salida=leido;
        leido="";
        return salida;
    }
}
