package pl.edu.mimuw.javabytecodestaticchecker.parser;

import java.util.ArrayList;
import java.util.List;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstruction;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstructionBuilder;

/**
 * Parser for Java Bytecode.
 *
 * @author M. Ziemba
 */
public class BytecodeParser implements Parser {

    @Override
    public List<BytecodeInstruction> parse(String input) {
        //check for empty input
        if (input == null || input.equals("")) {
            return null;
        }
        //input is not empty
        String[] lines = input.split("\n");
        List<BytecodeInstruction> result =
                new ArrayList<BytecodeInstruction>(1);
        for (int i = 0; i < lines.length; i++) {
            result.add(BytecodeInstructionBuilder.build(lines[i]));
        }
        return result;
    }

}
