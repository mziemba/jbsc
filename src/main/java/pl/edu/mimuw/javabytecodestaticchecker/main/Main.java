/**
 * Main
 * @author M. Ziemba
 * @version 1.0.0
 * 2011-12-05, 19:30
 */
package pl.edu.mimuw.javabytecodestaticchecker.main;

import java.util.concurrent.CountDownLatch;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.app.App;
import pl.edu.mimuw.javabytecodestaticchecker.app.JbscApp;

/**
 * Main application class.
 *
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("----------Starting JavaBytecodeChecker----------");
        App app = new JbscApp();
        try {
            CountDownLatch stopWaitLatch = new CountDownLatch(1);
            app.start(stopWaitLatch);
            stopWaitLatch.await();
            app.stop();
        } catch (Throwable exception) {
            log.error("Exception in main()", exception);
            app.stop();
        }
        log.info("----------Stopping JavaBytecodeChecker----------");
    }
}
