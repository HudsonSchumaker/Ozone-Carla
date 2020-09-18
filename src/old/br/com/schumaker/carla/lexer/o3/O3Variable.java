 package old.br.com.schumaker.carla.lexer.o3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class represents the variables of O³ pl. Ex: v: pi = 3.14f
 *
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public class O3Variable implements IO3Variable {

    private String name;
    private String internalName;
    private boolean isInitialized;
    private O3VariableTypeValue<O3VariableType, ?> typeValue;
    
    private O3Variable() {}

    @Override
    public O3VariableType getType() {
        return typeValue.getType();
    }
    
    public static O3Variable getBlankO3Variable() {
        return new O3Variable();
    }
}
