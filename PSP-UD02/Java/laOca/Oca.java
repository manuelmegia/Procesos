package laOca;

import java.util.logging.*;
import java.util.ArrayList;

public class Oca {

    // creamos un objeto logger para que nos registre la informacion en un log
    static Logger logging = PSPLogger.getLogger(Oca.class.getName());

    public static void main(String[] args) {
        // escribimos el numero de jugadores que van a participar
        int nJug = 10;
        // creamos una lista para introducir los hilos
        ArrayList<Thread> w = new ArrayList<>();
        for (int i = 0; i < nJug; i++) {
            w.add(new Thread(new Jugador(logging)));
        }
        // iniciamos todos los hilos de la lista
        for (int i = 0; i < w.size(); i++) {
            w.get(i).start();
        }
    }
}
