package com.markmurphydev;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Instruction {
    public static final List<Instruction> INSTRUCTIONS = Arrays.asList(
            new Instruction(InstructionType.RETURN, "00EE"),
            new Instruction(InstructionType.JUMP, "1nnn")
    );

    public final InstructionType type;
    private final String opcodePattern;

    public Instruction(InstructionType type, String opcodePattern) {
        this.type = type;
        this.opcodePattern = opcodePattern;
    }

    /**
     * @param instructionData u16
     */
    public boolean match(int instructionData) {
        var opcodeRegex = this.opcodePattern.replaceAll("[xynXYN]", ".");
        return Pattern.matches(opcodeRegex, Integer.toHexString(instructionData));
    }
}
