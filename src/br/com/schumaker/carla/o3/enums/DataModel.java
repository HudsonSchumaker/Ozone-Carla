package br.com.schumaker.carla.o3.enums;

import lombok.Getter;

/**
 * This enumerator defines data type in bytes.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum DataModel {

    VOID(0),
    _8(1),
    _16(2),
    _32(4),
    _64(8);

    private final int size; // size in bytes

    private DataModel(int size) {
        this.size = size;
    }
}
