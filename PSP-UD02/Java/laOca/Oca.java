package laOca;

import java.util.ArrayList;

public class Oca {

    public static void main(String[] args) {
        ThreadGroup uwu = new ThreadGroup("name");
        int nJug = 5;
        ArrayList<Thread> w = new ArrayList<>();
        for (int i = 0; i < nJug; i++) {
            w.add(new Thread(uwu, new Jugador()));
        }
        for (int i = 0; i < w.size(); i++) {
            w.get(i).start();
        }
    }
}
