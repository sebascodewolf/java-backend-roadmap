// CÓDIGO CON VIOLACIONES

interface Logger {
    void log(String mensaje);
}

class FileLogger implements Logger {
    public void log(String mensaje) {
        System.out.println("Escribiendo en archivo: " + mensaje);
    }
}

class ConsoleLogger implements Logger {
    public void log(String mensaje) {
        System.out.println("Consola: " + mensaje);
    }
}

class DatabaseLogger implements Logger {
    public void log(String mensaje) {
        System.out.println("Data Base: " + mensaje);
    }
}

class UsuarioService {
    // ❌ Depende directamente de FileLogger
//    private FileLogger logger = new FileLogger();
    private Logger logger;

    public UsuarioService(Logger logger) {
        this.logger = logger;
    }

    void registrarUsuario(String nombre) {
        // lógica de negocio
        System.out.println("Registrando usuario: " + nombre);
        logger.log("Usuario registrado: " + nombre);
    }

    void eliminarUsuario(String nombre) {
        // lógica de negocio
        System.out.println("Eliminando usuario: " + nombre);
        logger.log("Usuario eliminado: " + nombre);
    }
}

public class Dip {
    public static void main(String[] args) {
        UsuarioService service1 = new UsuarioService(new FileLogger());
        service1.registrarUsuario("Arturo");
        service1.eliminarUsuario("Arturo");

        UsuarioService service2 = new UsuarioService(new ConsoleLogger());
        service2.registrarUsuario("Carlos");
        service2.eliminarUsuario("Carlos");

        UsuarioService service3 = new UsuarioService(new DatabaseLogger());
        service3.registrarUsuario("Pedro");
        service3.eliminarUsuario("Pedro");
    }
}