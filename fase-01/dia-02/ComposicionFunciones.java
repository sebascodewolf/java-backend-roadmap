import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ComposicionFunciones {
    public static void main(String[] args) {

        // 1. Crea un pipeline con andThen que:
        //    - Reciba un número entero
        //    - Lo multiplique por 3
        //    - Le sume 5
        //    - Lo convierta a String con formato "Resultado: X"
        //    Pruébalo con el número 4
        //    Resultado esperado: "Resultado: 17"

        Function<Integer, Integer> mul = x -> x * 3;
        Function<Integer, Integer> sum = x -> x + 5;
        Function<Integer, Integer> res = mul.andThen(sum);
        System.out.println("Resultado: " + res.apply(4));

        // 2. Usando compose — crea dos funciones:
        //    - dividirEntre2: divide entre 2
        //    - restarTres: resta 3
        //    Usa compose para que primero reste 3 y luego divida entre 2
        //    Pruébalo con 10
        //    Resultado esperado: 3  (10-3=7... espera, (10-3)/2 = 3.5)
        //    Usa integers: (10-3)/2 = 3 por división entera

        Function<Integer, Integer> div = x -> x / 2;
        Function<Integer, Integer> rest = x -> x - 3;
        Function<Integer, Integer> res2 = div.compose(rest);
        System.out.println("Resultado: " + res2.apply(10));

        // 3. Crea tres Predicates y combínalos con and/or:
        //    - empiezaConA: el String empieza con "A" o "a"
        //    - longitudMayorTres: longitud > 3
        //    - noContieneNumeros: no contiene dígitos
        //    Filtra esta lista con los tres combinados:
        List<String> palabras = Arrays.asList(
                "Ana", "Alberto123", "al", "Algoritmo", "auto", "Beta"
        );
        //    Resultado esperado: [Ana, Algoritmo, auto]
        //    (empieza con A/a, longitud > 3 o exactamente Ana tiene 3...
        //     Ana tiene longitud 3, no cumple > 3... ajusta el predicado a >= 3)

        Predicate<String> empiezaConA = x -> x.charAt(0) == 'A' || x.charAt(0) == 'a';
        Predicate<String> longitudMayorTres = x -> x.length() >= 3;
        Predicate<String> noContieneNumeros = x -> !x.matches(".*\\d.*");

        Predicate<String> res3 = empiezaConA.and(longitudMayorTres).and(noContieneNumeros);

        System.out.println(palabras.stream().filter(res3).collect(Collectors.toList()));
    }
}
