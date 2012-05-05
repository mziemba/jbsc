package pl.edu.mimuw.javabytecodestaticchecker.test;

import junit.framework.TestCase;

/**
 * Abstract class for JBSC test cases.
 *
 * @author M. Ziemba
 */
public abstract class JbscTestCase extends TestCase {

    protected static final String TEST_BYTECODE_PROGRAM =
            "0:   iconst_2"
            + "1:   istore_1"
            + "2:   iload_1"
            + "3:   sipush  1000"
            + "6:   if_icmpge       44"
            + "9:   iconst_2"
            + "10:  istore_2"
            + "11:  iload_2"
            + "12:  iload_1"
            + "13:  if_icmpge       31"
            + "16:  iload_1"
            + "17:  iload_2"
            + "18:  irem"
            + "19:  ifne    25"
            + "22:  goto    38"
            + "25:  iinc    2, 1"
            + "28:  goto    11"
            + "31:  getstatic       #84; //Field java/lang/System.out:Ljava/io/PrintStream;"
            + "34:  iload_1"
            + "35:  invokevirtual   #85; //Method java/io/PrintStream.println:(I)V"
            + "38:  iinc    1, 1"
            + "41:  goto    2"
            + "44:  return";
}
