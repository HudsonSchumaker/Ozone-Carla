package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.io.impl.O3FileLine;
import br.com.schumaker.carla.lexer.ILexerVariable;
import br.com.schumaker.carla.o3.impl.O3Class;
import br.com.schumaker.carla.o3.impl.O3Keyword;
import br.com.schumaker.carla.o3.impl.O3Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This class create the O³ variables representations.
 *
 * @author Hudson Schumaker
 */
public final class LexerVariable implements ILexerVariable {

    private final LexerVariableType lexerMemorySpaceType = new LexerVariableType();


    @Override
    public void getClassVariables(O3Class o3Class) {
        var l = o3Class.getO3File().getLines().get(0).getInternalNumber();
        var endBlock = "";

        // get lines
        var variableLines = new ArrayList<O3FileLine>();
        while (!endBlock.equals(O3Keyword.CLOSE_STATEMENT) && !endBlock.contains(O3Keyword.FUNCTION)) {
            variableLines.add(o3Class.getO3File().getLines().get(l));
            endBlock = o3Class.getO3File().getLines().get(l).getData();
            l++;
        }

        var x = createVariables(variableLines);
        var c = 0;
    }

    public void getFunctionVariables() {
        // TODO
    }

    public List<O3Variable> createVariables(List<O3FileLine> lines) {
        var filteredVariables = lines.stream().parallel().filter(v -> v.getData()
                .startsWith(O3Keyword.VARIABLE)).collect(Collectors.toList());

        var filteredConstants = lines.stream().parallel().filter(c -> c.getData()
                .startsWith(O3Keyword.CONSTANT)).collect(Collectors.toList());


        return null;
    }

    public O3Variable createVariable(O3FileLine line) {

        // TODO

        return null;
    }

    public O3Variable createConstant(O3FileLine line) {

        // TODO
        return null;
    }
}


