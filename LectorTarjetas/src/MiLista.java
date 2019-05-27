import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MiLista implements Serializable {
    List<Dummy> favoritos;

    public MiLista() {
        this.favoritos = new ArrayList<>();
    }

    public void add(Dummy d){
        favoritos.add(d);
    }
}
