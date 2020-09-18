package old.br.com.schumaker.carla.lexer.o3;

import br.com.schumaker.carla.exception.VariableDefaultValueNotFoundException;
import br.com.schumaker.carla.exception.VariableTypeNotFoundException;
import old.br.com.schumaker.carla.o3.O3SyntaxType;

/**
 * This enumerator defines the variables types of O³ pl.
 *
 * @author Hudson Schumaker
 */
public enum O3VariableType {
    VOID("void", "void", O3SyntaxType.VOID.getSize()),
    BYTE("byte", "0", O3SyntaxType.BYTE.getSize()),
    BOOL("bool", "false", O3SyntaxType.BOOL.getSize()),
    CHAR("char", "", O3SyntaxType.CHAR.getSize()),
    STRING("string", "", O3SyntaxType.STRING.getSize()),
    INT("int", "0", O3SyntaxType.INT.getSize()),
    LONG("long", "0", O3SyntaxType.LONG.getSize()),
    FLOAT("float", "0.0", O3SyntaxType.FLOAT.getSize()),
    DOUBLE("double", "0.0", O3SyntaxType.DOUBLE.getSize()),
    PARAM("param", "?", O3SyntaxType.PARAM.getSize()),
    RETURN_STRING("ret_s", "?", O3SyntaxType.RETURN_STRING.getSize()),
    RETURN_INTEGER("ret_i", "?", O3SyntaxType.RETURN_INTEGER.getSize()),
    RETURN_FLOAT("ret_f", "?", O3SyntaxType.RETURN_FLOAT.getSize()),
    RETURN_DOUBLE("ret_d", "?", O3SyntaxType.RETURN_DOUBLE.getSize());

    private final String name;
    private final String defaultValue;
    private final int size; // size in bytes

    private O3VariableType(String name, String defaultValue, int size) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.size = size;
    }
    
    public static O3VariableType getByReference(O3VariableType type) {
        for (O3VariableType vt : O3VariableType.values()){
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
