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
        lines.forEach(line -> {
            variables.add(this.getVariable(functionName, line));
        });
        return variables;
    }

    public O3Variable getVariable(String functionName, O3FileLine line) {
        var type = this.getType(line.getData());
        switch (type) {
            case STRING:
                return new O3Variable(this.getVariableName(line.getData()),
                        functionName + "_" + this.getVariableName(line.getData()),
                        O3VariableTypeValue.of(type, this.getValueString(line.getData())));
            case BOOL:
                return new O3Variable(this.getVariableName(line.getData()),
                        functionName + "_" + this.getVariableName(line.getData()),
                        O3VariableTypeValue.of(type, this.getValueBoolean(line.getData())));
            case FLOAT:
                return new O3Variable(this.getVariableName(line.getData()),
                        functionName + "_" + this.getVariableName(line.getData()),
                        O3VariableTypeValue.of(type, this.getValueFloat(line.getData())));
            default:
                return new O3Variable(this.getVariableName(line.getData()),
                        functionName + "_" + this.getVariableName(line.getData()),
                        O3VariableTypeValue.of(type, this.getValueInteger(line.getData())));  
        }
    }

    public O3VariableType getType(String data) {
        var value = data.substring(data.indexOf(O3Keyword.ASSINGN), data.length()).trim();
         
        if (value.contains("\"")){
            return O3VariableType.STRING;
        } else {
           if (value.contains(O3Keyword.TRUE) || value.contains(O3Keyword.FALSE)) {
               return O3VariableType.BOOL;
           } 
           if (value.contains(O3Keyword.FLOATING_POINT_SIGN)) {
               return O3VariableType.FLOAT;
           }
           return O3VariableType.INT; 
        }
    }

    public String getValueString(String data) {
        var clean = data.trim();
        return clean.substring(clean.indexOf(O3Keyword.ASSINGN) + 1, clean.length()).trim();
    }
    
    public Boolean getValueBoolean(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSINGN) + 1, clean.length()).trim();
        return Boolean.valueOf(value);
    }
    
    public Integer getValueInteger(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSINGN) + 1, clean.length()).trim();
        return Integer.valueOf(value);
    }
    
    public Float getValueFloat(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSINGN) + 1, clean.length() - 1).trim();
        return Float.valueOf(value);
    }
    
    public String getVariableName(String data) {
        var clean = data.trim();
        var name = clean.substring(O3Keyword.VARIABLE.length(), clean.length()).trim();
        name = name.substring(0, name.indexOf(O3Keyword.ASSINGN)).trim();
        return name;
    }
}
