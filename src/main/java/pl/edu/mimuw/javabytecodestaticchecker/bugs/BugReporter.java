package pl.edu.mimuw.javabytecodestaticchecker.bugs;

/**
 * Class holding information about found bugs through the
 * execution of various analyses.
 *
 * @author M. Ziemba
 */
public interface BugReporter {

    void addBug(String bug);

    void printAllBugs();
}
