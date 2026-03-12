import java.util.function.*;

// Dia 01 - Bloque 1: Lambdas e interfaces funcionales
public class Lambdas {
    public static void main(String[] args) {

        // 1. Function: convierte un nombre a mayúsculas
        Function<String, String> aMayusculas = x -> x.toUpperCase();
        System.out.println(aMayusculas.apply("arturo")); // ARTURO

        // 2. Predicate: verifica si un número es par
        Predicate<Integer> esPar = x -> x%2 == 0;
        System.out.println(esPar.test(4));  // true
        System.out.println(esPar.test(7));  // false

        // 3. Consumer: imprime un mensaje con prefijo "[LOG] "
        Consumer<String> logger = x -> System.out.println(("LOG ").concat(x));
        logger.accept("Sistema iniciado"); // [LOG] Sistema iniciado

        // 4. Supplier: retorna tu nombre completo
        Supplier<String> miNombre = () -> "Arturo Garcia";
        System.out.println(miNombre.get()); // Arturo Garcia
    }
}