package br.com.schumaker.carla.io;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface FileBuilder<T> {
    T build(String path) throws Exception;
}
