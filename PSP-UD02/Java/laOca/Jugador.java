package laOca;

import java.util.Random;

public class Jugador implements Runnable {

    int pos = 0;

    protected static Random ra = new Random();
    protected static int MAXESPERA = 2000;

    @Override
    public void run() {
        Thread p = Thread.currentThread();
        int wa = p.getThreadGroup().activeCount();
        while (pos != 63) {
            try {
                Thread.sleep(1 + ra.nextInt(MAXESPERA));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (p.getThreadGroup().activeCount() != wa) {
                break;
            }
            int dados = ra.nextInt(6) + 1;
            System.out.println(p + "Posicion: " + pos + "\n" + p + "Has sacado: " + dados);
            if (pos < 63) {
                pos += dados;
            } else if (pos > 63) {
                pos -= dados;
            }
            System.out.println(p + "Nueva Posicion: " + pos);
            if (pos == 63) {
                System.out.println("HAS GANADO AAAAAAAAAAAAAAAAAAAAAAAAAA" + p);
            }
        }
    }
}
