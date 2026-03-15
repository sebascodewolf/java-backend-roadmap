import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class InterfazFuncionalAvanzado {
    public static void main(String[] args) {

        // 1. BiFunction — crea una que reciba
        //    (String nombre, String apellido) y retorne
        //    el nombre completo en mayúsculas
        //    Resultado esperado: "ARTURO GARCIA"

        BiFunction<String, String, String> nombreCompleto = (x1, x2) -> x1.toUpperCase().concat(" ").concat(x2.toUpperCase());
        System.out.println(nombreCompleto.apply("arturo", "garcia"));

        // 2. BiFunction + andThen — usa la BiFunction del punto 1
        //    y encadénale un Function que cuente los caracteres
        //    Resultado esperado: 13

        Function<String, Integer> conteo = x -> x.length();
        System.out.println(nombreCompleto.andThen(conteo).apply("arturo", "garcia"));

        // 3. UnaryOperator — crea uno que reciba un String
        //    y retorne el String al revés
        //    Pista: new StringBuilder(s).reverse().toString()
        //    Pruébalo con "backend"
        //    Resultado esperado: "dnekcab"

        UnaryOperator<String> reversa = x -> new StringBuilder(x).reverse().toString();
        System.out.println(reversa.apply("backend"));

        // 4. Usa replaceAll con UnaryOperator para transformar
        //    esta lista: cada elemento debe quedar como
        //    "item_X" donde X es el valor original en minúsculas
        List<String> items = new ArrayList<>(
                Arrays.asList("LAPTOP", "MOUSE", "TECLADO")
        );
        //    Resultado esperado: [item_laptop, item_mouse, item_teclado]

        // UnaryOperator<List<String>> reempla = x -> x.stream().map(y -> ("item_").concat(y.toLowerCase())).collect(Collectors.toList());
        // System.out.println(reempla.apply(items));
        // items.replaceAll()
        // UnaryOperator<String> reempla = x -> x.replaceAll(y -> ("item_").concat(y.toLowerCase())).collect(Collectors.toList());

        items.replaceAll(x -> "item_" + x.toLowerCase());
        System.out.println(items);

        // 5. BinaryOperator — crea uno que reciba dos Strings
        //    y retorne el más largo. Si son iguales retorna el primero.
        //    Pruébalo con ("java", "backend")
        //    Resultado esperado: "backend"

        BinaryOperator<String> comp = (x, y) -> x.length() >= y.length() ? x : y;
        System.out.println(comp.apply("java", "backend"));

    }
}