package pl.edu.mimuw.javabytecodestaticchecker.app;

import java.util.concurrent.CountDownLatch;

/**
 * Interface of a single application class.
 *
 * @author M. Ziemba
 */
public interface App {

    /**
     * Starts application.
     *
     * @param stopWaitLatch synchronization aid
     */
    void start(CountDownLatch stopWaitLatch);

    /**
     * Stops application.
     */
    void stop();
}
