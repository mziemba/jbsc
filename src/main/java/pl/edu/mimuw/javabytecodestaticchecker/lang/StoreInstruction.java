package pl.edu.mimuw.javabytecodestaticchecker.lang;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 * Class representing group of instructions that store values
 * on operand stack. Amongst these are:
 *  * store
 *
 * @author M. Ziemba
 */
public class StoreInstruction extends BytecodeInstruction {

    //--------------------------------PATTERNS---------------------------------

    private static final String STORE_PATTERN = "(.*)store_(.*)";
    private static final Logger log = Logger.getLogger(StoreInstruction.class);

    public StoreInstruction(String stringInstruction) {
        Pattern pattern = Pattern.compile(STORE_PATTERN);
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
        return "StoreInstruction [type=" + type + ", args="
                + arguments.size() + "]";
    }
}
