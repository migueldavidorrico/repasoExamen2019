import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaVentanas {

    static Toolkit pantalla=Toolkit.getDefaultToolkit();
    private static int ANCHO=pantalla.getScreenSize().width;
    private static int ALTO=pantalla.getScreenSize().height;
    private static int BORDER=20;
    List<JDialog> dialogos= new ArrayList<>();
    {

        dialogos.add(new JDialog());
        dialogos.get(0).getContentPane().setLayout(new FlowLayout());



        dialogos.add(new JDialog());
        dialogos.get(1).getContentPane().setLayout(new GridLayout(0,2,60,60));
        dialogos.add(new JDialog());
        dialogos.get(2).getContentPane().setLayout(new GridBagLayout());
        dialogos.add(new JDialog());
        dialogos.get(3).getContentPane().setLayout(new BorderLayout());

    }




    public List<JDialog> getDialogos() {
        return dialogos;
    }

    public void setDialogos(List<JDialog> dialogos) {
        this.dialogos = dialogos;
    }

    public static void main(String[] args) {

        try{

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        JFrame cerrar=new JFrame("CERRAR");
        cerrar.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cerrar.setBounds(BORDER, BORDER,ANCHO-BORDER*2,ALTO-BORDER*2);
    cerrar.setVisible(true);
        ListaVentanas l=new ListaVentanas();
        l.getDialogos().get(0).setBounds(BORDER*2,BORDER*2,ANCHO/2-BORDER*4,ALTO/2-BORDER*4);
        l.getDialogos().get(1).setBounds(ANCHO/2+BORDER*2,BORDER*2,ANCHO/2-BORDER*4,ALTO/2-BORDER*4);
        l.getDialogos().get(2).setBounds(BORDER*2,ALTO/2+BORDER*2,ANCHO/2-BORDER*4,ALTO/2-BORDER*4);
        l.getDialogos().get(3).setBounds(ANCHO/2+BORDER*2,ALTO/2+BORDER*2,ANCHO/2-BORDER*4,ALTO/2-BORDER*4);
        for (JDialog d :
                l.getDialogos()) {
            d.getContentPane().add(new JLabel("Nombre"));
        }

        for (JDialog d :
                l.getDialogos()) {
            d.getContentPane().add(new TextField("Escriba su nombre"));
        }
    for (JDialog d :
                l.getDialogos()) {
            d.getContentPane().add(new JLabel("Apellidos"));
        }

        for (JDialog d :
                l.getDialogos()) {
            d.getContentPane().add(new TextField("Escriba sus Apellidos"));
        }

        JDialog grid=l.getDialogos().get(2);
        Container panel=grid.getContentPane();
        panel.removeAll();
        JPanel gridBag=new JPanel(new GridBagLayout());
        panel.add(gridBag);
        Map<Component,GridBagConstraints> posiciones=new HashMap<>();

        JLabel nom=new JLabel("Nombre");
        posiciones.put(nom,new GridBagConstraints());
        posiciones.get(nom).gridx=0;
        posiciones.get(nom).gridy=0;
        nom.setAlignmentX(Component.LEFT_ALIGNMENT);
        gridBag.add(nom,posiciones.get(nom));
        GridBagConstraints gbc2=new GridBagConstraints();
        gbc2.gridx=1;
        gbc2.gridy=0;
        gbc2.fill=1;
        gridBag.add(new JTextField("Escriba su nombre"),gbc2);

        GridBagConstraints gbc3=new GridBagConstraints();
        gbc3.gridx=0;
        gbc3.gridy=1;
        gridBag.add(new JLabel("Apellidos"),gbc3);
        GridBagConstraints gbc4=new GridBagConstraints();
        gbc4.gridx=1;
        gbc4.gridy=1;
        gridBag.add(new JTextField("Escriba sus Apellidos"),gbc4);

        GridBagConstraints gbc5=new GridBagConstraints();
        gbc5.gridx=2;
        gbc5.gridy=0;
        gbc5.gridheight=2;
        gbc5.fill=1;
        gridBag.add(new JButton("Pulsame"),gbc5);
        GridBagConstraints gbc6=new GridBagConstraints();
        gbc6.gridx=0;
        gbc6.gridy=3;
        gbc6.gridwidth=3;
        gbc6.fill=1;
        gridBag.add(new JButton("Largo"),gbc6);



        grid.pack();

        for (JDialog d :
                l.getDialogos()) {
            d.setVisible(true);
        }


    }
}
