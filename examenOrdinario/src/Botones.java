import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones {
    static JFrame frame;
    static JButton botonArriba = new JButton("Arriba");
    static JButton botonAbajo = new JButton("Aabjo");
    static JLabel etiqueta = new JLabel();
    static int pulsadasArriba = 0;
    static int pulsadasAbajo = 0;

    public static void main(String[] args) {
        frame = new JFrame("DOS BOTONES");
//TITULO
        frame.setResizable(false);
        frame.setLayout(new GridLayout(3,0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//CERRAR VENTANA
        frame.add(etiqueta);
        frame.add(botonArriba);
        frame.add(botonAbajo);


        botonArriba.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {
                //A rellenar por el alumno
             pulsadasArriba++;
             actualizaEtiqueta();


         }
     });
        botonAbajo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                //A rellenar por el alumno
            pulsadasAbajo++;
            actualizaEtiqueta();
        }
    });
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
            //MUESTRA LA VENTANA
    }

    private static void actualizaEtiqueta() {
        etiqueta.setText("<html>Has pulsado " + pulsadasArriba + " el botón de arriba<br> y " + pulsadasAbajo + " veces el botón de abajo");

    }
}