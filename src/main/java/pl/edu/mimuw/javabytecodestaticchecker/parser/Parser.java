package pl.edu.mimuw.javabytecodestaticchecker.parser;

import java.util.List;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstruction;

/**
 * Parser interface.
 *
 * @author M. Ziemba
 */
public interface Parser {

    /**
     * Main parser method, it takes String input and parses it into
     * a list of bytecode instructions.
     *
     * @param input String representation of input
     *
     * @return list of bytecode instructions
     */
    List<BytecodeInstruction> parse(String input) throws ParseException;
}
