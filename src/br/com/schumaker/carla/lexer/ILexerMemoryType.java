package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.o3.enums.MemoryType;

/**
 * @author Hudson Schumaker
 */
public interface ILexerMemoryType {

    MemoryType getType(String data);

    boolean isInitialized(String data);

    String getValueString(String data);

    Boolean getValueBoolean(String data);

    Integer getValueInteger(String data);

    Float getValueFloat(String data);

    Double getValueDouble(String data);
}
