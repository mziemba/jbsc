package pl.edu.mimuw.javabytecodestaticchecker.context;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.bytecode.ClassDescriptor;
import pl.edu.mimuw.javabytecodestaticchecker.input.ClassLoader;

/**
 * Class holding information about all classes in project. It serves as
 * a code repository.
 *
 * @author M. Ziemba
 */
@Singleton
public class AnalysisContext {
    private static final Logger log = Logger.getLogger(AnalysisContext.class);

    //----------------------------------FIELDS---------------------------------

    private Map<ClassDescriptor, ClassContext> classes;
    private ClassLoader loader;

    //-------------------------------CONSTRUCTOR-------------------------------

    @Inject
    public AnalysisContext(ClassLoader loader) {
        log.info("Creating AnalysisContext");
        this.loader = loader;
    }

    //---------------------------------METHODS---------------------------------

    public void createCodeRepository() {
        log.info("Creating code repository");
        //TODO: load classes for project
        classes = Maps.newHashMap();
        classes.put(new ClassDescriptor("java/lang/String"),
                loader.loadClass("java/lang/String"));
    }

    public ClassContext getClassContext(ClassDescriptor classDesc) {
        return classes.get(classDesc);
    }
}
