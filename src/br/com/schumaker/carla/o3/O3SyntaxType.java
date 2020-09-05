package br.com.schumaker.carla.o3;

import lombok.Getter;

/**
 * Core class that defines data type in bytes.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum O3SyntaxType {
    VOID(0),
    BYTE(1),    // byte,  1byte (db), 8 bits
    BOOL(1),    // byte,  1byte (db), 8 bits
    CHAR(1),    // byte,  1byte (db), 8 bits
    STRING(8), 
    INT(4),     // doubleword, 4bytes (dd), 32bits
    LONG(8),    // quadword,   8bytes (dq), 64bits
    FLOAT(4),   // doubleword, 4bytes (dd), 32bits
    DOUBLE(8),  // quadword,   8bytes (dq), 64bits
    PARAM(8),   // quadword,   8bytes (dq), 64bits
    RETURN(8);  // quadword,   8bytes (dq), 64bits

    private final int size; // size in bytes
    private O3SyntaxType(int size) {
        this.size = size;
    }
}
