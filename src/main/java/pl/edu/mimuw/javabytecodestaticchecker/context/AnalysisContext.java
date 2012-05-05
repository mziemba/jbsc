package pl.edu.mimuw.javabytecodestaticchecker.context;

import com.google.common.collect.Maps;
import com.google.inject.Singleton;
import java.util.Map;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.bytecode.ClassDescriptor;
import pl.edu.mimuw.javabytecodestaticchecker.model.ClassContext;

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

    //-------------------------------CONSTRUCTOR-------------------------------

    public AnalysisContext() {
        log.info("Creating AnalysisContext");

    }

    //---------------------------------METHODS---------------------------------

    public void createCodeRepository() {
        log.info("Creating code repository");
        classes = Maps.newHashMap();
    }

    public ClassContext getClassContext(ClassDescriptor classDesc) {
        return classes.get(classDesc);
    }
}
