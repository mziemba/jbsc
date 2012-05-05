package pl.edu.mimuw.javabytecodestaticchecker.checker;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.bugs.BugReporter;
import pl.edu.mimuw.javabytecodestaticchecker.context.AnalysisContext;

/**
 * Implementation of CheckerService, a service that performs a single
 * check of code.
 *
 * @author M. Ziemba
 */
public class DefaultCheckerService extends AbstractExecutionThreadService
        implements CheckerService {
    private static final Logger log =
            Logger.getLogger(DefaultCheckerService.class);

    //---------------------------------FIELDS----------------------------------

    private AnalysisContext context;
    private BugReporter reporter;

    @Inject
    public DefaultCheckerService(AnalysisContext context,
            BugReporter reporter) {
        this.context = context;
        this.reporter = reporter;
    }

    //----------------------------INTERFACE METHODS----------------------------

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
        executeAnalysis();
    }

    //--------------------------------METHODS----------------------------------

    private void executeAnalysis() {
        context.createCodeRepository();
        reporter.printAllBugs();
    }
}
