package pl.edu.mimuw.javabytecodestaticchecker.bugs;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Implementation of BugReporter interface using console output.
 *
 * @author M. Ziemba
 */
@Singleton
public class ConsoleBugReporter implements BugReporter {
    private static final Logger log = Logger.getLogger(BugReporter.class);

    private List<String> foundBugs;

    public ConsoleBugReporter() {
        if (log.isDebugEnabled()) log.debug("Creating BugReporter");
        foundBugs = Lists.newLinkedList();
    }

    //---------------------------INTERFACE METHODS-----------------------------

    @Override
    public void addBug(String bug) {
        foundBugs.add(bug);
    }

    @Override
    public void printAllBugs() {
        if (foundBugs.isEmpty()) {
            log.info("No bugs found");
        }
        for (String bug : foundBugs) {
            log.info("Found: " + bug);
        }
    }
}
