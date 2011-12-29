/**
 * @author M. Ziemba
 * @version 1.0.0
 * 2011-12-05, 19:30
 */
package pl.edu.mimuw.javabytecodestaticchecker.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Main application class.
 *
 */
public class Main {
    
    private static Logger logger = Logger.getLogger(Main.class);
    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Starting JavaBytecodeChecker");
 
    }
}
