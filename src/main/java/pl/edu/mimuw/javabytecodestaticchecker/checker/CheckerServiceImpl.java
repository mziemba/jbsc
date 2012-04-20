package pl.edu.mimuw.javabytecodestaticchecker.checker;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.input.ClassLoader;
import pl.edu.mimuw.javabytecodestaticchecker.parser.Parser;

/**
 * Implementation of CheckerService, a service that performs a single
 * check of code.
 *
 * @author M. Ziemba
 */
public class CheckerServiceImpl extends AbstractExecutionThreadService
                                implements CheckerService {

    //---------------------------------FIELDS----------------------------------

    @Inject private ClassLoader classLoader;
    @Inject private Parser parser;
    private static final Logger log =
            Logger.getLogger(CheckerServiceImpl.class);

    @Override
    protected void shutDown() throws Exception {
        log.info("Stopping CheckerService");
        super.shutDown();
    }

    @Override
    protected void startUp() throws Exception {
        log.info("Starting CheckerService");
        super.startUp();
    }

    @Override
    protected void run() throws Exception {
        log.info("Running the service");
        if (classLoader == null) {
            log.warn("Failed to inject InputLoader");
        }
        if (parser == null) {
            log.warn("Failed to inject Parser");
        }
        classLoader.loadClass("java.lang.String");

    }

}
