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
public enum O3VariableType {
    VOID("void", "void", O3VariableTypeSize.VOID.getSize()),
    BYTE("byte", "0", O3VariableTypeSize.BYTE.getSize()),
    BOOL("bool", "0", O3VariableTypeSize.BOOL.getSize()),
    CHAR("char", "", O3VariableTypeSize.CHAR.getSize()),
    STRING("string", "", O3VariableTypeSize.STRING.getSize()),
    INT("int", "0", O3VariableTypeSize.INT.getSize()),
    DOUBLE("double", "0.0", O3VariableTypeSize.DOUBLE.getSize());

    private final String name;
    private final String defaultValue;
    private final int size; // size in bytes

    private O3VariableType(String name, String defaultValue, int size) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.size = size;
    }

    public static O3VariableType getByReference(O3VariableType type) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(type.name())) {
                return vt;
            }
        }
        throw new VariableTypeNotFoundException();
    }

    public static String getDefaultValueByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.defaultValue;
            }
        }
        throw new VariableDefaultValueNotFoundException();
    }

    public static int getSizeByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.size;
            }
        }
        return 0;
    }
}
