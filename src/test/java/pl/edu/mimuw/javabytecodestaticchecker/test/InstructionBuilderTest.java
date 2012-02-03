/**
 * InstructionBuilderTest class
 * @version 1.0.0
 * 2012-02-11, 17:05
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.test;

import junit.framework.TestCase;
import pl.edu.mimuw.javabytecodestaticchecker.lang.InstructionType;
import pl.edu.mimuw.javabytecodestaticchecker.lang.LoadInstruction;
import pl.edu.mimuw.javabytecodestaticchecker.lang.StoreInstruction;

/**
 * Tests for building instruction objects from Strings.
 *
 */
public class InstructionBuilderTest extends TestCase {

    public void testCreateStoreInstruction() {
        String instruction = "astore_1";
        StoreInstruction storeInstruction = new StoreInstruction(instruction);
        assertEquals(0, storeInstruction.getArguments().size());
        assertEquals(InstructionType.REFERENCE, storeInstruction.getType());
    }

    public void testCreateLoadInstruction() {
        String instruction = "iload_0";
        LoadInstruction loadInstruction = new LoadInstruction(instruction);
        assertEquals(InstructionType.INTEGER, loadInstruction.getType());
        assertEquals(0, loadInstruction.getArguments().size());
    }
}
