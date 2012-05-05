package pl.edu.mimuw.javabytecodestaticchecker.parser;

/**
 * Exception which occurs when parsing of input fails.
 *
 * @author M. Ziemba
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
