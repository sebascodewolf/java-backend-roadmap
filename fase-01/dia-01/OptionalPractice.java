import java.util.*;

class Producto {
    String nombre;
    Double precio;

    Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    String getNombre() { return nombre; }
    Double getPrecio() { return precio; }
}

// Dia 01 - Bloque 1: Optional
public class OptionalPractice {
    static Optional<Producto> buscarProducto(String nombre) {
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", 2500.00),
                new Producto("Mouse", 45.00),
                new Producto("Teclado", 120.00)
        );
        return productos.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public static void main(String[] args) {

        // 1. Busca "Laptop" y muestra su precio.
        //    Si no existe muestra "Producto no encontrado"
        System.out.println(buscarProducto("Laptop").orElseThrow(() -> new RuntimeException("Producto no encontrado")).getPrecio());

        // 2. Busca "Monitor" y lanza una RuntimeException
        //    con mensaje "Producto Monitor no encontrado"
        //    (usa try-catch para que no explote el programa)
        try{
            System.out.println(buscarProducto("Monitor").orElseThrow(() -> new RuntimeException("Producto Monitor no encontrado")));
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // 3. Busca "Mouse" y muestra el nombre en mayúsculas
        //    usando map() + orElse()
        System.out.println(buscarProducto("Mouse").map(p -> p.getNombre().toUpperCase()).orElse("Deconocido"));

        // 4. Busca "Teclado" y usando ifPresentOrElse:
        //    si existe imprime "Precio: [precio]"
        //    si no existe imprime "Sin stock"
        buscarProducto("Teclado").ifPresentOrElse(
                p -> System.out.println(p.getPrecio()),
                () -> System.out.println("Sin stock")
        );

    }
}