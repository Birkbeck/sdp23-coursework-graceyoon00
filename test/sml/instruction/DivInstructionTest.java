package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

class DivInstructionTest {
    private Machine machine;
    private Registers registers;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
    }

    @Test
    void executeValid() {
        registers.set(EAX, 30);
        registers.set(EBX, 6);
        Instruction instruction = new DivInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(5, machine.getRegisters().get(EAX));
    }

    // throw ArithmeticException for division by 0
    @Test
    void executeValidTwo() {
        registers.set(EAX, 30);
        registers.set(EBX, 0);
        Instruction instruction = new DivInstruction(null, EAX, EBX);
        Assertions.assertThrows(ArithmeticException.class, () -> instruction.execute(machine));
    }
}