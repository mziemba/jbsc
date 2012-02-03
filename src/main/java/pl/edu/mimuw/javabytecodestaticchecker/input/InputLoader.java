/**
 * @version 1.0.0
 * @date 2012-01-30, 21:13
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.input;

/**
 * Interface.
 *
 */
public interface InputLoader {

    /**
     * Loads resource to memory and returns it as String.
     *
     * @return String representation of loaded resource
     */
    String load();

}
