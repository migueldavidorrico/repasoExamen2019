import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class FicheroTexto {
    public static void main(String[] args) throws IOException {
        File f=new File("texto.txt");
        File f2=new File("texto2.txt");
        String[] pp={"7","6","5","4","5","4"};

        Files.write(f.toPath(), Arrays.asList(pp));
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(f,true))){
            bw.write("8");
            bw.newLine();
        }

        ///////////////////////////////////////////////////////////
        //                                                       //
        //  SSSSSS TTTTTTTT   OOOOO   PPPPPPP                    //
        // S          T      O     O  P      P                   //
        // S          T      O     O  P      P                   //
        //  SSSSS     T      O     O  PPPPPPP                    //
        //       S    T      O     O  P                          //
        //       S    T      O     O  P                          //
        // SSSSSS     T       OOOOO   P                          //
        //                                                       //
        //     ESTO ES IMPORTANTE                                //
        ///////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////
        try(BufferedReader br=new BufferedReader(new FileReader(f))
            ;PrintWriter pw=new PrintWriter(f2);){
            String s;
            while((s=br.readLine())!=null){
                pw.println(Integer.parseInt(s) * 2);
            }
        }
    }
}
