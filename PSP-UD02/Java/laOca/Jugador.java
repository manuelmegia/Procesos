package laOca;

import java.util.Random;

public class Jugador implements Runnable {

    int pos = 0;

    static Random ra = new Random();

    @Override
    public void run() {
        Thread p = Thread.currentThread();
        while (pos != 63) {
            try {
                Thread.sleep(50);
                System.out.println(p + "Posicion: " + pos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int dados = ra.nextInt(6) + 1;
            System.out.println(p + "Has sacado: " + dados);
            if (pos < 63) {
                pos += dados;
            } else {
                pos -= dados;
            }
            if (pos==63) {
                System.out.println("HAS GANADO AAAAAAAAAAAAAAAAAAAAAAAAAA" + p);
            }
            if (p.getThreadGroup().activeCount() != 5) {
                break;
            }
        }
    }

    public int getPos() {
        return pos;
    }
}
