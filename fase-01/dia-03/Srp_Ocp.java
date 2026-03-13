import java.util.Map;
import java.util.HashMap;

// CODIGO CON VIOLACIONES - refactoriza esto
class Pedido {
    int id;
    String producto;
    double precio;
    String tipoPago;

    public Pedido(int id, String producto, double precio, String tipoPago) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.tipoPago = tipoPago;
    }

    // Violación SRP — responsabilidad 1
    double calcularImpuesto() {
        return precio * 0.18; // IGV Peru
    }
    //Se queda este metodo por ser logica de negocio

    // Violación SRP — responsabilidad 2
//    void guardar() {
//        System.out.println("INSERT INTO pedidos VALUES(" + id + ")");
//    }
//    debe estar en un repository

    // Violación SRP — responsabilidad 3
//    void enviarConfirmacion() {
//        System.out.println("Enviando email de confirmacion del pedido " + id);
//    }
//    debe estar en una clase email para la gestion del correo

    // Violación OCP — agregar nuevo tipo de pago requiere modificar esta clase
//    double calcularComision() {
//        if (tipoPago.equals("TARJETA")) {
//            return precio * 0.03;
//        } else if (tipoPago.equals("YAPE")) {
//            return precio * 0.01;
//        } else if (tipoPago.equals("EFECTIVO")) {
//            return 0;
//        }
//        return 0;
//    }
}

class RepositoryPedido {
    public void guardar(int id) {
        System.out.println("INSERT INTO pedidos VALUES(" + id + ")");
    }
}

class PedidoNotificacion {
    public void enviarConfirmacion(int id) {
        System.out.println("Enviando email de confirmacion del pedido " + id);
    }
}

interface ComisionPago {
    public double calcularComision(double precio);
}

class CalculoTarjeta implements ComisionPago {
    public double calcularComision(double precio) {
        return precio * 0.03;
    }
}

class CalculoYape implements ComisionPago {
    public double calcularComision(double precio) {
        return precio * 0.01;
    }
}

class CalculoEfectivo implements ComisionPago {
    public double calcularComision(double precio) {
        return 0;
    }
}

public class Srp_Ocp {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1, "polo", 20.0, "YAPE");
        RepositoryPedido repositoryPedido = new RepositoryPedido();
        repositoryPedido.guardar(pedido.id);
        PedidoNotificacion pedidoNotificacion = new PedidoNotificacion();
        pedidoNotificacion.enviarConfirmacion(pedido.id);

        Map<String, ComisionPago> comisiones = new HashMap<>();
        comisiones.put("TARJETA", new CalculoTarjeta());
        comisiones.put("YAPE", new CalculoYape());
        comisiones.put("EFECTIVO", new CalculoEfectivo());

        ComisionPago comision = comisiones.getOrDefault(
                pedido.tipoPago,
                precio -> 0.0
        );
        double comisionPago = comision.calcularComision(pedido.precio);
        System.out.println("Comision de pago del pedido "+pedido.id+" es: "+comisionPago);
    }
}