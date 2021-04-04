package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Variable;
import br.com.schumaker.carla.o3.enums.MemoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public final class O3Argument implements Variable {

    private String name;
    private String internalName;
    private boolean constant;
    private VariableType<MemoryType, ?> typeValue;

    @Override
    public Object getValue() {
        return typeValue.getValue();
    }

    @Override
    public String getType() {
        return typeValue.getType().getName();
    }
}
