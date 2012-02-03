/**
 * BytecodeInstructionBuilder class
 * @version 1.0.0
 * 2012-02-11, 17:45
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.lang;

/**
 * Builder class for bytecode instructions.
 *
 */
public class BytecodeInstructionBuilder {

    public static BytecodeInstruction build(String instruction) {
        return new LoadInstruction("arg1 arg2");
    }

    public static InstructionType mapInstructionType(String stringType) {
        if ("a".equals(stringType)) {
            return InstructionType.REFERENCE;
        } else if ("i".equals(stringType)) {
            return InstructionType.INTEGER;
        } else {
            return null;
        }
    }
}
