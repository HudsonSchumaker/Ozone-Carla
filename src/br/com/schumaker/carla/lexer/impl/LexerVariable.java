package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerVariable;
import br.com.schumaker.carla.o3.impl.MemorySpaceTypeValue;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create the O³ variables representations.
 *
 * @author Hudson Schumaker
 */
public class LexerVariable implements ILexerVariable {

    private final LexerMemorySpaceType lexerMemorySpaceType = new LexerMemorySpaceType();

    @Override
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
     * @param functionName name of the function.
     * @param line         line of the function statement that has variable declaration.
     * @return O3Variable with type and value.
     */
    public O3Variable getVariable(String functionName, O3FileLine line) {
        var type = lexerMemorySpaceType.getType(line.getData());
        var isInitialized = this.isInitialized(line.getData());
        switch (type) {
            case STRING:
                return null;
            case BOOL:
                return null;
            case FLOAT:
                return null;

            default:
                return null;
        }
    }

    @Override
    public String getVariableName(String data) {
        var clean = data.trim();
        var name = clean.substring(O3Keyword.VARIABLE.length(), clean.length()).trim();
        return name.substring(0, name.indexOf(O3Keyword.ASSIGN)).trim();
    }

    /**
     * Creates the the internal name of a variable, based on the name of the
     * function and the declared name of the variable. Formula: functionName + _
     * + nameOfVariable + : Ex: f: main() { v: text = "Hello World!!!" } The
     * internal name of the "v: text" variable will be "main_text"
     *
     * @param functionName name of the function that the variable is inside
     * @param data         content from a O3FileLine.getData()
     * @return variable internal name
     */
    @Override
    public String getVariableInternalName(String functionName, String data) {
        return functionName + "_" + this.getVariableName(data);
    }

    @Override
    public boolean isInitialized(String data) {
        return lexerMemorySpaceType.isInitialized(data);
    }

    private String getValueString(String data) {
        return lexerMemorySpaceType.getValueString(data);
    }

    private Boolean getValueBoolean(String data) {
        return lexerMemorySpaceType.getValueBoolean(data);
    }

    private Integer getValueInteger(String data) {
        return lexerMemorySpaceType.getValueInteger(data);
    }

    private Float getValueFloat(String data) {
        return lexerMemorySpaceType.getValueFloat(data);
    }

    private Double getValueDouble(String data) {
        return lexerMemorySpaceType.getValueDouble(data);
    }
}
