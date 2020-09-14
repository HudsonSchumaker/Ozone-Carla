package old.br.com.schumaker.carla.lexer;

import old.br.com.schumaker.carla.lexer.o3.O3Argument;
import old.br.com.schumaker.carla.lexer.o3.O3TypeValue;
import old.br.com.schumaker.carla.lexer.o3.O3VariableType;
import old.br.com.schumaker.carla.o3.O3SyntaxKeyword;

/**
 * This class solves the arguments in function call of a O3 function.
 *
 * @author Hudson Schumaker
 */
public class LexerArgument {

    private static int counter = 0;

    public O3Argument getTypeAndValue(String data) {
        if (data.contains("\"")) {
            return new O3Argument(O3Argument.NAME + "_" + counter++,
                    false, true, O3TypeValue.of(O3VariableType.STRING, data));
        }

        if (data.contains(O3SyntaxKeyword.TRUE) || data.contains(O3SyntaxKeyword.FALSE)) {
            return new O3Argument(O3Argument.NAME + "_" + counter++,
                    false, true, O3TypeValue.of(O3VariableType.BOOL, data));
        }

        if (data.contains(O3SyntaxKeyword.FLOATING_POINT_SIGN)) {
            if (data.contains(O3SyntaxKeyword.FLOAT_SIGN)) {
                return new O3Argument(O3Argument.NAME + "_" + counter++,
                        false, true,
                        O3TypeValue.of(O3VariableType.FLOAT,
                                this.removeDecimalTypeSign(data)));
            }
            if (data.contains(O3SyntaxKeyword.DOUBLE_SIGN)) {
                return new O3Argument(O3Argument.NAME + "_" + counter++,
                        false, true,
                        O3TypeValue.of(O3VariableType.DOUBLE,
                                this.removeDecimalTypeSign(data)));
            }
        }

        return new O3Argument(O3Argument.NAME + "_" + counter++,
                false, true, O3TypeValue.of(O3VariableType.INT, data));
    }

    public String removeDecimalTypeSign(String data) {
        return data.substring(0, data.length() - 1);
    }
}