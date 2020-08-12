package br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the functions of O³ pl. Ex: f: main() { ; some code
 * here... }
 *
 * @author schumaker
 */
@Data
@AllArgsConstructor
public class O3Function {

    private String name;
    private String internalName;
    private boolean isMain;
    private List<O3Variable> params; 
    private IO3Statement statement;
    private IO3VariableTable variableTable;

    @Override
    public String toString() {
        return "{\n"
                + "Name : " + name + ",\n"
                + "Internal Name : " + internalName + ",\n"
                + "Is Main : " + isMain + ",\n"
                + "Params  : " + params + ",\n"
                + "Variables : " + ((O3FunctionStatement)statement).getVariables()
                + "FunctionCalls : " +((O3FunctionStatement)statement).getFunctionCalls()
                + "\n}";
    }
}
