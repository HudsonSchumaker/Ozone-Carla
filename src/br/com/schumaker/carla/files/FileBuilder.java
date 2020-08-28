package br.com.schumaker.carla.files;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface FileBuilder<T> {
   T build(String path) throws Exception;
}
