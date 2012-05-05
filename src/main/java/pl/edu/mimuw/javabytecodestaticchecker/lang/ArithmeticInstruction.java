package pl.edu.mimuw.javabytecodestaticchecker.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 * Class representing arithmetic bytecode instructions, such as iadd, imul.
 *
 * @author M. Ziemba
 */
public class ArithmeticInstruction extends BytecodeInstruction {

    //----------------------------------FIELDS---------------------------------

    private static final String ADD_PATTERN = "(.*)add";
    private static final Logger log = Logger.getLogger(StoreInstruction.class);
    Instruction instruction;

    /**
     * Constructs new LoadInstruction instance based on given String.
     *
     * @param stringInstruction String representing the instruction
     */
    public ArithmeticInstruction(String stringInstruction) {
        Pattern pattern = Pattern.compile(ADD_PATTERN);
        Matcher matcher = pattern.matcher(stringInstruction);
        if (matcher.find()) {
            this.type =
                BytecodeInstructionBuilder.mapInstructionType(matcher.group(1));
            this.instruction = Instruction.ADD;
        }
        this.arguments = new ArrayList<String>(1);
        log.info("Created object: " + this);
    }

    @Override
    public String toString() {
        return "ArithmeticInstruction [instruction=" + instruction
                + ", type=" + type + ", args=" + arguments.size() + "]";
    }

    public enum Instruction {
        ADD(0);

        private int instruction;

        private Instruction(int instruction) {
            this.instruction = instruction;
        }

        public int getInstruction() {
            return instruction;
        }
    }
}
