/**
 * @author M. Ziemba
 * @version 1.0.0
 * 2011-12-29, 12:11
 */
package pl.edu.mimuw.javabytecodestaticchecker.parser;

import com.google.inject.AbstractModule;

/**
 * Guice configuration class for Parser module.
 *
 */
public class ParserModule extends AbstractModule {
    
    public void configure() {
        bind(Parser.class).to(BytecodeParser.class);
    }
    
}
