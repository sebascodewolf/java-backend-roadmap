// Implementa un sistema de pagos con Factory Pattern

// Contexto: una tienda online acepta diferentes métodos de pago.
// Cada método tiene su propia lógica de procesamiento.

// Lo que debes crear:
// 1. Interfaz MetodoPago con método: void procesar(double monto)

import java.util.Map;
import java.util.HashMap;

interface MetodoPago {
    void procesar(double monto);
}

// 2. Implementaciones:
//    - PagoTarjeta   → "Procesando pago con tarjeta: S/. [monto]"
//    - PagoYape      → "Procesando pago con Yape: S/. [monto]"
//    - PagoBCP       → "Procesando pago con BCP: S/. [monto]"
//    - PagoEfectivo  → "Procesando pago en efectivo: S/. [monto]"

class PagoTarjeta implements MetodoPago {
    public void procesar(double monto) {
        System.out.println("Procesando pago con tarjeta: S/. " + monto);
    }
}

class PagoYape implements MetodoPago {
    public void procesar(double monto) {
        System.out.println("Procesando pago con Yape: S/. " + monto);
    }
}

class PagoBCP implements MetodoPago {
    public void procesar(double monto) {
        System.out.println("Procesando pago con BCP: S/. " + monto);
    }
}

class PagoEfectivo implements MetodoPago {
    public void procesar(double monto) {
        System.out.println("Procesando pago con efectivo: S/. " + monto);
    }
}

// 3. PagoFactory con método estático crear(String tipo)
//    Si el tipo no existe → "Metodo de pago no soportado: [tipo]"

class PagoFactory {
    static MetodoPago crear(String tipo) {
        Map<String, MetodoPago> metodoPagoMap = new HashMap<>();
        metodoPagoMap.put("TARJETA", new PagoTarjeta());
        metodoPagoMap.put("YAPE", new PagoYape());
        metodoPagoMap.put("BCP", new PagoBCP());
        metodoPagoMap.put("EFECTIVO", new PagoEfectivo());
        return metodoPagoMap.getOrDefault(tipo,
                mensaje -> System.out.println("Metodo de pago no soportado: " + tipo)
        );
    }
}

// 4. PagoService que usa la factory — nunca usa new directamente

class PagoService {
    void pago(String tipo, double monto) {
        MetodoPago metodoPago = PagoFactory.crear(tipo);
        metodoPago.procesar(monto);
    }
}

// 5. Main que procese estos pagos:
//    TARJETA → 250.0
//    YAPE    → 45.50
//    BCP     → 180.0
//    EFECTIVO → 30.0
//    BITCOIN → 500.0  (no soportado)

public class FactoryPattern {
    public static void main(String[] args) {
        // tu código aquí
        PagoService service = new PagoService();
        service.pago("TARJETA", 250.0);
        service.pago("YAPE", 45.50);
        service.pago("BCP", 180.0);
        service.pago("EFECTIVO", 30.0);
        service.pago("BITCOIN", 500.0);
    }
}