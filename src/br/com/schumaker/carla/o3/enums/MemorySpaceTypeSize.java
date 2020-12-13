package br.com.schumaker.carla.o3.enums;

import lombok.Getter;

/**
 * This enumerator defines data type in bytes.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum MemorySpaceTypeSize {

    VOID(0),
    BYTE(1),     // byte, 1byte, 8bits
    BOOL(1),     // byte, 1byte, 8bits
    CHAR(1),     // byte, 1byte, 8bits
    STRING(8),   // ?
    INT(8),      // 8bytes, 64bits
    DOUBLE(8),   // 8bytes, 64bits
    PARAM(8);    // 8bytes, 64bits

    private final int size; // size in bytes

    private MemorySpaceTypeSize(int size) {
        this.size = size;
    }
}
