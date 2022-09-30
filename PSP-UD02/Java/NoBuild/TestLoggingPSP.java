import java.util.logging.Logger;

public class TestLoggingPSP {
    private static Logger logging = PSPLogger.getLogger(TestLoggingPSP.class.getName());

    public static void main(String[] args) {
        logging.finest("Esto es finest");
        logging.finer("Esto es finer");
        logging.fine("Esto es fine");
        logging.config("Esto es config");
        logging.info("Esto es info");
        logging.warning("Esto es warning");
        logging.severe("Esto es severe");
    }  
}
