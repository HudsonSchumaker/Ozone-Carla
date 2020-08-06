 package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3Keyword;
import br.com.schumaker.carla.lexer.o3.O3Variable;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.lexer.o3.O3VariableTypeValue;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O³ variables representations.
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
                        this.getVariableInternalName(functionName,line.getData()),
                        O3VariableTypeValue.of(type, this.getValueString(line.getData())));
            case BOOL:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName,line.getData()),
                        O3VariableTypeValue.of(type, this.getValueBoolean(line.getData())));
            case FLOAT:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName,line.getData()),
                        O3VariableTypeValue.of(type, this.getValueFloat(line.getData())));
            default:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName,line.getData()),
                        O3VariableTypeValue.of(type, this.getValueInteger(line.getData())));  
        }
    }
    
    /**
     * Creates the the parameters list of a function, based on the name of the 
     * function and the declared parameters.
     * Formula: p_ + functionName +_ + nameOfVarible + :
     * Ex:
     * f: print(v: text) {
     *   ;some code...
     * }
     * The internal name of the "v: text" variable will be "p_main_text:" 
     * 
     * @param functionName name of the function that the parameter is declared
     * @param headerLine O3Line that holds the function signature
     * @return the parameters list of the function
     */
    public List<O3Variable> getParameters(String functionName, O3FileLine headerLine) {
        var raw = headerLine.getData().trim().substring(
                headerLine.getData().trim().indexOf(O3Keyword.OPEN_EXPRESSION) + 1,
                headerLine.getData().trim().indexOf(O3Keyword.CLOSE_EXPRESSION));
        
        var rawParams = raw.split(",");
        if (!this.validParamsArray(rawParams)) {
            return new ArrayList<>();
        }
        
        var params = new ArrayList<O3Variable>();
        for (String p : rawParams) {
            var clean = p.trim();
            var param = clean.substring(O3Keyword.VARIABLE.length(), clean.length()).trim();
            var internalName = "p_" + functionName + "_" + param + ":";
            params.add(new O3Variable(param, internalName, 
                    O3VariableTypeValue.of(O3VariableType.PARAM, 
                            O3VariableType.PARAM.getDefaultValue())));
        }        
        return params;
    }
    
    public boolean validParamsArray(String[] rawParams) {
        if (rawParams.length == 0) {
            return false;
        } else {
            if (rawParams.length == 1) {
                if (StringUtils.isBlankString(rawParams[0])) {
                    return false;
                }
            }
        }
        return true;
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
    
    /**
     * Creates the the internal name of a variable, based on the name of the 
     * function and the declared name of the variable.
     * Formula: functionName + _ + nameOfVarible + :
     * Ex:
     * f: main() {
     *   v: text = "Hello World!!!"
     * }
     * The internal name of the "v: text" variable will be "main_text:" 
     * 
     * @param functionName name of the function that the variable is inside
     * @param data content from a O3FileLine.getData()
     * @return variable internal name
     */
    public String getVariableInternalName(String functionName, String data) {
        return functionName + "_" + this.getVariableName(data) + ":";
    }
}