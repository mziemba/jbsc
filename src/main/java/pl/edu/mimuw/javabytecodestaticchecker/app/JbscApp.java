package pl.edu.mimuw.javabytecodestaticchecker.app;

import com.google.common.collect.ImmutableList;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.PrivateModule;
import java.util.concurrent.CountDownLatch;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.checker.CheckerService;
import pl.edu.mimuw.javabytecodestaticchecker.checker.CheckerServiceImpl;
import pl.edu.mimuw.javabytecodestaticchecker.input.BcelClassLoader;
import pl.edu.mimuw.javabytecodestaticchecker.input.ClassLoader;
import pl.edu.mimuw.javabytecodestaticchecker.parser.BytecodeParser;
import pl.edu.mimuw.javabytecodestaticchecker.parser.Parser;

/**
 * Main application class.
 *
 * @author M. Ziemba
 */
public class JbscApp extends GuiceApp {

    private CheckerService checkerService;

    private static final Logger log = Logger.getLogger(JbscApp.class);

    @Override
    protected Iterable<? extends Module> getGuiceModules() {
        return ImmutableList.of(
                    new FileLoaderModule(),
                    new ParserModule(),
                    new CheckerModule()
                );
    }

    @Override
    public void guiceStart(Injector injector, CountDownLatch stopWaitLatch) {
        log.info("Starting application");
        super.guiceStart(injector, stopWaitLatch);
        checkerService = injector.getInstance(CheckerService.class);
        checkerService.startAndWait();
    }

    @Override
    public void stop() {
        log.info("Stopping application");
        if (checkerService != null) {
            checkerService.stopAndWait();
        }
    }

    //------------------------------MODULES------------------------------------

    private class FileLoaderModule extends PrivateModule {
        @Override
        protected void configure() {
            bind(ClassLoader.class).to(BcelClassLoader.class);
            expose(ClassLoader.class);
        }
    }

    private class ParserModule extends PrivateModule {
        @Override
        protected void configure() {
            bind(Parser.class).to(BytecodeParser.class);
            expose(Parser.class);
        }
    }

    private class CheckerModule extends PrivateModule {
        @Override
        protected void configure() {
            bind(CheckerService.class).to(CheckerServiceImpl.class);
            expose(CheckerService.class);
        }
    }
}
