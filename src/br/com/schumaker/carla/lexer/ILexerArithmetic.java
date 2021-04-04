package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.enums.MemoryType;

/**
 * @author Hudson Schumaker
 */
public interface ILexerArithmetic {
    MemoryType getReturnTypeExpression(String data);

    Integer getIntegerValueFromExpression(String data);

    Float getFloatValueFromExpression(String data);

    Double getDoubleValueFromExpression(String data);

    String getStringValueFromExpression(String data);
}
