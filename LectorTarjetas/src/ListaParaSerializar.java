import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaParaSerializar {

    public static void main(String[] args) {
        MiLista favoritos=new MiLista();
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        favoritos.add((new Dummy()));
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("ppe"))){
            oos.writeObject(favoritos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        MiLista leido;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("ppe"))){
            leido= (MiLista) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        JFileChooser chooser=new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            chooser.showOpenDialog(null);
            chooser.getSelectedFile();






    }
}
