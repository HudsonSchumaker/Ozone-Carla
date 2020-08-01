package br.com.schumaker.carla.files;

/**
 *
 * @author schumaker
 * @param <T>
 */
public interface FileBuilder<T> {
   T build(String path) throws Exception;
}
