package br.com.schumaker.carla.lexer.o3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents the arguments of function call O³ pl.
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3Argument implements IO3Variable {

    public static final String NAME = "arg";
    public static final String VALUE = "?";

    private String name;
    private boolean isVariable;
    private boolean isInitialized;
    private O3TypeValue<?, ?> typeAndValue;
    
    public O3Argument(String name, boolean isVar, O3TypeValue<?, ?> typeAndValue) {
        this.name = name;
        this.isVariable = isVar;
        this.typeAndValue = typeAndValue;
    }
    
    @Override
    public O3VariableType getType() {
        return (O3VariableType) this.typeAndValue.getType();
    }
}
