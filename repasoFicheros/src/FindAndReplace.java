import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindAndReplace {
    //FindAndReplace palabra1 palabra2 file [file2]
//    Sustituye palabra1 por palabra2 en file (si se le pasa file2
//    pone el resultado en file2)
    public static void main(String[] args) throws IOException {
      if(args.length<3){
          System.out.println("ERROR, faltan parámetros");
          return;
      }
      if(args.length>4){
            System.out.println("ERROR, sobran parámetros");
            return;
      }
      String ficheroOut="";
      if(args.length==3){
          System.out.println("sustituiré " + args[0] + " por " + args[1] + " en " + args[2]);
          ficheroOut=args[2];
      }

      if(args.length==4){
            System.out.println("sustituiré " + args[0] + " por " + args[1] + " del fichero " + args[2]+" guardándolo al fichero "+args[3]);
            ficheroOut=args[3];
      }

      encuentraYSustituye(args[0],args[1],args[2],ficheroOut);
    }

    private static void encuentraYSustituye(
            String palabraOriginal,
            String palabraASustituir,
            String primerFichero,
            String segundoFichero) throws IOException {
        File primero=new File(primerFichero);
        if(!primero.exists()){
            throw new IllegalArgumentException("El primer fichero no existe");
        }

        try(BufferedReader br=new BufferedReader(new FileReader(primerFichero));
            PrintWriter pw=new PrintWriter(segundoFichero);
                ){
            String lineaActual=br.readLine();
            while(lineaActual!=null){
                String nuevaLinea=lineaActual.replace(palabraOriginal,palabraASustituir);
                pw.println(nuevaLinea);
                lineaActual=br.readLine();
            }
        }
//        List<String> lineas= Files.readAllLines(Paths.get(primerFichero));
//
//        List<String> nuevas=new ArrayList<>();
//        for (String s :
//                lineas) {
//            nuevas.add(s.replace(palabraOriginal, palabraASustituir));
//        }
//
//        Files.write(Paths.get(segundoFichero),nuevas);
    }
}
