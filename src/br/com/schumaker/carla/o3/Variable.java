package br.com.schumaker.carla.o3;

/**
 * @author Hudson Schumaker
 */
public interface Variable extends Memory {

    boolean isConstant();

    Object getValue();
}
