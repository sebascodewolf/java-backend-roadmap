import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class MethodReference {

    static void imprimirMayusculas(String s) {
        System.out.println(s.toUpperCase());
    }

    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("ana", "carlos", "beto", "diana");

        // 1. Convierte a — reescribe como method reference
        // nombres.stream()
        //     .map(s -> s.toUpperCase())
        //     .forEach(s -> System.out.println(s));

        nombres.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // // 2. Reescribe como method reference
        // List<String> res = nombres.stream()
        //     .sorted((a, b) -> a.compareTo(b))
        //     .collect(Collectors.toList());

        List<String> res = nombres.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(res);

        // // 3. Reescribe como method reference
        // Function<String, Integer> longitud = s -> s.length();

        Function<String, Integer> longitud = String::length;
        System.out.println(longitud.apply("hola"));

        // // 4. Reescribe como method reference
        // Supplier<List<String>> crearLista = () -> new ArrayList<>();

        Supplier<List<String>> crearLista = ArrayList::new;
        System.out.println(crearLista);


        // // 5. Esta lambda — ¿se puede convertir a method reference?
        // //    Si no puedes, explica por qué.
        // nombres.stream()
        //     .map(s -> s.toUpperCase() + "!")
        //     .forEach(s -> System.out.println(s));
        nombres.stream()
                .map(s -> s.toUpperCase() + "!")
                .forEach(System.out::println);
        //no se puede modificar el map ya que no solo e sun metodo es mas complejo y el foreach si se puede por que es unicamente el system.out.println
    }
}