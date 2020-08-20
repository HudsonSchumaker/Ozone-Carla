package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3TypeValue;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3CoreKeyword;

/**
 *
 * @author schumaker
 */
public class LexerArgument {
    
    public O3Argument getTypeAndValue(String data) {
        if (data.contains("\"")) {
            return new O3Argument(O3Argument.NAME,
                    false, O3TypeValue.of(O3VariableType.STRING, data));
        }

        if (data.contains(O3CoreKeyword.TRUE) || data.contains(O3CoreKeyword.FALSE)) {
            return new O3Argument(O3Argument.NAME,
                    false, O3TypeValue.of(O3VariableType.BOOL, data));
        }

        if (data.contains(O3CoreKeyword.FLOATING_POINT_SIGN)) {
            if (data.contains(O3CoreKeyword.FLOAT_SIGN)) {
                return new O3Argument(O3Argument.NAME,
                        false, O3TypeValue.of(O3VariableType.FLOAT, data));
            }
            if (data.contains(O3CoreKeyword.DOUBLE_SIGN)) {
                return new O3Argument(O3Argument.NAME,
                        false, O3TypeValue.of(O3VariableType.DOUBLE, data));
            }
        }
        
        return new O3Argument(O3Argument.NAME,
                false, O3TypeValue.of(O3VariableType.INT, data));
    }
}
