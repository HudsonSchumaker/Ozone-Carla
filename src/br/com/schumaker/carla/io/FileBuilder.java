package br.com.schumaker.carla.io;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface FileBuilder<F, L> {

    F build(String path) throws Exception;

    List<L> createLines(List<String> rawLines);
}
