package br.com.schumaker.carla.io;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface Reader<T> {
    T read(String path) throws Exception;
}