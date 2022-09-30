import java.util.logging.Logger;

public class HelloThread extends Thread {
    private static Logger logging = PSPLogger.getLogger(HelloThread.class.getName());
    
    public void run() {
        logging.info("Hola desde Thread");
    }

    public static void main (String[] args) {
        // Se llama a start, que pertenece a la clase Thread
        (new HelloThread()).start();
    }
}
