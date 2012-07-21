package pl.edu.mimuw.javabytecodestaticchecker.input;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.apache.log4j.Logger;

/**
 * Provides instance of ClassLoader based on config.
 *
 * @author M. Ziemba
 */
public class ClassLoaderProvider implements Provider<ClassLoader> {
    private static final Logger log
            = Logger.getLogger(ClassLoaderProvider.class);

    private ClassLoader loader;

    @Inject
    public ClassLoaderProvider() {
        String fileName = "";
        if (log.isDebugEnabled()) log.debug("Loading class " + fileName);
        loader = new TextClassLoader(fileName);
    }

    @Override
    public ClassLoader get() {
        return loader;
    }

}
