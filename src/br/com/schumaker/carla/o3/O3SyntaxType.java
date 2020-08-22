package br.com.schumaker.carla.o3;

import lombok.Getter;

/**
 * Core class that defines data type in bytes.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum O3SyntaxType {
    BYTE(1),
    BOOL(1),
    CHAR(1),
    STRING(8),
    INT(4),
    LONG(8),
    FLOAT(4),
    DOUBLE(8),
    PARAM(8);

    private final int size; // size in bytes

    private O3SyntaxType(int size) {
        this.size = size;
    }
}
