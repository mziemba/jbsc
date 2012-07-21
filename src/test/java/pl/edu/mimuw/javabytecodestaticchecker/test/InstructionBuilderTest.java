package pl.edu.mimuw.javabytecodestaticchecker.test;

import junit.framework.Assert;
import org.junit.Test;
import pl.edu.mimuw.javabytecodestaticchecker.lang.InstructionType;
import pl.edu.mimuw.javabytecodestaticchecker.lang.LoadInstruction;
import pl.edu.mimuw.javabytecodestaticchecker.lang.StoreInstruction;

/**
 * Tests for building instruction objects from Strings.
 *
 * @author M. Ziemba
 */
public class InstructionBuilderTest {

    @Test
    public void testCreateStoreInstruction() {
        String instruction = "astore_1";
        StoreInstruction storeInstruction = new StoreInstruction(instruction);
        Assert.assertEquals(0, storeInstruction.getArguments().size());
        Assert.assertEquals(InstructionType.REFERENCE, storeInstruction.getType());
    }

    @Test
    public void testCreateLoadInstruction() {
        String instruction = "iload_0";
        LoadInstruction loadInstruction = new LoadInstruction(instruction);
        Assert.assertEquals(InstructionType.INTEGER, loadInstruction.getType());
        Assert.assertEquals(0, loadInstruction.getArguments().size());
    }
}
