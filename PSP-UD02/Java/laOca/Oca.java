package laOca;

import java.util.ArrayList;

public class Oca {

    public static void main(String[] args) {
        ThreadGroup uwu = new ThreadGroup("name");
        
        ArrayList<Thread> w = new ArrayList<>();
        w.add(new Thread(uwu, new Jugador()));
        w.add(new Thread(uwu, new Jugador()));
        w.add(new Thread(uwu, new Jugador()));
        w.add(new Thread(uwu, new Jugador()));
        w.add(new Thread(uwu, new Jugador()));
        for (int i = 0; i < w.size(); i++) {
            w.get(i).start();
        }
        System.out.print(w.get(1).getThreadGroup());
    }
}
