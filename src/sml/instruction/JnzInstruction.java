package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

// jnz s L : If the contents of register s is not zero, then make the statement labeled L the next statement to execute
public class JnzInstruction extends Instruction {
	private final RegisterName register;
	private final String label;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName source, String getLabel) {
		super(label, OP_CODE);
		this.register = source;
		this.label = getLabel;
	}

	@Override
	public int execute(Machine m) throws NullPointerException {
		int val = m.getRegisters().get(register);
		if (val == 0) return NORMAL_PROGRAM_COUNTER_UPDATE;
		int getAdd = m.getLabels().getAddress(label);
		return getAdd;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + register + " " + label;
	}

	//implement equals
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		JnzInstruction that = (JnzInstruction) o;

		if (register != that.register) return false;
		return label == that.label;
	}

	//implment hashCode
	@Override
	public int hashCode() {
		return Objects.hash(register, label);
	}

}
