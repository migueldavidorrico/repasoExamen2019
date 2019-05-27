import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PruebaLector {
    static JDialog dialogoERROR;
    static Timer temporizador;
    static LectorTarjetas lector;

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        boolean entradaPermitida = false;
        JFrame miVentana = new JFrame();
        lector = new LectorTarjetas(miVentana);
        while(!entradaPermitida) {
            lector.bloquea();
            String leido = lector.getLectura();
            System.out.println(leido);
            List<String> permitidos = Files.readAllLines(Paths.get("permitidos.txt"));
            System.out.println(permitidos.size());
            if (permitidos.contains(leido)) {
                System.out.println("ACCESO PERMITIDO");
                entradaPermitida = true;
            } else {
                System.out.println("ACCESO DENEGADO");
                dialogoERROR = new JDialog(lector);
                dialogoERROR.setModal(true);
                dialogoERROR.setBounds(0, 0, 480, 360);
                JPanel panelERROR = new JPanel();
                dialogoERROR.add(panelERROR);
                JLabel imagen = new JLabel("");
                panelERROR.add(imagen);
                //Hace falta un fichero de alarma.gif
                ImageIcon imagenIcon = new ImageIcon("alarma.gif");
                imagen.setIcon(imagenIcon);
                temporizador = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        finTemporizador();
                    }
                });
                temporizador.start();



                //Hace falta un fichero de alarma.mp3

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("alarma.wav" +
                        ""));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                dialogoERROR.setVisible(true);





            }
        }
        lector.dispose();
        if(dialogoERROR!=null){
            dialogoERROR.dispose();
        }




    }

    private static void finTemporizador() {
        dialogoERROR.dispose();
        temporizador.stop();
        System.out.println("EER");


    }
}

