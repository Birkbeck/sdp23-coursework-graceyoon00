package sml.instruction;

import sml.Instruction;
import sml.RegisterName;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstructionFactory {

    public InstructionFactory() {
    }

    public static InstructionFactory getInstance() {
        return new InstructionFactory();
    }

    /* Standardise name in format "sml.instruction" + (opcode in all caps) + "Instruction" */
    public String getName(String opcode) {
        return "sml.instruction." + opcode.toUpperCase() + "Instruction";
    }

    /* Convert based on types (String.class, int.class, RegisterName.class) */
    public Object[] convertArgs(Object[] args, Class<?>[] types) {
        for (int i = 0; i < args.length; i++) {
            if (types[i] == String.class) {
                args[i] = args[i].toString();
            } else if (types[i] == int.class) {
                args[i] = Integer.parseInt(args[i].toString());
            } else if (types[i] == RegisterName.class) {
                args[i] = Registers.Register.valueOf(args[i].toString());
            }
        }
        return args;
    }

    /* Constructing instruction */
    public Instruction constructInstruction(String opcode, Object[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> instructionClass = Class.forName(getName(opcode));
        Constructor<?> constructor = instructionClass.getConstructor(String.class, RegisterName.class, RegisterName.class);
        Object[] convertedArgs = convertArgs(args, constructor.getParameterTypes());
        return (Instruction) constructor.newInstance(convertedArgs);
    }
}