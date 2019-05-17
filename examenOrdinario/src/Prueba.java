import java.util.Scanner;
import java.util.Set;

public class Prueba {
    public static void main(String[] args) {
        int num = pedirEntrada();
        mostrarResultado(num);
    }

    private static void mostrarResultado(int num) {
        System.out.println("El doble es "+num*2);
    }

    private static int pedirEntrada() {
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }
}
