package pl.edu.mimuw.javabytecodestaticchecker.lang;

import java.util.List;

/**
 *
 * @author M. Ziemba
 */
public abstract class BytecodeInstruction {

    protected InstructionType type;
    protected List<String> arguments;

    public List<String> getArguments() {
        return arguments;
    }

    public InstructionType getType() {
        return type;
    }

}
