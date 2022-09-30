import java.util.logging.Logger;

public class HelloRunnable implements Runnable {
    private static Logger logging = PSPLogger.getLogger(HelloRunnable.class.getName());

    public void run() {
        logging.info("Hola desde Runnable");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}