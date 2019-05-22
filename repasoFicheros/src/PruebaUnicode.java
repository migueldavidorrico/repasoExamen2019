import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.RandomAccessFile;
import java.util.Random;

public class PruebaUnicode {
    public static void main(String[] args) {
        int[][] mapa=new int[20][20];
        Random r=new Random();
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j]=10+ r.nextInt(5);
            }
        }
        JPanel panel=new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(new Color(0,0,0));
                g.fillRect(g.getClipBounds().x,g.getClipBounds().y,g.getClipBounds().width,g.getClipBounds().height);
                for(int i=0;i<mapa.length;i++){

                }
//                g.setColor(new Color(20,200,mapa[i][j]));
                g.draw3DRect(10,10,10,10,true);
            }
        };

        JFrame ventana=new JFrame("PRUEBA");
        ventana.setLayout(new BorderLayout());


        ventana.add(panel);


        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setBounds(20,20,200,200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
