package pl.edu.mimuw.javabytecodestaticchecker.bugs;

import com.google.inject.Singleton;
import org.apache.log4j.Logger;

/**
 * Implementation of BugReporter interface using Json file format.
 *
 * @author M. Ziemba
 */
@Singleton
public class JsonBugReporter implements BugReporter {
    private static final Logger log = Logger.getLogger(JsonBugReporter.class);

    public JsonBugReporter() {
        if (log.isDebugEnabled()) log.debug("Creating BugReporter instance");
    }

    @Override
    public void addBug(String bug) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void printAllBugs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
