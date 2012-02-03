/**
 * @version 1.0.0
 * @date 2011-12-29, 12:23
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.main;

import com.google.inject.AbstractModule;
import pl.edu.mimuw.javabytecodestaticchecker.input.FileInputLoader;
import pl.edu.mimuw.javabytecodestaticchecker.input.InputLoader;

/**
 * Guice configuration for Main module.
 *
 */
public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InputLoader.class).to(FileInputLoader.class);
    }
}
