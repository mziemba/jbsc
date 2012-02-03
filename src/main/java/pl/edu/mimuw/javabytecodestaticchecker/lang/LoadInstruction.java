/**
 * LoadInstruction class
 * @version 1.0.0
 * 2012-02-03, 21:32
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 * Class representing instructions: iload, aload, etc.
 *
 */
public class LoadInstruction extends BytecodeInstruction {

    //----------------------------------FIELDS---------------------------------

    private static final String LOAD_PATTERN = "(.*)load_(.*)";
    private static final Logger log = Logger.getLogger(StoreInstruction.class);

    /**
     * Constructs new LoadInstruction instance based on given String.
     *
     * @param stringInstruction String representing the instruction
     */
    public LoadInstruction(String stringInstruction) {
        Pattern pattern = Pattern.compile(LOAD_PATTERN);
        Matcher matcher = pattern.matcher(stringInstruction);
        if (matcher.find()) {
            this.type =
                BytecodeInstructionBuilder.mapInstructionType(matcher.group(1));
        }
        this.arguments = new ArrayList<String>(1);
        log.info("Created object: " + this);
    }

    @Override
    public String toString() {
        return "LoadInstruction [type=" + type + ", args="
                + arguments.size() + "]";
    }
}
