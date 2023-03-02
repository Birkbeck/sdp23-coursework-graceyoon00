package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

// mov r x: stores integer x in register r
public class MovInstruction extends Instruction {
    private final RegisterName register;
    private final int value;

    public static final String OP_CODE = "mov";

    public MovInstruction(String label, RegisterName register, int value) {
        super(label, OP_CODE);
        this.register = register;
        this.value = value;
    }

    @Override
    public int execute(Machine m) {
        m.getRegisters().set(register, value);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + register + " " + value;
    }
}