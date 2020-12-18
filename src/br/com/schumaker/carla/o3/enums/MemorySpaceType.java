package br.com.schumaker.carla.o3.enums;

import br.com.schumaker.carla.exception.VariableDefaultValueNotFoundException;
import br.com.schumaker.carla.exception.VariableTypeNotFoundException;
import lombok.Data;
import lombok.Getter;

/**
 * This enumerator defines the variables types of O³ p.l.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum MemorySpaceType {
    VOID("void", "void", DataModel.VOID.getSize()),
    BOOL("bool", "false", DataModel._8.getSize()),
    STRING("string", "", DataModel._32.getSize()),
    INT("int", "0", DataModel._32.getSize()),
    FLOAT("float", "0.0f", DataModel._32.getSize()),
    PARAM("param", "?", DataModel._32.getSize()),
    R_BOOL("r_bool", "false", DataModel._8.getSize()),
    R_STRING("r_str", "", DataModel._32.getSize()),
    R_INTEGER("r_int", "0", DataModel._32.getSize()),
    R_FLOAT("r_float", "0.0f", DataModel._32.getSize());

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
