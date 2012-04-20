package pl.edu.mimuw.javabytecodestaticchecker.input;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.log4j.Logger;

/**
 * Class loader using BCEL API.
 *
 * @author M. Ziemba
 */
public class BcelClassLoader implements ClassLoader {
    private static final Logger log = Logger.getLogger(BcelClassLoader.class);

    public void loadClass(String className) {
        try {
            JavaClass clazz = Repository.lookupClass(className);
            Method[] methods = clazz.getMethods();
            ConstantPoolGen cp = new ConstantPoolGen(clazz.getConstantPool());

            for(int i=0; i < methods.length; i++) {
                if(!(methods[i].isAbstract() || methods[i].isNative())) {
                    MethodGen mg = new MethodGen(methods[i],
                            clazz.getClassName(), cp);
                }
            }

            clazz.setConstantPool(cp.getFinalConstantPool());
            log.debug("Loaded class: " + clazz);
            //clazz.dump(clazz.getClassName() + "_.class");
        } catch(Exception e) { e.printStackTrace(); }
    }
}
