/**
 * ParseException class
 * @version 1.0.0
 * @date 2012-02-03, 21:55
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.parser;

/**
 * Exception which occurs when parsing of input fails.
 *
 */
public class ParseException extends Exception {

    /**
     * Contructs new ParseException instance with given message.
     *
     * @param message exception message
     */
    public ParseException(String message) {
        super(message);
    }
}
