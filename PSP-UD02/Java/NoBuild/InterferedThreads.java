public class InterferedThreads {
     private class Counter {
        private int c = 0;
    
        public  void increment() {
            c++;
        }
    
        public  void decrement() {
            c--;
        }
    
        public  int value() {
            return c;
        }
    }

    Counter c;

    private static void touch_counter(Counter c, long n, Boolean up) {
        for (int i=0; i < n; i++) {
            if (up) {
                c.increment();
            }
            else {
                c.decrement();
            }

        }
    }

    public InterferedThreads() {
        c = new Counter();
    }

    public static void main(String[] args) {

        InterferedThreads ift = new InterferedThreads();
        
        int NTHREADS = 2;
        long NCALLS = 1000000;

        Thread[] tinc = new Thread[NTHREADS];
        Thread[] tdec = new Thread[NTHREADS];

        for (int i= 0; i<NTHREADS; i++) {    
            tinc[i] = new Thread(()-> touch_counter(ift.c, NCALLS, true));
            tdec[i] = new Thread(()-> touch_counter(ift.c, NCALLS, false));
        }

        for (int i= 0; i<NTHREADS; i++) {          
            tinc[i].start();
            tdec[i].start();
        }

        for (int i= 0; i<NTHREADS; i++) {  
            try {
                tinc[i].join();
                tdec[i].join();    
            }  catch (InterruptedException e) {
                System.out.println(e);
            }      
        }

        System.out.println(ift.c.value());
        
    }
}
