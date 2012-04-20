/**
 * ParserTest class
 * @version 1.0.0
 * @date 2012-02-03, 20:29
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.test;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstruction;
import pl.edu.mimuw.javabytecodestaticchecker.parser.BytecodeParser;
import pl.edu.mimuw.javabytecodestaticchecker.parser.ParseException;
import pl.edu.mimuw.javabytecodestaticchecker.parser.Parser;

/**
 * Tests for Parser module.
 *
 */
public class ParserTest extends JbscTestCase {

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

    /**
     * Prepares testing environment.
     */
    @Override
    protected void setUp() {
        parser = new BytecodeParser();
    }

    @Override
    protected void tearDown() {
    }

    //----------------------------------TESTS----------------------------------

    public void testParseEmptyInput() {
        log.info("Running testParseEmptyInput");
        try {
            List<BytecodeInstruction> instructions =
                    parser.parse(TEST_EMPTY_CODE);
            assertNull("Abstract Syntax Tree is not null as it should be",
                    instructions);
            String input = null;
            instructions = parser.parse(input);
            assertNull("Abstract Syntax Tree is not null as it should be",
                    instructions);
        } catch (ParseException exception) {
            fail("Unexpected parse exception");
        }
    }

    public void testParseBadSyntaxInput() {
        log.info("Running testParseBadSyntaxInput");
    }

    public void testParseValidInput() {
        log.info("Running testParseValidInput");
        try {
            List<BytecodeInstruction> instructions =
                    parser.parse(TEST_CODE);
            Iterator<BytecodeInstruction> iter = instructions.iterator();
            while (iter.hasNext()) {
                log.debug("Element: " + iter.next());
            }
            assertEquals(TEST_CODE_LINES, instructions.size());
        } catch (ParseException exception) {
            fail("Unexpected parse exception");
        }
    }
}
