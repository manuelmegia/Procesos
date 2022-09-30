import java.lang.System.Logger;

public class HelloThread extends Thread {
    private static Logger logging = PSPLogger.getLogger(HelloThread.cla);

    public void run() {
    logging.info("Hola desde Thread");
}

    public class Main {
        public static void main(String[] args) {
            (new HelloThread()).start();
        }
    }
}