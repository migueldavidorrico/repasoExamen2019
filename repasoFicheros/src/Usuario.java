import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Usuario {
    private final String nombre;
    private byte[] pass;


    public byte[] getPass() {
        return pass;
    }

    public boolean loginCorrecto(String nombre,String password){
        if(!nombre.equals(this.nombre)){
            return false;
        }
        byte[] encriptada=null;
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            encriptada = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(Arrays.equals(encriptada,this.pass)) {
            return true;
        }
        return false;

    }

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            this.pass = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Usuario(String nombre, byte[] pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", longitud de pass: "+pass.length+" pass=");
        if (pass == null) sb.append("null");
        else {
            byte[] encoded = Base64.getEncoder().encode(pass);
            sb.append(new String(encoded));
        }
        sb.append('}');
        return sb.toString();
    }

    public void setPass(String pass) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            this.pass = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }



}
