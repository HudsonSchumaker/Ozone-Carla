package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3TypeValue;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3SyntaxKeyword;

/**
 * This class solves the arguments in function call of a O3 function.
 *
 * @author Hudson Schumaker
 */
public class LexerArgument {

    public O3Argument getTypeAndValue(String data) {
        if (data.contains("\"")) {
            return new O3Argument(O3Argument.NAME,
                    false, O3TypeValue.of(O3VariableType.STRING, data));
        }

        if (data.contains(O3SyntaxKeyword.TRUE) || data.contains(O3SyntaxKeyword.FALSE)) {
            return new O3Argument(O3Argument.NAME,
                    false, O3TypeValue.of(O3VariableType.BOOL, data));
        }

        if (data.contains(O3SyntaxKeyword.FLOATING_POINT_SIGN)) {
            if (data.contains(O3SyntaxKeyword.FLOAT_SIGN)) {
                return new O3Argument(O3Argument.NAME,
                        false, O3TypeValue.of(O3VariableType.FLOAT, data));
            }
            if (data.contains(O3SyntaxKeyword.DOUBLE_SIGN)) {
                return new O3Argument(O3Argument.NAME,
                        false, O3TypeValue.of(O3VariableType.DOUBLE, data));
            }
        }

        return new O3Argument(O3Argument.NAME,
                false, O3TypeValue.of(O3VariableType.INT, data));
    }
}
