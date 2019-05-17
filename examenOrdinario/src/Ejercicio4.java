import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4 {
    public static void main(String[] args) {

    }
    private static void punto(int posicion,int x, int y) throws IOException {
    //Rellenar por el alumno
        try(RandomAccessFile raf=new RandomAccessFile("puntos.dat","rw")){
            raf.seek(posicion*(4+4));
            raf.writeInt(x);
            raf.writeInt(y);
        }
    }
}
