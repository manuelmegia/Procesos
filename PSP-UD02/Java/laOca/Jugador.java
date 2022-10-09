package laOca;

import java.util.Random;
import java.util.logging.*;

public class Jugador implements Runnable {

    // creo una variable posicion para marcar donde está el hilo en cada momento y
    // otra para marcar cual es el maximo antes de parar
    private int pos = 0, max = 100;

    // creamos un objeto logging
    Logger logging;

    // creamos su constuctor para que se escriban los datos en el log del que se le
    // referencie y no cree mas archivos log
    public Jugador(Logger logging) {
        this.logging = logging;
    }

    // creamos un objeto random para poder generar numeros aleatorios
    protected static Random ra = new Random();
    // creamos una variable para saber el máximo de segundos que queremos que
    // esperen los hilos
    protected static int MAXESPERA = 2000;

    @Override
    public void run() {
        // creamos un bucle para que los recorran los hilos
        while (pos != max) {
            try {
                // cada vez que inicie el bucle mandamos a dormir el hilo en un tiempo aleatorio
                // entre 1 y el MAXESPERA
                Thread.sleep(1 + ra.nextInt(MAXESPERA));
            } catch (InterruptedException e) {
                // cuando el hilo no esté vivo interrumpe el metodo
                break;
            }
            // el dado genera un númeo aleatorio entre 1 y 6
            int dados = ra.nextInt(6) + 1;
            // introducimos datos en el log
            logging.info(Thread.currentThread() + "Posicion: " + pos + "\n" + Thread.currentThread() + "Has sacado: "
                    + dados);
            // la posición va avanzando según el numero que haya salido en el dado
            pos += dados;
            // si la posición es mayor al número máximo se resta la posición del dadopara
            // acercarse al objetivo
            if (pos > max) {
                pos -= dados * 2;
            }
            // introducimos datos en el log
            logging.info(Thread.currentThread() + "Nueva Posicion: " + pos);
            // si la posición es igual al tamaño maximo de la partida manda a dormir a todos
            // los hilos del grupo
            if (pos == max) {
                Thread.currentThread().getThreadGroup().interrupt();
                // introducimos datos en el log
                logging.info("HAS GANADO " + Thread.currentThread());
            }
        }
    }
}
