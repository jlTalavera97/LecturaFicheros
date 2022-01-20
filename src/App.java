import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args)  {

        String fichero = "C:\\Users\\joseluis.talavera\\IdeaProjects\\LecturaFicheros\\Empleados.txt";
        List<Persona> listPerson = new ArrayList<>();
        String cadena;

        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            while((cadena = br.readLine())!=null){

                String[] partes = cadena.split(":");
                Persona persona = new Persona();

                if(partes.length>=3){
                    persona.setNombre(Optional.ofNullable(String.valueOf(partes[0])));
                    persona.setPoblacion(Optional.ofNullable(String.valueOf(partes[1])));
                    persona.setEdad(Optional.of((Integer.parseInt(partes[2]))));
                }else{
                    persona.setNombre(Optional.ofNullable(String.valueOf(partes[0])));
                    persona.setPoblacion(Optional.ofNullable(String.valueOf(partes[1])));
                    persona.setEdad(Optional.of(0));
                }
                listPerson.add(persona);

            }
            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pintarLista(listPerson);

    }
    public static Boolean pintarLista(List<Persona> listPersona){

        AtomicInteger contador = new AtomicInteger(1);

        listPersona.stream()
                .filter(x -> x.getEdad().isPresent())
                .filter(x -> x.getEdad().get() < 25)
                .forEach(x -> System.out.println("Linea "+contador.getAndIncrement()+". Nombre:"+x.getNombre().orElse("Desconocido")+
                        ". Poblacion:"+x.getPoblacion().orElse("Desconocida")+". Edad:"+x.getEdad().orElse(null)));
        return true;
    }
}
