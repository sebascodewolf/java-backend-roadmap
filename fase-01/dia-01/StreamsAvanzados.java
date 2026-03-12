import java.util.*;
import java.util.stream.*;

class Empleado {
    String nombre;
    String area;
    double salario;

    Empleado(String nombre, String area, double salario) {
        this.nombre = nombre;
        this.area = area;
        this.salario = salario;
    }
}

// Dia 01 - Bloque 1: Streams Avanzados
public class StreamsAvanzados {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana", "TI", 4500),
                new Empleado("Carlos", "TI", 3800),
                new Empleado("Beto", "RRHH", 3200),
                new Empleado("Diana", "RRHH", 4100),
                new Empleado("Elena", "TI", 5200),
                new Empleado("Frank", "VENTAS", 2900)
        );

        // 1. Agrupar empleados por área
        // Resultado esperado: Map<String, List<Empleado>>
        System.out.println("Exercise 1");
        Map<String, List<Empleado>> empxArea = empleados.
                stream().
                collect(Collectors.groupingBy(e -> e.area));
        System.out.println(empxArea);

        // 2. Contar cuántos empleados hay por área
        // Resultado esperado: Map<String, Long>
        System.out.println("Exercise 2");
        Map<String, Long> empCountxArea = empleados.
                stream().
                collect(Collectors.groupingBy(e -> e.area, Collectors.counting()));
        System.out.println(empCountxArea);

        // 3. Calcular el salario total de toda la empresa con reduce()
        // Resultado esperado: 23700.0
        System.out.println("Exercise 3");
        Double salarios = empleados.
                stream().
                map(e -> e.salario).
                reduce(0.0, Double::sum);
        System.out.println(salarios);

        // 4. Obtener los nombres de empleados de TI
        //    separados por coma en un solo String
        // Resultado esperado: "Ana, Carlos, Elena"
        System.out.println("Exercise 4");
        String nombres = empleados.
                stream().
                filter(e -> e.area.equals("TI")).
                map(e -> e.nombre).
                distinct().
                sorted().
                collect(Collectors.joining(", ", "", ""));
        System.out.println(nombres);

    }
}
