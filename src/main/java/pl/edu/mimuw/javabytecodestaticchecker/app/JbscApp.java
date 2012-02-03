/**
 * JbscApp class
 * @version 1.0.0
 * @date 2012-02-03, 19:26
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.app;

import org.apache.log4j.Logger;

/**
 * Main application class.
 *
 */
public class JbscApp extends GuiceApp {

    private static final Logger log = Logger.getLogger(JbscApp.class);

    @Override
    public void start() {
        log.info("Starting application");
    }

    @Override
    public void stop() {
        log.info("Stopping application");
    }

}
