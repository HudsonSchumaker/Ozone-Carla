package br.com.schumaker.carla.io;

import br.com.schumaker.carla.io.impl.O3FileLine;

import java.util.List;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface FileBuilder<T> {
    T build(String path) throws Exception;

    List<O3FileLine> createLines(List<String> rawLines);
}
