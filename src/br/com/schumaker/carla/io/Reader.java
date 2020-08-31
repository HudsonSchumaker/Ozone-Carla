package br.com.schumaker.carla.io;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface Reader<T> {
    boolean fileExists(String path);
    boolean validExtension(String path);
    T read(String path) throws Exception;
}
