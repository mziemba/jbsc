package pl.edu.mimuw.javabytecodestaticchecker.bytecode;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * Class descriptor used for distinguishing analyzed classes.
 *
 * @author M. Ziemba
 */
public class ClassDescriptor {

    //-------------------------------FIELDS------------------------------------

    private final String className;
    private static final Pattern ANONYMOUS_CLASS_NAME
            = Pattern.compile(".*\\$[0-9]*$");

    public ClassDescriptor(String className) {
        Preconditions.checkArgument(!StringUtils.contains(className, "."),
                "Class name should not contain '.'");
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public boolean isAnonymousClass() {
    	return ANONYMOUS_CLASS_NAME.matcher(className).matches();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassDescriptor other = (ClassDescriptor) obj;
        if (!Objects.equal(this.className, other.className)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(className);
    }
}
