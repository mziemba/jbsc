package pl.edu.mimuw.javabytecodestaticchecker.input;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import com.google.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.context.ClassContext;

/**
 * Loads class data from given file.
 *
 * @author M. Ziemba
 */
@Singleton
public class TextClassLoader implements ClassLoader {

    private static final Logger log = Logger.getLogger(TextClassLoader.class);

    private String fileName;

    /**
     * Constructs new FileLoader instance with given file name.
     *
     * @param fileName name of file
     */
    public TextClassLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ClassContext loadClass(String className) {
        Preconditions.checkArgument(className != null,
                "Class name should not be null");
        ClassContext context = null;
        File file = new File(getClass().getResource(fileName).getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException exc) {
            log.error("Exception while reading file", exc);
        }
        context = ClassContext.builder().setClassName(className).build();
        return context;
    }
}
