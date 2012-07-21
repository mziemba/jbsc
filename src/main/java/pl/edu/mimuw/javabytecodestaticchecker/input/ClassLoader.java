package pl.edu.mimuw.javabytecodestaticchecker.input;

import pl.edu.mimuw.javabytecodestaticchecker.context.ClassContext;

/**
 * Class loader interface.
 *
 * @author M. Ziemba
 */
public interface ClassLoader {

    ClassContext loadClass(String className);
}
