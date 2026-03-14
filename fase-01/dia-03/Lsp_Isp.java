// CÓDIGO CON VIOLACIONES

//interface Vehiculo {
//    void acelerar();
//    void frenar();

/// /    void cargarCombustible(); // ¿Y los eléctricos?
/// /    void cargarBateria();     // ¿Y los de gasolina?
/// /    void activarAutopilot();  // ¿Todos los vehículos tienen autopilot?
//}

//ISP
interface VehiculoAutopilot {
    void activarAutopilot();
}

interface VehiculoGasolina {
    void cargarCombustible();
}

interface VehiculoElectrico {
    void cargarBateria();
}

//LSP
interface Auto {
    void acelerar();
    void frenar();
}

class AutoGasolina implements Auto, VehiculoGasolina {
    public void acelerar() {
        System.out.println("Acelerando con gasolina");
    }

    public void frenar() {
        System.out.println("Frenando");
    }

    public void cargarCombustible() {
        System.out.println("Cargando gasolina");
    }
//    public void cargarBateria()      {
//        throw new UnsupportedOperationException("No tengo bateria");
//    }
//    public void activarAutopilot()   {
//        throw new UnsupportedOperationException("No tengo autopilot");
//    }
}

class AutoElectrico implements Auto, VehiculoElectrico {
    public void acelerar() {
        System.out.println("Acelerando con electricidad");
    }

    public void frenar() {
        System.out.println("Frenando");
    }

    //    public void cargarCombustible()  {
//        throw new UnsupportedOperationException("No uso combustible");
//    }
    public void cargarBateria() {
        System.out.println("Cargando bateria");
    }
//    public void activarAutopilot()   {
//        throw new UnsupportedOperationException("No tengo autopilot");
//    }
}

class TeslaModelS implements Auto, VehiculoAutopilot, VehiculoElectrico {
    public void acelerar()           { System.out.println("Acelerando Tesla"); }
    public void frenar()             { System.out.println("Frenando Tesla"); }
//    public void cargarCombustible()  {
//        throw new UnsupportedOperationException("No uso combustible");
//    }
    public void cargarBateria()      { System.out.println("Cargando bateria Tesla"); }
    public void activarAutopilot()   { System.out.println("Autopilot activado"); }
}

public class Lsp_Isp {
    static void probarAuto(Auto auto) {
        auto.acelerar();
        auto.frenar();
    }

    public static void main(String[] args) {
        AutoGasolina autoGasolina = new AutoGasolina();
        AutoElectrico autoElectrico = new AutoElectrico();
        TeslaModelS teslaModelS = new TeslaModelS();

//        autoGasolina.acelerar();
//        autoGasolina.frenar();
        autoGasolina.cargarCombustible();

//        autoElectrico.acelerar();
//        autoElectrico.frenar();
        autoElectrico.cargarBateria();

//        teslaModelS.acelerar();
//        teslaModelS.frenar();
        teslaModelS.cargarBateria();
        teslaModelS.activarAutopilot();


        probarAuto(new AutoGasolina());
        probarAuto(new AutoElectrico());
        probarAuto(new TeslaModelS());
    }
}
