package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3Keyword;
import br.com.schumaker.carla.o3.O3Variable;
import br.com.schumaker.carla.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3VariableTypeValue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schumaker
 */
public class LexerVariable {

    public List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        var variables = new ArrayList<O3Variable>();
        for (O3FileLine line : lines) {
            variables.add(this.getVariable(functionName, line));
        }
        return variables;
    }

    public O3Variable getVariable(String functionName, O3FileLine line) {
        return new O3Variable(this.getVariableName(line.getData()),
                functionName + "_" + this.getVariableName(line.getData()),
                O3VariableTypeValue.of(this.getType(line.getData()),
                        this.getValue(line.getData())));
    }

    public O3VariableType getType(String data) {
        var value = data.substring(data.indexOf(O3Keyword.ASSINGN), data.length()).trim();
         
        if (value.contains("\"")){
            return O3VariableType.STRING;
        } else {
            // TODO check others types
           return O3VariableType.INT; 
        }
    }

    public Object getValue(String data) {
        return data.substring(data.indexOf(O3Keyword.ASSINGN), data.length()).trim();
    }

    public String getVariableName(String data) {
        var name = data.substring(O3Keyword.VARIABLE.length(), data.length()).trim();
        name = name.substring(0, name.indexOf(O3Keyword.ASSINGN)).trim();
        return name;
    }
}
