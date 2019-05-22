import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictado {
    //Ir recogiendo líneas que va escribiendo el usuario y guardarlas en un fichero
    //hasta escribir FIN
    public static void main(String[] args) throws IOException {
        List<String> dictado=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        try {
            while (true) {
                System.out.print(":");
                String entrada = sc.nextLine();
                if ("FIN".equals(entrada)) {
                    break;
                }
                dictado.add(entrada);

            }
        }finally {
            Files.write(Paths.get(args[0]+".conLista"),dictado);
        }


        try(PrintWriter pw=new PrintWriter(args[0]);
            Scanner sc2=new Scanner(System.in)) {
            while(true) {
                System.out.print(":");
                String entrada = sc2.nextLine();
                if ("FIN".equals(entrada)) {
                    break;
                }
                pw.println(entrada);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
