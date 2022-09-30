import java.util.logging.*;

public class PSPLogger {

    private static String lname;

    private static Logger postConfigureLogger(Logger l) {
        // La configuración consiste en leer el fichero local
        // de logging.properties y aplicarlo
        try {
            LogManager.getLogManager().readConfiguration(
                MultiRequester.class.getResourceAsStream("logging.properties")
            );
        } catch (Exception ex) {
            l.severe("Problemas con el fichero de propiedades");
        }

        try {
             // El nombre del log para cada clase será el de la clase,
             // seguida de .log
             FileHandler fh = new FileHandler(lname + ".log");
             l.addHandler(fh);
        } catch (Exception ex) {
            l.severe("Problemas con el fichero de log");
        }
        l.setLevel(Level.FINEST);
        return l;
    }

    static public Logger getLogger(String name) {
        lname = name;
        // Obtiene un objeto Logger y lo configura
        Logger logger = Logger.getLogger(name);
        return postConfigureLogger(logger);
    }
}
