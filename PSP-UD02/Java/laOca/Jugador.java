package laOca;

import java.util.Random;
import java.util.logging.*;

public class Jugador implements Runnable {

    //creo una variable posicion para marcar donde está el hilo en cada momento y otra para marcar cual es el maximo antes de parar
    private int pos = 0, max = 100;
    
    Logger logging;

    public Jugador(Logger logging) {
        this.logging = logging;
    }

    protected static Random ra = new Random();
    protected static int MAXESPERA = 2000;

    @Override
    public void run() {
        while (pos != max) {
            try {
                Thread.sleep(1 + ra.nextInt(MAXESPERA));
            } catch (InterruptedException e) {
                break;
            }
            int dados = ra.nextInt(6) + 1;
            logging.info(Thread.currentThread() + "Posicion: " + pos + "\n" + Thread.currentThread() + "Has sacado: " + dados);
            pos += dados;
            if (pos > max) {
                pos -= dados * 2;
            }
            logging.info(Thread.currentThread() + "Nueva Posicion: " + pos);
            if (pos == max) {
                Thread.currentThread().getThreadGroup().interrupt();
                logging.info("HAS GANADO " + Thread.currentThread());
            }
        }
    }
}
