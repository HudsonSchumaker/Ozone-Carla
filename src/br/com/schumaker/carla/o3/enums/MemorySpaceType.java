package br.com.schumaker.carla.o3.enums;

import br.com.schumaker.carla.exception.VariableDefaultValueNotFoundException;
import br.com.schumaker.carla.exception.VariableTypeNotFoundException;
import lombok.Getter;

/**
 * This enumerator defines the variables types of O³ p.l.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum MemorySpaceType {
    VOID("void", "void", MemorySpaceTypeSize.VOID.getSize()),
    BYTE("byte", "0", MemorySpaceTypeSize.BYTE.getSize()),
    BOOL("bool", "0", MemorySpaceTypeSize.BOOL.getSize()),
    CHAR("char", " ", MemorySpaceTypeSize.CHAR.getSize()),
    STRING("string", "", MemorySpaceTypeSize.STRING.getSize()),
    INT("int", "0", MemorySpaceTypeSize.INT.getSize()),
    DOUBLE("double", "0.0", MemorySpaceTypeSize.DOUBLE.getSize()),
    PARAM("param", "?", MemorySpaceTypeSize.PARAM.getSize()),
    R_BYTE("r_byte", "0", MemorySpaceTypeSize.BYTE.getSize()),
    R_BOOL("r_bool", "false", MemorySpaceTypeSize.BOOL.getSize()),
    R_CHAR("r_char", " ", MemorySpaceTypeSize.CHAR.getSize()),
    R_STRING("r_str", "", MemorySpaceTypeSize.STRING.getSize()),
    R_INTEGER("r_int", "0", MemorySpaceTypeSize.INT.getSize()),
    R_DOUBLE("r_double", "0.0", MemorySpaceTypeSize.DOUBLE.getSize());

    private final String name;
    private final String defaultValue;
    private final int size; // size in bytes

    private MemorySpaceType(String name, String defaultValue, int size) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.size = size;
    }

    public static MemorySpaceType getByReference(MemorySpaceType type) {
        for (MemorySpaceType vt : MemorySpaceType.values()) {
            if (vt.name().equals(type.name())) {
                return vt;
            }
        }
        throw new VariableTypeNotFoundException();
    }

    public static String getDefaultValueByName(String name) {
        for (MemorySpaceType vt : MemorySpaceType.values()) {
            if (vt.name().equals(name)) {
                return vt.defaultValue;
            }
        }
        throw new VariableDefaultValueNotFoundException();
    }

    public static int getSizeByName(String name) {
        for (MemorySpaceType vt : MemorySpaceType.values()) {
            if (vt.name().equals(name)) {
                return vt.size;
            }
        }
        return -1;
    }
}
