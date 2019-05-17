import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {
    public static void main(String[] args) {
        Usuario usuario=new Usuario("miguel","1234");
        System.out.println(usuario);
        Usuario usuario2=new Usuario("pepe","antoniocebolla");
        System.out.println(usuario2);
        Usuario usuario3=new Usuario("juan","password");
        System.out.println(usuario3);

        borraSiExiste("user.otm");
        anyadirUsuarioFichero("user.otm",usuario);
        anyadirUsuarioFichero("user.otm",usuario2);
        anyadirUsuarioFichero("user.otm",usuario3);

        long numeroUsuarios=usuariosEnFichero("user.otm");

        System.out.println(numeroUsuarios);
        Integer[] numerosElegir=new Integer[(int)numeroUsuarios];
        for (int i = 0; i < numerosElegir.length; i++) {
            numerosElegir[i]=i;
        }

        int elegido=(Integer)JOptionPane.showInputDialog(null,"Elija un id","ID",
                JOptionPane.INFORMATION_MESSAGE,null, numerosElegir,0);

        Usuario seleccionado=leeUsuario("user.otm",elegido);
        System.out.println(seleccionado);
        String entrada=JOptionPane.showInputDialog(null,"Hola, "+seleccionado.getNombre()+" Escribe la contraseña para continuar");
        if(usuario.loginCorrecto(seleccionado.getNombre(),entrada)){
            System.out.println("BIEEEEEEEEEEEEEEEEEEEEEEEEEN");
        } else {
            System.out.println("MAAL");
        }

    }

    private static Usuario leeUsuario(String s, int elegido) {
        try(RandomAccessFile raf=new RandomAccessFile(s,"r")){
            raf.seek(elegido*(20+32));
            String nombre=raf.readUTF();
            raf.seek(elegido*(20+32)+20);
            byte[] pass=new byte[32];
            System.out.println("He leido un array de bytes de longitud:" + raf.read(pass));
            return new Usuario(nombre,pass);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long usuariosEnFichero(String s) {
        File f=new File(s);

        return f.length()/(20+32);
    }

    private static void anyadirUsuarioFichero(String s,Usuario u) {
        try(RandomAccessFile raf=new RandomAccessFile(s,"rw")){
            long ultimaPosicion=raf.length();
            raf.seek(ultimaPosicion);
            raf.writeUTF(u.getNombre());
            raf.seek(ultimaPosicion+20);
            raf.write(u.getPass());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void borraSiExiste(String s) {
        File f=new File(s);
        if(f.exists()){
            f.delete();
        }
    }



}
