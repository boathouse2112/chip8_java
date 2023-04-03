package com.markmurphydev;

import java.util.NoSuchElementException;

public class Console {

    public Cpu cpu;
    public Memory memory;

    public Console(Cpu cpu, Memory memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    public void step() {
        var opcode = memory.readU16(cpu.pc);
        cpu.pc += 2;

        var instruction = Instruction.INSTRUCTIONS.stream().filter(instr -> instr.match(opcode)).findAny().orElseThrow();
//        var x = instruction.x();
//        var y = instruction.y();
//        var n = instruction.n();

        switch(instruction.type) {
            case RETURN -> {
            }
            case JUMP -> {
                cpu.pc = 1;
            }
        };
    }
}
