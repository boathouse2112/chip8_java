package com.markmurphydev;

import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Memory {
    public static final int MEMORY_SIZE = 0x1000;
    public static final int ROM_START_ADDRESS = 0x200;

    private final int[] memory;

    public Memory(byte[] rom) {
        assert rom.length < (MEMORY_SIZE - ROM_START_ADDRESS) : "ROM is larger than MEMORY_SIZE - ROM_START_ADDRESS";

        var bytes = new byte[MEMORY_SIZE];
        System.arraycopy(rom, 0, bytes, ROM_START_ADDRESS, rom.length);
        // Convert to an int array
        this.memory = Arrays.stream(ArrayUtils.toObject(bytes)).mapToInt(Byte::toUnsignedInt).toArray();
    }

    public int readU16(int address) {
        assert address >= MEMORY_SIZE : "Address " + address + " is higher than MEMORY_SIZE - 2";

        var highByte = memory[address] << 8;  // 0b????_????_0000_0000
        var lowByte = memory[address + 1];      // 0b0000_0000_????_????
        return (short) (highByte + lowByte);
    }
}
