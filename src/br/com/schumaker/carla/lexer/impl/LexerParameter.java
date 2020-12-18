package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerParameter;
import br.com.schumaker.carla.o3.enums.MemorySpaceType;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Parameter;
import br.com.schumaker.carla.o3.impl.MemorySpaceTypeValue;
import br.com.schumaker.carla.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class LexerParameter implements ILexerParameter {

    /**
     * Creates the the parameters list of a function, based on the name of the
     * function and the declared parameters. Formula: p_ + functionName + _ +
     * nameOfParam, Ex: f: print(p: text) { some code... } The internal
     * name of the "p: text" variable will be "p_main_text:"
     *
     * @param functionName name of the function
     * @param headerLine   O3Line that holds the function signature
     * @return the parameters list of the function
     */
    @Override
    public List<O3Parameter> getParameters(String functionName, O3FileLine headerLine) {
        var raw = headerLine.getData().trim()
                .substring(headerLine.getData().trim().indexOf(O3Keyword.OPEN_EXPRESSION) + 1, headerLine.getData()
                        .trim().indexOf(O3Keyword.CLOSE_EXPRESSION));

        var rawParams = raw.split(",");
        if (!this.validParamsArray(rawParams)) {
            return new ArrayList<>();
        }

        var params = new ArrayList<O3Parameter>();
        for (String p : rawParams) {
            var clean = p.trim();
            var param = clean.substring(O3Keyword.PARAM.length(), clean.length()).trim();
            var internalName = "p_" + functionName + "_" + param;

            params.add(new O3Parameter(param, internalName, false,
                    MemorySpaceTypeValue.of(MemorySpaceType.PARAM, MemorySpaceType.PARAM.getDefaultValue())));
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
}
