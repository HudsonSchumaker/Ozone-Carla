package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.lexer.o3.O3VariableTypeValue;
import lombok.Data;

/**
 * This class holds the name, value and type map between O3 variable.
 *
 * @author schumaker
 */
@Data
public class X64Variable {

    private final String internalName;
    private final String internalFunctionName;
    private final O3VariableTypeValue<O3VariableType, ?> typeValue;
    private final X64O3VariableMap varTypeMap;
    
    private X64Variable(String name, String funcName, O3VariableTypeValue<O3VariableType, ?> typeValue, X64O3VariableMap varTypeMap) {
        this.internalName = name;
        this.internalFunctionName = funcName;
        this.typeValue = typeValue;
        this.varTypeMap = varTypeMap;
    }
    
    public static X64Variable of(String name, String funcName, O3VariableTypeValue<O3VariableType, ?> typeValue, X64O3VariableMap varTypeMap) {
        return new X64Variable(name, funcName, typeValue, varTypeMap);
    }
}
