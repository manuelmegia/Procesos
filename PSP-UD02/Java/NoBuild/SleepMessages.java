import java.util.logging.Logger;

public class SleepMessages {
    private static Logger logging = PSPLogger.getLogger(SleepMessages.class.getName());

    public static void main(String args[])
                            throws InterruptedException {      
        // sleep lanza la excepción InterruptedException cuando otra thread
        // interrumpe la actividad
        
        String quatrain[] = {
            "Umbrío por la pena, casi bruno",
            "Porque la pena tizna cuando estalla",
            "Donde yo no me hallo, no se halla",
            "Hombre más apenado que ninguno"
        };

        for (int i = 0;
            i < quatrain.length;
            i++) {
            //Pausa de 4000 ms
            Thread.sleep(4000);
            //Imprime un verso
            logging.info(quatrain[i]);
        }
    }
}
