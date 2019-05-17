import java.io.*;
import java.util.Map;
import java.util.Set;

public class SegundoEjercicio {
    public static void main(String[] args) {
        Map<String,Set<String>> idiomas=null;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("pepe.obj"))){
            idiomas=(Map<String,Set<String>>)ois.readObject();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("MALO");
        }

        for (Map.Entry<String, Set<String>> entrada :
                idiomas.entrySet()) {
            System.out.println(entrada.getKey());
            for (String s :
                    entrada.getValue()) {
                System.out.println("      -"+s);
            }
        }
    }
}
