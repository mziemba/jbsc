package pl.edu.mimuw.javabytecodestaticchecker.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.concurrent.CountDownLatch;

/**
 * Main Guice application configuration.
 *
 * @author M. Ziemba
 */
public abstract class BaseApp implements App {

    /**
     *
     * @return
     */
    protected abstract Iterable<? extends Module> getGuiceModules();

    protected void guiceStart(Injector injector,
                              final CountDownLatch stopWaitLatch) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                BaseApp.this.stop();
                stopWaitLatch.countDown();
            }
        });
    }

    @Override
    public void start(CountDownLatch stopWaitLatch) {
        Injector injector = Guice.createInjector(getGuiceModules());
        guiceStart(injector, stopWaitLatch);
    }

    @Override
    public void stop() {
    }
}
