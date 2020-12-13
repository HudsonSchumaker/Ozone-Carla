package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Variable;
import lombok.Data;

/**
 * @author Hudson Schumaker
 */
@Data
public final class O3Return implements Variable {

    private String name;
    private String internalName;
    private boolean constant;

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Object getValue() {
        return null;
    }
}
