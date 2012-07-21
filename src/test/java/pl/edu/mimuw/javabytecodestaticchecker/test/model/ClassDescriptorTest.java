package pl.edu.mimuw.javabytecodestaticchecker.test.model;

import junit.framework.Assert;
import org.junit.Test;
import pl.edu.mimuw.javabytecodestaticchecker.bytecode.ClassDescriptor;

/**
 * Unit tests for ClassDescriptor class.
 *
 * @author M. Ziemba
 */
public class ClassDescriptorTest {

    //---------------------------------FIELDS----------------------------------

    private static final String CLASS_NAME = "java/util/String";
    private static final String OTHER_CLASS_NAME
            = "java/sql/PreparedStatement";

    //----------------------------------TESTS----------------------------------

    @Test
    public void testEqualsSameClasses() {
        ClassDescriptor descriptor1 = new ClassDescriptor(CLASS_NAME);
        ClassDescriptor descriptor2 = new ClassDescriptor(CLASS_NAME);
        Assert.assertTrue(descriptor1.equals(descriptor2));
        Assert.assertTrue(descriptor2.equals(descriptor1));
    }

    @Test
    public void testEqualsDifferentClasses() {
        ClassDescriptor descriptor1 = new ClassDescriptor(CLASS_NAME);
        ClassDescriptor descriptor2 = new ClassDescriptor(OTHER_CLASS_NAME);
        Assert.assertFalse(descriptor1.equals(descriptor2));
        Assert.assertFalse(descriptor2.equals(descriptor1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidArgument() {
        String className = "java.util.List";
        ClassDescriptor desc = new ClassDescriptor(className);
    }
}
