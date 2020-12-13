package br.com.schumaker.carla.o3.impl;

import br.com.schumaker.carla.o3.Variable;
import lombok.Data;

/**
 * @author Hudson Schumaker
 */
@Data
public final class O3Variable implements Variable {

    private boolean isGlobal;

    private String name;
    private String internalName;

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
