package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * Translates input file to list of instructions so that we can interpret the text file into a program
 * @author Doyeon Yoon
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

    //implement equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovInstruction that = (MovInstruction) o;

        if (register != that.register) return false;
        return value == that.value;
    }

    //implment hashCode
    @Override
    public int hashCode() {
        return Objects.hash(register, value);
    }
}