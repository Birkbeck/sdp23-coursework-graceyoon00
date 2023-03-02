package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

// TODO: write a JavaDoc for the class

/**
 * @author
 */

// jnz s L : If the contents of register s is not zero, then make the statement labeled L the next statement to execute
public class JnzInstruction extends Instruction {
	private final RegisterName register;
	private final String label;

	public static final String OP_CODE = "jnz";

	public JnzInstruction(String label, RegisterName source, String goToLabel) {
		super(label, OP_CODE);
		this.register = source;
		this.label = goToLabel;
	}

	@Override
	public int execute(Machine m) throws NullPointerException {
		int value = m.getRegisters().get(register);
		if (value == 0) return NORMAL_PROGRAM_COUNTER_UPDATE;
		int goToAddress = m.getLabels().getAddress(label);
		return goToAddress;
	}

	@Override
	public String toString() {
		return getLabelString() + getOpcode() + " " + register + " " + label;
	}
}
