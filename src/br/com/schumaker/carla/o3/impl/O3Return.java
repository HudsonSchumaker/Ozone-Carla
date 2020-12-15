package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Variable;
import br.com.schumaker.carla.o3.enums.MemorySpaceType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public final class O3Return implements Variable {

    private String name;
    private String internalName;
    private boolean constant;
    private MemorySpaceTypeValue<MemorySpaceType, ?> typeValue;

    @Override
    public Object getValue() {
        return typeValue.getValue();
    }

    @Override
    public String getType() {
        return typeValue.getType().getName();
    }
}
