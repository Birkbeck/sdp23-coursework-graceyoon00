package sml.instruction;

import sml.Instruction;
import sml.RegisterName;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstructionFactory {

    public Instruction getInstance(String label, RegisterName result, RegisterName source) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Constructor<?> constructor = null;

        if (label.equals("add")) {
            constructor = AddInstruction.class.getConstructor(String.class, RegisterName.class, RegisterName.class);
        }

        return (Instruction) constructor.newInstance(label, result, source);
    }


}