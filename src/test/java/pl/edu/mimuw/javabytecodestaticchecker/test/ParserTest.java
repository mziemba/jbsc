package pl.edu.mimuw.javabytecodestaticchecker.test;

import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstruction;
import pl.edu.mimuw.javabytecodestaticchecker.parser.BytecodeParser;
import pl.edu.mimuw.javabytecodestaticchecker.parser.ParseException;
import pl.edu.mimuw.javabytecodestaticchecker.parser.Parser;

/**
 * Tests for Parser module.
 *
 * @author M. Ziemba
 */
public class ParserTest {

    //--------------------------------FIELDS-----------------------------------

    private static final Logger log = Logger.getLogger(ParserTest.class);
    private Parser parser;
    private static final String TEST_CODE =
            "iload_1\n"
            + "iload_2\n"
            + "iadd\n"
            + "istore_3";
    private static final int TEST_CODE_LINES = 4;
    private static final String TEST_EMPTY_CODE = "";

    //----------------------------TEST ENVIRONMENT-----------------------------

    @Before
    public void setUp() {
        parser = new BytecodeParser();
    }

    @After
    public void tearDown() {
    }

    //----------------------------------TESTS----------------------------------

    @Test
    public void testParseEmptyInput() {
        log.info("Running testParseEmptyInput");
        try {
            List<BytecodeInstruction> instructions =
                    parser.parse(TEST_EMPTY_CODE);
            Assert.assertNull("Abstract Syntax Tree is not null as it should be",
                    instructions);
            String input = null;
            instructions = parser.parse(input);
            Assert.assertNull("Abstract Syntax Tree is not null as it should be",
                    instructions);
        } catch (ParseException exception) {
            Assert.fail("Unexpected parse exception");
        }
    }

    @Test
    public void testParseBadSyntaxInput() {
        log.info("Running testParseBadSyntaxInput");
    }

    @Test
    public void testParseValidInput() {
        log.info("Running testParseValidInput");
        try {
            List<BytecodeInstruction> instructions =
                    parser.parse(TEST_CODE);
            Iterator<BytecodeInstruction> iter = instructions.iterator();
            while (iter.hasNext()) {
                log.debug("Element: " + iter.next());
            }
            Assert.assertEquals(TEST_CODE_LINES, instructions.size());
        } catch (ParseException exception) {
            Assert.fail("Unexpected parse exception");
        }
    }
}
