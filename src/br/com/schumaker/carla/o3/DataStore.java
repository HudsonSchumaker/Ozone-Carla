package br.com.schumaker.carla.o3;

/**
 *
 * @author Hudson Schumaker
 */
public interface DataStore extends MemorySpace {
    String getName();
    String getOType(); 
}
