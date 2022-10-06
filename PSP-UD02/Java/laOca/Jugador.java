package laOca;

import java.util.Random;
import java.util.logging.*;

public class Jugador implements Runnable {

    private int pos = 0;
    Logger logging;

    public Jugador(Logger logging) {
        this.logging = logging;
    }

    protected static Random ra = new Random();
    protected static int MAXESPERA = 2000;

    @Override
    public void run() {
        Thread p = Thread.currentThread();
        while (pos != 100) {
            try {
                Thread.sleep(1 + ra.nextInt(MAXESPERA));
            } catch (InterruptedException e) {
                break;
            }
            int dados = ra.nextInt(6) + 1;
            logging.info(p + "Posicion: " + pos + "\n" + p + "Has sacado: " + dados);
            if (pos < 100) {
                pos += dados;
            } else if (pos > 100) {
                pos -= dados;
            }
            logging.info(p + "Nueva Posicion: " + pos);
            if (pos == 100) {
                p.getThreadGroup().interrupt();
                logging.info("HAS GANADO " + p);
            }
        }
    }
}
