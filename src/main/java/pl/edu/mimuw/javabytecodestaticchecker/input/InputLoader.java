package pl.edu.mimuw.javabytecodestaticchecker.input;

/**
 * Interface.
 *
 * @author M. Ziemba
 */
public interface InputLoader {

    /**
     * Loads resource to memory and returns it as String.
     *
     * @return String representation of loaded resource
     */
    String load();

}
