package br.com.schumaker.carla.o3;

/**
 * This enumerator defines the variables types of O³ pl.
 *
 * @author schumaker
 */
public enum O3VariableType {
    BYTE("byte", "0", 1),
    BOOL("bool", "false", 1),
    CHAR("char", "", 1),
    STRING("string", "", 8),
    INT("int", "0", 4),
    LONG("long", "0L", 8),
    FLOAT("float", "0.0f", 4),
    DOUBLE("double", "0.0d", 8);

    private final String name;
    private final String defaultValue;
    private final int size; // size in bytes

    private O3VariableType(String name, String defaultValue, int size) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.size = size;
    }

    public static String getDefaultValueByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.defaultValue;
            }
        }
        return null;
    }
    
    public static int getSizeByName(String name) {
        for (O3VariableType vt : O3VariableType.values()) {
            if (vt.name().equals(name)) {
                return vt.size;
            }
        }
        return 0;
    }
    
    public String getName() {
        return name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public int getSize() {
        return size;
    }
}
