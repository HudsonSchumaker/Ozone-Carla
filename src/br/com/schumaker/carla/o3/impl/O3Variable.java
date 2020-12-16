package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Variable;
import br.com.schumaker.carla.o3.enums.MemorySpaceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public final class O3Variable implements Variable {

    private String name;
    private String internalName;
    private boolean global;
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
