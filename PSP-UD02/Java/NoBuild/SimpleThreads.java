import java.util.logging.Logger;

public class SimpleThreads {
    private static Logger logging = PSPLogger.getLogger(SimpleThreads.class.getName());

    // Muestra un mensaje precedido por
    // el nombre de la tarea actual
    static void threadMessage(String message) {
        // El mensaje va en el parámetro
        // El nombre de la tarea se obtiene de currentThread
        String threadName =
            Thread.currentThread().getName();
        logging.info(String.format("%s: %s%n",
                          threadName,
                          message));
    }

    private static class MessageLoop
        implements Runnable {
        public void run() {
            String quatrain[] = {
                "Umbrío por la pena, casi bruno",
                "Porque la pena tizna cuando estalla",
                "Donde yo no me hallo, no se halla",
                "Hombre más apenado que ninguno"
            };
            try {
                for (int i = 0;
                     i < quatrain.length;
                     i++) {
                    // Pausa de 4 segundos
                    Thread.sleep(4000);
                    // Escribe el verso
                    threadMessage(quatrain[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("Aún no esatba listo");

            }
        }
    }

    public static void main(String args[])
        throws InterruptedException {

        // Si no se dice otra cosa, la variable
        // patience indica una hora.
        long patience = 1000 * 60 * 60;

        // El argumento, si existe, debe poder
        // convertirse a segundos
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Comenzando la tarea MessageLoop");
        long startTime = System.currentTimeMillis();
        
        // Aquí es donde se define la tarea
        Thread t = new Thread(new MessageLoop());
        // Aquí es donde se arranca
        t.start();

        threadMessage("Esperando el final de MessageLoop");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Esperando...");
            
            // Espera de un segundo a que la tarea se pare
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
                // La tarea sigue viva
                threadMessage("Me he hartado. Procedo a interrumpir");
                
                // Se interrumpe la tares
                t.interrupt();
                // Se vuelve a arrancar
                t.join();
            }
        }
        threadMessage("¡Por fin!");
    } 
}
