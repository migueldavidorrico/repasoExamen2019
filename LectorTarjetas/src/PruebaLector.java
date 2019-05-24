public class PruebaLector {
    public static void main(String[] args) {
        LectorTarjetas lector=new LectorTarjetas();
        lector.bloquea();
        String leido=lector.getLectura();
        System.out.println(leido);
    }
}
