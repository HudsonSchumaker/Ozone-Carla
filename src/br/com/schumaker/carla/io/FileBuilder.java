package br.com.schumaker.carla.io;

import br.com.schumaker.carla.io.impl.FileLine;

import java.util.List;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface FileBuilder<T> {
    T build(String path) throws Exception;
    List<FileLine> createLines(List<String> rawLines);
}
