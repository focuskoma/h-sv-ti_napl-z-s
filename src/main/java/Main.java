import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker KIJELENTES = MarkerManager.getMarker("KIJELENTES");
    private static final Marker KERELEM = MarkerManager.getMarker("KERELEM");

    public static void main(String[] args) throws InterruptedException {
        int iterationCount = 2;
        if (args.length == 1) {
            iterationCount = Integer.parseInt(args[0]);
        }

        for (int i = 1; i <= iterationCount; i++) {
            ThreadContext.put("iterationNumber", String.valueOf(i));

            logger.info("Zöld erdőben jártam");
            logger.trace(KIJELENTES, "Kék ibolyát láttam");
            logger.warn(KIJELENTES, "El akart hervadni");
            logger.debug(KERELEM, "Szabad-e locsolni?");

            ThreadContext.clearAll();
            Thread.sleep(1000);
        }
    }
}
