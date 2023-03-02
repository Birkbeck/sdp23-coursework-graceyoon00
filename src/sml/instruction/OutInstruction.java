package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

// out s : prints the contents of register s on the console
public class OutInstruction extends Instruction {
    private final RegisterName register;

    public static final String OP_CODE = "out";

    public OutInstruction(String label, RegisterName source) {
        super(label, OP_CODE);
        this.register = source;
    }

    @Override
    public int execute(Machine m) {
        int val = m.getRegisters().get(register);
        System.out.println(register.name() + ": " + val);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + register;
    }

    //implement equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutInstruction that = (OutInstruction) o;

        if (label != that.label) return false;
        return register == that.register;
    }

    //implment hashCode
    @Override
    public int hashCode() {
        return Objects.hash(label, register);
    }
}