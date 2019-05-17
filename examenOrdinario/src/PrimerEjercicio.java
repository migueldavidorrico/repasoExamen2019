public class PrimerEjercicio {
    public static void main(String[] args) {
        List<String> lineas=Files.reallLines(Paths.get("idiomas.txt"));


        Map<String,List<String>> idiomas=new TreeMap<>();

        Iterator<String> iterador=lineas.Iterator();
        while(iterador.hasNext()) {
            String pais=iterador.next();
            String idiomas=iterador.next();
            String[] idiomasSeparados=idiomas.split(",");
            //List<String> listaIdiomas=idiomasSeparados.asList();
            List<String> listaIdiomas=new ArrayList<>();
            for (String s :
                    idiomasSeparados) {
                listaIdiomas.add(s);
            }
            idiomas.put(pais,listaIdiomas);
        }






        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("pepe.obj"))){
            oos.writeObject(idiomas);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("MALO");
        }
    }
}
