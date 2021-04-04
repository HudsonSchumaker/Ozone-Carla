package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerParameter;
import br.com.schumaker.carla.o3.enums.MemoryType;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Parameter;
import br.com.schumaker.carla.o3.impl.VariableType;
import br.com.schumaker.carla.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class LexerParameter implements ILexerParameter {

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
                    VariableType.of(MemoryType.PARAM, MemoryType.PARAM.getDefaultValue())));
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
