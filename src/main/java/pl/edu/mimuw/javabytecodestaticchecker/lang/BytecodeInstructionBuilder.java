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
        if (instruction.matches("(.*)load(.*)")) {
            return new LoadInstruction(instruction);
        } else if (instruction.matches("(.*)store(.*)")) {
            return new StoreInstruction(instruction);
        } else if (instruction.matches("(.*)add(.*)")) {
            return new ArithmeticInstruction(instruction);
        } else {
            return new LoadInstruction("arg1 arg2");
        }
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
