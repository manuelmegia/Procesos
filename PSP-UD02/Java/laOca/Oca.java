package laOca;

import java.util.logging.*;
import java.util.ArrayList;

public class Oca {

    static Logger logging = PSPLogger.getLogger(Oca.class.getName());

    public static void main(String[] args) {
        int nJug = 10;
        ArrayList<Thread> w = new ArrayList<>();
        for (int i = 0; i < nJug; i++) {
            w.add(new Thread(new Jugador(logging)));
        }
        for (int i = 0; i < w.size(); i++) {
            w.get(i).start();
        }
    }
}
