package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.io.impl.O3FileLine;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
public interface Statement {
    List<O3FileLine> getLines();
}