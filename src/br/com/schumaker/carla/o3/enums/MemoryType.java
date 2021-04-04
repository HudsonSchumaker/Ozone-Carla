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
public enum MemoryType {

    VOID("void", "void"),
    BOOL("bool", "false"),
    STRING("string", ""),
    INT("int", "0"),
    FLOAT("float", "0.0f"),
    DOUBLE("double", "0.0d"),
    PARAM("param", "?"),
    RETURN("return", "?");

    private final String name;
    private final String defaultValue;

    private MemoryType(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public static MemoryType getByReference(MemoryType type) {
        for (MemoryType vt : MemoryType.values()) {
            if (vt.name().equals(type.name())) {
                return vt;
            }
        }
        throw new VariableTypeNotFoundException();
    }

    public static String getDefaultValueByName(String name) {
        for (MemoryType vt : MemoryType.values()) {
            if (vt.name().equals(name)) {
                return vt.defaultValue;
            }
        }
        throw new VariableDefaultValueNotFoundException();
    }
}
