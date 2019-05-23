import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PruebaStream {

    public static void main(String[] args) {
        List<String> lineas=new ArrayList<>();
        lineas.add("aasa");
        lineas.add("ttsa");
        lineas.add("aahgdfngfdsa");
        lineas.add("angfnhgasa");
        lineas.add("adfdsgasa");
        lineas.add("aagdsgsa");
        List<String> nuevas=lineas.stream().map(s->s.replace("a","%")).collect(Collectors.toList());

        nuevas.forEach(System.out::println);
    }
}
