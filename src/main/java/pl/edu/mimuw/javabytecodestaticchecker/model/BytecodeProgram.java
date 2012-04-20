package pl.edu.mimuw.javabytecodestaticchecker.model;

import java.util.List;
import pl.edu.mimuw.javabytecodestaticchecker.lang.BytecodeInstruction;

/**
 *
 *
 */
public class BytecodeProgram {

    private List<BytecodeInstruction> instructions;



    public List<BytecodeInstruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<BytecodeInstruction> instructions) {
        this.instructions = instructions;
    }

    public void addInstruction(BytecodeInstruction instruction) {
        this.instructions.add(instruction);
    }
}
