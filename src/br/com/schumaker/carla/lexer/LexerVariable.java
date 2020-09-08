package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.files.O3FileLine;
import br.com.schumaker.carla.o3.O3SyntaxKeyword;
import br.com.schumaker.carla.lexer.o3.O3Variable;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.lexer.o3.O3VariableTypeValue;
import br.com.schumaker.carla.lexer.utils.StringUtils;
import br.com.schumaker.carla.o3.core.O3CoreLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O³ variables representations.
 *
 * @author Hudson Schumaker
 */
public class LexerVariable {

    private final O3CoreLibrary coreLibrary = new O3CoreLibrary();
    private final LexerArithmetic lexerArithmetic = new LexerArithmetic();

    public List<O3Variable> getVariables(String functionName, List<O3FileLine> lines) {
        var variables = new ArrayList<O3Variable>();
        lines.forEach(line -> {
            variables.add(this.getVariable(functionName, line));
        });
        return variables;
    }

    /**
     * Get a declared variable inside a function.
     *
     * @param functionName
     * @param line
     * @return O3Variable with type and value.
     */
    public O3Variable getVariable(String functionName, O3FileLine line) {
        var type = this.getType(line.getData());
        var isInitialized = this.isInitialized(line.getData());
        switch (type) {
            case STRING:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName, line.getData()),
                        isInitialized,
                        O3VariableTypeValue.of(type, this.getValueString(line.getData())));
            case BOOL:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName, line.getData()),
                        isInitialized,
                        O3VariableTypeValue.of(type, this.getValueBoolean(line.getData())));
            case FLOAT:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName, line.getData()),
                        isInitialized,
                        O3VariableTypeValue.of(type, this.getValueFloat(line.getData())));

            case DOUBLE:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName, line.getData()),
                        isInitialized,
                        O3VariableTypeValue.of(type, this.getValueDouble(line.getData())));

            default:
                return new O3Variable(this.getVariableName(line.getData()),
                        this.getVariableInternalName(functionName, line.getData()),
                        isInitialized,
                        O3VariableTypeValue.of(type, this.getValueInteger(line.getData())));
        }
    }

    /**
     * Creates the the parameters list of a function, based on the name of the
     * function and the declared parameters. Formula: p_ + functionName +_ +
     * nameOfVarible + : Ex: f: print(v: text) { ;some code... } The internal
     * name of the "v: text" variable will be "p_main_text:"
     *
     * @param functionName name of the function that the parameter is declared
     * @param headerLine O3Line that holds the function signature
     * @return the parameters list of the function
     */
    public List<O3Variable> getParameters(String functionName, O3FileLine headerLine) {
        var raw = headerLine.getData().trim().substring(headerLine.getData().trim().indexOf(O3SyntaxKeyword.OPEN_EXPRESSION) + 1,
                headerLine.getData().trim().indexOf(O3SyntaxKeyword.CLOSE_EXPRESSION));

        var rawParams = raw.split(",");
        if (!this.validParamsArray(rawParams)) {
            return new ArrayList<>();
        }

        var params = new ArrayList<O3Variable>();
        for (String p : rawParams) {
            var clean = p.trim();
            var param = clean.substring(O3SyntaxKeyword.VARIABLE.length(), clean.length()).trim();
            var internalName = "p_" + functionName + "_" + param + ":";
            params.add(new O3Variable(param,
                    internalName,
                    false,
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

    /**
     * Resolves the type of declared variable with assignment.
     *
     * @param data Raw line from .o3 file source
     * @return
     */
    public O3VariableType getType(String data) {
        var value = data.substring(data.indexOf(O3SyntaxKeyword.ASSINGN) + 1, data.length()).trim();

        if (data.contains("\"") && !value.contains(O3SyntaxKeyword.PLUS)) {
            return O3VariableType.STRING;
        } else {
            if (value.contains(O3SyntaxKeyword.TRUE) || value.contains(O3SyntaxKeyword.FALSE)) {
                return O3VariableType.BOOL;
            }

            if (value.contains(O3SyntaxKeyword.FLOATING_POINT_SIGN)) {
                if (data.contains(O3SyntaxKeyword.FLOAT_SIGN)) {
                    return O3VariableType.FLOAT;
                }

                if (data.contains(O3SyntaxKeyword.DOUBLE_SIGN)) {
                    return O3VariableType.DOUBLE;
                }
            }

            if (data.contains(O3SyntaxKeyword.OPEN_EXPRESSION)
                    && data.contains(O3SyntaxKeyword.CLOSE_EXPRESSION)) {
                return this.resolveReturnVariableType(data);
            }

            // will treat concatenation of string either.
            if (data.contains(O3SyntaxKeyword.PLUS)
                    || data.contains(O3SyntaxKeyword.DIVISION)
                    || data.contains(O3SyntaxKeyword.MINUS)
                    || data.contains(O3SyntaxKeyword.MULTIPLICATION)) {

                return this.lexerArithmetic.getReturnTypeExpression(value);
            }

            return O3VariableType.INT;
        }
    }

    public String getValueString(String data) {
        var clean = data.trim();
        return clean.substring(clean.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clean.length()).trim();
    }

    public Boolean getValueBoolean(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clean.length()).trim();
        return Boolean.valueOf(value);
    }

    public Integer getValueInteger(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clean.length()).trim();
        if (data.contains(O3SyntaxKeyword.PLUS)
                || data.contains(O3SyntaxKeyword.DIVISION)
                || data.contains(O3SyntaxKeyword.MINUS)
                || data.contains(O3SyntaxKeyword.MULTIPLICATION)) {

            return this.lexerArithmetic.getIntegerValueFromExpression(value);
        }
        return Integer.valueOf(value);
    }

    public Float getValueFloat(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clean.length() - 1).trim();
        if (data.contains(O3SyntaxKeyword.PLUS)
                || data.contains(O3SyntaxKeyword.DIVISION)
                || data.contains(O3SyntaxKeyword.MINUS)
                || data.contains(O3SyntaxKeyword.MULTIPLICATION)) {

            return this.lexerArithmetic.getFloatValueFromExpression(value);
        }
        return Float.valueOf(value);
    }

    public Double getValueDouble(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clean.length() - 1).trim();
        if (data.contains(O3SyntaxKeyword.PLUS)
                || data.contains(O3SyntaxKeyword.DIVISION)
                || data.contains(O3SyntaxKeyword.MINUS)
                || data.contains(O3SyntaxKeyword.MULTIPLICATION)) {

            return this.lexerArithmetic.getDoubleValueFromExpression(value);
        }

        return Double.valueOf(value);
    }

    public String getVariableName(String data) {
        var clean = data.trim();
        var name = clean.substring(O3SyntaxKeyword.VARIABLE.length(), clean.length()).trim();
        name = name.substring(0, name.indexOf(O3SyntaxKeyword.ASSINGN)).trim();
        return name;
    }

    /**
     * Creates the the internal name of a variable, based on the name of the
     * function and the declared name of the variable. Formula: functionName + _
     * + nameOfVarible + : Ex: f: main() { v: text = "Hello World!!!" } The
     * internal name of the "v: text" variable will be "main_text:"
     *
     * @param functionName name of the function that the variable is inside
     * @param data content from a O3FileLine.getData()
     * @return variable internal name
     */
    public String getVariableInternalName(String functionName, String data) {
        return functionName + "_" + this.getVariableName(data) + ":";
    }

    /**
     * Resolves the type of the return of a function.
     *
     * @param data raw line
     * @return variable type of the function return.
     */
    public O3VariableType resolveReturnVariableType(String data) {
        var clear = data.trim();
        var subLine = clear.substring(clear.indexOf(O3SyntaxKeyword.ASSINGN) + 1, clear.length()).trim();
        if (subLine.contains(O3SyntaxKeyword.OPEN_EXPRESSION)) {
            subLine = subLine.substring(0, subLine.indexOf(O3SyntaxKeyword.OPEN_EXPRESSION));
        }

        var function = coreLibrary.getByName(subLine);
        return function.getReturnType();
    }

    /**
     * Determine if the variable is initialized or not.
     *
     * @param data raw line
     * @return
     */
    public boolean isInitialized(String data) {
        var value = data.substring(data.indexOf(O3SyntaxKeyword.ASSINGN) + 1, data.length()).trim();
        if (value.contains("\"")) {
            return true;
        }

        if (value.contains(O3SyntaxKeyword.TRUE)
                || value.contains(O3SyntaxKeyword.FALSE)) {
            return true;
        }

        if (value.contains(O3SyntaxKeyword.FLOATING_POINT_SIGN)) {
            if (data.contains(O3SyntaxKeyword.FLOAT_SIGN)) {
                return true;
            }

            if (data.contains(O3SyntaxKeyword.DOUBLE_SIGN)) {
                return true;
            }
        }

        if (data.contains(O3SyntaxKeyword.OPEN_EXPRESSION)
                && data.contains(O3SyntaxKeyword.CLOSE_EXPRESSION)) {
            return false;
        }
       
        return true;
    }
}
