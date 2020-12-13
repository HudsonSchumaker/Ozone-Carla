package br.com.schumaker.carla.o3.enums;

import lombok.Getter;

/**
 * This enumerator defines data type in bytes.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum O3VariableTypeSize {

    VOID(0),
    BYTE(1),    // byte,  1byte (db), 8 bits
    BOOL(1),    // byte,  1byte (db), 8 bits
    CHAR(1),    // byte,  1byte (db), 8 bits
    STRING(8),
    INT(4),      // 8bytes, 64bits
    DOUBLE(8);   // 8bytes, 64bits

    private final int size; // size in bytes

    private O3VariableTypeSize(int size) {
        this.size = size;
    }

}
