import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PrimerEjercicio {




    public static void main(String[] args) throws IOException {
        List<String> lineas= Files.readAllLines(Paths.get("idiomas.txt"));


        Map<String,Set<String>> idiomas=new TreeMap<>();

        Iterator<String> iterador=lineas.iterator();
        while(iterador.hasNext()) {
            String pais=iterador.next();
            String idiomasLinea=iterador.next();
            String[] idiomasSeparados=idiomasLinea.split(",");
            //List<String> listaIdiomas=idiomasSeparados.asList();
            Set<String> listaIdiomas=new TreeSet<>();
            for (String s :
                    idiomasSeparados) {
                listaIdiomas.add(s.trim());
            }
            idiomas.put(pais,listaIdiomas);
        }


        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("pepe.obj"))){
            oos.writeObject(idiomas);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("MALO");
        }


        //Importante porque es interesante como ejercicio para un examen
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
